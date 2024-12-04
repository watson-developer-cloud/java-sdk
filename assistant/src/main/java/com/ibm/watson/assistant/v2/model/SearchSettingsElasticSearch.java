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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Configuration settings for the Elasticsearch service used by the search integration. You can
 * provide either basic auth or apiKey auth.
 */
public class SearchSettingsElasticSearch extends GenericModel {

  protected String url;
  protected String port;
  protected String username;
  protected String password;
  protected String index;
  protected List<Object> filter;

  @SerializedName("query_body")
  protected Map<String, Object> queryBody;

  @SerializedName("managed_index")
  protected String managedIndex;

  protected String apikey;

  /** Builder. */
  public static class Builder {
    private String url;
    private String port;
    private String username;
    private String password;
    private String index;
    private List<Object> filter;
    private Map<String, Object> queryBody;
    private String managedIndex;
    private String apikey;

    /**
     * Instantiates a new Builder from an existing SearchSettingsElasticSearch instance.
     *
     * @param searchSettingsElasticSearch the instance to initialize the Builder with
     */
    private Builder(SearchSettingsElasticSearch searchSettingsElasticSearch) {
      this.url = searchSettingsElasticSearch.url;
      this.port = searchSettingsElasticSearch.port;
      this.username = searchSettingsElasticSearch.username;
      this.password = searchSettingsElasticSearch.password;
      this.index = searchSettingsElasticSearch.index;
      this.filter = searchSettingsElasticSearch.filter;
      this.queryBody = searchSettingsElasticSearch.queryBody;
      this.managedIndex = searchSettingsElasticSearch.managedIndex;
      this.apikey = searchSettingsElasticSearch.apikey;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param port the port
     * @param index the index
     */
    public Builder(String url, String port, String index) {
      this.url = url;
      this.port = port;
      this.index = index;
    }

    /**
     * Builds a SearchSettingsElasticSearch.
     *
     * @return the new SearchSettingsElasticSearch instance
     */
    public SearchSettingsElasticSearch build() {
      return new SearchSettingsElasticSearch(this);
    }

    /**
     * Adds a new element to filter.
     *
     * @param filter the new element to be added
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder addFilter(Object filter) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(filter, "filter cannot be null");
      if (this.filter == null) {
        this.filter = new ArrayList<Object>();
      }
      this.filter.add(filter);
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the port.
     *
     * @param port the port
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder port(String port) {
      this.port = port;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the index.
     *
     * @param index the index
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder index(String index) {
      this.index = index;
      return this;
    }

    /**
     * Set the filter. Existing filter will be replaced.
     *
     * @param filter the filter
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder filter(List<Object> filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the queryBody.
     *
     * @param queryBody the queryBody
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder queryBody(Map<String, Object> queryBody) {
      this.queryBody = queryBody;
      return this;
    }

    /**
     * Set the managedIndex.
     *
     * @param managedIndex the managedIndex
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder managedIndex(String managedIndex) {
      this.managedIndex = managedIndex;
      return this;
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the SearchSettingsElasticSearch builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }
  }

  protected SearchSettingsElasticSearch() {}

  protected SearchSettingsElasticSearch(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.port, "port cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.index, "index cannot be null");
    url = builder.url;
    port = builder.port;
    username = builder.username;
    password = builder.password;
    index = builder.index;
    filter = builder.filter;
    queryBody = builder.queryBody;
    managedIndex = builder.managedIndex;
    apikey = builder.apikey;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsElasticSearch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The URL for the Elasticsearch service.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the port.
   *
   * <p>The port number for the Elasticsearch service URL.
   *
   * <p>**Note:** It can be omitted if a port number is appended to the URL.
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
   * Gets the index.
   *
   * <p>The Elasticsearch index to use for the search integration.
   *
   * @return the index
   */
  public String index() {
    return index;
  }

  /**
   * Gets the filter.
   *
   * <p>An array of filters that can be applied to the search results via the `$FILTER` variable in
   * the `query_body`.For more information, see [Elasticsearch filter
   * documentation](https://www.elastic.co/guide/en/elasticsearch/reference/current/filter-search-results.html).
   *
   * @return the filter
   */
  public List<Object> filter() {
    return filter;
  }

  /**
   * Gets the queryBody.
   *
   * <p>The Elasticsearch query object. For more information, see [Elasticsearch search API
   * documentation](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-search.html).
   *
   * @return the queryBody
   */
  public Map<String, Object> queryBody() {
    return queryBody;
  }

  /**
   * Gets the managedIndex.
   *
   * <p>The Elasticsearch index for uploading documents. It is created automatically when the upload
   * document option is selected from the user interface.
   *
   * @return the managedIndex
   */
  public String managedIndex() {
    return managedIndex;
  }

  /**
   * Gets the apikey.
   *
   * <p>The API key of the apiKey authentication method. Use either basic auth or apiKey auth. The
   * credentials are not returned due to security reasons.
   *
   * @return the apikey
   */
  public String apikey() {
    return apikey;
  }
}
