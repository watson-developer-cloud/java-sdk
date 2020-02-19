/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getTrainingUsage options.
 */
public class GetTrainingUsageOptions extends GenericModel {

  protected String startTime;
  protected String endTime;

  /**
   * Builder.
   */
  public static class Builder {
    private String startTime;
    private String endTime;

    private Builder(GetTrainingUsageOptions getTrainingUsageOptions) {
      this.startTime = getTrainingUsageOptions.startTime;
      this.endTime = getTrainingUsageOptions.endTime;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetTrainingUsageOptions.
     *
     * @return the getTrainingUsageOptions
     */
    public GetTrainingUsageOptions build() {
      return new GetTrainingUsageOptions(this);
    }

    /**
     * Set the startTime.
     *
     * @param startTime the startTime
     * @return the GetTrainingUsageOptions builder
     */
    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * Set the endTime.
     *
     * @param endTime the endTime
     * @return the GetTrainingUsageOptions builder
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }
  }

  protected GetTrainingUsageOptions(Builder builder) {
    startTime = builder.startTime;
    endTime = builder.endTime;
  }

  /**
   * New builder.
   *
   * @return a GetTrainingUsageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the startTime.
   *
   * The earliest day to include training events. Specify dates in YYYY-MM-DD format. If empty or not specified, the
   * earliest training event is included.
   *
   * @return the startTime
   */
  public String startTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The most recent day to include training events. Specify dates in YYYY-MM-DD format. All events for the day are
   * included. If empty or not specified, the current day is used. Specify the same value as `start_time` to request
   * events for a single day.
   *
   * @return the endTime
   */
  public String endTime() {
    return endTime;
  }
}

