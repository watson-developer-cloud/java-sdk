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

/**
 * Configuration settings for the Watson Discovery service instance used by the search integration.
 */
public class SearchSettingsDiscovery extends GenericModel {

  @SerializedName("instance_id")
  protected String instanceId;

  @SerializedName("project_id")
  protected String projectId;

  protected String url;

  @SerializedName("max_primary_results")
  protected Long maxPrimaryResults;

  @SerializedName("max_total_results")
  protected Long maxTotalResults;

  @SerializedName("confidence_threshold")
  protected Double confidenceThreshold;

  protected Boolean highlight;

  @SerializedName("find_answers")
  protected Boolean findAnswers;

  protected SearchSettingsDiscoveryAuthentication authentication;

  /** Builder. */
  public static class Builder {
    private String instanceId;
    private String projectId;
    private String url;
    private Long maxPrimaryResults;
    private Long maxTotalResults;
    private Double confidenceThreshold;
    private Boolean highlight;
    private Boolean findAnswers;
    private SearchSettingsDiscoveryAuthentication authentication;

    /**
     * Instantiates a new Builder from an existing SearchSettingsDiscovery instance.
     *
     * @param searchSettingsDiscovery the instance to initialize the Builder with
     */
    private Builder(SearchSettingsDiscovery searchSettingsDiscovery) {
      this.instanceId = searchSettingsDiscovery.instanceId;
      this.projectId = searchSettingsDiscovery.projectId;
      this.url = searchSettingsDiscovery.url;
      this.maxPrimaryResults = searchSettingsDiscovery.maxPrimaryResults;
      this.maxTotalResults = searchSettingsDiscovery.maxTotalResults;
      this.confidenceThreshold = searchSettingsDiscovery.confidenceThreshold;
      this.highlight = searchSettingsDiscovery.highlight;
      this.findAnswers = searchSettingsDiscovery.findAnswers;
      this.authentication = searchSettingsDiscovery.authentication;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param projectId the projectId
     * @param url the url
     * @param authentication the authentication
     */
    public Builder(
        String instanceId,
        String projectId,
        String url,
        SearchSettingsDiscoveryAuthentication authentication) {
      this.instanceId = instanceId;
      this.projectId = projectId;
      this.url = url;
      this.authentication = authentication;
    }

    /**
     * Builds a SearchSettingsDiscovery.
     *
     * @return the new SearchSettingsDiscovery instance
     */
    public SearchSettingsDiscovery build() {
      return new SearchSettingsDiscovery(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the SearchSettingsDiscovery builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the SearchSettingsDiscovery builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SearchSettingsDiscovery builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the maxPrimaryResults.
     *
     * @param maxPrimaryResults the maxPrimaryResults
     * @return the SearchSettingsDiscovery builder
     */
    public Builder maxPrimaryResults(long maxPrimaryResults) {
      this.maxPrimaryResults = maxPrimaryResults;
      return this;
    }

    /**
     * Set the maxTotalResults.
     *
     * @param maxTotalResults the maxTotalResults
     * @return the SearchSettingsDiscovery builder
     */
    public Builder maxTotalResults(long maxTotalResults) {
      this.maxTotalResults = maxTotalResults;
      return this;
    }

    /**
     * Set the confidenceThreshold.
     *
     * @param confidenceThreshold the confidenceThreshold
     * @return the SearchSettingsDiscovery builder
     */
    public Builder confidenceThreshold(Double confidenceThreshold) {
      this.confidenceThreshold = confidenceThreshold;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the SearchSettingsDiscovery builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the findAnswers.
     *
     * @param findAnswers the findAnswers
     * @return the SearchSettingsDiscovery builder
     */
    public Builder findAnswers(Boolean findAnswers) {
      this.findAnswers = findAnswers;
      return this;
    }

    /**
     * Set the authentication.
     *
     * @param authentication the authentication
     * @return the SearchSettingsDiscovery builder
     */
    public Builder authentication(SearchSettingsDiscoveryAuthentication authentication) {
      this.authentication = authentication;
      return this;
    }
  }

  protected SearchSettingsDiscovery() {}

  protected SearchSettingsDiscovery(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.instanceId, "instanceId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.projectId, "projectId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url, "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.authentication, "authentication cannot be null");
    instanceId = builder.instanceId;
    projectId = builder.projectId;
    url = builder.url;
    maxPrimaryResults = builder.maxPrimaryResults;
    maxTotalResults = builder.maxTotalResults;
    confidenceThreshold = builder.confidenceThreshold;
    highlight = builder.highlight;
    findAnswers = builder.findAnswers;
    authentication = builder.authentication;
  }

  /**
   * New builder.
   *
   * @return a SearchSettingsDiscovery builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * <p>The ID for the Watson Discovery service instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID for the Watson Discovery project.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the url.
   *
   * <p>The URL for the Watson Discovery service instance.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the maxPrimaryResults.
   *
   * <p>The maximum number of primary results to include in the response.
   *
   * @return the maxPrimaryResults
   */
  public Long maxPrimaryResults() {
    return maxPrimaryResults;
  }

  /**
   * Gets the maxTotalResults.
   *
   * <p>The maximum total number of primary and additional results to include in the response.
   *
   * @return the maxTotalResults
   */
  public Long maxTotalResults() {
    return maxTotalResults;
  }

  /**
   * Gets the confidenceThreshold.
   *
   * <p>The minimum confidence threshold for included results. Any results with a confidence below
   * this threshold will be discarded.
   *
   * @return the confidenceThreshold
   */
  public Double confidenceThreshold() {
    return confidenceThreshold;
  }

  /**
   * Gets the highlight.
   *
   * <p>Whether to include the most relevant passages of text in the **highlight** property of each
   * result.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the findAnswers.
   *
   * <p>Whether to use the answer finding feature to emphasize answers within highlighted passages.
   * This property is ignored if **highlight**=`false`.
   *
   * <p>**Notes:** - Answer finding is available only if the search skill is connected to a
   * Discovery v2 service instance. - Answer finding is not supported on IBM Cloud Pak for Data.
   *
   * @return the findAnswers
   */
  public Boolean findAnswers() {
    return findAnswers;
  }

  /**
   * Gets the authentication.
   *
   * <p>Authentication information for the Watson Discovery service. For more information, see the
   * [Watson Discovery documentation](https://cloud.ibm.com/apidocs/discovery-data#authentication).
   *
   * <p>**Note:** You must specify either **basic** or **bearer**, but not both.
   *
   * @return the authentication
   */
  public SearchSettingsDiscoveryAuthentication authentication() {
    return authentication;
  }
}
