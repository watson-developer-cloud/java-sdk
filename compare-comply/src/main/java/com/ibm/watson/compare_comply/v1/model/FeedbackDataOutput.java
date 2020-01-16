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
 * Information returned from the **Add Feedback** method.
 */
public class FeedbackDataOutput extends GenericModel {

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
  protected OriginalLabelsOut originalLabels;
  @SerializedName("updated_labels")
  protected UpdatedLabelsOut updatedLabels;
  protected Pagination pagination;

  /**
   * Gets the feedbackType.
   *
   * A string identifying the user adding the feedback. The only permitted value is `element_classification`.
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
   * The text to which the feedback applies.
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
  public OriginalLabelsOut getOriginalLabels() {
    return originalLabels;
  }

  /**
   * Gets the updatedLabels.
   *
   * The updated labeling from the input document, accounting for the submitted feedback.
   *
   * @return the updatedLabels
   */
  public UpdatedLabelsOut getUpdatedLabels() {
    return updatedLabels;
  }

  /**
   * Gets the pagination.
   *
   * Pagination details, if required by the length of the output.
   *
   * @return the pagination
   */
  public Pagination getPagination() {
    return pagination;
  }
}
