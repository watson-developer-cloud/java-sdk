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

/** The getBatch options. */
public class GetBatchOptions extends GenericModel {

  protected String batchId;

  /** Builder. */
  public static class Builder {
    private String batchId;

    private Builder(GetBatchOptions getBatchOptions) {
      this.batchId = getBatchOptions.batchId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param batchId the batchId
     */
    public Builder(String batchId) {
      this.batchId = batchId;
    }

    /**
     * Builds a GetBatchOptions.
     *
     * @return the new GetBatchOptions instance
     */
    public GetBatchOptions build() {
      return new GetBatchOptions(this);
    }

    /**
     * Set the batchId.
     *
     * @param batchId the batchId
     * @return the GetBatchOptions builder
     */
    public Builder batchId(String batchId) {
      this.batchId = batchId;
      return this;
    }
  }

  protected GetBatchOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.batchId, "batchId cannot be empty");
    batchId = builder.batchId;
  }

  /**
   * New builder.
   *
   * @return a GetBatchOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the batchId.
   *
   * <p>The ID of the batch-processing job whose information you want to retrieve.
   *
   * @return the batchId
   */
  public String batchId() {
    return batchId;
  }
}
