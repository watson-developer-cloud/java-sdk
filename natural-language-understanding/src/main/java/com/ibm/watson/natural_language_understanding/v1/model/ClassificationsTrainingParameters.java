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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Optional classifications training parameters along with model train requests. */
public class ClassificationsTrainingParameters extends GenericModel {

  /** Model type selector to train either a single_label or a multi_label classifier. */
  public interface ModelType {
    /** single_label. */
    String SINGLE_LABEL = "single_label";
    /** multi_label. */
    String MULTI_LABEL = "multi_label";
  }

  @SerializedName("model_type")
  protected String modelType;

  /** Builder. */
  public static class Builder {
    private String modelType;

    private Builder(ClassificationsTrainingParameters classificationsTrainingParameters) {
      this.modelType = classificationsTrainingParameters.modelType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ClassificationsTrainingParameters.
     *
     * @return the new ClassificationsTrainingParameters instance
     */
    public ClassificationsTrainingParameters build() {
      return new ClassificationsTrainingParameters(this);
    }

    /**
     * Set the modelType.
     *
     * @param modelType the modelType
     * @return the ClassificationsTrainingParameters builder
     */
    public Builder modelType(String modelType) {
      this.modelType = modelType;
      return this;
    }
  }

  protected ClassificationsTrainingParameters() {}

  protected ClassificationsTrainingParameters(Builder builder) {
    modelType = builder.modelType;
  }

  /**
   * New builder.
   *
   * @return a ClassificationsTrainingParameters builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the modelType.
   *
   * <p>Model type selector to train either a single_label or a multi_label classifier.
   *
   * @return the modelType
   */
  public String modelType() {
    return modelType;
  }
}
