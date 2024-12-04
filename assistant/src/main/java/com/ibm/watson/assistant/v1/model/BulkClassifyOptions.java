/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The bulkClassify options. */
public class BulkClassifyOptions extends GenericModel {

  protected String workspaceId;
  protected List<BulkClassifyUtterance> input;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private List<BulkClassifyUtterance> input;

    /**
     * Instantiates a new Builder from an existing BulkClassifyOptions instance.
     *
     * @param bulkClassifyOptions the instance to initialize the Builder with
     */
    private Builder(BulkClassifyOptions bulkClassifyOptions) {
      this.workspaceId = bulkClassifyOptions.workspaceId;
      this.input = bulkClassifyOptions.input;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a BulkClassifyOptions.
     *
     * @return the new BulkClassifyOptions instance
     */
    public BulkClassifyOptions build() {
      return new BulkClassifyOptions(this);
    }

    /**
     * Adds a new element to input.
     *
     * @param input the new element to be added
     * @return the BulkClassifyOptions builder
     */
    public Builder addInput(BulkClassifyUtterance input) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(input, "input cannot be null");
      if (this.input == null) {
        this.input = new ArrayList<BulkClassifyUtterance>();
      }
      this.input.add(input);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the BulkClassifyOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the input. Existing input will be replaced.
     *
     * @param input the input
     * @return the BulkClassifyOptions builder
     */
    public Builder input(List<BulkClassifyUtterance> input) {
      this.input = input;
      return this;
    }
  }

  protected BulkClassifyOptions() {}

  protected BulkClassifyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    input = builder.input;
  }

  /**
   * New builder.
   *
   * @return a BulkClassifyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the input.
   *
   * <p>An array of input utterances to classify.
   *
   * @return the input
   */
  public List<BulkClassifyUtterance> input() {
    return input;
  }
}
