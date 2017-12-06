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
 * The UpdateDialogNode options.
 */
public class UpdateDialogNodeOptions extends GenericModel {

  /**
   * How the node is processed.
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
  public interface NewEventName {
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
  private String nodeType;
  private List<DialogNodeAction> newActions;
  private String newConditions;
  private Map newContext;
  private String newPreviousSibling;
  private String newVariable;
  private Map newMetadata;
  private String newTitle;
  private String newDescription;
  private String newEventName;
  private DialogNodeNextStep newNextStep;
  private Map newOutput;
  private String newParent;
  private String newDialogNode;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String dialogNode;
    private String nodeType;
    private List<DialogNodeAction> newActions;
    private String newConditions;
    private Map newContext;
    private String newPreviousSibling;
    private String newVariable;
    private Map newMetadata;
    private String newTitle;
    private String newDescription;
    private String newEventName;
    private DialogNodeNextStep newNextStep;
    private Map newOutput;
    private String newParent;
    private String newDialogNode;

    private Builder(UpdateDialogNodeOptions updateDialogNodeOptions) {
      workspaceId = updateDialogNodeOptions.workspaceId;
      dialogNode = updateDialogNodeOptions.dialogNode;
      nodeType = updateDialogNodeOptions.nodeType;
      newActions = updateDialogNodeOptions.newActions;
      newConditions = updateDialogNodeOptions.newConditions;
      newContext = updateDialogNodeOptions.newContext;
      newPreviousSibling = updateDialogNodeOptions.newPreviousSibling;
      newVariable = updateDialogNodeOptions.newVariable;
      newMetadata = updateDialogNodeOptions.newMetadata;
      newTitle = updateDialogNodeOptions.newTitle;
      newDescription = updateDialogNodeOptions.newDescription;
      newEventName = updateDialogNodeOptions.newEventName;
      newNextStep = updateDialogNodeOptions.newNextStep;
      newOutput = updateDialogNodeOptions.newOutput;
      newParent = updateDialogNodeOptions.newParent;
      newDialogNode = updateDialogNodeOptions.newDialogNode;
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
     * @param newDialogNode the newDialogNode
     */
    public Builder(String workspaceId, String dialogNode, String newDialogNode) {
      this.workspaceId = workspaceId;
      this.dialogNode = dialogNode;
      this.newDialogNode = newDialogNode;
    }

    /**
     * Builds a UpdateDialogNodeOptions.
     *
     * @return the updateDialogNodeOptions
     */
    public UpdateDialogNodeOptions build() {
      return new UpdateDialogNodeOptions(this);
    }

    /**
     * Adds an newActions to newActions.
     *
     * @param newActions the new newActions
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder addNewActions(DialogNodeAction newActions) {
      Validator.notNull(newActions, "newActions cannot be null");
      if (this.newActions == null) {
        this.newActions = new ArrayList<DialogNodeAction>();
      }
      this.newActions.add(newActions);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the nodeType.
     *
     * @param nodeType the nodeType
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder nodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    /**
     * Set the newActions.
     * Existing newActions will be replaced.
     *
     * @param newActions the newActions
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newActions(List<DialogNodeAction> newActions) {
      this.newActions = newActions;
      return this;
    }

    /**
     * Set the newConditions.
     *
     * @param newConditions the newConditions
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newConditions(String newConditions) {
      this.newConditions = newConditions;
      return this;
    }

    /**
     * Set the newContext.
     *
     * @param newContext the newContext
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newContext(Map newContext) {
      this.newContext = newContext;
      return this;
    }

    /**
     * Set the newPreviousSibling.
     *
     * @param newPreviousSibling the newPreviousSibling
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newPreviousSibling(String newPreviousSibling) {
      this.newPreviousSibling = newPreviousSibling;
      return this;
    }

    /**
     * Set the newVariable.
     *
     * @param newVariable the newVariable
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newVariable(String newVariable) {
      this.newVariable = newVariable;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newMetadata(Map newMetadata) {
      this.newMetadata = newMetadata;
      return this;
    }

    /**
     * Set the newTitle.
     *
     * @param newTitle the newTitle
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newTitle(String newTitle) {
      this.newTitle = newTitle;
      return this;
    }

    /**
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }

    /**
     * Set the newEventName.
     *
     * @param newEventName the newEventName
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newEventName(String newEventName) {
      this.newEventName = newEventName;
      return this;
    }

    /**
     * Set the newNextStep.
     *
     * @param newNextStep the newNextStep
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newNextStep(DialogNodeNextStep newNextStep) {
      this.newNextStep = newNextStep;
      return this;
    }

    /**
     * Set the newOutput.
     *
     * @param newOutput the newOutput
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newOutput(Map newOutput) {
      this.newOutput = newOutput;
      return this;
    }

    /**
     * Set the newParent.
     *
     * @param newParent the newParent
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newParent(String newParent) {
      this.newParent = newParent;
      return this;
    }

    /**
     * Set the newDialogNode.
     *
     * @param newDialogNode the newDialogNode
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDialogNode(String newDialogNode) {
      this.newDialogNode = newDialogNode;
      return this;
    }
  }

  private UpdateDialogNodeOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.dialogNode, "dialogNode cannot be empty");
    Validator.notNull(builder.newDialogNode, "newDialogNode cannot be null");
    workspaceId = builder.workspaceId;
    dialogNode = builder.dialogNode;
    nodeType = builder.nodeType;
    newActions = builder.newActions;
    newConditions = builder.newConditions;
    newContext = builder.newContext;
    newPreviousSibling = builder.newPreviousSibling;
    newVariable = builder.newVariable;
    newMetadata = builder.newMetadata;
    newTitle = builder.newTitle;
    newDescription = builder.newDescription;
    newEventName = builder.newEventName;
    newNextStep = builder.newNextStep;
    newOutput = builder.newOutput;
    newParent = builder.newParent;
    newDialogNode = builder.newDialogNode;
  }

  /**
   * New builder.
   *
   * @return a UpdateDialogNodeOptions builder
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
   * The dialog node ID (for example, `get_order`).
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the nodeType.
   *
   * How the node is processed.
   *
   * @return the nodeType
   */
  public String nodeType() {
    return nodeType;
  }

  /**
   * Gets the newActions.
   *
   * The actions for the dialog node.
   *
   * @return the newActions
   */
  public List<DialogNodeAction> newActions() {
    return newActions;
  }

  /**
   * Gets the newConditions.
   *
   * The condition that will trigger the dialog node.
   *
   * @return the newConditions
   */
  public String newConditions() {
    return newConditions;
  }

  /**
   * Gets the newContext.
   *
   * The context for the dialog node.
   *
   * @return the newContext
   */
  public Map newContext() {
    return newContext;
  }

  /**
   * Gets the newPreviousSibling.
   *
   * The previous dialog node.
   *
   * @return the newPreviousSibling
   */
  public String newPreviousSibling() {
    return newPreviousSibling;
  }

  /**
   * Gets the newVariable.
   *
   * The location in the dialog context where output is stored.
   *
   * @return the newVariable
   */
  public String newVariable() {
    return newVariable;
  }

  /**
   * Gets the newMetadata.
   *
   * The metadata for the dialog node.
   *
   * @return the newMetadata
   */
  public Map newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newTitle.
   *
   * The alias used to identify the dialog node.
   *
   * @return the newTitle
   */
  public String newTitle() {
    return newTitle;
  }

  /**
   * Gets the newDescription.
   *
   * The description of the dialog node.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newEventName.
   *
   * How an `event_handler` node is processed.
   *
   * @return the newEventName
   */
  public String newEventName() {
    return newEventName;
  }

  /**
   * Gets the newNextStep.
   *
   * The next step to execute following this dialog node.
   *
   * @return the newNextStep
   */
  public DialogNodeNextStep newNextStep() {
    return newNextStep;
  }

  /**
   * Gets the newOutput.
   *
   * The output of the dialog node.
   *
   * @return the newOutput
   */
  public Map newOutput() {
    return newOutput;
  }

  /**
   * Gets the newParent.
   *
   * The ID of the parent dialog node (if any).
   *
   * @return the newParent
   */
  public String newParent() {
    return newParent;
  }

  /**
   * Gets the newDialogNode.
   *
   * The dialog node ID.
   *
   * @return the newDialogNode
   */
  public String newDialogNode() {
    return newDialogNode;
  }
}
