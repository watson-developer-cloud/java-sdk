/*
 * (C) Copyright IBM Corp. 2017, 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** Training status details. */
public class TrainingStatus extends GenericModel {

  @SerializedName("total_examples")
  protected Long totalExamples;

  protected Boolean available;
  protected Boolean processing;

  @SerializedName("minimum_queries_added")
  protected Boolean minimumQueriesAdded;

  @SerializedName("minimum_examples_added")
  protected Boolean minimumExamplesAdded;

  @SerializedName("sufficient_label_diversity")
  protected Boolean sufficientLabelDiversity;

  protected Long notices;

  @SerializedName("successfully_trained")
  protected Date successfullyTrained;

  @SerializedName("data_updated")
  protected Date dataUpdated;

  protected TrainingStatus() {}

  /**
   * Gets the totalExamples.
   *
   * <p>The total number of training examples uploaded to this collection.
   *
   * @return the totalExamples
   */
  public Long getTotalExamples() {
    return totalExamples;
  }

  /**
   * Gets the available.
   *
   * <p>When `true`, the collection has been successfully trained.
   *
   * @return the available
   */
  public Boolean isAvailable() {
    return available;
  }

  /**
   * Gets the processing.
   *
   * <p>When `true`, the collection is currently processing training.
   *
   * @return the processing
   */
  public Boolean isProcessing() {
    return processing;
  }

  /**
   * Gets the minimumQueriesAdded.
   *
   * <p>When `true`, the collection has a sufficent amount of queries added for training to occur.
   *
   * @return the minimumQueriesAdded
   */
  public Boolean isMinimumQueriesAdded() {
    return minimumQueriesAdded;
  }

  /**
   * Gets the minimumExamplesAdded.
   *
   * <p>When `true`, the collection has a sufficent amount of examples added for training to occur.
   *
   * @return the minimumExamplesAdded
   */
  public Boolean isMinimumExamplesAdded() {
    return minimumExamplesAdded;
  }

  /**
   * Gets the sufficientLabelDiversity.
   *
   * <p>When `true`, the collection has a sufficent amount of diversity in labeled results for
   * training to occur.
   *
   * @return the sufficientLabelDiversity
   */
  public Boolean isSufficientLabelDiversity() {
    return sufficientLabelDiversity;
  }

  /**
   * Gets the notices.
   *
   * <p>The number of notices associated with this data set.
   *
   * @return the notices
   */
  public Long getNotices() {
    return notices;
  }

  /**
   * Gets the successfullyTrained.
   *
   * <p>The timestamp of when the collection was successfully trained.
   *
   * @return the successfullyTrained
   */
  public Date getSuccessfullyTrained() {
    return successfullyTrained;
  }

  /**
   * Gets the dataUpdated.
   *
   * <p>The timestamp of when the data was uploaded.
   *
   * @return the dataUpdated
   */
  public Date getDataUpdated() {
    return dataUpdated;
  }
}
