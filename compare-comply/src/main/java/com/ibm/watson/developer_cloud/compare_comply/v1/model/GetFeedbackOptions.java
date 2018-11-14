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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getFeedback options.
 */
public class GetFeedbackOptions extends GenericModel {

  /**
   * The analysis model to be used by the service. For the `/v1/element_classification` and `/v1/comparison` methods,
   * the default is `contracts`. For the `/v1/tables` method, the default is `tables`. These defaults apply to the
   * standalone methods as well as to the methods' use in batch-processing requests.
   */
  public interface ModelId {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  private String feedbackId;
  private String modelId;

  /**
   * Builder.
   */
  public static class Builder {
    private String feedbackId;
    private String modelId;

    private Builder(GetFeedbackOptions getFeedbackOptions) {
      feedbackId = getFeedbackOptions.feedbackId;
      modelId = getFeedbackOptions.modelId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param feedbackId the feedbackId
     */
    public Builder(String feedbackId) {
      this.feedbackId = feedbackId;
    }

    /**
     * Builds a GetFeedbackOptions.
     *
     * @return the getFeedbackOptions
     */
    public GetFeedbackOptions build() {
      return new GetFeedbackOptions(this);
    }

    /**
     * Set the feedbackId.
     *
     * @param feedbackId the feedbackId
     * @return the GetFeedbackOptions builder
     */
    public Builder feedbackId(String feedbackId) {
      this.feedbackId = feedbackId;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the GetFeedbackOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }
  }

  private GetFeedbackOptions(Builder builder) {
    Validator.notEmpty(builder.feedbackId, "feedbackId cannot be empty");
    feedbackId = builder.feedbackId;
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a GetFeedbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the feedbackId.
   *
   * An string that specifies the feedback entry to be included in the output.
   *
   * @return the feedbackId
   */
  public String feedbackId() {
    return feedbackId;
  }

  /**
   * Gets the modelId.
   *
   * The analysis model to be used by the service. For the `/v1/element_classification` and `/v1/comparison` methods,
   * the default is `contracts`. For the `/v1/tables` method, the default is `tables`. These defaults apply to the
   * standalone methods as well as to the methods' use in batch-processing requests.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }
}
