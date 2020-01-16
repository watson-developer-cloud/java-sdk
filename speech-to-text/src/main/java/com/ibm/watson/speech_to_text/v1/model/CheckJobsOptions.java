/*
 * (C) Copyright IBM Corp. 2018, 2019.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The checkJobs options.
 */
public class CheckJobsOptions extends GenericModel {

  /**
   * Builder.
   */
  public static class Builder {

    private Builder(CheckJobsOptions checkJobsOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CheckJobsOptions.
     *
     * @return the checkJobsOptions
     */
    public CheckJobsOptions build() {
      return new CheckJobsOptions(this);
    }
  }

  private CheckJobsOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a CheckJobsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
