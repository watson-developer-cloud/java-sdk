/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteUserData options. */
public class DeleteUserDataOptions extends GenericModel {

  protected String customerId;

  /** Builder. */
  public static class Builder {
    private String customerId;

    private Builder(DeleteUserDataOptions deleteUserDataOptions) {
      this.customerId = deleteUserDataOptions.customerId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customerId the customerId
     */
    public Builder(String customerId) {
      this.customerId = customerId;
    }

    /**
     * Builds a DeleteUserDataOptions.
     *
     * @return the new DeleteUserDataOptions instance
     */
    public DeleteUserDataOptions build() {
      return new DeleteUserDataOptions(this);
    }

    /**
     * Set the customerId.
     *
     * @param customerId the customerId
     * @return the DeleteUserDataOptions builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }
  }

  protected DeleteUserDataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.customerId, "customerId cannot be null");
    customerId = builder.customerId;
  }

  /**
   * New builder.
   *
   * @return a DeleteUserDataOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customerId.
   *
   * <p>The customer ID for which all data is to be deleted.
   *
   * @return the customerId
   */
  public String customerId() {
    return customerId;
  }
}
