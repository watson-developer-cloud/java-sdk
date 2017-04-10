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

import java.util.Map;

/**
 * DialogNodeResponse.
 */
public class DialogNodeResponse extends GenericModel {

  /** The dialog node ID. */
  @SerializedName("dialog_node")
  private String dialogNode;
  /** The description of the dialog node. */
  private String description;
  /** The condition that will trigger the dialog node. */
  private String conditions;
  /** The parent dialog node. */
  private String parent;
  /** The previous dialog node. */
  @SerializedName("previous_sibling")
  private String previousSibling;
  private DialogNodeOutput output;
  /** The context for the dialog node. */
  private Map<String,Object> context;
  /** The metadata for the dialog node. */
  private Map<String,Object> metadata;
  @SerializedName("go_to")
  private DialogNodeGoTo goTo;
  /** The timestamp for creation of the dialog node. */
  private String created;

  /**
   * Gets the dialogNode.
   *
   * @return the dialogNode
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the conditions.
   *
   * @return the conditions
   */
  public String getConditions() {
    return conditions;
  }

  /**
   * Gets the parent.
   *
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * @return the previousSibling
   */
  public String getPreviousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * @return the output
   */
  public DialogNodeOutput getOutput() {
    return output;
  }

  /**
   * Gets the context.
   *
   * @return the context
   */
  public Map<String,Object> getContext() {
    return context;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String,Object> getMetadata() {
    return metadata;
  }

  /**
   * Gets the goTo.
   *
   * @return the goTo
   */
  public DialogNodeGoTo getGoTo() {
    return goTo;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public String getCreated() {
    return created;
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
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the conditions.
   *
   * @param conditions the new conditions
   */
  public void setConditions(final String conditions) {
    this.conditions = conditions;
  }

  /**
   * Sets the parent.
   *
   * @param parent the new parent
   */
  public void setParent(final String parent) {
    this.parent = parent;
  }

  /**
   * Sets the previousSibling.
   *
   * @param previousSibling the new previousSibling
   */
  public void setPreviousSibling(final String previousSibling) {
    this.previousSibling = previousSibling;
  }

  /**
   * Sets the output.
   *
   * @param output the new output
   */
  public void setOutput(final DialogNodeOutput output) {
    this.output = output;
  }

  /**
   * Sets the context.
   *
   * @param context the new context
   */
  public void setContext(final Map<String,Object> context) {
    this.context = context;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map<String,Object> metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the goTo.
   *
   * @param goTo the new goTo
   */
  public void setGoTo(final DialogNodeGoTo goTo) {
    this.goTo = goTo;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final String created) {
    this.created = created;
  }
}
