/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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
 * Request to create a {@link Configuration}
 *
 * Input a JSON object that allows you to customize how your content is ingested and what enrichments
 * are added to your data. If the input configuration contains the configuration_id, created, and/or
 * the updated properties, then they will be ignored and overridden by the system
 * (an error is not returned so that the overridden fields do not need to be removed when copying a configuration).
 * The configuration can contain unrecognized JSON fields.
 * Any such fields will be ignored and will not generate an error.
 * This makes it easier to use newer configuration files with older versions of the API and the service.
 * It also makes it possible for the tooling to add additional metadata and information to the configuration.
 *
 * @author apturgeo
 */
public class CreateConfigurationRequest extends GenericModel {
    private final String environmentId;
    private final Configuration configuration;

    private CreateConfigurationRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.configuration = builder.configuration;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public static class Builder {
        private final String environmentId;
        private Configuration configuration;

        public Builder(String environmentId) {
            this.environmentId = environmentId;
        }

        public Builder configuration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public CreateConfigurationRequest build() {
            return new CreateConfigurationRequest(this);
        }
    }
}
