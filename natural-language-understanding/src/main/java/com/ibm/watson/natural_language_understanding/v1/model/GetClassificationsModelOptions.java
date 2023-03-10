/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getClassificationsModel options. */
public class GetClassificationsModelOptions extends GenericModel {

  protected String modelId;

  /** Builder. */
  public static class Builder {
    private String modelId;

    /**
     * Instantiates a new Builder from an existing GetClassificationsModelOptions instance.
     *
     * @param getClassificationsModelOptions the instance to initialize the Builder with
     */
    private Builder(GetClassificationsModelOptions getClassificationsModelOptions) {
      this.modelId = getClassificationsModelOptions.modelId;
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
     * Builds a GetClassificationsModelOptions.
     *
     * @return the new GetClassificationsModelOptions instance
     */
    public GetClassificationsModelOptions build() {
      return new GetClassificationsModelOptions(this);
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the GetClassificationsModelOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }
  }

  protected GetClassificationsModelOptions() {}

  protected GetClassificationsModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a GetClassificationsModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the modelId.
   *
   * <p>ID of the model.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }
}
