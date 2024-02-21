/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about a specific enrichment. */
public class Enrichment extends GenericModel {

  /** The type of this enrichment. */
  public interface Type {
    /** part_of_speech. */
    String PART_OF_SPEECH = "part_of_speech";
    /** sentiment. */
    String SENTIMENT = "sentiment";
    /** natural_language_understanding. */
    String NATURAL_LANGUAGE_UNDERSTANDING = "natural_language_understanding";
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
    /** classifier. */
    String CLASSIFIER = "classifier";
    /** webhook. */
    String WEBHOOK = "webhook";
    /** sentence_classifier. */
    String SENTENCE_CLASSIFIER = "sentence_classifier";
  }

  @SerializedName("enrichment_id")
  protected String enrichmentId;

  protected String name;
  protected String description;
  protected String type;
  protected EnrichmentOptions options;

  protected Enrichment() {}

  /**
   * Gets the enrichmentId.
   *
   * <p>The unique identifier of this enrichment.
   *
   * @return the enrichmentId
   */
  public String getEnrichmentId() {
    return enrichmentId;
  }

  /**
   * Gets the name.
   *
   * <p>The human readable name for this enrichment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of this enrichment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the type.
   *
   * <p>The type of this enrichment.
   *
   * @return the type
   */
  public String getType() {
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
  public EnrichmentOptions getOptions() {
    return options;
  }
}
