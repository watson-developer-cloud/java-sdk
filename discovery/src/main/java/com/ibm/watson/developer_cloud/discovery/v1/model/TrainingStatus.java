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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * TrainingStatus.
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
   * @return the totalExamples
   */
  public Long getTotalExamples() {
    return totalExamples;
  }

  /**
   * Gets the available.
   *
   * @return the available
   */
  public Boolean isAvailable() {
    return available;
  }

  /**
   * Gets the processing.
   *
   * @return the processing
   */
  public Boolean isProcessing() {
    return processing;
  }

  /**
   * Gets the minimumQueriesAdded.
   *
   * @return the minimumQueriesAdded
   */
  public Boolean isMinimumQueriesAdded() {
    return minimumQueriesAdded;
  }

  /**
   * Gets the minimumExamplesAdded.
   *
   * @return the minimumExamplesAdded
   */
  public Boolean isMinimumExamplesAdded() {
    return minimumExamplesAdded;
  }

  /**
   * Gets the sufficientLabelDiversity.
   *
   * @return the sufficientLabelDiversity
   */
  public Boolean isSufficientLabelDiversity() {
    return sufficientLabelDiversity;
  }

  /**
   * Gets the notices.
   *
   * @return the notices
   */
  public Long getNotices() {
    return notices;
  }

  /**
   * Gets the successfullyTrained.
   *
   * @return the successfullyTrained
   */
  public Date getSuccessfullyTrained() {
    return successfullyTrained;
  }

  /**
   * Gets the dataUpdated.
   *
   * @return the dataUpdated
   */
  public Date getDataUpdated() {
    return dataUpdated;
  }

  /**
   * Sets the totalExamples.
   *
   * @param totalExamples the new totalExamples
   */
  public void setTotalExamples(final long totalExamples) {
    this.totalExamples = totalExamples;
  }

  /**
   * Sets the available.
   *
   * @param available the new available
   */
  public void setAvailable(final Boolean available) {
    this.available = available;
  }

  /**
   * Sets the processing.
   *
   * @param processing the new processing
   */
  public void setProcessing(final Boolean processing) {
    this.processing = processing;
  }

  /**
   * Sets the minimumQueriesAdded.
   *
   * @param minimumQueriesAdded the new minimumQueriesAdded
   */
  public void setMinimumQueriesAdded(final Boolean minimumQueriesAdded) {
    this.minimumQueriesAdded = minimumQueriesAdded;
  }

  /**
   * Sets the minimumExamplesAdded.
   *
   * @param minimumExamplesAdded the new minimumExamplesAdded
   */
  public void setMinimumExamplesAdded(final Boolean minimumExamplesAdded) {
    this.minimumExamplesAdded = minimumExamplesAdded;
  }

  /**
   * Sets the sufficientLabelDiversity.
   *
   * @param sufficientLabelDiversity the new sufficientLabelDiversity
   */
  public void setSufficientLabelDiversity(final Boolean sufficientLabelDiversity) {
    this.sufficientLabelDiversity = sufficientLabelDiversity;
  }

  /**
   * Sets the notices.
   *
   * @param notices the new notices
   */
  public void setNotices(final long notices) {
    this.notices = notices;
  }

  /**
   * Sets the successfullyTrained.
   *
   * @param successfullyTrained the new successfullyTrained
   */
  public void setSuccessfullyTrained(final Date successfullyTrained) {
    this.successfullyTrained = successfullyTrained;
  }

  /**
   * Sets the dataUpdated.
   *
   * @param dataUpdated the new dataUpdated
   */
  public void setDataUpdated(final Date dataUpdated) {
    this.dataUpdated = dataUpdated;
  }
}
