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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DialogNodeGoTo.
 */
public class DialogNodeGoTo extends GenericModel {

  /** The ID of the dialog node to go to. */
  @SerializedName("dialog_node")
  private String dialogNode;
  /** Where in the target node focus is passed to. */
  private String selector;
  /** Reserved for future use. */
  @SerializedName("return")
  private Boolean xreturn;

  /**
   * Gets the dialogNode.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the selector.
   *
   * @return the selector
   */
  public String getSelector() {
    return selector;
  }

  /**
   * Gets the return.
   *
   * @return the return
   */
  public Boolean getReturn() {
    return xreturn;
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
   * Sets the selector.
   *
   * @param selector the new selector
   */
  public void setSelector(final String selector) {
    this.selector = selector;
  }

  /**
   * Sets the return.
   *
   * @param xreturn the new return
   */
  public void setReturn(final Boolean xreturn) {
    this.xreturn = xreturn;
  }
}
