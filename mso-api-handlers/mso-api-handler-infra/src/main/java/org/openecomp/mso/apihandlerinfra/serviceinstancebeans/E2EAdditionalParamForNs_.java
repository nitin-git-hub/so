/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2017 Huawei Technologies Co., Ltd. All rights reserved.
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
 
package org.openecomp.mso.apihandlerinfra.serviceinstancebeans;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class E2EAdditionalParamForNs_ {

	@JsonProperty("E2EService.param1")
	private String e2EServiceParam1;
	@JsonProperty("E2EService.param2")
	private String e2EServiceParam2;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public String getE2EServiceParam1() {
		return e2EServiceParam1;
	}

	public void setE2EServiceParam1(String e2EServiceParam1) {
		this.e2EServiceParam1 = e2EServiceParam1;
	}

	public String getE2EServiceParam2() {
		return e2EServiceParam2;
	}

	public void setE2EServiceParam2(String e2EServiceParam2) {
		this.e2EServiceParam2 = e2EServiceParam2;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
