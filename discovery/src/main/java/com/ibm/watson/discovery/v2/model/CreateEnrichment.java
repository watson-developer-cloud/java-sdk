/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about a specific enrichment. */
public class CreateEnrichment extends GenericModel {

  /**
   * The type of this enrichment. The following types are supported:
   *
   * <p>* `classifier`: Creates a document classifier enrichment from a document classifier model
   * that you create by using the [Document classifier
   * API](/apidocs/discovery-data#createdocumentclassifier). **Note**: A text classifier enrichment
   * can be created only from the product user interface.
   *
   * <p>* `dictionary`: Creates a custom dictionary enrichment that you define in a CSV file.
   *
   * <p>* `regular_expression`: Creates a custom regular expression enrichment from regex syntax
   * that you specify in the request.
   *
   * <p>* `rule_based`: Creates an enrichment from an advanced rules model that is created and
   * exported as a ZIP file from Watson Knowledge Studio.
   *
   * <p>* `uima_annotator`: Creates an enrichment from a custom UIMA text analysis model that is
   * defined in a PEAR file created in one of the following ways:
   *
   * <p>* Watson Explorer Content Analytics Studio. **Note**: Supported in IBM Cloud Pak for Data
   * instances only.
   *
   * <p>* Rule-based model that is created in Watson Knowledge Studio.
   *
   * <p>* `watson_knowledge_studio_model`: Creates an enrichment from a Watson Knowledge Studio
   * machine learning model that is defined in a ZIP file.
   */
  public interface Type {
    /** classifier. */
    String CLASSIFIER = "classifier";
    /** dictionary. */
    String DICTIONARY = "dictionary";
    /** regular_expression. */
    String REGULAR_EXPRESSION = "regular_expression";
    /** uima_annotator. */
    String UIMA_ANNOTATOR = "uima_annotator";
    /** rule_based. */
    String RULE_BASED = "rule_based";
    /** watson_knowledge_studio_model. */
    String WATSON_KNOWLEDGE_STUDIO_MODEL = "watson_knowledge_studio_model";
  }

  protected String name;
  protected String description;
  protected String type;
  protected EnrichmentOptions options;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private String type;
    private EnrichmentOptions options;

    /**
     * Instantiates a new Builder from an existing CreateEnrichment instance.
     *
     * @param createEnrichment the instance to initialize the Builder with
     */
    private Builder(CreateEnrichment createEnrichment) {
      this.name = createEnrichment.name;
      this.description = createEnrichment.description;
      this.type = createEnrichment.type;
      this.options = createEnrichment.options;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CreateEnrichment.
     *
     * @return the new CreateEnrichment instance
     */
    public CreateEnrichment build() {
      return new CreateEnrichment(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateEnrichment builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateEnrichment builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateEnrichment builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the options.
     *
     * @param options the options
     * @return the CreateEnrichment builder
     */
    public Builder options(EnrichmentOptions options) {
      this.options = options;
      return this;
    }
  }

  protected CreateEnrichment() {}

  protected CreateEnrichment(Builder builder) {
    name = builder.name;
    description = builder.description;
    type = builder.type;
    options = builder.options;
  }

  /**
   * New builder.
   *
   * @return a CreateEnrichment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>The human readable name for this enrichment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of this enrichment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the type.
   *
   * <p>The type of this enrichment. The following types are supported:
   *
   * <p>* `classifier`: Creates a document classifier enrichment from a document classifier model
   * that you create by using the [Document classifier
   * API](/apidocs/discovery-data#createdocumentclassifier). **Note**: A text classifier enrichment
   * can be created only from the product user interface.
   *
   * <p>* `dictionary`: Creates a custom dictionary enrichment that you define in a CSV file.
   *
   * <p>* `regular_expression`: Creates a custom regular expression enrichment from regex syntax
   * that you specify in the request.
   *
   * <p>* `rule_based`: Creates an enrichment from an advanced rules model that is created and
   * exported as a ZIP file from Watson Knowledge Studio.
   *
   * <p>* `uima_annotator`: Creates an enrichment from a custom UIMA text analysis model that is
   * defined in a PEAR file created in one of the following ways:
   *
   * <p>* Watson Explorer Content Analytics Studio. **Note**: Supported in IBM Cloud Pak for Data
   * instances only.
   *
   * <p>* Rule-based model that is created in Watson Knowledge Studio.
   *
   * <p>* `watson_knowledge_studio_model`: Creates an enrichment from a Watson Knowledge Studio
   * machine learning model that is defined in a ZIP file.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the options.
   *
   * <p>An object that contains options for the current enrichment. Starting with version
   * `2020-08-30`, the enrichment options are not included in responses from the List Enrichments
   * method.
   *
   * @return the options
   */
  public EnrichmentOptions options() {
    return options;
  }
}
