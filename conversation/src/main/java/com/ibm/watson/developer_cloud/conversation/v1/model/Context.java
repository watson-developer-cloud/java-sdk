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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * Context information for the message. Include the context from the previous response to maintain state for the
 * conversation.
 */
public class Context extends DynamicModel {
  private Type conversationIdType = new TypeToken<String>() {
  }.getType();
  private Type systemType = new TypeToken<SystemResponse>() {
  }.getType();

  /**
   * Builder.
   */
  public static class Builder {
    private String conversationId;
    private SystemResponse system;

    private Builder(Context context) {
      conversationId = context.conversationId;
      system = context.system;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param conversationId the conversationId
     * @param system the system
     */
    public Builder(String conversationId, SystemResponse system) {
      this.conversationId = conversationId;
      this.system = system;
    }

    /**
     * Builds a Context.
     *
     * @return the context
     */
    public Context build() {
      Context context = new Context();
      context.put("conversation_id", this.conversationId);
      context.put("system", this.system);
      return context;
    }

    /**
     * Set the conversationId.
     *
     * @param conversationId the conversationId
     * @return the Context builder
     */
    public Builder conversationId(String conversationId) {
      this.conversationId = conversationId;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the Context builder
     */
    public Builder system(SystemResponse system) {
      this.system = system;
      return this;
    }
  }

  private Context(Builder builder) {
    Validator.notNull(builder.conversationId, "conversationId cannot be null");
    Validator.notNull(builder.system, "system cannot be null");
    conversationId = builder.conversationId;
    system = builder.system;
  }

  /**
   * New builder.
   *
   * @return a Context builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the conversationId.
   *
   * @return the conversationId
   */
  public String conversationId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("conversation_id"), conversationIdType);
  }

  /**
   * Gets the system.
   *
   * @return the system
   */
  public SystemResponse system() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("system"), systemType);
  }
}
