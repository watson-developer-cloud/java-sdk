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
 * The updateBatch options.
 */
public class UpdateBatchOptions extends GenericModel {

  /**
   * The action you want to perform on the specified batch-processing request.
   */
  public interface Action {
    /** rescan. */
    String RESCAN = "rescan";
    /** cancel. */
    String CANCEL = "cancel";
  }

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

  private String batchId;
  private String action;
  private String modelId;

  /**
   * Builder.
   */
  public static class Builder {
    private String batchId;
    private String action;
    private String modelId;

    private Builder(UpdateBatchOptions updateBatchOptions) {
      batchId = updateBatchOptions.batchId;
      action = updateBatchOptions.action;
      modelId = updateBatchOptions.modelId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param batchId the batchId
     * @param action the action
     */
    public Builder(String batchId, String action) {
      this.batchId = batchId;
      this.action = action;
    }

    /**
     * Builds a UpdateBatchOptions.
     *
     * @return the updateBatchOptions
     */
    public UpdateBatchOptions build() {
      return new UpdateBatchOptions(this);
    }

    /**
     * Set the batchId.
     *
     * @param batchId the batchId
     * @return the UpdateBatchOptions builder
     */
    public Builder batchId(String batchId) {
      this.batchId = batchId;
      return this;
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the UpdateBatchOptions builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the UpdateBatchOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }
  }

  private UpdateBatchOptions(Builder builder) {
    Validator.notEmpty(builder.batchId, "batchId cannot be empty");
    Validator.notNull(builder.action, "action cannot be null");
    batchId = builder.batchId;
    action = builder.action;
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a UpdateBatchOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the batchId.
   *
   * The ID of the batch-processing request you want to update.
   *
   * @return the batchId
   */
  public String batchId() {
    return batchId;
  }

  /**
   * Gets the action.
   *
   * The action you want to perform on the specified batch-processing request.
   *
   * @return the action
   */
  public String action() {
    return action;
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
