/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2019 AT&T Intellectual Property. All rights reserved.
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
package org.onap.so.apihandlerinfra.workflowspecificationbeans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxLength",
    "allowableChars"
})
public class Validation {

    @JsonProperty("maxLength")
    private String maxLength;
    @JsonProperty("allowableChars")
    private String allowableChars;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Validation() {
    }

    /**
     * 
     * @param maxLength
     * @param allowableChars
     */
    public Validation(String maxLength, String allowableChars) {
        super();
        this.maxLength = maxLength;
        this.allowableChars = allowableChars;
    }

    @JsonProperty("maxLength")
    public String getMaxLength() {
        return maxLength;
    }

    @JsonProperty("maxLength")
    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public Validation withMaxLength(String maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    @JsonProperty("allowableChars")
    public String getAllowableChars() {
        return allowableChars;
    }

    @JsonProperty("allowableChars")
    public void setAllowableChars(String allowableChars) {
        this.allowableChars = allowableChars;
    }

    public Validation withAllowableChars(String allowableChars) {
        this.allowableChars = allowableChars;
        return this;
    }

}
