/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getExample options.
 */
public class GetExampleOptions extends GenericModel {

  private String workspaceId;
  private String intent;
  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String text;

    private Builder(GetExampleOptions getExampleOptions) {
      workspaceId = getExampleOptions.workspaceId;
      intent = getExampleOptions.intent;
      text = getExampleOptions.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param intent the intent
     * @param text the text
     */
    public Builder(String workspaceId, String intent, String text) {
      this.workspaceId = workspaceId;
      this.intent = intent;
      this.text = text;
    }

    /**
     * Builds a GetExampleOptions.
     *
     * @return the getExampleOptions
     */
    public GetExampleOptions build() {
      return new GetExampleOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetExampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the GetExampleOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the GetExampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private GetExampleOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.intent, "intent cannot be empty");
    Validator.notEmpty(builder.text, "text cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a GetExampleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the intent.
   *
   * The intent name (for example, `pizza_order`).
   *
   * @return the intent
   */
  public String intent() {
    return intent;
  }

  /**
   * Gets the text.
   *
   * The text of the user input example.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}
