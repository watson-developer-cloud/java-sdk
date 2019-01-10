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
    /** folder. */
    String FOLDER = "folder";
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
    /** digression_return_prompt. */
    String DIGRESSION_RETURN_PROMPT = "digression_return_prompt";
  }

  /**
   * Whether this top-level dialog node can be digressed into.
   */
  public interface DigressIn {
    /** not_available. */
    String NOT_AVAILABLE = "not_available";
    /** returns. */
    String RETURNS = "returns";
    /** does_not_return. */
    String DOES_NOT_RETURN = "does_not_return";
  }

  /**
   * Whether this dialog node can be returned to after a digression.
   */
  public interface DigressOut {
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
    /** allow_all_never_return. */
    String ALLOW_ALL_NEVER_RETURN = "allow_all_never_return";
  }

  /**
   * Whether the user can digress to top-level nodes while filling out slots.
   */
  public interface DigressOutSlots {
    /** not_allowed. */
    String NOT_ALLOWED = "not_allowed";
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
  }

  @SerializedName("dialog_node")
  private String dialogNodeId;
  private String description;
  private String conditions;
  private String parent;
  @SerializedName("previous_sibling")
  private String previousSibling;
  private DialogNodeOutput output;
  private Map context;
  private Map metadata;
  @SerializedName("next_step")
  private DialogNodeNextStep nextStep;
  private Date created;
  private Date updated;
  private List<DialogNodeAction> actions;
  private String title;
  private Boolean disabled;
  @SerializedName("type")
  private String nodeType;
  @SerializedName("event_name")
  private String eventName;
  private String variable;
  @SerializedName("digress_in")
  private String digressIn;
  @SerializedName("digress_out")
  private String digressOut;
  @SerializedName("digress_out_slots")
  private String digressOutSlots;
  @SerializedName("user_label")
  private String userLabel;

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
   * The ID of the parent dialog node. This property is not returned if the dialog node has no parent.
   *
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * The ID of the previous sibling dialog node. This property is not returned if the dialog node has no previous
   * sibling.
   *
   * @return the previousSibling
   */
  public String getPreviousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * The output of the dialog node. For more information about how to specify dialog node output, see the
   * [documentation](https://cloud.ibm.com/docs/services/assistant/dialog-overview.html#complex).
   *
   * @return the output
   */
  public DialogNodeOutput getOutput() {
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
   * Any metadata for the dialog node.
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
   * Gets the disabled.
   *
   * For internal use only.
   *
   * @return the disabled
   */
  public Boolean isDisabled() {
    return disabled;
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
   * Gets the digressIn.
   *
   * Whether this top-level dialog node can be digressed into.
   *
   * @return the digressIn
   */
  public String getDigressIn() {
    return digressIn;
  }

  /**
   * Gets the digressOut.
   *
   * Whether this dialog node can be returned to after a digression.
   *
   * @return the digressOut
   */
  public String getDigressOut() {
    return digressOut;
  }

  /**
   * Gets the digressOutSlots.
   *
   * Whether the user can digress to top-level nodes while filling out slots.
   *
   * @return the digressOutSlots
   */
  public String getDigressOutSlots() {
    return digressOutSlots;
  }

  /**
   * Gets the userLabel.
   *
   * A label that can be displayed externally to describe the purpose of the node to users. This string must be no
   * longer than 512 characters.
   *
   * @return the userLabel
   */
  public String getUserLabel() {
    return userLabel;
  }
}
