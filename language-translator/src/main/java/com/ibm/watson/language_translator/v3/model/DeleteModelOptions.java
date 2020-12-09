/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteModel options. */
public class DeleteModelOptions extends GenericModel {

  protected String modelId;

  /** Builder. */
  public static class Builder {
    private String modelId;

    private Builder(DeleteModelOptions deleteModelOptions) {
      this.modelId = deleteModelOptions.modelId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param modelId the modelId
     */
    public Builder(String modelId) {
      this.modelId = modelId;
    }

    /**
     * Builds a DeleteModelOptions.
     *
     * @return the new DeleteModelOptions instance
     */
    public DeleteModelOptions build() {
      return new DeleteModelOptions(this);
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the DeleteModelOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }
  }

  protected DeleteModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a DeleteModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the modelId.
   *
   * <p>Model ID of the model to delete.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }
}
