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
package com.ibm.watson.assistant.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.cloud.sdk.core.util.GsonSerializationHelper;

/**
 * State information for the conversation. To maintain state, include the context from the previous response.
 */
public class Context extends DynamicModel {
  private Type conversationIdType = new TypeToken<String>() {
  }.getType();
  private Type systemType = new TypeToken<SystemResponse>() {
  }.getType();
  private Type metadataType = new TypeToken<MessageContextMetadata>() {
  }.getType();

  /**
   * Gets the conversationId.
   *
   * @return the conversationId
   */
  public String getConversationId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("conversation_id"), conversationIdType);
  }

  /**
   * Gets the system.
   *
   * @return the system
   */
  public SystemResponse getSystem() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("system"), systemType);
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public MessageContextMetadata getMetadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("metadata"), metadataType);
  }

  /**
   * Sets the conversationId.
   *
   * @param conversationId the new conversationId
   */
  public void setConversationId(final String conversationId) {
    this.put("conversation_id", conversationId);
  }

  /**
   * Sets the system.
   *
   * @param system the new system
   */
  public void setSystem(final SystemResponse system) {
    this.put("system", system);
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final MessageContextMetadata metadata) {
    this.put("metadata", metadata);
  }
}
