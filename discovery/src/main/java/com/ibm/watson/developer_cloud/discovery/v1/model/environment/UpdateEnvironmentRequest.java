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

package com.ibm.watson.developer_cloud.discovery.v1.model.environment;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request to update an {@link Environment}.
 */
public class UpdateEnvironmentRequest extends GenericModel {
    private final String environmentId;
    private final String name;
    private final String description;

    private UpdateEnvironmentRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.name = builder.name;
        this.description = builder.description;
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

    public static class Builder {
        private final String environmentId;
        private final String name;
        private String description;

        public Builder(String environmentId, String name) {
            this.environmentId = environmentId;
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public UpdateEnvironmentRequest build() {
            return new UpdateEnvironmentRequest(this);
        }
    }
}
