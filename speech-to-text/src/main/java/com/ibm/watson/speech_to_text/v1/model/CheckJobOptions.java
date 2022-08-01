/*
 * (C) Copyright IBM Corp. 2022.
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

/** The checkJob options. */
public class CheckJobOptions extends GenericModel {

  protected String id;

  /** Builder. */
  public static class Builder {
    private String id;

    private Builder(CheckJobOptions checkJobOptions) {
      this.id = checkJobOptions.id;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a CheckJobOptions.
     *
     * @return the new CheckJobOptions instance
     */
    public CheckJobOptions build() {
      return new CheckJobOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CheckJobOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected CheckJobOptions() {}

  protected CheckJobOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id, "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a CheckJobOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * <p>The identifier of the asynchronous job that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the job.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}
