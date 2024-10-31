/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** The updateDialogNode options. */
public class UpdateDialogNodeOptions extends GenericModel {

  /** How the dialog node is processed. */
  public interface NewType {
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

  /** How an `event_handler` node is processed. */
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
    /** digression_return_prompt. */
    String DIGRESSION_RETURN_PROMPT = "digression_return_prompt";
  }

  /** Whether this top-level dialog node can be digressed into. */
  public interface NewDigressIn {
    /** not_available. */
    String NOT_AVAILABLE = "not_available";
    /** returns. */
    String RETURNS = "returns";
    /** does_not_return. */
    String DOES_NOT_RETURN = "does_not_return";
  }

  /** Whether this dialog node can be returned to after a digression. */
  public interface NewDigressOut {
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
    /** allow_all_never_return. */
    String ALLOW_ALL_NEVER_RETURN = "allow_all_never_return";
  }

  /** Whether the user can digress to top-level nodes while filling out slots. */
  public interface NewDigressOutSlots {
    /** not_allowed. */
    String NOT_ALLOWED = "not_allowed";
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
  }

  protected String workspaceId;
  protected String dialogNode;
  protected String newDialogNode;
  protected String newDescription;
  protected String newConditions;
  protected String newParent;
  protected String newPreviousSibling;
  protected DialogNodeOutput newOutput;
  protected DialogNodeContext newContext;
  protected Map<String, Object> newMetadata;
  protected DialogNodeNextStep newNextStep;
  protected String newTitle;
  protected String newType;
  protected String newEventName;
  protected String newVariable;
  protected List<DialogNodeAction> newActions;
  protected String newDigressIn;
  protected String newDigressOut;
  protected String newDigressOutSlots;
  protected String newUserLabel;
  protected Boolean newDisambiguationOptOut;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String dialogNode;
    private String newDialogNode;
    private String newDescription;
    private String newConditions;
    private String newParent;
    private String newPreviousSibling;
    private DialogNodeOutput newOutput;
    private DialogNodeContext newContext;
    private Map<String, Object> newMetadata;
    private DialogNodeNextStep newNextStep;
    private String newTitle;
    private String newType;
    private String newEventName;
    private String newVariable;
    private List<DialogNodeAction> newActions;
    private String newDigressIn;
    private String newDigressOut;
    private String newDigressOutSlots;
    private String newUserLabel;
    private Boolean newDisambiguationOptOut;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing UpdateDialogNodeOptions instance.
     *
     * @param updateDialogNodeOptions the instance to initialize the Builder with
     */
    private Builder(UpdateDialogNodeOptions updateDialogNodeOptions) {
      this.workspaceId = updateDialogNodeOptions.workspaceId;
      this.dialogNode = updateDialogNodeOptions.dialogNode;
      this.newDialogNode = updateDialogNodeOptions.newDialogNode;
      this.newDescription = updateDialogNodeOptions.newDescription;
      this.newConditions = updateDialogNodeOptions.newConditions;
      this.newParent = updateDialogNodeOptions.newParent;
      this.newPreviousSibling = updateDialogNodeOptions.newPreviousSibling;
      this.newOutput = updateDialogNodeOptions.newOutput;
      this.newContext = updateDialogNodeOptions.newContext;
      this.newMetadata = updateDialogNodeOptions.newMetadata;
      this.newNextStep = updateDialogNodeOptions.newNextStep;
      this.newTitle = updateDialogNodeOptions.newTitle;
      this.newType = updateDialogNodeOptions.newType;
      this.newEventName = updateDialogNodeOptions.newEventName;
      this.newVariable = updateDialogNodeOptions.newVariable;
      this.newActions = updateDialogNodeOptions.newActions;
      this.newDigressIn = updateDialogNodeOptions.newDigressIn;
      this.newDigressOut = updateDialogNodeOptions.newDigressOut;
      this.newDigressOutSlots = updateDialogNodeOptions.newDigressOutSlots;
      this.newUserLabel = updateDialogNodeOptions.newUserLabel;
      this.newDisambiguationOptOut = updateDialogNodeOptions.newDisambiguationOptOut;
      this.includeAudit = updateDialogNodeOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new UpdateDialogNodeOptions instance
     */
    public UpdateDialogNodeOptions build() {
      return new UpdateDialogNodeOptions(this);
    }

    /**
     * Adds a new element to newActions.
     *
     * @param newActions the new element to be added
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder addNewActions(DialogNodeAction newActions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newActions, "newActions cannot be null");
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
     * Set the newDialogNode.
     *
     * @param newDialogNode the newDialogNode
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDialogNode(String newDialogNode) {
      this.newDialogNode = newDialogNode;
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
     * Set the newOutput.
     *
     * @param newOutput the newOutput
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newOutput(DialogNodeOutput newOutput) {
      this.newOutput = newOutput;
      return this;
    }

    /**
     * Set the newContext.
     *
     * @param newContext the newContext
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newContext(DialogNodeContext newContext) {
      this.newContext = newContext;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newMetadata(Map<String, Object> newMetadata) {
      this.newMetadata = newMetadata;
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
     * Set the newType.
     *
     * @param newType the newType
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newType(String newType) {
      this.newType = newType;
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
     * Set the newActions. Existing newActions will be replaced.
     *
     * @param newActions the newActions
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newActions(List<DialogNodeAction> newActions) {
      this.newActions = newActions;
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
     * Set the newUserLabel.
     *
     * @param newUserLabel the newUserLabel
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newUserLabel(String newUserLabel) {
      this.newUserLabel = newUserLabel;
      return this;
    }

    /**
     * Set the newDisambiguationOptOut.
     *
     * @param newDisambiguationOptOut the newDisambiguationOptOut
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder newDisambiguationOptOut(Boolean newDisambiguationOptOut) {
      this.newDisambiguationOptOut = newDisambiguationOptOut;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateDialogNodeOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateDialogNodeOptions() {}

  protected UpdateDialogNodeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.dialogNode, "dialogNode cannot be empty");
    workspaceId = builder.workspaceId;
    dialogNode = builder.dialogNode;
    newDialogNode = builder.newDialogNode;
    newDescription = builder.newDescription;
    newConditions = builder.newConditions;
    newParent = builder.newParent;
    newPreviousSibling = builder.newPreviousSibling;
    newOutput = builder.newOutput;
    newContext = builder.newContext;
    newMetadata = builder.newMetadata;
    newNextStep = builder.newNextStep;
    newTitle = builder.newTitle;
    newType = builder.newType;
    newEventName = builder.newEventName;
    newVariable = builder.newVariable;
    newActions = builder.newActions;
    newDigressIn = builder.newDigressIn;
    newDigressOut = builder.newDigressOut;
    newDigressOutSlots = builder.newDigressOutSlots;
    newUserLabel = builder.newUserLabel;
    newDisambiguationOptOut = builder.newDisambiguationOptOut;
    includeAudit = builder.includeAudit;
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
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The dialog node ID (for example, `node_1_1479323581900`).
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the newDialogNode.
   *
   * <p>The unique ID of the dialog node. This is an internal identifier used to refer to the dialog
   * node from other dialog nodes and in the diagnostic information included with message responses.
   *
   * <p>This string can contain only Unicode alphanumeric, space, underscore, hyphen, and dot
   * characters.
   *
   * @return the newDialogNode
   */
  public String newDialogNode() {
    return newDialogNode;
  }

  /**
   * Gets the newDescription.
   *
   * <p>The description of the dialog node. This string cannot contain carriage return, newline, or
   * tab characters.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newConditions.
   *
   * <p>The condition that will trigger the dialog node. This string cannot contain carriage return,
   * newline, or tab characters.
   *
   * @return the newConditions
   */
  public String newConditions() {
    return newConditions;
  }

  /**
   * Gets the newParent.
   *
   * <p>The unique ID of the parent dialog node. This property is omitted if the dialog node has no
   * parent.
   *
   * @return the newParent
   */
  public String newParent() {
    return newParent;
  }

  /**
   * Gets the newPreviousSibling.
   *
   * <p>The unique ID of the previous sibling dialog node. This property is omitted if the dialog
   * node has no previous sibling.
   *
   * @return the newPreviousSibling
   */
  public String newPreviousSibling() {
    return newPreviousSibling;
  }

  /**
   * Gets the newOutput.
   *
   * <p>The output of the dialog node. For more information about how to specify dialog node output,
   * see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-dialog-overview#dialog-overview-responses).
   *
   * @return the newOutput
   */
  public DialogNodeOutput newOutput() {
    return newOutput;
  }

  /**
   * Gets the newContext.
   *
   * <p>The context for the dialog node.
   *
   * @return the newContext
   */
  public DialogNodeContext newContext() {
    return newContext;
  }

  /**
   * Gets the newMetadata.
   *
   * <p>The metadata for the dialog node.
   *
   * @return the newMetadata
   */
  public Map<String, Object> newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newNextStep.
   *
   * <p>The next step to execute following this dialog node.
   *
   * @return the newNextStep
   */
  public DialogNodeNextStep newNextStep() {
    return newNextStep;
  }

  /**
   * Gets the newTitle.
   *
   * <p>A human-readable name for the dialog node. If the node is included in disambiguation, this
   * title is used to populate the **label** property of the corresponding suggestion in the
   * `suggestion` response type (unless it is overridden by the **user_label** property). The title
   * is also used to populate the **topic** property in the `connect_to_agent` response type.
   *
   * <p>This string can contain only Unicode alphanumeric, space, underscore, hyphen, and dot
   * characters.
   *
   * @return the newTitle
   */
  public String newTitle() {
    return newTitle;
  }

  /**
   * Gets the newType.
   *
   * <p>How the dialog node is processed.
   *
   * @return the newType
   */
  public String newType() {
    return newType;
  }

  /**
   * Gets the newEventName.
   *
   * <p>How an `event_handler` node is processed.
   *
   * @return the newEventName
   */
  public String newEventName() {
    return newEventName;
  }

  /**
   * Gets the newVariable.
   *
   * <p>The location in the dialog context where output is stored.
   *
   * @return the newVariable
   */
  public String newVariable() {
    return newVariable;
  }

  /**
   * Gets the newActions.
   *
   * <p>An array of objects describing any actions to be invoked by the dialog node.
   *
   * @return the newActions
   */
  public List<DialogNodeAction> newActions() {
    return newActions;
  }

  /**
   * Gets the newDigressIn.
   *
   * <p>Whether this top-level dialog node can be digressed into.
   *
   * @return the newDigressIn
   */
  public String newDigressIn() {
    return newDigressIn;
  }

  /**
   * Gets the newDigressOut.
   *
   * <p>Whether this dialog node can be returned to after a digression.
   *
   * @return the newDigressOut
   */
  public String newDigressOut() {
    return newDigressOut;
  }

  /**
   * Gets the newDigressOutSlots.
   *
   * <p>Whether the user can digress to top-level nodes while filling out slots.
   *
   * @return the newDigressOutSlots
   */
  public String newDigressOutSlots() {
    return newDigressOutSlots;
  }

  /**
   * Gets the newUserLabel.
   *
   * <p>A label that can be displayed externally to describe the purpose of the node to users. If
   * set, this label is used to identify the node in disambiguation responses (overriding the value
   * of the **title** property).
   *
   * @return the newUserLabel
   */
  public String newUserLabel() {
    return newUserLabel;
  }

  /**
   * Gets the newDisambiguationOptOut.
   *
   * <p>Whether the dialog node should be excluded from disambiguation suggestions. Valid only when
   * **type**=`standard` or `frame`.
   *
   * @return the newDisambiguationOptOut
   */
  public Boolean newDisambiguationOptOut() {
    return newDisambiguationOptOut;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}
