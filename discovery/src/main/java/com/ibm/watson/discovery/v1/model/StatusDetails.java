/*
 * (C) Copyright IBM Corp. 2021, 2022.
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

  protected Boolean authenticated;

  @SerializedName("error_message")
  protected String errorMessage;

  /** Builder. */
  public static class Builder {
    private Boolean authenticated;
    private String errorMessage;

    private Builder(StatusDetails statusDetails) {
      this.authenticated = statusDetails.authenticated;
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
     * Set the authenticated.
     *
     * @param authenticated the authenticated
     * @return the StatusDetails builder
     */
    public Builder authenticated(Boolean authenticated) {
      this.authenticated = authenticated;
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

  protected StatusDetails() {}

  protected StatusDetails(Builder builder) {
    authenticated = builder.authenticated;
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
   * Gets the authenticated.
   *
   * <p>Indicates whether the credential is accepted by the target data source.
   *
   * @return the authenticated
   */
  public Boolean authenticated() {
    return authenticated;
  }

  /**
   * Gets the errorMessage.
   *
   * <p>If `authenticated` is `false`, a message describes why authentication is unsuccessful.
   *
   * @return the errorMessage
   */
  public String errorMessage() {
    return errorMessage;
  }
}
