/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The deleteJob options.
 */
public class DeleteJobOptions extends GenericModel {

  private String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(DeleteJobOptions deleteJobOptions) {
      id = deleteJobOptions.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a DeleteJobOptions.
     *
     * @return the deleteJobOptions
     */
    public DeleteJobOptions build() {
      return new DeleteJobOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteJobOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  private DeleteJobOptions(Builder builder) {
    Validator.notEmpty(builder.id, "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a DeleteJobOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The identifier of the asynchronous job that is to be used for the request. You must make the request with
   * credentials for the instance of the service that owns the job.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}
