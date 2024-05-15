/*
 * (C) Copyright IBM Corp. 2024.
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

/** The listDocumentClassifiers options. */
public class ListDocumentClassifiersOptions extends GenericModel {

  protected String projectId;

  /** Builder. */
  public static class Builder {
    private String projectId;

    /**
     * Instantiates a new Builder from an existing ListDocumentClassifiersOptions instance.
     *
     * @param listDocumentClassifiersOptions the instance to initialize the Builder with
     */
    private Builder(ListDocumentClassifiersOptions listDocumentClassifiersOptions) {
      this.projectId = listDocumentClassifiersOptions.projectId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     */
    public Builder(String projectId) {
      this.projectId = projectId;
    }

    /**
     * Builds a ListDocumentClassifiersOptions.
     *
     * @return the new ListDocumentClassifiersOptions instance
     */
    public ListDocumentClassifiersOptions build() {
      return new ListDocumentClassifiersOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the ListDocumentClassifiersOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }
  }

  protected ListDocumentClassifiersOptions() {}

  protected ListDocumentClassifiersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    projectId = builder.projectId;
  }

  /**
   * New builder.
   *
   * @return a ListDocumentClassifiersOptions builder
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
}