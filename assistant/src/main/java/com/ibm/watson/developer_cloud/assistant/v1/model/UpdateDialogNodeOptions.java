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
package com.ibm.watson.developer_cloud.assistant.v1.model;

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
    /** folder. */
    String FOLDER = "folder";
  }

  /**
   * Whether this dialog node can be returned to after a digression.
   */
  public interface NewDigressOut {
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
    /** allow_all_never_return. */
    String ALLOW_ALL_NEVER_RETURN = "allow_all_never_return";
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

  /**
   * Whether the user can digress to top-level nodes while filling out slots.
   */
  public interface NewDigressOutSlots {
    /** not_allowed. */
    String NOT_ALLOWED = "not_allowed";
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
  }

  /**
   * Whether this top-level dialog node can be digressed into.
   */
  public interface NewDigressIn {
    /** not_available. */
    String NOT_AVAILABLE = "not_available";
    /** returns. */
    String RETURNS = "returns";
    /** does_not_return. */
    String DOES_NOT_RETURN = "does_not_return";
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
  private String newDigressOut;
  private String newEventName;
  private String newDigressOutSlots;
  private DialogNodeNextStep newNextStep;
  private String newDigressIn;
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
    private String newDigressOut;
    private String newEventName;
    private String newDigressOutSlots;
    private DialogNodeNextStep newNextStep;
    private String newDigressIn;
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
      newDigressOut = updateDialogNodeOptions.newDigressOut;
      newEventName = updateDialogNodeOptions.newEventName;
      newDigressOutSlots = updateDialogNodeOptions.newDigressOutSlots;
      newNextStep = updateDialogNodeOptions.newNextStep;
      newDigressIn = updateDialogNodeOptions.newDigressIn;
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
     */
    public Builder(String workspaceId, String dialogNode) {
      this.workspaceId = workspaceId;
      this.dialogNode = dialogNode;
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
     * Set the newDigressOut.
     *
     * @param newDigressOut the newDigressOut
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDigressOut(String newDigressOut) {
      this.newDigressOut = newDigressOut;
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
     * Set the newDigressOutSlots.
     *
     * @param newDigressOutSlots the newDigressOutSlots
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDigressOutSlots(String newDigressOutSlots) {
      this.newDigressOutSlots = newDigressOutSlots;
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
     * Set the newDigressIn.
     *
     * @param newDigressIn the newDigressIn
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDigressIn(String newDigressIn) {
      this.newDigressIn = newDigressIn;
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
    newDigressOut = builder.newDigressOut;
    newEventName = builder.newEventName;
    newDigressOutSlots = builder.newDigressOutSlots;
    newNextStep = builder.newNextStep;
    newDigressIn = builder.newDigressIn;
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
   * Unique identifier of the workspace.
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
   * How the dialog node is processed.
   *
   * @return the nodeType
   */
  public String nodeType() {
    return nodeType;
  }

  /**
   * Gets the newActions.
   *
   * An array of objects describing any actions to be invoked by the dialog node.
   *
   * @return the newActions
   */
  public List<DialogNodeAction> newActions() {
    return newActions;
  }

  /**
   * Gets the newConditions.
   *
   * The condition that will trigger the dialog node. This string cannot contain carriage return, newline, or tab
   * characters, and it must be no longer than 2048 characters.
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
   * The ID of the previous sibling dialog node.
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
   * The alias used to identify the dialog node. This string must conform to the following restrictions: - It can
   * contain only Unicode alphanumeric, space, underscore, hyphen, and dot characters. - It must be no longer than 64
   * characters.
   *
   * @return the newTitle
   */
  public String newTitle() {
    return newTitle;
  }

  /**
   * Gets the newDescription.
   *
   * The description of the dialog node. This string cannot contain carriage return, newline, or tab characters, and it
   * must be no longer than 128 characters.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newDigressOut.
   *
   * Whether this dialog node can be returned to after a digression.
   *
   * @return the newDigressOut
   */
  public String newDigressOut() {
    return newDigressOut;
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
   * Gets the newDigressOutSlots.
   *
   * Whether the user can digress to top-level nodes while filling out slots.
   *
   * @return the newDigressOutSlots
   */
  public String newDigressOutSlots() {
    return newDigressOutSlots;
  }

  /**
   * Gets the newNextStep.
   *
   * The next step to be executed in dialog processing.
   *
   * @return the newNextStep
   */
  public DialogNodeNextStep newNextStep() {
    return newNextStep;
  }

  /**
   * Gets the newDigressIn.
   *
   * Whether this top-level dialog node can be digressed into.
   *
   * @return the newDigressIn
   */
  public String newDigressIn() {
    return newDigressIn;
  }

  /**
   * Gets the newOutput.
   *
   * The output of the dialog node. For more information about how to specify dialog node output, see the
   * [documentation](https://console.bluemix.net/docs/services/conversation/dialog-overview.html#complex).
   *
   * @return the newOutput
   */
  public Map newOutput() {
    return newOutput;
  }

  /**
   * Gets the newParent.
   *
   * The ID of the parent dialog node.
   *
   * @return the newParent
   */
  public String newParent() {
    return newParent;
  }

  /**
   * Gets the newDialogNode.
   *
   * The dialog node ID. This string must conform to the following restrictions: - It can contain only Unicode
   * alphanumeric, space, underscore, hyphen, and dot characters. - It must be no longer than 1024 characters.
   *
   * @return the newDialogNode
   */
  public String newDialogNode() {
    return newDialogNode;
  }
}
