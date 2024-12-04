/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** A warning describing an error in the search skill configuration. */
public class SearchSkillWarning extends GenericModel {

  protected String code;
  protected String path;
  protected String message;

  /** Builder. */
  public static class Builder {
    private String code;
    private String path;
    private String message;

    /**
     * Instantiates a new Builder from an existing SearchSkillWarning instance.
     *
     * @param searchSkillWarning the instance to initialize the Builder with
     */
    private Builder(SearchSkillWarning searchSkillWarning) {
      this.code = searchSkillWarning.code;
      this.path = searchSkillWarning.path;
      this.message = searchSkillWarning.message;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SearchSkillWarning.
     *
     * @return the new SearchSkillWarning instance
     */
    public SearchSkillWarning build() {
      return new SearchSkillWarning(this);
    }

    /**
     * Set the code.
     *
     * @param code the code
     * @return the SearchSkillWarning builder
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the SearchSkillWarning builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }

    /**
     * Set the message.
     *
     * @param message the message
     * @return the SearchSkillWarning builder
     */
    public Builder message(String message) {
      this.message = message;
      return this;
    }
  }

  protected SearchSkillWarning() {}

  protected SearchSkillWarning(Builder builder) {
    code = builder.code;
    path = builder.path;
    message = builder.message;
  }

  /**
   * New builder.
   *
   * @return a SearchSkillWarning builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the code.
   *
   * <p>The error code.
   *
   * @return the code
   */
  public String code() {
    return code;
  }

  /**
   * Gets the path.
   *
   * <p>The location of the error in the search skill configuration object.
   *
   * @return the path
   */
  public String path() {
    return path;
  }

  /**
   * Gets the message.
   *
   * <p>The error message.
   *
   * @return the message
   */
  public String message() {
    return message;
  }
}
