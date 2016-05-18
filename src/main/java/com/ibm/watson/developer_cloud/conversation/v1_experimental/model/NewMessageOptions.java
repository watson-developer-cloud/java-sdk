/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * This class contains the parameters when using {@link ConversationService#message(NewMessageOptions)}.
 * 
 * @see ConversationService
 */
public class NewMessageOptions {

  private String inputText;
  private Context context;
  private String workspaceId;
  
  /**
   * Builder.
   */
  public static class Builder {
    private String inputText;
    private Context context;
    private String workspaceId;


    /**
     * Instantiates a new builder.
     */
    public Builder() {}

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    public Builder(NewMessageOptions options) {
      this.inputText = options.inputText;
      this.context = options.context;
      this.workspaceId = options.workspaceId;
    }

    /**
     * Sets the workspace id
     *
     * @param workspaceId the workspace id
     * @return the builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }
    
    /**
     * Sets the input text
     *
     * @param text the text
     * @return the builder
     */
    public Builder inputText(String inputText) {
      this.inputText = inputText;
      return this;
    }

    /**
     * Sets the {@link Context}
     *
     * @param context the message context
     * @return the builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    
    /**
     * Builds the {@link NewMessageOptions} object.
     *
     * @return the gets the tone options
     */
    public NewMessageOptions build() {
      Validator.notNull(workspaceId, "workspaceId cannot be null");      
      return new NewMessageOptions(this);
    }
  }

  private NewMessageOptions(Builder builder) {
    this.inputText = builder.inputText;
    this.context = builder.context;
    this.workspaceId = builder.workspaceId;

  }

  /**
   * Gets the input text.
   * 
   * @return the input Text
   */
  public String inputText() {
    return this.inputText;
  }


  /**
   * Gets the message context
   * 
   * @return the context
   */
  public Context context() {
    return this.context;
  }

  /**
   * Gets the workspace id
   * 
   * @return the workspace id
   */
  public String workspaceId() {
    return this.workspaceId;
  }
  
  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
