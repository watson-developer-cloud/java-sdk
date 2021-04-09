/*
 * (C) Copyright IBM Corp. 2021.
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

/** The user input utterance to classify. */
public class BulkClassifyUtterance extends GenericModel {

  protected String text;

  /** Builder. */
  public static class Builder {
    private String text;

    private Builder(BulkClassifyUtterance bulkClassifyUtterance) {
      this.text = bulkClassifyUtterance.text;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a BulkClassifyUtterance.
     *
     * @return the new BulkClassifyUtterance instance
     */
    public BulkClassifyUtterance build() {
      return new BulkClassifyUtterance(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the BulkClassifyUtterance builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected BulkClassifyUtterance(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a BulkClassifyUtterance builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The text of the input utterance.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}
