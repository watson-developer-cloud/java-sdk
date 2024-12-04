/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The createStopwordList options. */
public class CreateStopwordListOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected List<String> stopwords;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private List<String> stopwords;

    /**
     * Instantiates a new Builder from an existing CreateStopwordListOptions instance.
     *
     * @param createStopwordListOptions the instance to initialize the Builder with
     */
    private Builder(CreateStopwordListOptions createStopwordListOptions) {
      this.projectId = createStopwordListOptions.projectId;
      this.collectionId = createStopwordListOptions.collectionId;
      this.stopwords = createStopwordListOptions.stopwords;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     */
    public Builder(String projectId, String collectionId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a CreateStopwordListOptions.
     *
     * @return the new CreateStopwordListOptions instance
     */
    public CreateStopwordListOptions build() {
      return new CreateStopwordListOptions(this);
    }

    /**
     * Adds a new element to stopwords.
     *
     * @param stopwords the new element to be added
     * @return the CreateStopwordListOptions builder
     */
    public Builder addStopwords(String stopwords) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(stopwords, "stopwords cannot be null");
      if (this.stopwords == null) {
        this.stopwords = new ArrayList<String>();
      }
      this.stopwords.add(stopwords);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateStopwordListOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the CreateStopwordListOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the stopwords. Existing stopwords will be replaced.
     *
     * @param stopwords the stopwords
     * @return the CreateStopwordListOptions builder
     */
    public Builder stopwords(List<String> stopwords) {
      this.stopwords = stopwords;
      return this;
    }

    /**
     * Set the stopWordList.
     *
     * @param stopWordList the stopWordList
     * @return the CreateStopwordListOptions builder
     */
    public Builder stopWordList(StopWordList stopWordList) {
      this.stopwords = stopWordList.stopwords();
      return this;
    }
  }

  protected CreateStopwordListOptions() {}

  protected CreateStopwordListOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    stopwords = builder.stopwords;
  }

  /**
   * New builder.
   *
   * @return a CreateStopwordListOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the stopwords.
   *
   * <p>List of stop words.
   *
   * @return the stopwords
   */
  public List<String> stopwords() {
    return stopwords;
  }
}
