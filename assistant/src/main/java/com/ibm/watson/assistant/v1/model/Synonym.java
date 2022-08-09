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

/** Synonym. */
public class Synonym extends GenericModel {

  protected String synonym;
  protected Date created;
  protected Date updated;

  /** Builder. */
  public static class Builder {
    private String synonym;

    private Builder(Synonym synonym) {
      this.synonym = synonym.synonym;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param synonym the synonym
     */
    public Builder(String synonym) {
      this.synonym = synonym;
    }

    /**
     * Builds a Synonym.
     *
     * @return the new Synonym instance
     */
    public Synonym build() {
      return new Synonym(this);
    }

    /**
     * Set the synonym.
     *
     * @param synonym the synonym
     * @return the Synonym builder
     */
    public Builder synonym(String synonym) {
      this.synonym = synonym;
      return this;
    }
  }

  protected Synonym() {}

  protected Synonym(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.synonym, "synonym cannot be null");
    synonym = builder.synonym;
  }

  /**
   * New builder.
   *
   * @return a Synonym builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the synonym.
   *
   * <p>The text of the synonym. This string must conform to the following restrictions: - It cannot
   * contain carriage return, newline, or tab characters. - It cannot consist of only whitespace
   * characters.
   *
   * @return the synonym
   */
  public String synonym() {
    return synonym;
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
