/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The updateBatch options. */
public class UpdateBatchOptions extends GenericModel {

  /** The action you want to perform on the specified batch-processing job. */
  public interface Action {
    /** rescan. */
    String RESCAN = "rescan";
    /** cancel. */
    String CANCEL = "cancel";
  }

  /**
   * The analysis model to be used by the service. For the **Element classification** and **Compare
   * two documents** methods, the default is `contracts`. For the **Extract tables** method, the
   * default is `tables`. These defaults apply to the standalone methods as well as to the methods'
   * use in batch-processing requests.
   */
  public interface Model {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  protected String batchId;
  protected String action;
  protected String model;

  /** Builder. */
  public static class Builder {
    private String batchId;
    private String action;
    private String model;

    private Builder(UpdateBatchOptions updateBatchOptions) {
      this.batchId = updateBatchOptions.batchId;
      this.action = updateBatchOptions.action;
      this.model = updateBatchOptions.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * Set the model.
     *
     * @param model the model
     * @return the UpdateBatchOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected UpdateBatchOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.batchId, "batchId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action, "action cannot be null");
    batchId = builder.batchId;
    action = builder.action;
    model = builder.model;
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
   * <p>The ID of the batch-processing job you want to update.
   *
   * @return the batchId
   */
  public String batchId() {
    return batchId;
  }

  /**
   * Gets the action.
   *
   * <p>The action you want to perform on the specified batch-processing job.
   *
   * @return the action
   */
  public String action() {
    return action;
  }

  /**
   * Gets the model.
   *
   * <p>The analysis model to be used by the service. For the **Element classification** and
   * **Compare two documents** methods, the default is `contracts`. For the **Extract tables**
   * method, the default is `tables`. These defaults apply to the standalone methods as well as to
   * the methods' use in batch-processing requests.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
