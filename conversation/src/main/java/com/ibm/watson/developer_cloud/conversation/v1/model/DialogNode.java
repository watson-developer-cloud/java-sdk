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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DialogNode.
 */
public class DialogNode extends GenericModel {

  /**
   * How the dialog node is processed.
   */
  public interface NodeType {
    /** standard. */
    String STANDARD = "standard";
    /** event_handler. */
    String EVENT_HANDLER = "event_handler";
    /** frame. */
    String FRAME = "frame";
    /** slot. */
    String SLOT = "slot";
    /** response_condition. */
    String RESPONSE_CONDITION = "response_condition";
  }

  /**
   * How an `event_handler` node is processed.
   */
  public interface EventName {
    /** focus. */
    String FOCUS = "focus";
    /** input. */
    String INPUT = "input";
    /** filled. */
    String FILLED = "filled";
    /** validate. */
    String VALIDATE = "validate";
    /** filled_multiple. */
    String FILLED_MULTIPLE = "filled_multiple";
    /** generic. */
    String GENERIC = "generic";
    /** nomatch. */
    String NOMATCH = "nomatch";
    /** nomatch_responses_depleted. */
    String NOMATCH_RESPONSES_DEPLETED = "nomatch_responses_depleted";
  }

  @SerializedName("dialog_node")
  private String dialogNodeId;
  private String description;
  private String conditions;
  private String parent;
  @SerializedName("previous_sibling")
  private String previousSibling;
  private Map output;
  private Map context;
  private Map metadata;
  @SerializedName("next_step")
  private DialogNodeNextStep nextStep;
  private Date created;
  private Date updated;
  private List<DialogNodeAction> actions;
  private String title;
  @SerializedName("type")
  private String nodeType;
  @SerializedName("event_name")
  private String eventName;
  private String variable;

  /**
   * Gets the dialogNodeId.
   *
   * The dialog node ID.
   *
   * @return the dialogNodeId
   */
  public String getDialogNodeId() {
    return dialogNodeId;
  }

  /**
   * Gets the description.
   *
   * The description of the dialog node.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the conditions.
   *
   * The condition that triggers the dialog node.
   *
   * @return the conditions
   */
  public String getConditions() {
    return conditions;
  }

  /**
   * Gets the parent.
   *
   * The ID of the parent dialog node.
   *
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * The ID of the previous sibling dialog node.
   *
   * @return the previousSibling
   */
  public String getPreviousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * The output of the dialog node.
   *
   * @return the output
   */
  public Map getOutput() {
    return output;
  }

  /**
   * Gets the context.
   *
   * The context (if defined) for the dialog node.
   *
   * @return the context
   */
  public Map getContext() {
    return context;
  }

  /**
   * Gets the metadata.
   *
   * The metadata (if any) for the dialog node.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return metadata;
  }

  /**
   * Gets the nextStep.
   *
   * The next step to execute following this dialog node.
   *
   * @return the nextStep
   */
  public DialogNodeNextStep getNextStep() {
    return nextStep;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the dialog node.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the dialog node.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the actions.
   *
   * The actions for the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return actions;
  }

  /**
   * Gets the title.
   *
   * The alias used to identify the dialog node.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the nodeType.
   *
   * How the dialog node is processed.
   *
   * @return the nodeType
   */
  public String getNodeType() {
    return nodeType;
  }

  /**
   * Gets the eventName.
   *
   * How an `event_handler` node is processed.
   *
   * @return the eventName
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * Gets the variable.
   *
   * The location in the dialog context where output is stored.
   *
   * @return the variable
   */
  public String getVariable() {
    return variable;
  }

  /**
   * Sets the dialogNodeId.
   *
   * @param dialogNodeId the new dialogNodeId
   */
  public void setDialogNodeId(final String dialogNodeId) {
    this.dialogNodeId = dialogNodeId;
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
  public void setOutput(final Map output) {
    this.output = output;
  }

  /**
   * Sets the context.
   *
   * @param context the new context
   */
  public void setContext(final Map context) {
    this.context = context;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the nextStep.
   *
   * @param nextStep the new nextStep
   */
  public void setNextStep(final DialogNodeNextStep nextStep) {
    this.nextStep = nextStep;
  }

  /**
   * Sets the actions.
   *
   * @param actions the new actions
   */
  public void setActions(final List<DialogNodeAction> actions) {
    this.actions = actions;
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
   * Sets the nodeType.
   *
   * @param nodeType the new nodeType
   */
  public void setNodeType(final String nodeType) {
    this.nodeType = nodeType;
  }

  /**
   * Sets the eventName.
   *
   * @param eventName the new eventName
   */
  public void setEventName(final String eventName) {
    this.eventName = eventName;
  }

  /**
   * Sets the variable.
   *
   * @param variable the new variable
   */
  public void setVariable(final String variable) {
    this.variable = variable;
  }
}
