/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** DialogNodeOutputOptionsElement. */
public class DialogNodeOutputOptionsElement extends GenericModel {

  protected String label;
  protected DialogNodeOutputOptionsElementValue value;

  /** Builder. */
  public static class Builder {
    private String label;
    private DialogNodeOutputOptionsElementValue value;

    private Builder(DialogNodeOutputOptionsElement dialogNodeOutputOptionsElement) {
      this.label = dialogNodeOutputOptionsElement.label;
      this.value = dialogNodeOutputOptionsElement.value;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param label the label
     * @param value the value
     */
    public Builder(String label, DialogNodeOutputOptionsElementValue value) {
      this.label = label;
      this.value = value;
    }

    /**
     * Builds a DialogNodeOutputOptionsElement.
     *
     * @return the new DialogNodeOutputOptionsElement instance
     */
    public DialogNodeOutputOptionsElement build() {
      return new DialogNodeOutputOptionsElement(this);
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the DialogNodeOutputOptionsElement builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the DialogNodeOutputOptionsElement builder
     */
    public Builder value(DialogNodeOutputOptionsElementValue value) {
      this.value = value;
      return this;
    }
  }

  protected DialogNodeOutputOptionsElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.label, "label cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value, "value cannot be null");
    label = builder.label;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputOptionsElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the label.
   *
   * <p>The user-facing label for the option.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the value.
   *
   * <p>An object defining the message input to be sent to the Watson Assistant service if the user
   * selects the corresponding option.
   *
   * @return the value
   */
  public DialogNodeOutputOptionsElementValue value() {
    return value;
  }
}
