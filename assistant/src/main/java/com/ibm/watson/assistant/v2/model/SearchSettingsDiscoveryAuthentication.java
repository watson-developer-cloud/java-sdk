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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Authentication information for the Watson Discovery service. For more information, see the
 * [Watson Discovery documentation](https://cloud.ibm.com/apidocs/discovery-data#authentication).
 *
 * <p>**Note:** You must specify either **basic** or **bearer**, but not both.
 */
public class SearchSettingsDiscoveryAuthentication extends GenericModel {

  protected String basic;
  protected String bearer;

  /** Builder. */
  public static class Builder {
    private String basic;
    private String bearer;

    /**
     * Instantiates a new Builder from an existing SearchSettingsDiscoveryAuthentication instance.
     *
     * @param searchSettingsDiscoveryAuthentication the instance to initialize the Builder with
     */
    private Builder(SearchSettingsDiscoveryAuthentication searchSettingsDiscoveryAuthentication) {
      this.basic = searchSettingsDiscoveryAuthentication.basic;
      this.bearer = searchSettingsDiscoveryAuthentication.bearer;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SearchSettingsDiscoveryAuthentication.
     *
     * @return the new SearchSettingsDiscoveryAuthentication instance
     */
    public SearchSettingsDiscoveryAuthentication build() {
      return new SearchSettingsDiscoveryAuthentication(this);
    }

    /**
     * Set the basic.
     *
     * @param basic the basic
     * @return the SearchSettingsDiscoveryAuthentication builder
     */
    public Builder basic(String basic) {
      this.basic = basic;
      return this;
    }

    /**
     * Set the bearer.
     *
     * @param bearer the bearer
     * @return the SearchSettingsDiscoveryAuthentication builder
     */
    public Builder bearer(String bearer) {
      this.bearer = bearer;
      return this;
    }
  }

  protected SearchSettingsDiscoveryAuthentication() {}

  protected SearchSettingsDiscoveryAuthentication(Builder builder) {
    basic = builder.basic;
    bearer = builder.bearer;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsDiscoveryAuthentication builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the basic.
   *
   * <p>The HTTP basic authentication credentials for Watson Discovery. Specify your Watson
   * Discovery API key in the format `apikey:{apikey}`.
   *
   * @return the basic
   */
  public String basic() {
    return basic;
  }

  /**
   * Gets the bearer.
   *
   * <p>The authentication bearer token for Watson Discovery.
   *
   * @return the bearer
   */
  public String bearer() {
    return bearer;
  }
}
