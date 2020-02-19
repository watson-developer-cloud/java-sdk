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

/**
 * A response from the Watson Assistant service.
 */
public class MessageResponse extends GenericModel {

  protected MessageOutput output;
  protected MessageContext context;

  /**
   * Gets the output.
   *
   * Assistant output to be rendered or processed by the client.
   *
   * @return the output
   */
  public MessageOutput getOutput() {
    return output;
  }

  /**
   * Gets the context.
   *
   * State information for the conversation. The context is stored by the assistant on a per-session basis. You can use
   * this property to access context variables.
   *
   * **Note:** The context is included in message responses only if **return_context**=`true` in the message request.
   *
   * @return the context
   */
  public MessageContext getContext() {
    return context;
  }
}

