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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createSession options.
 */
public class CreateSessionOptions extends GenericModel {

  private String assistantId;

  /**
   * Builder.
   */
  public static class Builder {
    private String assistantId;

    private Builder(CreateSessionOptions createSessionOptions) {
      assistantId = createSessionOptions.assistantId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     */
    public Builder(String assistantId) {
      this.assistantId = assistantId;
    }

    /**
     * Builds a CreateSessionOptions.
     *
     * @return the createSessionOptions
     */
    public CreateSessionOptions build() {
      return new CreateSessionOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the CreateSessionOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }
  }

  private CreateSessionOptions(Builder builder) {
    Validator.notEmpty(builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
  }

  /**
   * New builder.
   *
   * @return a CreateSessionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * Unique identifier of the assistant. You can find the assistant ID of an assistant on the **Assistants** tab of the
   * Watson Assistant tool. For information about creating assistants, see the
   * [documentation](https://console.bluemix.net/docs/services/assistant/create-assistant.html#creating-assistants).
   *
   * **Note:** Currently, the v2 API does not support creating assistants.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }
}
