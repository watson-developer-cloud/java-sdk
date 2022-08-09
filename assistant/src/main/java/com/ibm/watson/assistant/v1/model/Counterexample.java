/*
 * (C) Copyright IBM Corp. 2017, 2022.
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
import java.util.Date;

/** Counterexample. */
public class Counterexample extends GenericModel {

  protected String text;
  protected Date created;
  protected Date updated;

  /** Builder. */
  public static class Builder {
    private String text;

    private Builder(Counterexample counterexample) {
      this.text = counterexample.text;
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
     * Builds a Counterexample.
     *
     * @return the new Counterexample instance
     */
    public Counterexample build() {
      return new Counterexample(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the Counterexample builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected Counterexample() {}

  protected Counterexample(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a Counterexample builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The text of a user input marked as irrelevant input. This string must conform to the
   * following restrictions: - It cannot contain carriage return, newline, or tab characters. - It
   * cannot consist of only whitespace characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}
