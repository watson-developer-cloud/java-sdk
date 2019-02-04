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

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * An input object that includes the input text.
 */
public class InputData extends DynamicModel {
  private Type textType = new TypeToken<String>() {
  }.getType();

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String text() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("text"), textType);
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.put("text", text);
  }

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(InputData inputData) {
      text = inputData.text();
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a InputData.
     *
     * @return the inputData
     */
    public InputData build() {
      return new InputData(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the InputData builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private InputData(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    setText(builder.text);
  }
}
