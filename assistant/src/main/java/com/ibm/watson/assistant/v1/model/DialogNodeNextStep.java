/*
 * (C) Copyright IBM Corp. 2017, 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The next step to execute following this dialog node. */
public class DialogNodeNextStep extends GenericModel {

  /**
   * What happens after the dialog node completes. The valid values depend on the node type: - The
   * following values are valid for any node: - `get_user_input` - `skip_user_input` - `jump_to` -
   * If the node is of type `event_handler` and its parent node is of type `slot` or `frame`,
   * additional values are also valid: - if **event_name**=`filled` and the type of the parent node
   * is `slot`: - `reprompt` - `skip_all_slots` - if **event_name**=`nomatch` and the type of the
   * parent node is `slot`: - `reprompt` - `skip_slot` - `skip_all_slots` - if
   * **event_name**=`generic` and the type of the parent node is `frame`: - `reprompt` - `skip_slot`
   * - `skip_all_slots` If you specify `jump_to`, then you must also specify a value for the
   * `dialog_node` property.
   */
  public interface Behavior {
    /** get_user_input. */
    String GET_USER_INPUT = "get_user_input";
    /** skip_user_input. */
    String SKIP_USER_INPUT = "skip_user_input";
    /** jump_to. */
    String JUMP_TO = "jump_to";
    /** reprompt. */
    String REPROMPT = "reprompt";
    /** skip_slot. */
    String SKIP_SLOT = "skip_slot";
    /** skip_all_slots. */
    String SKIP_ALL_SLOTS = "skip_all_slots";
  }

  /** Which part of the dialog node to process next. */
  public interface Selector {
    /** condition. */
    String CONDITION = "condition";
    /** client. */
    String CLIENT = "client";
    /** user_input. */
    String USER_INPUT = "user_input";
    /** body. */
    String BODY = "body";
  }

  protected String behavior;

  @SerializedName("dialog_node")
  protected String dialogNode;

  protected String selector;

  /** Builder. */
  public static class Builder {
    private String behavior;
    private String dialogNode;
    private String selector;

    private Builder(DialogNodeNextStep dialogNodeNextStep) {
      this.behavior = dialogNodeNextStep.behavior;
      this.dialogNode = dialogNodeNextStep.dialogNode;
      this.selector = dialogNodeNextStep.selector;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param behavior the behavior
     */
    public Builder(String behavior) {
      this.behavior = behavior;
    }

    /**
     * Builds a DialogNodeNextStep.
     *
     * @return the new DialogNodeNextStep instance
     */
    public DialogNodeNextStep build() {
      return new DialogNodeNextStep(this);
    }

    /**
     * Set the behavior.
     *
     * @param behavior the behavior
     * @return the DialogNodeNextStep builder
     */
    public Builder behavior(String behavior) {
      this.behavior = behavior;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the DialogNodeNextStep builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }

    /**
     * Set the selector.
     *
     * @param selector the selector
     * @return the DialogNodeNextStep builder
     */
    public Builder selector(String selector) {
      this.selector = selector;
      return this;
    }
  }

  protected DialogNodeNextStep(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.behavior, "behavior cannot be null");
    behavior = builder.behavior;
    dialogNode = builder.dialogNode;
    selector = builder.selector;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeNextStep builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the behavior.
   *
   * <p>What happens after the dialog node completes. The valid values depend on the node type: -
   * The following values are valid for any node: - `get_user_input` - `skip_user_input` - `jump_to`
   * - If the node is of type `event_handler` and its parent node is of type `slot` or `frame`,
   * additional values are also valid: - if **event_name**=`filled` and the type of the parent node
   * is `slot`: - `reprompt` - `skip_all_slots` - if **event_name**=`nomatch` and the type of the
   * parent node is `slot`: - `reprompt` - `skip_slot` - `skip_all_slots` - if
   * **event_name**=`generic` and the type of the parent node is `frame`: - `reprompt` - `skip_slot`
   * - `skip_all_slots` If you specify `jump_to`, then you must also specify a value for the
   * `dialog_node` property.
   *
   * @return the behavior
   */
  public String behavior() {
    return behavior;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique ID of the dialog node to process next. This parameter is required if
   * **behavior**=`jump_to`.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }

  /**
   * Gets the selector.
   *
   * <p>Which part of the dialog node to process next.
   *
   * @return the selector
   */
  public String selector() {
    return selector;
  }
}
