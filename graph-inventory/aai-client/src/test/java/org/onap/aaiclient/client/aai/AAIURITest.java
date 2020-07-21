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

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.UriBuilder;
import org.junit.Test;
import org.onap.aaiclient.client.aai.entities.uri.AAIResourceUri;
import org.onap.aaiclient.client.aai.entities.uri.AAIUriFactory;

public class AAIURITest {



    @Test
    public void verifyTemplateReplacement() {
        final String id = "test1";
        AAIResourceUri aaiUri = AAIUriFactory.createResourceUri(AAIObjectType.CONFIGURATION, id);
        String manualReplace = AAIObjectType.CONFIGURATION.toString().replaceAll("\\{configuration-id\\}", id);
        assertEquals("uri template replaced", aaiUri.build(), UriBuilder.fromPath(manualReplace).build());

    }
}