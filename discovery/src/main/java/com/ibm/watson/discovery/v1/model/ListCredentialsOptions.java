/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listCredentials options.
 */
public class ListCredentialsOptions extends GenericModel {

  private String environmentId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;

    private Builder(ListCredentialsOptions listCredentialsOptions) {
      this.environmentId = listCredentialsOptions.environmentId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a ListCredentialsOptions.
     *
     * @return the listCredentialsOptions
     */
    public ListCredentialsOptions build() {
      return new ListCredentialsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the ListCredentialsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }
  }

  private ListCredentialsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.environmentId,
        "environmentId cannot be empty");
    environmentId = builder.environmentId;
  }

  /**
   * New builder.
   *
   * @return a ListCredentialsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }
}
