/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Feedback data for submission.
 */
public class FeedbackDataInput extends GenericModel {

  @SerializedName("feedback_type")
  protected String feedbackType;
  protected ShortDoc document;
  @SerializedName("model_id")
  protected String modelId;
  @SerializedName("model_version")
  protected String modelVersion;
  protected Location location;
  protected String text;
  @SerializedName("original_labels")
  protected OriginalLabelsIn originalLabels;
  @SerializedName("updated_labels")
  protected UpdatedLabelsIn updatedLabels;

  /**
   * Builder.
   */
  public static class Builder {
    private String feedbackType;
    private ShortDoc document;
    private String modelId;
    private String modelVersion;
    private Location location;
    private String text;
    private OriginalLabelsIn originalLabels;
    private UpdatedLabelsIn updatedLabels;

    private Builder(FeedbackDataInput feedbackDataInput) {
      this.feedbackType = feedbackDataInput.feedbackType;
      this.document = feedbackDataInput.document;
      this.modelId = feedbackDataInput.modelId;
      this.modelVersion = feedbackDataInput.modelVersion;
      this.location = feedbackDataInput.location;
      this.text = feedbackDataInput.text;
      this.originalLabels = feedbackDataInput.originalLabels;
      this.updatedLabels = feedbackDataInput.updatedLabels;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param feedbackType the feedbackType
     * @param location the location
     * @param text the text
     * @param originalLabels the originalLabels
     * @param updatedLabels the updatedLabels
     */
    public Builder(String feedbackType, Location location, String text, OriginalLabelsIn originalLabels,
        UpdatedLabelsIn updatedLabels) {
      this.feedbackType = feedbackType;
      this.location = location;
      this.text = text;
      this.originalLabels = originalLabels;
      this.updatedLabels = updatedLabels;
    }

    /**
     * Builds a FeedbackDataInput.
     *
     * @return the feedbackDataInput
     */
    public FeedbackDataInput build() {
      return new FeedbackDataInput(this);
    }

    /**
     * Set the feedbackType.
     *
     * @param feedbackType the feedbackType
     * @return the FeedbackDataInput builder
     */
    public Builder feedbackType(String feedbackType) {
      this.feedbackType = feedbackType;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the FeedbackDataInput builder
     */
    public Builder document(ShortDoc document) {
      this.document = document;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the FeedbackDataInput builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the modelVersion.
     *
     * @param modelVersion the modelVersion
     * @return the FeedbackDataInput builder
     */
    public Builder modelVersion(String modelVersion) {
      this.modelVersion = modelVersion;
      return this;
    }

    /**
     * Set the location.
     *
     * @param location the location
     * @return the FeedbackDataInput builder
     */
    public Builder location(Location location) {
      this.location = location;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the FeedbackDataInput builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the originalLabels.
     *
     * @param originalLabels the originalLabels
     * @return the FeedbackDataInput builder
     */
    public Builder originalLabels(OriginalLabelsIn originalLabels) {
      this.originalLabels = originalLabels;
      return this;
    }

    /**
     * Set the updatedLabels.
     *
     * @param updatedLabels the updatedLabels
     * @return the FeedbackDataInput builder
     */
    public Builder updatedLabels(UpdatedLabelsIn updatedLabels) {
      this.updatedLabels = updatedLabels;
      return this;
    }
  }

  protected FeedbackDataInput(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.feedbackType,
        "feedbackType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.location,
        "location cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
        "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.originalLabels,
        "originalLabels cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.updatedLabels,
        "updatedLabels cannot be null");
    feedbackType = builder.feedbackType;
    document = builder.document;
    modelId = builder.modelId;
    modelVersion = builder.modelVersion;
    location = builder.location;
    text = builder.text;
    originalLabels = builder.originalLabels;
    updatedLabels = builder.updatedLabels;
  }

  /**
   * New builder.
   *
   * @return a FeedbackDataInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the feedbackType.
   *
   * The type of feedback. The only permitted value is `element_classification`.
   *
   * @return the feedbackType
   */
  public String feedbackType() {
    return feedbackType;
  }

  /**
   * Gets the document.
   *
   * Brief information about the input document.
   *
   * @return the document
   */
  public ShortDoc document() {
    return document;
  }

  /**
   * Gets the modelId.
   *
   * An optional string identifying the model ID. The only permitted value is `contracts`.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * An optional string identifying the version of the model used.
   *
   * @return the modelVersion
   */
  public String modelVersion() {
    return modelVersion;
  }

  /**
   * Gets the location.
   *
   * The numeric location of the identified element in the document, represented with two integers labeled `begin` and
   * `end`.
   *
   * @return the location
   */
  public Location location() {
    return location;
  }

  /**
   * Gets the text.
   *
   * The text on which to submit feedback.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the originalLabels.
   *
   * The original labeling from the input document, without the submitted feedback.
   *
   * @return the originalLabels
   */
  public OriginalLabelsIn originalLabels() {
    return originalLabels;
  }

  /**
   * Gets the updatedLabels.
   *
   * The updated labeling from the input document, accounting for the submitted feedback.
   *
   * @return the updatedLabels
   */
  public UpdatedLabelsIn updatedLabels() {
    return updatedLabels;
  }
}
