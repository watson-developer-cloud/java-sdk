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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DialogNodeVisitedDetails.
 */
public class DialogNodeVisitedDetails extends GenericModel {

  @SerializedName("dialog_node")
  private String dialogNode;
  private String title;
  private String conditions;

  /**
   * Gets the dialogNode.
   *
   * A dialog node that was triggered during processing of the input message.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the title.
   *
   * The title of the dialog node.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the conditions.
   *
   * The conditions that trigger the dialog node.
   *
   * @return the conditions
   */
  public String getConditions() {
    return conditions;
  }

  /**
   * Sets the dialogNode.
   *
   * @param dialogNode the new dialogNode
   */
  public void setDialogNode(final String dialogNode) {
    this.dialogNode = dialogNode;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Sets the conditions.
   *
   * @param conditions the new conditions
   */
  public void setConditions(final String conditions) {
    this.conditions = conditions;
  }
}
