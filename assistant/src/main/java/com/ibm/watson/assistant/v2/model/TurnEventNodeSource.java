/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** TurnEventNodeSource. */
public class TurnEventNodeSource extends GenericModel {

  /** The type of turn event. */
  public interface Type {
    /** dialog_node. */
    String DIALOG_NODE = "dialog_node";
  }

  protected String type;

  @SerializedName("dialog_node")
  protected String dialogNode;

  protected String title;
  protected String condition;

  protected TurnEventNodeSource() {}

  /**
   * Gets the type.
   *
   * <p>The type of turn event.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>A dialog node that was visited during processing of the input message.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the title.
   *
   * <p>The title of the dialog node.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the condition.
   *
   * <p>The condition that triggered the dialog node.
   *
   * @return the condition
   */
  public String getCondition() {
    return condition;
  }
}
