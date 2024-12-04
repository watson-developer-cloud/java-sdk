/*
 * (C) Copyright IBM Corp. 2017, 2024.
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

/** The createDialogNode options. */
public class CreateDialogNodeOptions extends GenericModel {

  /** How the dialog node is processed. */
  public interface Type {
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

  /** Whether this top-level dialog node can be digressed into. */
  public interface DigressIn {
    /** not_available. */
    String NOT_AVAILABLE = "not_available";
    /** returns. */
    String RETURNS = "returns";
    /** does_not_return. */
    String DOES_NOT_RETURN = "does_not_return";
  }

  /** Whether this dialog node can be returned to after a digression. */
  public interface DigressOut {
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
    /** allow_all_never_return. */
    String ALLOW_ALL_NEVER_RETURN = "allow_all_never_return";
  }

  /** Whether the user can digress to top-level nodes while filling out slots. */
  public interface DigressOutSlots {
    /** not_allowed. */
    String NOT_ALLOWED = "not_allowed";
    /** allow_returning. */
    String ALLOW_RETURNING = "allow_returning";
    /** allow_all. */
    String ALLOW_ALL = "allow_all";
  }

  protected String workspaceId;
  protected String dialogNode;
  protected String description;
  protected String conditions;
  protected String parent;
  protected String previousSibling;
  protected DialogNodeOutput output;
  protected DialogNodeContext context;
  protected Map<String, Object> metadata;
  protected DialogNodeNextStep nextStep;
  protected String title;
  protected String type;
  protected String eventName;
  protected String variable;
  protected List<DialogNodeAction> actions;
  protected String digressIn;
  protected String digressOut;
  protected String digressOutSlots;
  protected String userLabel;
  protected Boolean disambiguationOptOut;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String dialogNode;
    private String description;
    private String conditions;
    private String parent;
    private String previousSibling;
    private DialogNodeOutput output;
    private DialogNodeContext context;
    private Map<String, Object> metadata;
    private DialogNodeNextStep nextStep;
    private String title;
    private String type;
    private String eventName;
    private String variable;
    private List<DialogNodeAction> actions;
    private String digressIn;
    private String digressOut;
    private String digressOutSlots;
    private String userLabel;
    private Boolean disambiguationOptOut;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing CreateDialogNodeOptions instance.
     *
     * @param createDialogNodeOptions the instance to initialize the Builder with
     */
    private Builder(CreateDialogNodeOptions createDialogNodeOptions) {
      this.workspaceId = createDialogNodeOptions.workspaceId;
      this.dialogNode = createDialogNodeOptions.dialogNode;
      this.description = createDialogNodeOptions.description;
      this.conditions = createDialogNodeOptions.conditions;
      this.parent = createDialogNodeOptions.parent;
      this.previousSibling = createDialogNodeOptions.previousSibling;
      this.output = createDialogNodeOptions.output;
      this.context = createDialogNodeOptions.context;
      this.metadata = createDialogNodeOptions.metadata;
      this.nextStep = createDialogNodeOptions.nextStep;
      this.title = createDialogNodeOptions.title;
      this.type = createDialogNodeOptions.type;
      this.eventName = createDialogNodeOptions.eventName;
      this.variable = createDialogNodeOptions.variable;
      this.actions = createDialogNodeOptions.actions;
      this.digressIn = createDialogNodeOptions.digressIn;
      this.digressOut = createDialogNodeOptions.digressOut;
      this.digressOutSlots = createDialogNodeOptions.digressOutSlots;
      this.userLabel = createDialogNodeOptions.userLabel;
      this.disambiguationOptOut = createDialogNodeOptions.disambiguationOptOut;
      this.includeAudit = createDialogNodeOptions.includeAudit;
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
     * Builds a CreateDialogNodeOptions.
     *
     * @return the new CreateDialogNodeOptions instance
     */
    public CreateDialogNodeOptions build() {
      return new CreateDialogNodeOptions(this);
    }

    /**
     * Adds a new element to actions.
     *
     * @param actions the new element to be added
     * @return the CreateDialogNodeOptions builder
     */
    public Builder addActions(DialogNodeAction actions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(actions, "actions cannot be null");
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
    public Builder output(DialogNodeOutput output) {
      this.output = output;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the CreateDialogNodeOptions builder
     */
    public Builder context(DialogNodeContext context) {
      this.context = context;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateDialogNodeOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
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
     * Set the type.
     *
     * @param type the type
     * @return the CreateDialogNodeOptions builder
     */
    public Builder type(String type) {
      this.type = type;
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

    /**
     * Set the actions. Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the CreateDialogNodeOptions builder
     */
    public Builder actions(List<DialogNodeAction> actions) {
      this.actions = actions;
      return this;
    }

    /**
     * Set the digressIn.
     *
     * @param digressIn the digressIn
     * @return the CreateDialogNodeOptions builder
     */
    public Builder digressIn(String digressIn) {
      this.digressIn = digressIn;
      return this;
    }

    /**
     * Set the digressOut.
     *
     * @param digressOut the digressOut
     * @return the CreateDialogNodeOptions builder
     */
    public Builder digressOut(String digressOut) {
      this.digressOut = digressOut;
      return this;
    }

    /**
     * Set the digressOutSlots.
     *
     * @param digressOutSlots the digressOutSlots
     * @return the CreateDialogNodeOptions builder
     */
    public Builder digressOutSlots(String digressOutSlots) {
      this.digressOutSlots = digressOutSlots;
      return this;
    }

    /**
     * Set the userLabel.
     *
     * @param userLabel the userLabel
     * @return the CreateDialogNodeOptions builder
     */
    public Builder userLabel(String userLabel) {
      this.userLabel = userLabel;
      return this;
    }

    /**
     * Set the disambiguationOptOut.
     *
     * @param disambiguationOptOut the disambiguationOptOut
     * @return the CreateDialogNodeOptions builder
     */
    public Builder disambiguationOptOut(Boolean disambiguationOptOut) {
      this.disambiguationOptOut = disambiguationOptOut;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateDialogNodeOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the CreateDialogNodeOptions builder
     */
    public Builder dialogNode(DialogNode dialogNode) {
      this.dialogNode = dialogNode.dialogNode();
      this.description = dialogNode.description();
      this.conditions = dialogNode.conditions();
      this.parent = dialogNode.parent();
      this.previousSibling = dialogNode.previousSibling();
      this.output = dialogNode.output();
      this.context = dialogNode.context();
      this.metadata = dialogNode.metadata();
      this.nextStep = dialogNode.nextStep();
      this.title = dialogNode.title();
      this.type = dialogNode.type();
      this.eventName = dialogNode.eventName();
      this.variable = dialogNode.variable();
      this.actions = dialogNode.actions();
      this.digressIn = dialogNode.digressIn();
      this.digressOut = dialogNode.digressOut();
      this.digressOutSlots = dialogNode.digressOutSlots();
      this.userLabel = dialogNode.userLabel();
      this.disambiguationOptOut = dialogNode.disambiguationOptOut();
      return this;
    }
  }

  protected CreateDialogNodeOptions() {}

  protected CreateDialogNodeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.dialogNode, "dialogNode cannot be null");
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
    title = builder.title;
    type = builder.type;
    eventName = builder.eventName;
    variable = builder.variable;
    actions = builder.actions;
    digressIn = builder.digressIn;
    digressOut = builder.digressOut;
    digressOutSlots = builder.digressOutSlots;
    userLabel = builder.userLabel;
    disambiguationOptOut = builder.disambiguationOptOut;
    includeAudit = builder.includeAudit;
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
   * <p>The unique ID of the dialog node. This is an internal identifier used to refer to the dialog
   * node from other dialog nodes and in the diagnostic information included with message responses.
   *
   * <p>This string can contain only Unicode alphanumeric, space, underscore, hyphen, and dot
   * characters.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the dialog node. This string cannot contain carriage return, newline, or
   * tab characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the conditions.
   *
   * <p>The condition that will trigger the dialog node. This string cannot contain carriage return,
   * newline, or tab characters.
   *
   * @return the conditions
   */
  public String conditions() {
    return conditions;
  }

  /**
   * Gets the parent.
   *
   * <p>The unique ID of the parent dialog node. This property is omitted if the dialog node has no
   * parent.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the previousSibling.
   *
   * <p>The unique ID of the previous sibling dialog node. This property is omitted if the dialog
   * node has no previous sibling.
   *
   * @return the previousSibling
   */
  public String previousSibling() {
    return previousSibling;
  }

  /**
   * Gets the output.
   *
   * <p>The output of the dialog node. For more information about how to specify dialog node output,
   * see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-dialog-overview#dialog-overview-responses).
   *
   * @return the output
   */
  public DialogNodeOutput output() {
    return output;
  }

  /**
   * Gets the context.
   *
   * <p>The context for the dialog node.
   *
   * @return the context
   */
  public DialogNodeContext context() {
    return context;
  }

  /**
   * Gets the metadata.
   *
   * <p>The metadata for the dialog node.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the nextStep.
   *
   * <p>The next step to execute following this dialog node.
   *
   * @return the nextStep
   */
  public DialogNodeNextStep nextStep() {
    return nextStep;
  }

  /**
   * Gets the title.
   *
   * <p>A human-readable name for the dialog node. If the node is included in disambiguation, this
   * title is used to populate the **label** property of the corresponding suggestion in the
   * `suggestion` response type (unless it is overridden by the **user_label** property). The title
   * is also used to populate the **topic** property in the `connect_to_agent` response type.
   *
   * <p>This string can contain only Unicode alphanumeric, space, underscore, hyphen, and dot
   * characters.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the type.
   *
   * <p>How the dialog node is processed.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the eventName.
   *
   * <p>How an `event_handler` node is processed.
   *
   * @return the eventName
   */
  public String eventName() {
    return eventName;
  }

  /**
   * Gets the variable.
   *
   * <p>The location in the dialog context where output is stored.
   *
   * @return the variable
   */
  public String variable() {
    return variable;
  }

  /**
   * Gets the actions.
   *
   * <p>An array of objects describing any actions to be invoked by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> actions() {
    return actions;
  }

  /**
   * Gets the digressIn.
   *
   * <p>Whether this top-level dialog node can be digressed into.
   *
   * @return the digressIn
   */
  public String digressIn() {
    return digressIn;
  }

  /**
   * Gets the digressOut.
   *
   * <p>Whether this dialog node can be returned to after a digression.
   *
   * @return the digressOut
   */
  public String digressOut() {
    return digressOut;
  }

  /**
   * Gets the digressOutSlots.
   *
   * <p>Whether the user can digress to top-level nodes while filling out slots.
   *
   * @return the digressOutSlots
   */
  public String digressOutSlots() {
    return digressOutSlots;
  }

  /**
   * Gets the userLabel.
   *
   * <p>A label that can be displayed externally to describe the purpose of the node to users. If
   * set, this label is used to identify the node in disambiguation responses (overriding the value
   * of the **title** property).
   *
   * @return the userLabel
   */
  public String userLabel() {
    return userLabel;
  }

  /**
   * Gets the disambiguationOptOut.
   *
   * <p>Whether the dialog node should be excluded from disambiguation suggestions. Valid only when
   * **type**=`standard` or `frame`.
   *
   * @return the disambiguationOptOut
   */
  public Boolean disambiguationOptOut() {
    return disambiguationOptOut;
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
