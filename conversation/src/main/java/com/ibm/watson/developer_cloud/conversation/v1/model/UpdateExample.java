/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * UpdateExample.
 */
public class UpdateExample extends GenericModel {

  /** The text of the user input example. */
  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(UpdateExample updateExample) {
      text = updateExample.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the UpdateExample.
     *
     * @return the updateExample
     */
    public UpdateExample build() {
      return new UpdateExample(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return a UpdateExample Builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private UpdateExample(Builder builder) {
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}
