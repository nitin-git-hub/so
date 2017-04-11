/*-
 * ============LICENSE_START=======================================================
 * OPENECOMP - MSO
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.03 at 02:02:13 PM EDT 
//


package org.openecomp.mso.apihandlerinfra.vnfbeans;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://org.openecomp/mso/infra/vnf-request/v1}request-info"/>
 *           &lt;sequence>
 *             &lt;element ref="{http://org.openecomp/mso/infra/vnf-request/v1}vnf-inputs"/>
 *             &lt;element ref="{http://org.openecomp/mso/infra/vnf-request/v1}vnf-params" minOccurs="0"/>
 *             &lt;element ref="{http://org.openecomp/mso/infra/vnf-request/v1}vnf-outputs" minOccurs="0"/>
 *           &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestInfo",
    "vnfInputs",
    "vnfParams",
    "vnfOutputs"    
})
@XmlRootElement(name = "vnf-request")
public class VnfRequest {

    @XmlElement(name = "request-info", required = true)
    protected RequestInfo requestInfo;
    @XmlElement(name = "vnf-inputs")
    protected VnfInputs vnfInputs;
    @XmlElement(name = "vnf-params")
    protected Object vnfParams;
    @XmlElement(name = "vnf-outputs")
    protected VnfOutputs vnfOutputs;
  

    /**
     * Gets the value of the requestInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RequestInfo }
     *     
     */
    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    /**
     * Sets the value of the requestInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestInfo }
     *     
     */
    public void setRequestInfo(RequestInfo value) {
        this.requestInfo = value;
    }

    /**
     * Gets the value of the vnfInputs property.
     * 
     * @return
     *     possible object is
     *     {@link VnfInputs }
     *     
     */
    public VnfInputs getVnfInputs() {
        return vnfInputs;
    }

    /**
     * Sets the value of the vnfInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VnfInputs }
     *     
     */
    public void setVnfInputs(VnfInputs value) {
        this.vnfInputs = value;
    }

    /**
     * Gets the value of the vnfParams property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVnfParams() {
        return vnfParams;
    }

    /**
     * Sets the value of the vnfParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVnfParams(Object value) {
        this.vnfParams = value;
    }

    /**
     * Gets the value of the vnfOutputs property.
     * 
     * @return
     *     possible object is
     *     {@link VnfOutputs }
     *     
     */
    public VnfOutputs getVnfOutputs() {
        return vnfOutputs;
    }

    /**
     * Sets the value of the vnfOutputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VnfOutputs }
     *     
     */
    public void setVnfOutputs(VnfOutputs value) {
        this.vnfOutputs = value;
    }

 }
