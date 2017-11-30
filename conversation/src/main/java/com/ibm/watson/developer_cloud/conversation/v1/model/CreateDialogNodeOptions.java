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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createDialogNode options.
 */
public class CreateDialogNodeOptions extends GenericModel {

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

  private String workspaceId;
  private String dialogNode;
  private String description;
  private String conditions;
  private String parent;
  private String previousSibling;
  private Map output;
  private Map context;
  private Map metadata;
  private DialogNodeNextStep nextStep;
  private List<DialogNodeAction> actions;
  private String title;
  private String nodeType;
  private String eventName;
  private String variable;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String dialogNode;
    private String description;
    private String conditions;
    private String parent;
    private String previousSibling;
    private Map output;
    private Map context;
    private Map metadata;
    private DialogNodeNextStep nextStep;
    private List<DialogNodeAction> actions;
    private String title;
    private String nodeType;
    private String eventName;
    private String variable;

    private Builder(CreateDialogNodeOptions createDialogNodeOptions) {
      workspaceId = createDialogNodeOptions.workspaceId;
      dialogNode = createDialogNodeOptions.dialogNode;
      description = createDialogNodeOptions.description;
      conditions = createDialogNodeOptions.conditions;
      parent = createDialogNodeOptions.parent;
      previousSibling = createDialogNodeOptions.previousSibling;
      output = createDialogNodeOptions.output;
      context = createDialogNodeOptions.context;
      metadata = createDialogNodeOptions.metadata;
      nextStep = createDialogNodeOptions.nextStep;
      actions = createDialogNodeOptions.actions;
      title = createDialogNodeOptions.title;
      nodeType = createDialogNodeOptions.nodeType;
      eventName = createDialogNodeOptions.eventName;
      variable = createDialogNodeOptions.variable;
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
     * @param dialogNode the dialogNode
     */
    public Builder(String workspaceId, String dialogNode) {
      this.workspaceId = workspaceId;
      this.dialogNode = dialogNode;
    }

    /**
     * Builds a CreateDialogNodeOptions.
     *
     * @return the createDialogNodeOptions
     */
    public CreateDialogNodeOptions build() {
      return new CreateDialogNodeOptions(this);
    }

    /**
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the CreateDialogNodeOptions builder
     */
    public Builder addActions(DialogNodeAction actions) {
      Validator.notNull(actions, "actions cannot be null");
      if (this.actions == null) {
        this.actions = new ArrayList<DialogNodeAction>();
      }
      this.actions.add(actions);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateDialogNodeOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the CreateDialogNodeOptions builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateDialogNodeOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the conditions.
     *
     * @param conditions the conditions
     * @return the CreateDialogNodeOptions builder
     */
    public Builder conditions(String conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the CreateDialogNodeOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the previousSibling.
     *
     * @param previousSibling the previousSibling
     * @return the CreateDialogNodeOptions builder
     */
    public Builder previousSibling(String previousSibling) {
      this.previousSibling = previousSibling;
      return this;
    }

    /**
     * Set the output.
     *
     * @param output the output
     * @return the CreateDialogNodeOptions builder
     */
    public Builder output(Map output) {
      this.output = output;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the CreateDialogNodeOptions builder
     */
    public Builder context(Map context) {
      this.context = context;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateDialogNodeOptions builder
     */
    public Builder metadata(Map metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the nextStep.
     *
     * @param nextStep the nextStep
     * @return the CreateDialogNodeOptions builder
     */
    public Builder nextStep(DialogNodeNextStep nextStep) {
      this.nextStep = nextStep;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the CreateDialogNodeOptions builder
     */
    public Builder actions(List<DialogNodeAction> actions) {
      this.actions = actions;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the CreateDialogNodeOptions builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the nodeType.
     *
     * @param nodeType the nodeType
     * @return the CreateDialogNodeOptions builder
     */
    public Builder nodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    /**
     * Set the eventName.
     *
     * @param eventName the eventName
     * @return the CreateDialogNodeOptions builder
     */
    public Builder eventName(String eventName) {
      this.eventName = eventName;
      return this;
    }

    /**
     * Set the variable.
     *
     * @param variable the variable
     * @return the CreateDialogNodeOptions builder
     */
    public Builder variable(String variable) {
      this.variable = variable;
      return this;
    }
  }

  private CreateDialogNodeOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notNull(builder.dialogNode, "dialogNode cannot be null");
    workspaceId = builder.workspaceId;
    dialogNode = builder.dialogNode;
    description = builder.description;
    conditions = builder.conditions;
    parent = builder.parent;
    previousSibling = builder.previousSibling;
    output = builder.output;
    context = builder.context;
    metadata = builder.metadata;
    nextStep = builder.nextStep;
    actions = builder.actions;
    title = builder.title;
    nodeType = builder.nodeType;
    eventName = builder.eventName;
    variable = builder.variable;
  }

  /**
   * New builder.
   *
   * @return a CreateDialogNodeOptions builder
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
   * Gets the dialogNode.
   *
   * The dialog node ID.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the description.
   *
   * The description of the dialog node.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the conditions.
   *
   * The condition that will trigger the dialog node.
   *
   * @return the conditions
   */
  public String conditions() {
    return conditions;
  }

  /**
   * Gets the parent.
   *
   * The ID of the parent dialog node (if any).
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * The previous dialog node.
   *
   * @return the previousSibling
   */
  public String previousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * The output of the dialog node.
   *
   * @return the output
   */
  public Map output() {
    return output;
  }

  /**
   * Gets the context.
   *
   * The context for the dialog node.
   *
   * @return the context
   */
  public Map context() {
    return context;
  }

  /**
   * Gets the metadata.
   *
   * The metadata for the dialog node.
   *
   * @return the metadata
   */
  public Map metadata() {
    return metadata;
  }

  /**
   * Gets the nextStep.
   *
   * The next step to execute following this dialog node.
   *
   * @return the nextStep
   */
  public DialogNodeNextStep nextStep() {
    return nextStep;
  }

  /**
   * Gets the actions.
   *
   * The actions for the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> actions() {
    return actions;
  }

  /**
   * Gets the title.
   *
   * The alias used to identify the dialog node.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the nodeType.
   *
   * How the dialog node is processed.
   *
   * @return the nodeType
   */
  public String nodeType() {
    return nodeType;
  }

  /**
   * Gets the eventName.
   *
   * How an `event_handler` node is processed.
   *
   * @return the eventName
   */
  public String eventName() {
    return eventName;
  }

  /**
   * Gets the variable.
   *
   * The location in the dialog context where output is stored.
   *
   * @return the variable
   */
  public String variable() {
    return variable;
  }
}
