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
 * The message options.
 */
public class MessageOptions extends GenericModel {

  private String assistantId;
  private String sessionId;
  private MessageInput input;
  private MessageContext context;

  /**
   * Builder.
   */
  public static class Builder {
    private String assistantId;
    private String sessionId;
    private MessageInput input;
    private MessageContext context;

    private Builder(MessageOptions messageOptions) {
      this.assistantId = messageOptions.assistantId;
      this.sessionId = messageOptions.sessionId;
      this.input = messageOptions.input;
      this.context = messageOptions.context;
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
     * @param sessionId the sessionId
     */
    public Builder(String assistantId, String sessionId) {
      this.assistantId = assistantId;
      this.sessionId = sessionId;
    }

    /**
     * Builds a MessageOptions.
     *
     * @return the messageOptions
     */
    public MessageOptions build() {
      return new MessageOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the MessageOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the sessionId.
     *
     * @param sessionId the sessionId
     * @return the MessageOptions builder
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageOptions builder
     */
    public Builder input(MessageInput input) {
      this.input = input;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageOptions builder
     */
    public Builder context(MessageContext context) {
      this.context = context;
      return this;
    }
  }

  private MessageOptions(Builder builder) {
    Validator.notEmpty(builder.assistantId, "assistantId cannot be empty");
    Validator.notEmpty(builder.sessionId, "sessionId cannot be empty");
    assistantId = builder.assistantId;
    sessionId = builder.sessionId;
    input = builder.input;
    context = builder.context;
  }

  /**
   * New builder.
   *
   * @return a MessageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * Unique identifier of the assistant. To find the assistant ID in the Watson Assistant user interface, open the
   * assistant settings and click **API Details**. For information about creating assistants, see the
   * [documentation](https://cloud.ibm.com/docs/services/assistant?topic=assistant-assistant-add#assistant-add-task).
   *
   * **Note:** Currently, the v2 API does not support creating assistants.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the sessionId.
   *
   * Unique identifier of the session.
   *
   * @return the sessionId
   */
  public String sessionId() {
    return sessionId;
  }

  /**
   * Gets the input.
   *
   * An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInput input() {
    return input;
  }

  /**
   * Gets the context.
   *
   * State information for the conversation. The context is stored by the assistant on a per-session basis. You can use
   * this property to set or modify context variables, which can also be accessed by dialog nodes.
   *
   * @return the context
   */
  public MessageContext context() {
    return context;
  }
}
