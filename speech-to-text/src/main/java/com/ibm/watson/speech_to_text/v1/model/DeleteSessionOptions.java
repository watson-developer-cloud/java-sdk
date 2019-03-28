/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The deleteSession options.
 */
public class DeleteSessionOptions extends GenericModel {

  private String sessionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String sessionId;

    private Builder(DeleteSessionOptions deleteSessionOptions) {
      sessionId = deleteSessionOptions.sessionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param sessionId the sessionId
     */
    public Builder(String sessionId) {
      this.sessionId = sessionId;
    }

    /**
     * Builds a DeleteSessionOptions.
     *
     * @return the deleteSessionOptions
     */
    public DeleteSessionOptions build() {
      return new DeleteSessionOptions(this);
    }

    /**
     * Set the sessionId.
     *
     * @param sessionId the sessionId
     * @return the DeleteSessionOptions builder
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }
  }

  private DeleteSessionOptions(Builder builder) {
    Validator.notEmpty(builder.sessionId, "sessionId cannot be empty");
    sessionId = builder.sessionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteSessionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sessionId.
   *
   * The ID of the session to be deleted.
   *
   * @return the sessionId
   */
  public String sessionId() {
    return sessionId;
  }
}
