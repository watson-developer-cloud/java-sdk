/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** The messageStateless options. */
public class MessageStatelessOptions extends GenericModel {

  protected String assistantId;
  protected MessageInputStateless input;
  protected MessageContextStateless context;
  protected String userId;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private MessageInputStateless input;
    private MessageContextStateless context;
    private String userId;

    private Builder(MessageStatelessOptions messageStatelessOptions) {
      this.assistantId = messageStatelessOptions.assistantId;
      this.input = messageStatelessOptions.input;
      this.context = messageStatelessOptions.context;
      this.userId = messageStatelessOptions.userId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     */
    public Builder(String assistantId) {
      this.assistantId = assistantId;
    }

    /**
     * Builds a MessageStatelessOptions.
     *
     * @return the new MessageStatelessOptions instance
     */
    public MessageStatelessOptions build() {
      return new MessageStatelessOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the MessageStatelessOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageStatelessOptions builder
     */
    public Builder input(MessageInputStateless input) {
      this.input = input;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageStatelessOptions builder
     */
    public Builder context(MessageContextStateless context) {
      this.context = context;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageStatelessOptions builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected MessageStatelessOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
    input = builder.input;
    context = builder.context;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a MessageStatelessOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant. To find the assistant ID in the Watson Assistant user
   * interface, open the assistant settings and click **API Details**. For information about
   * creating assistants, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-assistant-add#assistant-add-task).
   *
   * <p>**Note:** Currently, the v2 API does not support creating assistants.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the input.
   *
   * <p>An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInputStateless input() {
    return input;
  }

  /**
   * Gets the context.
   *
   * <p>Context data for the conversation. You can use this property to set or modify context
   * variables, which can also be accessed by dialog nodes. The context is not stored by the
   * assistant. To maintain session state, include the context from the previous response.
   *
   * <p>**Note:** The total size of the context data for a stateless session cannot exceed 250KB.
   *
   * @return the context
   */
  public MessageContextStateless context() {
    return context;
  }

  /**
   * Gets the userId.
   *
   * <p>A string value that identifies the user who is interacting with the assistant. The client
   * must provide a unique identifier for each individual end user who accesses the application. For
   * user-based plans, this user ID is used to identify unique users for billing purposes. This
   * string cannot contain carriage return, newline, or tab characters. If no value is specified in
   * the input, **user_id** is automatically set to the value of **context.global.session_id**.
   *
   * <p>**Note:** This property is the same as the **user_id** property in the global system
   * context. If **user_id** is specified in both locations in a message request, the value
   * specified at the root is used.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }
}
