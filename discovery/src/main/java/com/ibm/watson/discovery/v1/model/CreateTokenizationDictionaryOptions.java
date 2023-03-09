/*
 * (C) Copyright IBM Corp. 2018, 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The createTokenizationDictionary options. */
public class CreateTokenizationDictionaryOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected List<TokenDictRule> tokenizationRules;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private List<TokenDictRule> tokenizationRules;

    /**
     * Instantiates a new Builder from an existing CreateTokenizationDictionaryOptions instance.
     *
     * @param createTokenizationDictionaryOptions the instance to initialize the Builder with
     */
    private Builder(CreateTokenizationDictionaryOptions createTokenizationDictionaryOptions) {
      this.environmentId = createTokenizationDictionaryOptions.environmentId;
      this.collectionId = createTokenizationDictionaryOptions.collectionId;
      this.tokenizationRules = createTokenizationDictionaryOptions.tokenizationRules;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a CreateTokenizationDictionaryOptions.
     *
     * @return the new CreateTokenizationDictionaryOptions instance
     */
    public CreateTokenizationDictionaryOptions build() {
      return new CreateTokenizationDictionaryOptions(this);
    }

    /**
     * Adds an tokenizationRules to tokenizationRules.
     *
     * @param tokenizationRules the new tokenizationRules
     * @return the CreateTokenizationDictionaryOptions builder
     */
    public Builder addTokenizationRules(TokenDictRule tokenizationRules) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          tokenizationRules, "tokenizationRules cannot be null");
      if (this.tokenizationRules == null) {
        this.tokenizationRules = new ArrayList<TokenDictRule>();
      }
      this.tokenizationRules.add(tokenizationRules);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateTokenizationDictionaryOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the CreateTokenizationDictionaryOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the tokenizationRules. Existing tokenizationRules will be replaced.
     *
     * @param tokenizationRules the tokenizationRules
     * @return the CreateTokenizationDictionaryOptions builder
     */
    public Builder tokenizationRules(List<TokenDictRule> tokenizationRules) {
      this.tokenizationRules = tokenizationRules;
      return this;
    }
  }

  protected CreateTokenizationDictionaryOptions() {}

  protected CreateTokenizationDictionaryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    tokenizationRules = builder.tokenizationRules;
  }

  /**
   * New builder.
   *
   * @return a CreateTokenizationDictionaryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the tokenizationRules.
   *
   * <p>An array of tokenization rules. Each rule contains, the original `text` string, component
   * `tokens`, any alternate character set `readings`, and which `part_of_speech` the text is from.
   *
   * @return the tokenizationRules
   */
  public List<TokenDictRule> tokenizationRules() {
    return tokenizationRules;
  }
}
