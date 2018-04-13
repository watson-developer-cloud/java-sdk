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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The checkJob options.
 */
public class CheckJobOptions extends GenericModel {

  private String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(CheckJobOptions checkJobOptions) {
      id = checkJobOptions.id;
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
     * Builds a CheckJobOptions.
     *
     * @return the checkJobOptions
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

  private CheckJobOptions(Builder builder) {
    Validator.notEmpty(builder.id, "id cannot be empty");
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
   * The ID of the job whose status is to be checked.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}
