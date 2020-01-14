/*
 * (C) Copyright IBM Corp. 2020.
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

/**
 * DialogNodeOutputTextValuesElement.
 */
public class DialogNodeOutputTextValuesElement extends GenericModel {

  protected String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElement) {
      this.text = dialogNodeOutputTextValuesElement.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DialogNodeOutputTextValuesElement.
     *
     * @return the dialogNodeOutputTextValuesElement
     */
    public DialogNodeOutputTextValuesElement build() {
      return new DialogNodeOutputTextValuesElement(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the DialogNodeOutputTextValuesElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected DialogNodeOutputTextValuesElement(Builder builder) {
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputTextValuesElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The text of a response. This string can include newline characters (`\n`), Markdown tagging, or other special
   * characters, if supported by the channel.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}
