/*
 * (C) Copyright IBM Corp. 2019.
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
  private String feedbackType;
  private ShortDoc document;
  @SerializedName("model_id")
  private String modelId;
  @SerializedName("model_version")
  private String modelVersion;
  private Location location;
  private String text;
  @SerializedName("original_labels")
  private OriginalLabelsIn originalLabels;
  @SerializedName("updated_labels")
  private UpdatedLabelsIn updatedLabels;

  /**
   * Gets the feedbackType.
   *
   * The type of feedback. The only permitted value is `element_classification`.
   *
   * @return the feedbackType
   */
  public String getFeedbackType() {
    return feedbackType;
  }

  /**
   * Gets the document.
   *
   * Brief information about the input document.
   *
   * @return the document
   */
  public ShortDoc getDocument() {
    return document;
  }

  /**
   * Gets the modelId.
   *
   * An optional string identifying the model ID. The only permitted value is `contracts`.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * An optional string identifying the version of the model used.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
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
  public Location getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * The text on which to submit feedback.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the originalLabels.
   *
   * The original labeling from the input document, without the submitted feedback.
   *
   * @return the originalLabels
   */
  public OriginalLabelsIn getOriginalLabels() {
    return originalLabels;
  }

  /**
   * Gets the updatedLabels.
   *
   * The updated labeling from the input document, accounting for the submitted feedback.
   *
   * @return the updatedLabels
   */
  public UpdatedLabelsIn getUpdatedLabels() {
    return updatedLabels;
  }

  /**
   * Sets the feedbackType.
   *
   * @param feedbackType the new feedbackType
   */
  public void setFeedbackType(final String feedbackType) {
    this.feedbackType = feedbackType;
  }

  /**
   * Sets the document.
   *
   * @param document the new document
   */
  public void setDocument(final ShortDoc document) {
    this.document = document;
  }

  /**
   * Sets the modelId.
   *
   * @param modelId the new modelId
   */
  public void setModelId(final String modelId) {
    this.modelId = modelId;
  }

  /**
   * Sets the modelVersion.
   *
   * @param modelVersion the new modelVersion
   */
  public void setModelVersion(final String modelVersion) {
    this.modelVersion = modelVersion;
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(final Location location) {
    this.location = location;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the originalLabels.
   *
   * @param originalLabels the new originalLabels
   */
  public void setOriginalLabels(final OriginalLabelsIn originalLabels) {
    this.originalLabels = originalLabels;
  }

  /**
   * Sets the updatedLabels.
   *
   * @param updatedLabels the new updatedLabels
   */
  public void setUpdatedLabels(final UpdatedLabelsIn updatedLabels) {
    this.updatedLabels = updatedLabels;
  }
}
