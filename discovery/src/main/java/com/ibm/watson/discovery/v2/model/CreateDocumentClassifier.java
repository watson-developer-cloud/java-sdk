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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/**
 * An object that manages the settings and data that is required to train a document classification
 * model.
 */
public class CreateDocumentClassifier extends GenericModel {

  protected String name;
  protected String description;
  protected String language;

  @SerializedName("answer_field")
  protected String answerField;

  protected List<DocumentClassifierEnrichment> enrichments;

  @SerializedName("federated_classification")
  protected ClassifierFederatedModel federatedClassification;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private String language;
    private String answerField;
    private List<DocumentClassifierEnrichment> enrichments;
    private ClassifierFederatedModel federatedClassification;

    /**
     * Instantiates a new Builder from an existing CreateDocumentClassifier instance.
     *
     * @param createDocumentClassifier the instance to initialize the Builder with
     */
    private Builder(CreateDocumentClassifier createDocumentClassifier) {
      this.name = createDocumentClassifier.name;
      this.description = createDocumentClassifier.description;
      this.language = createDocumentClassifier.language;
      this.answerField = createDocumentClassifier.answerField;
      this.enrichments = createDocumentClassifier.enrichments;
      this.federatedClassification = createDocumentClassifier.federatedClassification;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param language the language
     * @param answerField the answerField
     */
    public Builder(String name, String language, String answerField) {
      this.name = name;
      this.language = language;
      this.answerField = answerField;
    }

    /**
     * Builds a CreateDocumentClassifier.
     *
     * @return the new CreateDocumentClassifier instance
     */
    public CreateDocumentClassifier build() {
      return new CreateDocumentClassifier(this);
    }

    /**
     * Adds an enrichments to enrichments.
     *
     * @param enrichments the new enrichments
     * @return the CreateDocumentClassifier builder
     */
    public Builder addEnrichments(DocumentClassifierEnrichment enrichments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enrichments, "enrichments cannot be null");
      if (this.enrichments == null) {
        this.enrichments = new ArrayList<DocumentClassifierEnrichment>();
      }
      this.enrichments.add(enrichments);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateDocumentClassifier builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateDocumentClassifier builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateDocumentClassifier builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the answerField.
     *
     * @param answerField the answerField
     * @return the CreateDocumentClassifier builder
     */
    public Builder answerField(String answerField) {
      this.answerField = answerField;
      return this;
    }

    /**
     * Set the enrichments. Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the CreateDocumentClassifier builder
     */
    public Builder enrichments(List<DocumentClassifierEnrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the federatedClassification.
     *
     * @param federatedClassification the federatedClassification
     * @return the CreateDocumentClassifier builder
     */
    public Builder federatedClassification(ClassifierFederatedModel federatedClassification) {
      this.federatedClassification = federatedClassification;
      return this;
    }
  }

  protected CreateDocumentClassifier() {}

  protected CreateDocumentClassifier(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.language, "language cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.answerField, "answerField cannot be null");
    name = builder.name;
    description = builder.description;
    language = builder.language;
    answerField = builder.answerField;
    enrichments = builder.enrichments;
    federatedClassification = builder.federatedClassification;
  }

  /**
   * New builder.
   *
   * @return a CreateDocumentClassifier builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>A human-readable name of the document classifier.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the document classifier.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the training data that is associated with the document classifier. Language
   * is specified by using the ISO 639-1 language code, such as `en` for English or `ja` for
   * Japanese.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the answerField.
   *
   * <p>The name of the field from the training and test data that contains the classification
   * labels.
   *
   * @return the answerField
   */
  public String answerField() {
    return answerField;
  }

  /**
   * Gets the enrichments.
   *
   * <p>An array of enrichments to apply to the data that is used to train and test the document
   * classifier. The output from the enrichments is used as features by the classifier to classify
   * the document content both during training and at run time.
   *
   * @return the enrichments
   */
  public List<DocumentClassifierEnrichment> enrichments() {
    return enrichments;
  }

  /**
   * Gets the federatedClassification.
   *
   * <p>An object with details for creating federated document classifier models.
   *
   * @return the federatedClassification
   */
  public ClassifierFederatedModel federatedClassification() {
    return federatedClassification;
  }
}
