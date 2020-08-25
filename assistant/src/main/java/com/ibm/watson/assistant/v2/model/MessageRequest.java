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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A stateful message request formatted for the Watson Assistant service. */
public class MessageRequest extends GenericModel {

  protected MessageInput input;
  protected MessageContext context;

  /** Builder. */
  public static class Builder {
    private MessageInput input;
    private MessageContext context;

    private Builder(MessageRequest messageRequest) {
      this.input = messageRequest.input;
      this.context = messageRequest.context;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageRequest.
     *
     * @return the messageRequest
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageRequest builder
     */
    public Builder input(MessageInput input) {
      this.input = input;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageRequest builder
     */
    public Builder context(MessageContext context) {
      this.context = context;
      return this;
    }
  }

  protected MessageRequest(Builder builder) {
    input = builder.input;
    context = builder.context;
  }

  /**
   * New builder.
   *
   * @return a MessageRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
}
