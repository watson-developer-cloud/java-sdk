/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * State information for the conversation. To maintain state, include the context from the previous
 * response.
 */
public class Context extends DynamicModel<Object> {

  @SerializedName("conversation_id")
  protected String conversationId;

  @SerializedName("system")
  protected SystemResponse system;

  @SerializedName("metadata")
  protected MessageContextMetadata metadata;

  public Context() {
    super(new TypeToken<Object>() {});
  }

  /**
   * Gets the conversationId.
   *
   * <p>The unique identifier of the conversation.
   *
   * @return the conversationId
   */
  public String getConversationId() {
    return this.conversationId;
  }

  /**
   * Sets the conversationId.
   *
   * @param conversationId the new conversationId
   */
  public void setConversationId(final String conversationId) {
    this.conversationId = conversationId;
  }

  /**
   * Gets the system.
   *
   * <p>For internal use only.
   *
   * @return the system
   */
  public SystemResponse getSystem() {
    return this.system;
  }

  /**
   * Sets the system.
   *
   * @param system the new system
   */
  public void setSystem(final SystemResponse system) {
    this.system = system;
  }

  /**
   * Gets the metadata.
   *
   * <p>Metadata related to the message.
   *
   * @return the metadata
   */
  public MessageContextMetadata getMetadata() {
    return this.metadata;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final MessageContextMetadata metadata) {
    this.metadata = metadata;
  }
}
