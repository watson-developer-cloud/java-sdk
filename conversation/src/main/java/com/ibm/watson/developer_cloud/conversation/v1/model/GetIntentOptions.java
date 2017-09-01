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
 * The getIntent options.
 */
public class GetIntentOptions extends GenericModel {

  private String workspaceId;
  private String intent;
  private Boolean export;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private Boolean export;

    private Builder(GetIntentOptions getIntentOptions) {
      workspaceId = getIntentOptions.workspaceId;
      intent = getIntentOptions.intent;
      export = getIntentOptions.export;
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
     */
    public Builder(String workspaceId, String intent) {
      this.workspaceId = workspaceId;
      this.intent = intent;
    }

    /**
     * Builds a GetIntentOptions.
     *
     * @return the getIntentOptions
     */
    public GetIntentOptions build() {
      return new GetIntentOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the GetIntentOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the GetIntentOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the GetIntentOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }
  }

  private GetIntentOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.intent, "intent cannot be empty");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    export = builder.export;
  }

  /**
   * New builder.
   *
   * @return a GetIntentOptions builder
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
   * Gets the export.
   *
   * Whether to include all element content in the returned data. If export=`false`, the returned data includes only
   * information about the element itself. If export=`true`, all content, including subelements, is included. The
   * default value is `false`.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
  }
}
