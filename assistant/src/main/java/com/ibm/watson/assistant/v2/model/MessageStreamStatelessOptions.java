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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The messageStreamStateless options. */
public class MessageStreamStatelessOptions extends GenericModel {

  protected String assistantId;
  protected String environmentId;
  protected MessageInput input;
  protected MessageContext context;
  protected String userId;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String environmentId;
    private MessageInput input;
    private MessageContext context;
    private String userId;

    /**
     * Instantiates a new Builder from an existing MessageStreamStatelessOptions instance.
     *
     * @param messageStreamStatelessOptions the instance to initialize the Builder with
     */
    private Builder(MessageStreamStatelessOptions messageStreamStatelessOptions) {
      this.assistantId = messageStreamStatelessOptions.assistantId;
      this.environmentId = messageStreamStatelessOptions.environmentId;
      this.input = messageStreamStatelessOptions.input;
      this.context = messageStreamStatelessOptions.context;
      this.userId = messageStreamStatelessOptions.userId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param environmentId the environmentId
     */
    public Builder(String assistantId, String environmentId) {
      this.assistantId = assistantId;
      this.environmentId = environmentId;
    }

    /**
     * Builds a MessageStreamStatelessOptions.
     *
     * @return the new MessageStreamStatelessOptions instance
     */
    public MessageStreamStatelessOptions build() {
      return new MessageStreamStatelessOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the MessageStreamStatelessOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the MessageStreamStatelessOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageStreamStatelessOptions builder
     */
    public Builder input(MessageInput input) {
      this.input = input;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageStreamStatelessOptions builder
     */
    public Builder context(MessageContext context) {
      this.context = context;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageStreamStatelessOptions builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected MessageStreamStatelessOptions() {}

  protected MessageStreamStatelessOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    assistantId = builder.assistantId;
    environmentId = builder.environmentId;
    input = builder.input;
    context = builder.context;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a MessageStreamStatelessOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed,
   * depending on the type of request: - For message, session, and log requests, specify the
   * environment ID of the environment where the assistant is deployed. - For all other requests,
   * specify the assistant ID of the assistant.
   *
   * <p>To find the environment ID or assistant ID in the watsonx Assistant user interface, open the
   * assistant settings and scroll to the **Environments** section.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID. To find the assistant ID in the user interface, open the assistant settings and click API
   * Details.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the environmentId.
   *
   * <p>Unique identifier of the environment. To find the environment ID in the watsonx Assistant
   * user interface, open the environment settings and click **API Details**. **Note:** Currently,
   * the API does not support creating environments.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the input.
   *
   * <p>An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInput input() {
    return input;
  }

  /**
   * Gets the context.
   *
   * <p>Context data for the conversation. You can use this property to set or modify context
   * variables, which can also be accessed by dialog nodes. The context is stored by the assistant
   * on a per-session basis.
   *
   * <p>**Note:** The total size of the context data stored for a stateful session cannot exceed
   * 100KB.
   *
   * @return the context
   */
  public MessageContext context() {
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
   * context. If **user_id** is specified in both locations, the value specified at the root is
   * used.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }
}
