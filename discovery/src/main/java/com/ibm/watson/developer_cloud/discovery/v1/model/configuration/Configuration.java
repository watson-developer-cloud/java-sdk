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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.Document;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A Configuration is used to define how a {@link Document} will be ingested.
 * It contains various settings for different file types and various steps of the ingestion process.
 *
 * The three basic steps are Conversions, Enrichments, and Normalizations
 *
 * @see Conversions
 * @see Enrichment
 * @see NormalizationOperation
 */
public class Configuration extends GenericModel {
    @SerializedName(ConfigurationManager.ID)
    private String configurationId;
    @SerializedName(ConfigurationManager.NAME)
    private String name;
    @SerializedName(ConfigurationManager.DESCRIPTION)
    private String description;
    @SerializedName(ConfigurationManager.CREATED)
    private Date created;
    @SerializedName(ConfigurationManager.UPDATED)
    private Date updated;
    @SerializedName(ConfigurationManager.CONVERSIONS)
    private Conversions conversions;
    @SerializedName(ConfigurationManager.ENRICHMENTS)
    private List<Enrichment> enrichments;
    @SerializedName(ConfigurationManager.NORMALIZATIONS)
    private List<NormalizationOperation> normalizations;

    public String getConfigurationId() {
        return configurationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Conversions getConversions() {
        return conversions;
    }

    public List<Enrichment> getEnrichments() {
        return enrichments;
    }

    public List<NormalizationOperation> getNormalizations() {
        return normalizations;
    }
}
