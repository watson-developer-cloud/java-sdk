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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An Enrichment contains configuration pertaining to which fields Watson should extract metadata from.
 */
public class Enrichment extends GenericModel {
    @SerializedName(ConfigurationManager.DESCRIPTION)
    private String description;
    @SerializedName(ConfigurationManager.DESTINATION_FIELD)
    private String destinationField;
    @SerializedName(ConfigurationManager.SOURCE_FIELD)
    private String sourceField;
    @SerializedName(ConfigurationManager.OVERWRITE)
    private boolean overwrite;
    @SerializedName(ConfigurationManager.ENRICHMENT)
    private String enrichment;
    @SerializedName(ConfigurationManager.OPTIONS)
    private Map<String, Object> options;

    public String getDescription() {
        return description;
    }

    public String getDestinationField() {
        return destinationField;
    }

    public String getSourceField() {
        return sourceField;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public String getEnrichment() {
        return enrichment;
    }

    public Map<String, Object> getOptions() {
        return options;
    }
}
