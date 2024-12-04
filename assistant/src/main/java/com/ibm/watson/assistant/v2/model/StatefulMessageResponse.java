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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A response from the watsonx Assistant service. */
public class StatefulMessageResponse extends GenericModel {

  protected MessageOutput output;
  protected MessageContext context;

  @SerializedName("user_id")
  protected String userId;

  @SerializedName("masked_output")
  protected MessageOutput maskedOutput;

  @SerializedName("masked_input")
  protected MessageInput maskedInput;

  protected StatefulMessageResponse() {}

  /**
   * Gets the output.
   *
   * <p>Assistant output to be rendered or processed by the client.
   *
   * @return the output
   */
  public MessageOutput getOutput() {
    return output;
  }

  /**
   * Gets the context.
   *
   * <p>Context data for the conversation. You can use this property to access context variables.
   * The context is stored by the assistant on a per-session basis.
   *
   * <p>**Note:** The context is included in message responses only if **return_context**=`true` in
   * the message request. Full context is always included in logs.
   *
   * @return the context
   */
  public MessageContext getContext() {
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
   * context.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Gets the maskedOutput.
   *
   * <p>Assistant output to be rendered or processed by the client. All private data is masked or
   * removed.
   *
   * @return the maskedOutput
   */
  public MessageOutput getMaskedOutput() {
    return maskedOutput;
  }

  /**
   * Gets the maskedInput.
   *
   * <p>An input object that includes the input text. All private data is masked or removed.
   *
   * @return the maskedInput
   */
  public MessageInput getMaskedInput() {
    return maskedInput;
  }
}
