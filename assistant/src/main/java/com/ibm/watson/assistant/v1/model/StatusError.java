/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

/** An object describing an error that occurred during processing of an asynchronous operation. */
public class StatusError extends GenericModel {

  protected String message;

  /** Builder. */
  public static class Builder {
    private String message;

    /**
     * Instantiates a new Builder from an existing StatusError instance.
     *
     * @param statusError the instance to initialize the Builder with
     */
    private Builder(StatusError statusError) {
      this.message = statusError.message;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a StatusError.
     *
     * @return the new StatusError instance
     */
    public StatusError build() {
      return new StatusError(this);
    }

    /**
     * Set the message.
     *
     * @param message the message
     * @return the StatusError builder
     */
    public Builder message(String message) {
      this.message = message;
      return this;
    }
  }

  protected StatusError() {}

  protected StatusError(Builder builder) {
    message = builder.message;
  }

  /**
   * New builder.
   *
   * @return a StatusError builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the message.
   *
   * <p>The text of the error message.
   *
   * @return the message
   */
  public String message() {
    return message;
  }
}
