/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
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

package org.onap.aaiclient.client.aai;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import org.onap.aaiclient.client.graphinventory.GraphInventoryPatchConverter;
import org.onap.aaiclient.client.graphinventory.GraphInventoryRestClient;
import org.onap.logging.filter.base.ONAPComponents;
import org.onap.so.client.ResponseExceptionMapper;

public class AAIRestClient extends GraphInventoryRestClient {

    private final AAIProperties aaiProperties;
    private final Map<String, String> additionalHeaders;

    protected AAIRestClient(AAIProperties props, URI uri, Map<String, String> additionalHeaders) {
        super(props, uri);
        this.aaiProperties = props;
        this.additionalHeaders = additionalHeaders;
    }

    @Override
    public ONAPComponents getTargetEntity() {
        return ONAPComponents.AAI;
    }

    @Override
    protected void initializeHeaderMap(Map<String, String> headerMap) {
        headerMap.put("X-FromAppId", aaiProperties.getSystemName());
        headerMap.put("X-TransactionId", requestId);
        headerMap.putAll(additionalHeaders);
        String auth = aaiProperties.getAuth();
        String key = aaiProperties.getKey();

        if (auth != null && !auth.isEmpty() && key != null && !key.isEmpty()) {
            addBasicAuthHeader(auth, key);
        }
    }

    @Override
    protected Optional<ResponseExceptionMapper> addResponseExceptionMapper() {

        return Optional.of(new AAIClientResponseExceptionMapper());
    }

    protected GraphInventoryPatchConverter getPatchConverter() {
        return this.patchConverter;
    }

}
