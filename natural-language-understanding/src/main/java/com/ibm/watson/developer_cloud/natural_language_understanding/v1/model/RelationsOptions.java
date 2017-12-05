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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An option specifying if the relationships found between entities in the analyzed content should be returned.
 */
public class RelationsOptions extends GenericModel {

  private String model;

  /**
   * Builder.
   */
  public static class Builder {
    private String model;

    private Builder(RelationsOptions relationsOptions) {
      model = relationsOptions.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RelationsOptions.
     *
     * @return the relationsOptions
     */
    public RelationsOptions build() {
      return new RelationsOptions(this);
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the RelationsOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  private RelationsOptions(Builder builder) {
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a RelationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the model.
   *
   * Enter a custom model ID to override the default model
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
