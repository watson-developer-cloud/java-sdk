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

import com.ibm.watson.developer_cloud.http.ServiceCall;

/**
 * Interface defining the constants and methods associated with Configurations.
 *
 * @see Configuration
 */
public interface ConfigurationManager {
    String CONFIGURATIONS = "configurations";
    String CONFIGURATION = "configuration";

    //Configuration
    String ID = "configuration_id";
    String NAME = "name";
    String DESCRIPTION = "description";
    String CREATED = "created";
    String UPDATED = "updated";
    String CONVERSIONS = "conversions";
    String ENRICHMENTS = "enrichments";
    String NORMALIZATIONS = "normalizations";

    //Conversion Types
    String PDF = "pdf";
    String WORD = "word";
    String HTML = "html";
    String JSON = "json_normalizations";

    //Conversion -> PDF/Word
    String HEADING = "heading";

    //Conversion -> PDF/Word -> Heading
    String FONT_SETTINGS = "fonts";
    String FONT_STYLES = "styles";

    //Conversion -> PDF/Word -> Heading -> FontSettings
    String LEVEL = "level";
    String MIN_SIZE = "min_size";
    String MAX_SIZE = "max_size";
    String BOLD = "bold";
    String ITALIC = "italic";
    String FONT_NAME = "name";

    //Conversion -> PDF/Word -> Heading -> FontStyles
    String NAMES = "names";

    //Conversion -> HTML
    String EXCLUDE_TAGS_COMPLETELY = "exclude_tags_completely";
    String EXCLUDE_TAGS_KEEP_CONTENT = "exclude_tags_keep_content";
    String KEEP_CONTENT = "keep_content";
    String EXCLUDE_CONTENT = "exclude_content";
    String KEEP_TAG_ATTRIBUTES = "keep_tag_attributes";
    String EXCLUDE_TAG_ATTRIBUTES = "exclude_tag_attributes";

    //Conversion -> HTML -> ContentSelector
    String XPATHS = "xpaths";

    //Normalizations & Conversion -> JSON
    String OPERATION = "operation";
    String SOURCE_FIELD = "source_field";
    String DESTINATION_FIELD = "destination_field";

    //Enrichments -> Enrichment
    //includes DESCRIPTION, SOURCE_FIELD, DESTINATION_FIELD
    String OVERWRITE = "overwrite";
    String ENRICHMENT = "enrichment";
    String OPTIONS = "options";

    //Fields
    String FIELD = "field";
    String TYPE = "type";

    String STATUS = "status";

    /**
     * Lists existing configurations. Optional query param of name can be used to search for configurations by name.
     *
     * @param getRequest options for getting the configurations
     * @return a {@link GetConfigurationsResponse} containing result of the {@link GetConfigurationsRequest}
     */
    ServiceCall<GetConfigurationsResponse> getConfigurations(GetConfigurationsRequest getRequest);

    /**
     * Gets configuration details.
     *
     * @param getRequest options for getting the configuration
     * @return a {@link GetConfigurationResponse} containing result of the {@link GetConfigurationRequest}
     */
    ServiceCall<GetConfigurationResponse> getConfiguration(GetConfigurationRequest getRequest);

    /**
     * Creates a configuration.
     *
     * @param createRequest options for creating the configuration
     * @return a {@link CreateConfigurationResponse} containing the result of the {@link CreateConfigurationRequest}
     */
    ServiceCall<CreateConfigurationResponse> createConfiguration(CreateConfigurationRequest createRequest);

    /**
     * Deletes an existing configuration. The delete is performed unconditionally.
     * A configuration delete request will succeed even if the configuration is referenced by a
     * collection or document ingestion. However, documents which have already been submitted for processing will
     * continue to use the deleted configuration (documents are always processed with a snapshot of the
     * configuration as it existed at the time the document was submitted).
     *
     * @param deleteRequest options for deleting the configuration
     * @return a {@link DeleteConfigurationResponse} containing the result of the {@link DeleteConfigurationRequest}
     */
    ServiceCall<DeleteConfigurationResponse> deleteConfiguration(DeleteConfigurationRequest deleteRequest);

    /**
     * Replaces an existing configuration.
     * - Completely replaces the original configuration that was here before.
     * - The 'configuration_id', 'updated', and 'created' fields accepted in the request,
     * but they are ignored (an error is not generated). It is also acceptable for users to submit an
     * updated config with none of the three properties.
     * - Documents are processed with a snapshot of the configuration as it was at the time the document
     * was submitted to be ingested. This means that already submitted documents will not see any updates
     * made to the configuration.
     *
     * @param updateRequest options for updating the configuration
     * @return a {@link UpdateConfigurationResponse} containing the result of the {@link UpdateConfigurationRequest}
     */
    ServiceCall<UpdateConfigurationResponse> updateConfiguration(UpdateConfigurationRequest updateRequest);
}
