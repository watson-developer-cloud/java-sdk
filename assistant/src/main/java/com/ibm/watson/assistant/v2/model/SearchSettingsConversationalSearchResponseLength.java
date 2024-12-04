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

/** SearchSettingsConversationalSearchResponseLength. */
public class SearchSettingsConversationalSearchResponseLength extends GenericModel {

  /** The response length option. It controls the length of the generated response. */
  public interface Option {
    /** concise. */
    String CONCISE = "concise";
    /** moderate. */
    String MODERATE = "moderate";
    /** verbose. */
    String VERBOSE = "verbose";
  }

  protected String option;

  /** Builder. */
  public static class Builder {
    private String option;

    /**
     * Instantiates a new Builder from an existing SearchSettingsConversationalSearchResponseLength
     * instance.
     *
     * @param searchSettingsConversationalSearchResponseLength the instance to initialize the
     *     Builder with
     */
    private Builder(
        SearchSettingsConversationalSearchResponseLength
            searchSettingsConversationalSearchResponseLength) {
      this.option = searchSettingsConversationalSearchResponseLength.option;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SearchSettingsConversationalSearchResponseLength.
     *
     * @return the new SearchSettingsConversationalSearchResponseLength instance
     */
    public SearchSettingsConversationalSearchResponseLength build() {
      return new SearchSettingsConversationalSearchResponseLength(this);
    }

    /**
     * Set the option.
     *
     * @param option the option
     * @return the SearchSettingsConversationalSearchResponseLength builder
     */
    public Builder option(String option) {
      this.option = option;
      return this;
    }
  }

  protected SearchSettingsConversationalSearchResponseLength() {}

  protected SearchSettingsConversationalSearchResponseLength(Builder builder) {
    option = builder.option;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsConversationalSearchResponseLength builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the option.
   *
   * <p>The response length option. It controls the length of the generated response.
   *
   * @return the option
   */
  public String option() {
    return option;
  }
}
