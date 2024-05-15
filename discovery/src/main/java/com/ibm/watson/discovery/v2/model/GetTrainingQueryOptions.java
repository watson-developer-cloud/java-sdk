/*
 * (C) Copyright IBM Corp. 2019, 2024.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getTrainingQuery options. */
public class GetTrainingQueryOptions extends GenericModel {

  protected String projectId;
  protected String queryId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String queryId;

    /**
     * Instantiates a new Builder from an existing GetTrainingQueryOptions instance.
     *
     * @param getTrainingQueryOptions the instance to initialize the Builder with
     */
    private Builder(GetTrainingQueryOptions getTrainingQueryOptions) {
      this.projectId = getTrainingQueryOptions.projectId;
      this.queryId = getTrainingQueryOptions.queryId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param queryId the queryId
     */
    public Builder(String projectId, String queryId) {
      this.projectId = projectId;
      this.queryId = queryId;
    }

    /**
     * Builds a GetTrainingQueryOptions.
     *
     * @return the new GetTrainingQueryOptions instance
     */
    public GetTrainingQueryOptions build() {
      return new GetTrainingQueryOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the GetTrainingQueryOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the queryId.
     *
     * @param queryId the queryId
     * @return the GetTrainingQueryOptions builder
     */
    public Builder queryId(String queryId) {
      this.queryId = queryId;
      return this;
    }
  }

  protected GetTrainingQueryOptions() {}

  protected GetTrainingQueryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.queryId, "queryId cannot be empty");
    projectId = builder.projectId;
    queryId = builder.queryId;
  }

  /**
   * New builder.
   *
   * @return a GetTrainingQueryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the queryId.
   *
   * <p>The ID of the query used for training.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
  }
}
