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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DialogNodeVisitedDetails.
 */
public class DialogNodeVisitedDetails extends GenericModel {

  @SerializedName("dialog_node")
  private String dialogNode;
  private String title;

  /**
   * Builder.
   */
  public static class Builder {
    private String dialogNode;
    private String title;

    private Builder(DialogNodeVisitedDetails dialogNodeVisitedDetails) {
      dialogNode = dialogNodeVisitedDetails.dialogNode;
      title = dialogNodeVisitedDetails.title;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DialogNodeVisitedDetails.
     *
     * @return the dialogNodeVisitedDetails
     */
    public DialogNodeVisitedDetails build() {
      return new DialogNodeVisitedDetails(this);
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the DialogNodeVisitedDetails builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the DialogNodeVisitedDetails builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }
  }

  private DialogNodeVisitedDetails(Builder builder) {
    dialogNode = builder.dialogNode;
    title = builder.title;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeVisitedDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the dialogNode.
   *
   * A dialog node that was triggered during processing of the input message.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the title.
   *
   * The title of the dialog node.
   *
   * @return the title
   */
  public String title() {
    return title;
  }
}
