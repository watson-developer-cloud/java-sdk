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
 * The next step to execute following this dialog node.
 */
public class DialogNodeNextStep extends GenericModel {

  /**
   * How the `next_step` reference is processed.
   */
  public interface Behavior {
    /** jump_to. */
    String JUMP_TO = "jump_to";
  }

  /**
   * Which part of the dialog node to process next.
   */
  public interface Selector {
    /** condition. */
    String CONDITION = "condition";
    /** client. */
    String CLIENT = "client";
    /** user_input. */
    String USER_INPUT = "user_input";
    /** body. */
    String BODY = "body";
  }

  private String behavior;
  @SerializedName("dialog_node")
  private String dialogNode;
  private String selector;

  /**
   * Gets the behavior.
   *
   * How the `next_step` reference is processed.
   *
   * @return the behavior
   */
  public String getBehavior() {
    return behavior;
  }

  /**
   * Gets the dialogNode.
   *
   * The ID of the dialog node to process next.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the selector.
   *
   * Which part of the dialog node to process next.
   *
   * @return the selector
   */
  public String getSelector() {
    return selector;
  }

  /**
   * Sets the behavior.
   *
   * @param behavior the new behavior
   */
  public void setBehavior(final String behavior) {
    this.behavior = behavior;
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
}
