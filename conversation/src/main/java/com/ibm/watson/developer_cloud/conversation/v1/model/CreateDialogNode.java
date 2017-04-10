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
import com.ibm.watson.developer_cloud.util.Validator;

import java.util.Map;

/**
 * CreateDialogNode.
 */
public class CreateDialogNode extends GenericModel {

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

  /**
   * Builder.
   */
  public static class Builder {
    private String dialogNode;
    private String description;
    private String conditions;
    private String parent;
    private String previousSibling;
    private DialogNodeOutput output;
    private Map<String,Object> context;
    private Map<String,Object> metadata;
    private DialogNodeGoTo goTo;

    private Builder(CreateDialogNode createDialogNode) {
      dialogNode = createDialogNode.dialogNode;
      description = createDialogNode.description;
      conditions = createDialogNode.conditions;
      parent = createDialogNode.parent;
      previousSibling = createDialogNode.previousSibling;
      output = createDialogNode.output;
      context = createDialogNode.context;
      metadata = createDialogNode.metadata;
      goTo = createDialogNode.goTo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the CreateDialogNode.
     *
     * @return the createDialogNode
     */
    public CreateDialogNode build() {
      return new CreateDialogNode(this);
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return a CreateDialogNode Builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return a CreateDialogNode Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the conditions.
     *
     * @param conditions the conditions
     * @return a CreateDialogNode Builder
     */
    public Builder conditions(String conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return a CreateDialogNode Builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the previousSibling.
     *
     * @param previousSibling the previousSibling
     * @return a CreateDialogNode Builder
     */
    public Builder previousSibling(String previousSibling) {
      this.previousSibling = previousSibling;
      return this;
    }

    /**
     * Set the output.
     *
     * @param output the output
     * @return a CreateDialogNode Builder
     */
    public Builder output(DialogNodeOutput output) {
      this.output = output;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return a CreateDialogNode Builder
     */
    public Builder context(Map<String,Object> context) {
      this.context = context;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return a CreateDialogNode Builder
     */
    public Builder metadata(Map<String,Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the goTo.
     *
     * @param goTo the goTo
     * @return a CreateDialogNode Builder
     */
    public Builder goTo(DialogNodeGoTo goTo) {
      this.goTo = goTo;
      return this;
    }
  }

  private CreateDialogNode(Builder builder) {
    Validator.notNull(builder.dialogNode, "dialogNode cannot be null");
    dialogNode = builder.dialogNode;
    description = builder.description;
    conditions = builder.conditions;
    parent = builder.parent;
    previousSibling = builder.previousSibling;
    output = builder.output;
    context = builder.context;
    metadata = builder.metadata;
    goTo = builder.goTo;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the dialogNode.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the conditions.
   *
   * @return the conditions
   */
  public String conditions() {
    return conditions;
  }

  /**
   * Gets the parent.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * @return the previousSibling
   */
  public String previousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * @return the output
   */
  public DialogNodeOutput output() {
    return output;
  }

  /**
   * Gets the context.
   *
   * @return the context
   */
  public Map<String,Object> context() {
    return context;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String,Object> metadata() {
    return metadata;
  }

  /**
   * Gets the goTo.
   *
   * @return the goTo
   */
  public DialogNodeGoTo goTo() {
    return goTo;
  }
}
