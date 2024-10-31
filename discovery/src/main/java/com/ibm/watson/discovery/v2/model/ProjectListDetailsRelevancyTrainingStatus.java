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

/** Relevancy training status information for this project. */
public class ProjectListDetailsRelevancyTrainingStatus extends GenericModel {

  @SerializedName("data_updated")
  protected String dataUpdated;

  @SerializedName("total_examples")
  protected Long totalExamples;

  @SerializedName("sufficient_label_diversity")
  protected Boolean sufficientLabelDiversity;

  protected Boolean processing;

  @SerializedName("minimum_examples_added")
  protected Boolean minimumExamplesAdded;

  @SerializedName("successfully_trained")
  protected String successfullyTrained;

  protected Boolean available;
  protected Long notices;

  @SerializedName("minimum_queries_added")
  protected Boolean minimumQueriesAdded;

  protected ProjectListDetailsRelevancyTrainingStatus() {}

  /**
   * Gets the dataUpdated.
   *
   * <p>When the training data was updated.
   *
   * @return the dataUpdated
   */
  public String getDataUpdated() {
    return dataUpdated;
  }

  /**
   * Gets the totalExamples.
   *
   * <p>The total number of examples.
   *
   * @return the totalExamples
   */
  public Long getTotalExamples() {
    return totalExamples;
  }

  /**
   * Gets the sufficientLabelDiversity.
   *
   * <p>When `true`, sufficient label diversity is present to allow training for this project.
   *
   * @return the sufficientLabelDiversity
   */
  public Boolean isSufficientLabelDiversity() {
    return sufficientLabelDiversity;
  }

  /**
   * Gets the processing.
   *
   * <p>When `true`, the relevancy training is in processing.
   *
   * @return the processing
   */
  public Boolean isProcessing() {
    return processing;
  }

  /**
   * Gets the minimumExamplesAdded.
   *
   * <p>When `true`, the minimum number of examples required to train has been met.
   *
   * @return the minimumExamplesAdded
   */
  public Boolean isMinimumExamplesAdded() {
    return minimumExamplesAdded;
  }

  /**
   * Gets the successfullyTrained.
   *
   * <p>The time that the most recent successful training occurred.
   *
   * @return the successfullyTrained
   */
  public String getSuccessfullyTrained() {
    return successfullyTrained;
  }

  /**
   * Gets the available.
   *
   * <p>When `true`, relevancy training is available when querying collections in the project.
   *
   * @return the available
   */
  public Boolean isAvailable() {
    return available;
  }

  /**
   * Gets the notices.
   *
   * <p>The number of notices generated during the relevancy training.
   *
   * @return the notices
   */
  public Long getNotices() {
    return notices;
  }

  /**
   * Gets the minimumQueriesAdded.
   *
   * <p>When `true`, the minimum number of queries required to train has been met.
   *
   * @return the minimumQueriesAdded
   */
  public Boolean isMinimumQueriesAdded() {
    return minimumQueriesAdded;
  }
}
