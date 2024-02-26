/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

/** The getAutocompletion options. */
public class GetAutocompletionOptions extends GenericModel {

  protected String projectId;
  protected String prefix;
  protected List<String> collectionIds;
  protected String field;
  protected Long count;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String prefix;
    private List<String> collectionIds;
    private String field;
    private Long count;

    /**
     * Instantiates a new Builder from an existing GetAutocompletionOptions instance.
     *
     * @param getAutocompletionOptions the instance to initialize the Builder with
     */
    private Builder(GetAutocompletionOptions getAutocompletionOptions) {
      this.projectId = getAutocompletionOptions.projectId;
      this.prefix = getAutocompletionOptions.prefix;
      this.collectionIds = getAutocompletionOptions.collectionIds;
      this.field = getAutocompletionOptions.field;
      this.count = getAutocompletionOptions.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param prefix the prefix
     */
    public Builder(String projectId, String prefix) {
      this.projectId = projectId;
      this.prefix = prefix;
    }

    /**
     * Builds a GetAutocompletionOptions.
     *
     * @return the new GetAutocompletionOptions instance
     */
    public GetAutocompletionOptions build() {
      return new GetAutocompletionOptions(this);
    }

    /**
     * Adds a new element to collectionIds.
     *
     * @param collectionIds the new element to be added
     * @return the GetAutocompletionOptions builder
     */
    public Builder addCollectionIds(String collectionIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(collectionIds, "collectionIds cannot be null");
      if (this.collectionIds == null) {
        this.collectionIds = new ArrayList<String>();
      }
      this.collectionIds.add(collectionIds);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the GetAutocompletionOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the prefix.
     *
     * @param prefix the prefix
     * @return the GetAutocompletionOptions builder
     */
    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    /**
     * Set the collectionIds. Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the GetAutocompletionOptions builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }

    /**
     * Set the field.
     *
     * @param field the field
     * @return the GetAutocompletionOptions builder
     */
    public Builder field(String field) {
      this.field = field;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the GetAutocompletionOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected GetAutocompletionOptions() {}

  protected GetAutocompletionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.prefix, "prefix cannot be null");
    projectId = builder.projectId;
    prefix = builder.prefix;
    collectionIds = builder.collectionIds;
    field = builder.field;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a GetAutocompletionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the prefix.
   *
   * <p>The prefix to use for autocompletion. For example, the prefix `Ho` could autocomplete to
   * `hot`, `housing`, or `how`.
   *
   * @return the prefix
   */
  public String prefix() {
    return prefix;
  }

  /**
   * Gets the collectionIds.
   *
   * <p>Comma separated list of the collection IDs. If this parameter is not specified, all
   * collections in the project are used.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
  }

  /**
   * Gets the field.
   *
   * <p>The field in the result documents that autocompletion suggestions are identified from.
   *
   * @return the field
   */
  public String field() {
    return field;
  }

  /**
   * Gets the count.
   *
   * <p>The number of autocompletion suggestions to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}
