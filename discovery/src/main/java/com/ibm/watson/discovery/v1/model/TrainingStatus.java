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
package com.ibm.watson.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Training status details.
 */
public class TrainingStatus extends GenericModel {

  @SerializedName("total_examples")
  private Long totalExamples;
  private Boolean available;
  private Boolean processing;
  @SerializedName("minimum_queries_added")
  private Boolean minimumQueriesAdded;
  @SerializedName("minimum_examples_added")
  private Boolean minimumExamplesAdded;
  @SerializedName("sufficient_label_diversity")
  private Boolean sufficientLabelDiversity;
  private Long notices;
  @SerializedName("successfully_trained")
  private Date successfullyTrained;
  @SerializedName("data_updated")
  private Date dataUpdated;

  /**
   * Gets the totalExamples.
   *
   * The total number of training examples uploaded to this collection.
   *
   * @return the totalExamples
   */
  public Long getTotalExamples() {
    return totalExamples;
  }

  /**
   * Gets the available.
   *
   * When `true`, the collection has been successfully trained.
   *
   * @return the available
   */
  public Boolean isAvailable() {
    return available;
  }

  /**
   * Gets the processing.
   *
   * When `true`, the collection is currently processing training.
   *
   * @return the processing
   */
  public Boolean isProcessing() {
    return processing;
  }

  /**
   * Gets the minimumQueriesAdded.
   *
   * When `true`, the collection has a sufficent amount of queries added for training to occur.
   *
   * @return the minimumQueriesAdded
   */
  public Boolean isMinimumQueriesAdded() {
    return minimumQueriesAdded;
  }

  /**
   * Gets the minimumExamplesAdded.
   *
   * When `true`, the collection has a sufficent amount of examples added for training to occur.
   *
   * @return the minimumExamplesAdded
   */
  public Boolean isMinimumExamplesAdded() {
    return minimumExamplesAdded;
  }

  /**
   * Gets the sufficientLabelDiversity.
   *
   * When `true`, the collection has a sufficent amount of diversity in labeled results for training to occur.
   *
   * @return the sufficientLabelDiversity
   */
  public Boolean isSufficientLabelDiversity() {
    return sufficientLabelDiversity;
  }

  /**
   * Gets the notices.
   *
   * The number of notices associated with this data set.
   *
   * @return the notices
   */
  public Long getNotices() {
    return notices;
  }

  /**
   * Gets the successfullyTrained.
   *
   * The timestamp of when the collection was successfully trained.
   *
   * @return the successfullyTrained
   */
  public Date getSuccessfullyTrained() {
    return successfullyTrained;
  }

  /**
   * Gets the dataUpdated.
   *
   * The timestamp of when the data was uploaded.
   *
   * @return the dataUpdated
   */
  public Date getDataUpdated() {
    return dataUpdated;
  }
}
