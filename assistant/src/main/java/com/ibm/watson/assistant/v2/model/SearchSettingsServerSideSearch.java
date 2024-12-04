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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Map;

/**
 * Configuration settings for the server-side search service used by the search integration. You can
 * provide either basic auth, apiKey auth or none.
 */
public class SearchSettingsServerSideSearch extends GenericModel {

  /** The authorization type that is used. */
  public interface AuthType {
    /** basic. */
    String BASIC = "basic";
    /** apikey. */
    String APIKEY = "apikey";
    /** none. */
    String NONE = "none";
  }

  protected String url;
  protected String port;
  protected String username;
  protected String password;
  protected String filter;
  protected Map<String, Object> metadata;
  protected String apikey;

  @SerializedName("no_auth")
  protected Boolean noAuth;

  @SerializedName("auth_type")
  protected String authType;

  /** Builder. */
  public static class Builder {
    private String url;
    private String port;
    private String username;
    private String password;
    private String filter;
    private Map<String, Object> metadata;
    private String apikey;
    private Boolean noAuth;
    private String authType;

    /**
     * Instantiates a new Builder from an existing SearchSettingsServerSideSearch instance.
     *
     * @param searchSettingsServerSideSearch the instance to initialize the Builder with
     */
    private Builder(SearchSettingsServerSideSearch searchSettingsServerSideSearch) {
      this.url = searchSettingsServerSideSearch.url;
      this.port = searchSettingsServerSideSearch.port;
      this.username = searchSettingsServerSideSearch.username;
      this.password = searchSettingsServerSideSearch.password;
      this.filter = searchSettingsServerSideSearch.filter;
      this.metadata = searchSettingsServerSideSearch.metadata;
      this.apikey = searchSettingsServerSideSearch.apikey;
      this.noAuth = searchSettingsServerSideSearch.noAuth;
      this.authType = searchSettingsServerSideSearch.authType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     */
    public Builder(String url) {
      this.url = url;
    }

    /**
     * Builds a SearchSettingsServerSideSearch.
     *
     * @return the new SearchSettingsServerSideSearch instance
     */
    public SearchSettingsServerSideSearch build() {
      return new SearchSettingsServerSideSearch(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the port.
     *
     * @param port the port
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder port(String port) {
      this.port = port;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }

    /**
     * Set the noAuth.
     *
     * @param noAuth the noAuth
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder noAuth(Boolean noAuth) {
      this.noAuth = noAuth;
      return this;
    }

    /**
     * Set the authType.
     *
     * @param authType the authType
     * @return the SearchSettingsServerSideSearch builder
     */
    public Builder authType(String authType) {
      this.authType = authType;
      return this;
    }
  }

  protected SearchSettingsServerSideSearch() {}

  protected SearchSettingsServerSideSearch(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    url = builder.url;
    port = builder.port;
    username = builder.username;
    password = builder.password;
    filter = builder.filter;
    metadata = builder.metadata;
    apikey = builder.apikey;
    noAuth = builder.noAuth;
    authType = builder.authType;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsServerSideSearch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The URL of the server-side search service.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the port.
   *
   * <p>The port number of the server-side search service.
   *
   * @return the port
   */
  public String port() {
    return port;
  }

  /**
   * Gets the username.
   *
   * <p>The username of the basic authentication method.
   *
   * @return the username
   */
  public String username() {
    return username;
  }

  /**
   * Gets the password.
   *
   * <p>The password of the basic authentication method. The credentials are not returned due to
   * security reasons.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the filter.
   *
   * <p>The filter string that is applied to the search results.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the metadata.
   *
   * <p>The metadata object.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the apikey.
   *
   * <p>The API key of the apiKey authentication method. The credentails are not returned due to
   * security reasons.
   *
   * @return the apikey
   */
  public String apikey() {
    return apikey;
  }

  /**
   * Gets the noAuth.
   *
   * <p>To clear previous auth, specify `no_auth = true`.
   *
   * @return the noAuth
   */
  public Boolean noAuth() {
    return noAuth;
  }

  /**
   * Gets the authType.
   *
   * <p>The authorization type that is used.
   *
   * @return the authType
   */
  public String authType() {
    return authType;
  }
}
