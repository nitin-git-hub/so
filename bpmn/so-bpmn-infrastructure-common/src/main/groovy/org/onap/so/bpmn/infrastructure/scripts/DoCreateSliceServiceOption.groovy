/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 # Copyright (c) 2019, CMCC Technologies Co., Ltd.
 #
 # Licensed under the Apache License, Version 2.0 (the "License")
 # you may not use this file except in compliance with the License.
 # You may obtain a copy of the License at
 #
 #       http://www.apache.org/licenses/LICENSE-2.0
 #
 # Unless required by applicable law or agreed to in writing, software
 # distributed under the License is distributed on an "AS IS" BASIS,
 # WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 # See the License for the specific language governing permissions and
 # limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.onap.so.bpmn.infrastructure.scripts

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.onap.logging.filter.base.ONAPComponents
import org.onap.so.beans.nsmf.SliceTaskParams
import org.onap.so.bpmn.common.scripts.AbstractServiceTaskProcessor
import org.onap.so.bpmn.common.scripts.ExceptionUtil
import org.onap.so.bpmn.common.scripts.OofUtils
import org.onap.so.bpmn.core.UrnPropertiesReader
import org.onap.so.bpmn.core.domain.ServiceDecomposition
import org.onap.so.bpmn.core.domain.ServiceProxy
import org.onap.so.bpmn.core.json.JsonUtils
import org.onap.so.client.HttpClient
import org.onap.so.client.HttpClientFactory
import org.onap.aaiclient.client.aai.AAIObjectType
import org.onap.aaiclient.client.aai.AAIResourcesClient
import org.onap.aaiclient.client.aai.entities.AAIResultWrapper
import org.onap.aaiclient.client.aai.entities.uri.AAIResourceUri
import org.onap.aaiclient.client.aai.entities.uri.AAIUriFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.ws.rs.NotFoundException
import javax.ws.rs.core.Response

import static org.apache.commons.lang3.StringUtils.isBlank

class DoCreateSliceServiceOption extends AbstractServiceTaskProcessor{

    private static final Logger logger = LoggerFactory.getLogger( DoCreateSliceServiceOption.class)

    ExceptionUtil exceptionUtil = new ExceptionUtil()

    JsonUtils jsonUtil = new JsonUtils()

    OofUtils oofUtils = new OofUtils()

    ObjectMapper objectMapper = new ObjectMapper()

    void preProcessRequest (DelegateExecution execution) {
    }


    void getNSIOptionfromOOF(DelegateExecution execution) {

        String urlString = UrnPropertiesReader.getVariable("mso.oof.endpoint", execution)
        logger.debug( "get NSI option OOF Url: " + urlString)

        boolean isNSISuggested = true
        execution.setVariable("isNSISuggested",isNSISuggested)

        //Prepare auth for OOF - Begin
        def authHeader = ""
        String basicAuth = UrnPropertiesReader.getVariable("mso.oof.auth", execution)
        String msokey = UrnPropertiesReader.getVariable("mso.msoKey", execution)

        String basicAuthValue = utils.encrypt(basicAuth, msokey)
        if (basicAuthValue != null) {
            logger.debug( "Obtained BasicAuth username and password for OOF: " + basicAuthValue)
            try {
                authHeader = utils.getBasicAuth(basicAuthValue, msokey)
                execution.setVariable("BasicAuthHeaderValue", authHeader)
            } catch (Exception ex) {
                logger.debug( "Unable to encode username and password string: " + ex)
                exceptionUtil.buildAndThrowWorkflowException(execution, 401, "Internal Error - Unable to " +
                        "encode username and password string")
            }
        } else {
            logger.debug( "Unable to obtain BasicAuth - BasicAuth value null")
            exceptionUtil.buildAndThrowWorkflowException(execution, 401, "Internal Error - BasicAuth " +
                    "value null")
        }
        //Prepare auth for OOF - End

        String requestId = execution.getVariable("msoRequestId")
        Map<String, Object> profileInfo = execution.getVariable("serviceProfile")
        Map<String, Object> nstSolution = execution.getVariable("nstSolution")
        logger.debug("Get NST selection from OOF: " + nstSolution.toString())
        String nstInfo = """{
            "modelInvariantId":"${nstSolution.invariantUUID}",
            "modelVersionId":"${nstSolution.UUID}",
            "modelName":"${nstSolution.NSTName}"
         }"""

        String oofRequest = oofUtils.buildSelectNSIRequest(requestId, nstInfo, profileInfo)
        logger.debug("Sending request to OOF: " + oofRequest)

        //send request to get NSI option - Begin
        URL url = new URL(urlString+"/api/oof/selection/nsi/v1")
        HttpClient httpClient = new HttpClientFactory().newJsonClient(url, ONAPComponents.OOF)
        httpClient.addAdditionalHeader("Authorization", authHeader)
        Response httpResponse = httpClient.post(oofRequest)

        processOOFResponse(httpResponse, execution)

        //解析sliceProfile
        logger.debug("start parseServiceProfile")
        parseServiceProfile(execution)
        logger.debug("end parseServiceProfile")
    }

    private void processOOFResponse(Response httpResponse, DelegateExecution execution) {
        int responseCode = httpResponse.getStatus()
        logger.debug("OOF sync response code is: " + responseCode)

        if (responseCode != 200) {
            exceptionUtil.buildAndThrowWorkflowException(execution, responseCode, "Received a Bad Sync Response from OOF.")
            logger.debug("Info: No NSI suggested by OOF")
        }

        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        if (httpResponse.hasEntity()) {
            String OOFResponse = httpResponse.readEntity(String.class)
            logger.debug("NSI OOFResponse is: " + OOFResponse)
            execution.setVariable("OOFResponse", OOFResponse)
            //This needs to be changed to derive a value when we add policy to decide the solution options.
            Map OOFResponseObject = new JsonSlurper().parseText(OOFResponse)
            Map solutions = OOFResponseObject.get("solutions")

            String resourceSharingLevel = execution.getVariable("resourceSharingLevel")
            Boolean isSharable = resourceSharingLevel.equals("shared")

            if (solutions != null) {
                if (isSharable && hasSharedNSIsolutions(solutions)) {
                    //sharedNSISolution
                    processSharedNSISolutions(solutions, execution)
                }
                else if(solutions.containsKey("newNSISolutions")) {
                    processNewNSISolutions(solutions, execution)
                }
            }
            execution.setVariable("sliceTaskParams", sliceTaskParams)
            logger.debug("sliceTaskParams: "+sliceTaskParams.convertToJson())
        }
        logger.debug("*** Completed options Call to OOF ***")
    }

    private boolean hasSharedNSIsolutions( Map solutions){
        if(solutions.containsKey("sharedNSISolutions")){
            List sharedNSIsolutions = solutions.get("sharedNSISolutions")
            if (sharedNSIsolutions != null && !sharedNSIsolutions.isEmpty()) {
                return  true
            }
        }
        return false
    }

    private void processNewNSISolutions(Map solutions, DelegateExecution execution) {
        int index = 0
        List<Map> newNSISolutions = solutions.get("newNSISolutions")
        List<Map> NSSImap = new ArrayList<>()
        if (newNSISolutions != null && newNSISolutions.size() > 0) {
            NSSImap = newNSISolutions.get(index).get("NSSISolutions") as List<Map>
            for (Map nssi : NSSImap) {
                Map oofSliceProfile = nssi.get("sliceProfile")
                String domain = oofSliceProfile.getOrDefault("domainType","")
                logger.debug("OOF newNSISolutions SliceProfile: " +oofSliceProfile.toString()+",domain:${domain}")
                if(null != domain){
                    //TODO
//                    def nssiSolution = nssi.get("NSSISolution") as Map<String, ?>
//                    String nssiName = nssiSolution.getOrDefault("NSSIName", "")
//                    String nssiId = nssiSolution.getOrDefault("NSSIId", "")
//                    saveNSSIId(nssi, sliceTaskParams)
                    Map<String, Object> sliceProfile = getSliceProfile(domain, execution, oofSliceProfile)
                    saveSliceProfile(execution, domain, sliceProfile)

                }
            }
        }
    }

    private void processSharedNSISolutions(Map solutions, DelegateExecution execution) {
        String nsiName, nsiInstanceId, nssiId, nssiName
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")

        Map sharedNSIsolution = ((List) solutions.get("sharedNSISolutions"))?.get(0)
        nsiInstanceId = sharedNSIsolution.getOrDefault("NSIId", "")
        nsiName = sharedNSIsolution.getOrDefault("NSIName", "")
        sliceTaskParams.setSuggestNsiId(nsiInstanceId)
        sliceTaskParams.setSuggestNsiName(nsiName)

        //Temporary modification
        List NSSIs = sharedNSIsolution.get("NSSIs")
        for(Map nssi : NSSIs){
            Map oofSliceProfile = ((List)nssi.get("sliceProfile"))?.get(0)
            String domain = oofSliceProfile.getOrDefault("domainType","")
            nssiId = nssi.getOrDefault("NSSIId","")
            nssiName = nssi.getOrDefault("NSSIName","")
            saveNSSIId(domain, nssiId, nssiName,execution)
            Map<String, Object> sliceProfile = getSliceProfile(domain, execution, oofSliceProfile)
            saveSliceProfile(execution, domain, sliceProfile)
            logger.debug("OOF sharedNSISolution SliceProfile:"+oofSliceProfile.toString()+",domain:${domain}")
            logger.debug("OOF sharedNSISolution nsiInstanceId:${nsiInstanceId}, nsiName:${nsiName}, nssiId:${nssiId}, nssiName:${nssiName}")
        }
    }

    private void parseServiceProfile(DelegateExecution execution) {
        logger.debug("Start parseServiceProfile")
        String serviceType = execution.getVariable("serviceType")
        Map<String, Object> serviceProfile = execution.getVariable("serviceProfile")
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        // set sliceProfile for three domains
        if(!sliceTaskParams.getSliceProfileAn()){
            Map<String, Object> sliceProfileAn = getSliceProfile( "AN", execution,null)
            saveSliceProfile(execution,"AN",sliceProfileAn)
        }

        if(!sliceTaskParams.getSliceProfileTn()){
            Map<String, Object> sliceProfileTn = getSliceProfile( "TN", execution,null)
            saveSliceProfile(execution,"TN",sliceProfileTn)
        }

        if(!sliceTaskParams.getSliceProfileCn()){
            Map<String, Object> sliceProfileCn = getSliceProfile( "CN", execution,null, )
           saveSliceProfile(execution,"CN",sliceProfileCn)
        }

        logger.debug("Finish parseServiceProfile")
    }

    private void saveSliceProfile(DelegateExecution execution, String domain, Map<String, Object> sliceProfile){
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        if(domain.equalsIgnoreCase("AN")){
            execution.setVariable("sliceProfileAn", sliceProfile)
            sliceTaskParams.setSliceProfileAn(sliceProfile)
            logger.debug("sliceProfileAn: " + sliceProfile)
        }
        else if(domain.equalsIgnoreCase("TN")){
            execution.setVariable("sliceProfileTn", sliceProfile)
            sliceTaskParams.setSliceProfileTn(sliceProfile)
            logger.debug("sliceProfileTn: " + sliceProfile)
        }
        else if(domain.equalsIgnoreCase("CN")){
            execution.setVariable("sliceProfileCn", sliceProfile)
            sliceTaskParams.setSliceProfileCn(sliceProfile)
            logger.debug("sliceProfileCn: " + sliceProfile)
        }
    }

    private void saveNSSIId(String domain, String nssiId, String nssiName, DelegateExecution execution) {
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        if(domain.equalsIgnoreCase("AN")){
            sliceTaskParams.setAnSuggestNssiId(nssiId)
            sliceTaskParams.setAnSuggestNssiName(nssiName)
        }
        else if(domain.equalsIgnoreCase("CN")){
            sliceTaskParams.setCnSuggestNssiId(nssiId)
            sliceTaskParams.setCnSuggestNssiName(nssiName)
        }
        else if(domain.equalsIgnoreCase("TN")){
            sliceTaskParams.setTnSuggestNssiId(nssiId)
            sliceTaskParams.setTnSuggestNssiName(nssiName)
        }
    }

    private Map getSliceProfile(String domain, DelegateExecution execution, Map<String, Object> oofSliceProfile) {
        String profileMapStr
        Map<String, Object> serviceProfile = execution.getVariable("serviceProfile")
        Integer domainLatency = (Integer) serviceProfile.get("latency")/3

        if(domain.equalsIgnoreCase("AN")){
            profileMapStr = """ {
                    "latency": ${domainLatency}, 
                    "sNSSAI": "sNSSAI", 
                    "uEMobilityLevel": "uEMobilityLevel", 
                    "coverageAreaTAList": "coverageAreaTAList", 
                    "5QI": 100
                }"""
        }
        else if(domain.equalsIgnoreCase("TN")){
            profileMapStr =""" {
                    "latency":${domainLatency},
                    "sNSSAI":"sNSSAI", 
                    "e2eLatency":"latency", 
                    "bandwidth": 100
                }"""
        }
        else if(domain.equalsIgnoreCase("CN")){
            profileMapStr = """ {
                    "areaTrafficCapDL":"areaTrafficCapDL",
                    "maxNumberofUEs":"maxNumberofUEs",
                    "latency":${domainLatency},
                    "expDataRateUL":"expDataRateUL", 
                    "sNSSAI":"sNSSAI", 
                    "areaTrafficCapUL":"areaTrafficCapUL",
                    "uEMobilityLevel":"uEMobilityLevel", 
                    "expDataRateDL":"expDataRateDL",  
                    "activityFactor":"activityFactor",
                    "resourceSharingLevel":"resourceSharingLevel"
                }"""
        }

	    logger.debug("Profile map for " + domain + " : " + profileMapStr)
        Map<String, Object> profileMaps = objectMapper.readValue(profileMapStr.trim().replaceAll(" ", ""), new TypeReference<Map<String, String>>(){})
        Map<String, Object> sliceProfile = [:]
        for (Map.Entry<String, String> profileMap : profileMaps) {
            String key = profileMap.key
            String value = profileMaps.get(key)
            if(null != oofSliceProfile && oofSliceProfile.keySet().contains(key)){
                sliceProfile.put(key, oofSliceProfile.get(key))
                logger.debug("Get from oof, key:${key}, value: ${oofSliceProfile.get(key)}")
            }
            else if(serviceProfile.keySet().contains(value)){
                sliceProfile.put(key, serviceProfile.get(value))
            }
            else{
                sliceProfile.put(key, profileMaps.get(key))
            }
        }
        return sliceProfile
    }

    void processDecomposition(DelegateExecution execution){
        logger.debug("Start processDecomposition")

        ServiceDecomposition serviceDecomposition= execution.getVariable("serviceDecomposition")
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        String nstName = serviceDecomposition.getModelInfo().getModelName()
        String nstId = serviceDecomposition.getModelInfo().getModelUuid()
        sliceTaskParams.setNstName(nstName)
        sliceTaskParams.setNstId(nstId)

        logger.debug("End processDecomposition")
    }


    void prepareNSTDecompose(DelegateExecution execution) {

        String modelUuid = execution.getVariable("nstModelUuid")
        String modelInvariantUuid = execution.getVariable("nstModelInvariantUuid")

        String serviceModelInfo = """{
            "modelInvariantUuid":"${modelInvariantUuid}",
            "modelUuid":"${modelUuid}",
            "modelVersion":""
             }"""
        execution.setVariable("serviceModelInfo", serviceModelInfo)
    }

    void prepareNSSTDecompose(DelegateExecution execution) {
        Boolean isMoreNSSTtoProcess = false
        Integer maxNSST = execution.getVariable("maxNSST")
        Integer currentNSST=execution.getVariable("currentNSST")
        List<String> nsstModelUUIDList = new ArrayList<>()
        nsstModelUUIDList = execution.getVariable("nsstModelUUIDList")
        String modelUuid = nsstModelUUIDList.get(currentNSST)
        String serviceModelInfo = """{
            "modelInvariantUuid":"",
            "modelUuid":"${modelUuid}",
            "modelVersion":""
             }"""
        execution.setVariable("serviceModelInfo", serviceModelInfo)
        currentNSST=currentNSST+1
        if(currentNSST<maxNSST)
            isMoreNSSTtoProcess=true
        execution.setVariable("isMoreNSSTtoProcess",isMoreNSSTtoProcess)
        execution.setVariable("maxNSST",maxNSST)
        execution.setVariable("currentNSST",currentNSST)
    }


    void prepareNSSTlistfromNST(DelegateExecution execution) {
        //Need to update this part from decomposition.
        logger.trace("Enter prepareNSSTlistfromNST()")
        Boolean isMoreNSSTtoProcess = false
        ServiceDecomposition serviceDecomposition= execution.getVariable("serviceDecomposition")
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        String nstName = serviceDecomposition.getModelInfo().getModelName()
        sliceTaskParams.setNstName(nstName)
        String nstId = serviceDecomposition.getModelInfo().getModelUuid()
        sliceTaskParams.setNstId(nstId)
        execution.setVariable("sliceTaskParams",sliceTaskParams)

        List<ServiceProxy> proxyList = serviceDecomposition.getServiceProxy()
        List<String> nsstModelUUIDList = new ArrayList<>()
        for(ServiceProxy serviceProxy:proxyList)
            nsstModelUUIDList.add(serviceProxy.getSourceModelUuid())
        execution.setVariable("nsstModelUUIDList",nsstModelUUIDList)
        Integer maxNSST = nsstModelUUIDList.size()
        Integer currentNSST=0
        execution.setVariable("maxNSST",maxNSST)
        execution.setVariable("currentNSST",currentNSST)
        if(currentNSST<maxNSST)
            isMoreNSSTtoProcess=true
        execution.setVariable("isMoreNSSTtoProcess",isMoreNSSTtoProcess)
        logger.trace("Exit prepareNSSTlistfromNST()")

    }

    void getNSSTOption(DelegateExecution execution) {
        ServiceDecomposition serviceDecomposition= execution.getVariable("serviceDecomposition")
        String urlString = UrnPropertiesReader.getVariable("mso.oof.endpoint", execution)
        String globalSubscriberId = execution.getVariable("globalSubscriberId")
        String serviceType = execution.getVariable("subscriptionServiceType")
        String nssiInstanceId =""
        String nssiName =""
        SliceTaskParams sliceTaskParams = execution.getVariable("sliceTaskParams")
        logger.debug( "get NSI option OOF Url: " + urlString)
        boolean isNSISuggested = false
        execution.setVariable("isNSISuggested",isNSISuggested)

        //Prepare auth for OOF - Begin
        def authHeader = ""
        String basicAuth = UrnPropertiesReader.getVariable("mso.oof.auth", execution)
        String msokey = UrnPropertiesReader.getVariable("mso.msoKey", execution)

        String basicAuthValue = utils.encrypt(basicAuth, msokey)
        if (basicAuthValue != null) {
            logger.debug( "Obtained BasicAuth username and password for OOF: " + basicAuthValue)
            try {
                authHeader = utils.getBasicAuth(basicAuthValue, msokey)
                execution.setVariable("BasicAuthHeaderValue", authHeader)
            } catch (Exception ex) {
                logger.debug( "Unable to encode username and password string: " + ex)
                exceptionUtil.buildAndThrowWorkflowException(execution, 401, "Internal Error - Unable to " +
                        "encode username and password string")
            }
        } else {
            logger.debug( "Unable to obtain BasicAuth - BasicAuth value null")
            exceptionUtil.buildAndThrowWorkflowException(execution, 401, "Internal Error - BasicAuth " +
                    "value null")
        }
        //Prepare auth for OOF - End
        //Prepare send request to OOF - Begin
        String requestId = execution.getVariable("msoRequestId")
        Map<String, Object> profileInfo = execution.getVariable("serviceProfile")
        String nsstModelInvariantUuid = serviceDecomposition.getModelInfo().getModelInvariantUuid()
        String nsstModelUuid = serviceDecomposition.getModelInfo().getModelUuid()
        String nsstInfo = """"NSSTInfo": {
        "invariantUUID":"${nsstModelInvariantUuid}",
        "UUID":"${nsstModelUuid}"
         }"""
        String oofRequest = oofUtils.buildSelectNSSIRequest(execution, requestId, nsstInfo ,profileInfo)


        URL url = new URL(urlString+"/api/oof/v1/selectnssi")
        HttpClient httpClient = new HttpClientFactory().newJsonClient(url, ONAPComponents.OOF)
        httpClient.addAdditionalHeader("Authorization", authHeader)
        Response httpResponse = httpClient.post(oofRequest)

        int responseCode = httpResponse.getStatus()
        logger.debug("OOF sync response code is: " + responseCode)

        if(responseCode != 200){
            exceptionUtil.buildAndThrowWorkflowException(execution, responseCode, "Received a Bad Sync Response from OOF.")
        }

        if(httpResponse.hasEntity()){
            String OOFResponse = httpResponse.readEntity(String.class)
            execution.setVariable("OOFResponse", OOFResponse)
            nssiInstanceId = jsonUtil.getJsonValue(OOFResponse, "NSSIIInfo.NSSIID")
            nssiName = jsonUtil.getJsonValue(OOFResponse, "NSSIInfo.NSSIName")
            execution.setVariable("nssiInstanceId",nssiInstanceId)
            execution.setVariable("nssiName",nssiName)
        }
        if(isBlank(nssiInstanceId)){
            logger.debug( "There is no valid NSST suggested by OOF.")
        }else
        {
            try {
                AAIResourcesClient resourceClient = new AAIResourcesClient()
                AAIResourceUri serviceInstanceUri = AAIUriFactory.createResourceUri(AAIObjectType.SERVICE_INSTANCE, globalSubscriberId, serviceType, nssiInstanceId)
                AAIResultWrapper wrapper = resourceClient.get(serviceInstanceUri, NotFoundException.class)
                Optional<org.onap.aai.domain.yang.ServiceInstance> si = wrapper.asBean(org.onap.aai.domain.yang.ServiceInstance.class)
                org.onap.aai.domain.yang.ServiceInstance nssi = si.get()

                String domain = nssi.getEnvironmentContext().toString().toUpperCase()
                switch (domain) {
                    case "AN":
                        sliceTaskParams.setAnSuggestNssiId(nssi.getServiceInstanceId())
                        sliceTaskParams.setAnSuggestNssiName(nssi.getServiceInstanceName())
                        break
                    case "CN":
                        sliceTaskParams.setCnSuggestNssiId(nssi.getServiceInstanceId())
                        sliceTaskParams.setCnSuggestNssiName(nssi.getServiceInstanceName())
                        break
                    case "TN":
                        sliceTaskParams.setTnSuggestNssiId(nssi.getServiceInstanceId())
                        sliceTaskParams.setTnSuggestNssiName(nssi.getServiceInstanceName())
                        break
                    default:
                        break
                }
            }catch(NotFoundException e)
            {
                logger.debug("NSSI Service Instance not found in AAI: " + nssiInstanceId)
            }catch(Exception e)
            {
                logger.debug("NSSI Service Instance not found in AAI: " + nssiInstanceId)
            }
        }
        logger.debug("Prepare NSSI option completed ")
    }
}
