/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The messages included with responses from the search integration. */
public class SearchSettingsMessages extends GenericModel {

  protected String success;
  protected String error;

  @SerializedName("no_result")
  protected String noResult;

  /** Builder. */
  public static class Builder {
    private String success;
    private String error;
    private String noResult;

    /**
     * Instantiates a new Builder from an existing SearchSettingsMessages instance.
     *
     * @param searchSettingsMessages the instance to initialize the Builder with
     */
    private Builder(SearchSettingsMessages searchSettingsMessages) {
      this.success = searchSettingsMessages.success;
      this.error = searchSettingsMessages.error;
      this.noResult = searchSettingsMessages.noResult;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param success the success
     * @param error the error
     * @param noResult the noResult
     */
    public Builder(String success, String error, String noResult) {
      this.success = success;
      this.error = error;
      this.noResult = noResult;
    }

    /**
     * Builds a SearchSettingsMessages.
     *
     * @return the new SearchSettingsMessages instance
     */
    public SearchSettingsMessages build() {
      return new SearchSettingsMessages(this);
    }

    /**
     * Set the success.
     *
     * @param success the success
     * @return the SearchSettingsMessages builder
     */
    public Builder success(String success) {
      this.success = success;
      return this;
    }

    /**
     * Set the error.
     *
     * @param error the error
     * @return the SearchSettingsMessages builder
     */
    public Builder error(String error) {
      this.error = error;
      return this;
    }

    /**
     * Set the noResult.
     *
     * @param noResult the noResult
     * @return the SearchSettingsMessages builder
     */
    public Builder noResult(String noResult) {
      this.noResult = noResult;
      return this;
    }
  }

  protected SearchSettingsMessages() {}

  protected SearchSettingsMessages(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.success, "success cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.error, "error cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.noResult, "noResult cannot be null");
    success = builder.success;
    error = builder.error;
    noResult = builder.noResult;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsMessages builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the success.
   *
   * <p>The message to include in the response to a successful query.
   *
   * @return the success
   */
  public String success() {
    return success;
  }

  /**
   * Gets the error.
   *
   * <p>The message to include in the response when the query encounters an error.
   *
   * @return the error
   */
  public String error() {
    return error;
  }

  /**
   * Gets the noResult.
   *
   * <p>The message to include in the response when there is no result from the query.
   *
   * @return the noResult
   */
  public String noResult() {
    return noResult;
  }
}
