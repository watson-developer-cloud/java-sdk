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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * CreateCounterexample.
 */
public class CreateCounterexample extends GenericModel {

  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(CreateCounterexample createCounterexample) {
      text = createCounterexample.text;
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
     * Builds a CreateCounterexample.
     *
     * @return the createCounterexample
     */
    public CreateCounterexample build() {
      return new CreateCounterexample(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CreateCounterexample builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private CreateCounterexample(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a CreateCounterexample builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The text of a user input marked as irrelevant input. This string must conform to the following restrictions:
   * - It cannot contain carriage return, newline, or tab characters
   * - It cannot consist of only whitespace characters
   * - It must be no longer than 1024 characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}
