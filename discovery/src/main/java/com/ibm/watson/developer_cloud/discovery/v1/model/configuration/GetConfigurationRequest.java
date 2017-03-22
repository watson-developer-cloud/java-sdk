/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.watson.developer_cloud.discovery.v1.model.configuration;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request to get a single {@link Configuration}.
 */
public class GetConfigurationRequest extends GenericModel {
    private final String environmentId;
    private final String configurationId;

    private GetConfigurationRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.configurationId = builder.configurationId;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public static class Builder {
        private final String environmentId;
        private final String configurationId;

        public Builder(String environmentId, String configurationId) {
            this.environmentId = environmentId;
            this.configurationId = configurationId;
        }

        public GetConfigurationRequest build() {
            return new GetConfigurationRequest(this);
        }
    }
}
