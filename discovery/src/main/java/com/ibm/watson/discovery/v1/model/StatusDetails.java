/*
 * (C) Copyright IBM Corp. 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Object that contains details about the status of the authentication process. */
public class StatusDetails extends GenericModel {

  protected Boolean authentication;

  @SerializedName("error_message")
  protected String errorMessage;

  /** Builder. */
  public static class Builder {
    private Boolean authentication;
    private String errorMessage;

    private Builder(StatusDetails statusDetails) {
      this.authentication = statusDetails.authentication;
      this.errorMessage = statusDetails.errorMessage;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a StatusDetails.
     *
     * @return the new StatusDetails instance
     */
    public StatusDetails build() {
      return new StatusDetails(this);
    }

    /**
     * Set the authentication.
     *
     * @param authentication the authentication
     * @return the StatusDetails builder
     */
    public Builder authentication(Boolean authentication) {
      this.authentication = authentication;
      return this;
    }

    /**
     * Set the errorMessage.
     *
     * @param errorMessage the errorMessage
     * @return the StatusDetails builder
     */
    public Builder errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
    }
  }

  protected StatusDetails(Builder builder) {
    authentication = builder.authentication;
    errorMessage = builder.errorMessage;
  }

  /**
   * New builder.
   *
   * @return a StatusDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the authentication.
   *
   * <p>Indicates whether the credential is accepted by the target data source.
   *
   * @return the authentication
   */
  public Boolean authentication() {
    return authentication;
  }

  /**
   * Gets the errorMessage.
   *
   * <p>If `authentication` is `false`, a message describes why the authentication was unsuccessful.
   *
   * @return the errorMessage
   */
  public String errorMessage() {
    return errorMessage;
  }
}
