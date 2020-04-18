/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.visual_recognition.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Training status for the objects in the collection. */
public class ObjectTrainingStatus extends GenericModel {

  protected Boolean ready;

  @SerializedName("in_progress")
  protected Boolean inProgress;

  @SerializedName("data_changed")
  protected Boolean dataChanged;

  @SerializedName("latest_failed")
  protected Boolean latestFailed;

  protected String description;

  /** Builder. */
  public static class Builder {
    private Boolean ready;
    private Boolean inProgress;
    private Boolean dataChanged;
    private Boolean latestFailed;
    private String description;

    private Builder(ObjectTrainingStatus objectTrainingStatus) {
      this.ready = objectTrainingStatus.ready;
      this.inProgress = objectTrainingStatus.inProgress;
      this.dataChanged = objectTrainingStatus.dataChanged;
      this.latestFailed = objectTrainingStatus.latestFailed;
      this.description = objectTrainingStatus.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ready the ready
     * @param inProgress the inProgress
     * @param dataChanged the dataChanged
     * @param latestFailed the latestFailed
     * @param description the description
     */
    public Builder(
        Boolean ready,
        Boolean inProgress,
        Boolean dataChanged,
        Boolean latestFailed,
        String description) {
      this.ready = ready;
      this.inProgress = inProgress;
      this.dataChanged = dataChanged;
      this.latestFailed = latestFailed;
      this.description = description;
    }

    /**
     * Builds a ObjectTrainingStatus.
     *
     * @return the objectTrainingStatus
     */
    public ObjectTrainingStatus build() {
      return new ObjectTrainingStatus(this);
    }

    /**
     * Set the ready.
     *
     * @param ready the ready
     * @return the ObjectTrainingStatus builder
     */
    public Builder ready(Boolean ready) {
      this.ready = ready;
      return this;
    }

    /**
     * Set the inProgress.
     *
     * @param inProgress the inProgress
     * @return the ObjectTrainingStatus builder
     */
    public Builder inProgress(Boolean inProgress) {
      this.inProgress = inProgress;
      return this;
    }

    /**
     * Set the dataChanged.
     *
     * @param dataChanged the dataChanged
     * @return the ObjectTrainingStatus builder
     */
    public Builder dataChanged(Boolean dataChanged) {
      this.dataChanged = dataChanged;
      return this;
    }

    /**
     * Set the latestFailed.
     *
     * @param latestFailed the latestFailed
     * @return the ObjectTrainingStatus builder
     */
    public Builder latestFailed(Boolean latestFailed) {
      this.latestFailed = latestFailed;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ObjectTrainingStatus builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected ObjectTrainingStatus(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ready, "ready cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.inProgress, "inProgress cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.dataChanged, "dataChanged cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.latestFailed, "latestFailed cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.description, "description cannot be null");
    ready = builder.ready;
    inProgress = builder.inProgress;
    dataChanged = builder.dataChanged;
    latestFailed = builder.latestFailed;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a ObjectTrainingStatus builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ready.
   *
   * <p>Whether you can analyze images in the collection with the **objects** feature.
   *
   * @return the ready
   */
  public Boolean ready() {
    return ready;
  }

  /**
   * Gets the inProgress.
   *
   * <p>Whether training is in progress.
   *
   * @return the inProgress
   */
  public Boolean inProgress() {
    return inProgress;
  }

  /**
   * Gets the dataChanged.
   *
   * <p>Whether there are changes to the training data since the most recent training.
   *
   * @return the dataChanged
   */
  public Boolean dataChanged() {
    return dataChanged;
  }

  /**
   * Gets the latestFailed.
   *
   * <p>Whether the most recent training failed.
   *
   * @return the latestFailed
   */
  public Boolean latestFailed() {
    return latestFailed;
  }

  /**
   * Gets the description.
   *
   * <p>Details about the training. If training is in progress, includes information about the
   * status. If training is not in progress, includes a success message or information about why
   * training failed.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}
