/*
 * (C) Copyright IBM Corp. 2022.
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
import java.util.Map;

/** DialogSuggestion. */
public class DialogSuggestion extends GenericModel {

  protected String label;
  protected DialogSuggestionValue value;
  protected Map<String, Object> output;

  @SerializedName("dialog_node")
  protected String dialogNode;

  /** Builder. */
  public static class Builder {
    private String label;
    private DialogSuggestionValue value;
    private Map<String, Object> output;
    private String dialogNode;

    private Builder(DialogSuggestion dialogSuggestion) {
      this.label = dialogSuggestion.label;
      this.value = dialogSuggestion.value;
      this.output = dialogSuggestion.output;
      this.dialogNode = dialogSuggestion.dialogNode;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param label the label
     * @param value the value
     */
    public Builder(String label, DialogSuggestionValue value) {
      this.label = label;
      this.value = value;
    }

    /**
     * Builds a DialogSuggestion.
     *
     * @return the new DialogSuggestion instance
     */
    public DialogSuggestion build() {
      return new DialogSuggestion(this);
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the DialogSuggestion builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the DialogSuggestion builder
     */
    public Builder value(DialogSuggestionValue value) {
      this.value = value;
      return this;
    }

    /**
     * Set the output.
     *
     * @param output the output
     * @return the DialogSuggestion builder
     */
    public Builder output(Map<String, Object> output) {
      this.output = output;
      return this;
    }

    /**
     * Set the dialogNode.
     *
     * @param dialogNode the dialogNode
     * @return the DialogSuggestion builder
     */
    public Builder dialogNode(String dialogNode) {
      this.dialogNode = dialogNode;
      return this;
    }
  }

  protected DialogSuggestion() {}

  protected DialogSuggestion(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.label, "label cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value, "value cannot be null");
    label = builder.label;
    value = builder.value;
    output = builder.output;
    dialogNode = builder.dialogNode;
  }

  /**
   * New builder.
   *
   * @return a DialogSuggestion builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the label.
   *
   * <p>The user-facing label for the disambiguation option. This label is taken from the **title**
   * or **user_label** property of the corresponding dialog node.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the value.
   *
   * <p>An object defining the message input, intents, and entities to be sent to the Watson
   * Assistant service if the user selects the corresponding disambiguation option.
   *
   * @return the value
   */
  public DialogSuggestionValue value() {
    return value;
  }

  /**
   * Gets the output.
   *
   * <p>The dialog output that will be returned from the Watson Assistant service if the user
   * selects the corresponding option.
   *
   * @return the output
   */
  public Map<String, Object> output() {
    return output;
  }

  /**
   * Gets the dialogNode.
   *
   * <p>The unique ID of the dialog node that the **label** property is taken from. The **label**
   * property is populated using the value of the dialog node's **title** or **user_label**
   * property.
   *
   * @return the dialogNode
   */
  public String dialogNode() {
    return dialogNode;
  }
}
