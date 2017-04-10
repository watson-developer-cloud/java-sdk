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

package com.ibm.watson.developer_cloud.discovery.v1.model.collection;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request to create a {@link Collection}.
 */
public class CreateCollectionRequest extends GenericModel {
    private final String environmentId;
    private final String name;
    private final String description;
    @SerializedName("configuration_id")
    private final String configurationId;
    private final String language;

    private CreateCollectionRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.name = builder.name;
        this.description = builder.description;
        this.configurationId = builder.configurationId;
        this.language = builder.language;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public String getLanguage() {
        return language;
    }

    public static class Builder {
        private final String environmentId;
        private final String name;
        private final String configurationId;
        private String description;
        private String language;

        public Builder(String environmentId, String configurationId, String name) {
            this.environmentId = environmentId;
            this.configurationId = configurationId;
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public CreateCollectionRequest build() {
            return new CreateCollectionRequest(this);
        }
    }
}
