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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/**
 * An object that contains options for the current enrichment. Starting with version `2020-08-30`,
 * the enrichment options are not included in responses from the List Enrichments method.
 */
public class EnrichmentOptions extends GenericModel {

  protected List<String> languages;

  @SerializedName("entity_type")
  protected String entityType;

  @SerializedName("regular_expression")
  protected String regularExpression;

  @SerializedName("result_field")
  protected String resultField;

  @SerializedName("classifier_id")
  protected String classifierId;

  @SerializedName("model_id")
  protected String modelId;

  @SerializedName("confidence_threshold")
  protected Double confidenceThreshold;

  @SerializedName("top_k")
  protected Long topK;

  protected String url;
  protected String version;
  protected String secret;
  protected WebhookHeader headers;

  @SerializedName("location_encoding")
  protected String locationEncoding;

  /** Builder. */
  public static class Builder {
    private List<String> languages;
    private String entityType;
    private String regularExpression;
    private String resultField;
    private String classifierId;
    private String modelId;
    private Double confidenceThreshold;
    private Long topK;
    private String url;
    private String version;
    private String secret;
    private WebhookHeader headers;
    private String locationEncoding;

    /**
     * Instantiates a new Builder from an existing EnrichmentOptions instance.
     *
     * @param enrichmentOptions the instance to initialize the Builder with
     */
    private Builder(EnrichmentOptions enrichmentOptions) {
      this.languages = enrichmentOptions.languages;
      this.entityType = enrichmentOptions.entityType;
      this.regularExpression = enrichmentOptions.regularExpression;
      this.resultField = enrichmentOptions.resultField;
      this.classifierId = enrichmentOptions.classifierId;
      this.modelId = enrichmentOptions.modelId;
      this.confidenceThreshold = enrichmentOptions.confidenceThreshold;
      this.topK = enrichmentOptions.topK;
      this.url = enrichmentOptions.url;
      this.version = enrichmentOptions.version;
      this.secret = enrichmentOptions.secret;
      this.headers = enrichmentOptions.headers;
      this.locationEncoding = enrichmentOptions.locationEncoding;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a EnrichmentOptions.
     *
     * @return the new EnrichmentOptions instance
     */
    public EnrichmentOptions build() {
      return new EnrichmentOptions(this);
    }

    /**
     * Adds a new element to languages.
     *
     * @param languages the new element to be added
     * @return the EnrichmentOptions builder
     */
    public Builder addLanguages(String languages) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(languages, "languages cannot be null");
      if (this.languages == null) {
        this.languages = new ArrayList<String>();
      }
      this.languages.add(languages);
      return this;
    }

    /**
     * Set the languages. Existing languages will be replaced.
     *
     * @param languages the languages
     * @return the EnrichmentOptions builder
     */
    public Builder languages(List<String> languages) {
      this.languages = languages;
      return this;
    }

    /**
     * Set the entityType.
     *
     * @param entityType the entityType
     * @return the EnrichmentOptions builder
     */
    public Builder entityType(String entityType) {
      this.entityType = entityType;
      return this;
    }

    /**
     * Set the regularExpression.
     *
     * @param regularExpression the regularExpression
     * @return the EnrichmentOptions builder
     */
    public Builder regularExpression(String regularExpression) {
      this.regularExpression = regularExpression;
      return this;
    }

    /**
     * Set the resultField.
     *
     * @param resultField the resultField
     * @return the EnrichmentOptions builder
     */
    public Builder resultField(String resultField) {
      this.resultField = resultField;
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the EnrichmentOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the EnrichmentOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the confidenceThreshold.
     *
     * @param confidenceThreshold the confidenceThreshold
     * @return the EnrichmentOptions builder
     */
    public Builder confidenceThreshold(Double confidenceThreshold) {
      this.confidenceThreshold = confidenceThreshold;
      return this;
    }

    /**
     * Set the topK.
     *
     * @param topK the topK
     * @return the EnrichmentOptions builder
     */
    public Builder topK(long topK) {
      this.topK = topK;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the EnrichmentOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the EnrichmentOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the secret.
     *
     * @param secret the secret
     * @return the EnrichmentOptions builder
     */
    public Builder secret(String secret) {
      this.secret = secret;
      return this;
    }

    /**
     * Set the headers.
     *
     * @param headers the headers
     * @return the EnrichmentOptions builder
     */
    public Builder headers(WebhookHeader headers) {
      this.headers = headers;
      return this;
    }

    /**
     * Set the locationEncoding.
     *
     * @param locationEncoding the locationEncoding
     * @return the EnrichmentOptions builder
     */
    public Builder locationEncoding(String locationEncoding) {
      this.locationEncoding = locationEncoding;
      return this;
    }
  }

  protected EnrichmentOptions() {}

  protected EnrichmentOptions(Builder builder) {
    languages = builder.languages;
    entityType = builder.entityType;
    regularExpression = builder.regularExpression;
    resultField = builder.resultField;
    classifierId = builder.classifierId;
    modelId = builder.modelId;
    confidenceThreshold = builder.confidenceThreshold;
    topK = builder.topK;
    url = builder.url;
    version = builder.version;
    secret = builder.secret;
    headers = builder.headers;
    locationEncoding = builder.locationEncoding;
  }

  /**
   * New builder.
   *
   * @return a EnrichmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the languages.
   *
   * <p>An array of supported languages for this enrichment. When creating an enrichment, only
   * specify a language that is used by the model or in the dictionary. Required when **type** is
   * `dictionary`. Optional when **type** is `rule_based`. Not valid when creating any other type of
   * enrichment.
   *
   * @return the languages
   */
  public List<String> languages() {
    return languages;
  }

  /**
   * Gets the entityType.
   *
   * <p>The name of the entity type. This value is used as the field name in the index. Required
   * when **type** is `dictionary` or `regular_expression`. Not valid when creating any other type
   * of enrichment.
   *
   * @return the entityType
   */
  public String entityType() {
    return entityType;
  }

  /**
   * Gets the regularExpression.
   *
   * <p>The regular expression to apply for this enrichment. Required when **type** is
   * `regular_expression`. Not valid when creating any other type of enrichment.
   *
   * @return the regularExpression
   */
  public String regularExpression() {
    return regularExpression;
  }

  /**
   * Gets the resultField.
   *
   * <p>The name of the result document field that this enrichment creates. Required when **type**
   * is `rule_based` or `classifier`. Not valid when creating any other type of enrichment.
   *
   * @return the resultField
   */
  public String resultField() {
    return resultField;
  }

  /**
   * Gets the classifierId.
   *
   * <p>A unique identifier of the document classifier. Required when **type** is `classifier`. Not
   * valid when creating any other type of enrichment.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the modelId.
   *
   * <p>A unique identifier of the document classifier model. Required when **type** is
   * `classifier`. Not valid when creating any other type of enrichment.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the confidenceThreshold.
   *
   * <p>Specifies a threshold. Only classes with evaluation confidence scores that are higher than
   * the specified threshold are included in the output. Optional when **type** is `classifier`. Not
   * valid when creating any other type of enrichment.
   *
   * @return the confidenceThreshold
   */
  public Double confidenceThreshold() {
    return confidenceThreshold;
  }

  /**
   * Gets the topK.
   *
   * <p>Evaluates only the classes that fall in the top set of results when ranked by confidence.
   * For example, if set to `5`, then the top five classes for each document are evaluated. If set
   * to 0, the **confidence_threshold** is used to determine the predicted classes. Optional when
   * **type** is `classifier`. Not valid when creating any other type of enrichment.
   *
   * @return the topK
   */
  public Long topK() {
    return topK;
  }

  /**
   * Gets the url.
   *
   * <p>A URL that uses the SSL protocol (begins with https) for the webhook. Required when type is
   * `webhook`. Not valid when creating any other type of enrichment.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the version.
   *
   * <p>The Discovery API version that allows to distinguish the schema. The version is specified in
   * the `yyyy-mm-dd` format. Optional when `type` is `webhook`. Not valid when creating any other
   * type of enrichment.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the secret.
   *
   * <p>A private key can be included in the request to authenticate with the external service. The
   * maximum length is 1,024 characters. Optional when `type` is `webhook`. Not valid when creating
   * any other type of enrichment.
   *
   * @return the secret
   */
  public String secret() {
    return secret;
  }

  /**
   * Gets the headers.
   *
   * <p>An array of headers to pass with the HTTP request. Optional when `type` is `webhook`. Not
   * valid when creating any other type of enrichment.
   *
   * @return the headers
   */
  public WebhookHeader headers() {
    return headers;
  }

  /**
   * Gets the locationEncoding.
   *
   * <p>Discovery calculates offsets of the text's location with this encoding type in documents.
   * Use the same location encoding type in both Discovery and external enrichment for a document.
   *
   * <p>These encoding types are supported: `utf-8`, `utf-16`, and `utf-32`. Optional when `type` is
   * `webhook`. Not valid when creating any other type of enrichment.
   *
   * @return the locationEncoding
   */
  public String locationEncoding() {
    return locationEncoding;
  }
}
