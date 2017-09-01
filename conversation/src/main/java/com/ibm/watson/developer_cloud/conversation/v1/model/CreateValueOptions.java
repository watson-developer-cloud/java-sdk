/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the createValue options.
 */
public class CreateValueOptions extends GenericModel {

  private String workspaceId;
  private String entity;
  private Map metadata;
  private List<String> synonyms;
  private String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private Map metadata;
    private List<String> synonyms;
    private String value;

    private Builder(CreateValueOptions createValueOptions) {
      workspaceId = createValueOptions.workspaceId;
      entity = createValueOptions.entity;
      metadata = createValueOptions.metadata;
      synonyms = createValueOptions.synonyms;
      value = createValueOptions.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     * @param value the value
     */
    public Builder(String workspaceId, String entity, String value) {
      this.workspaceId = workspaceId;
      this.entity = entity;
      this.value = value;
    }

    /**
     * Builds a CreateValueOptions.
     *
     * @return the createValueOptions
     */
    public CreateValueOptions build() {
      return new CreateValueOptions(this);
    }

    /**
     * Adds an synonym to synonyms.
     *
     * @param synonym the new synonym
     * @return the CreateValueOptions builder
     */
    public Builder addSynonym(String synonym) {
      Validator.notNull(synonym, "synonym cannot be null");
      if (this.synonyms == null) {
        this.synonyms = new ArrayList<String>();
      }
      this.synonyms.add(synonym);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateValueOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the CreateValueOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateValueOptions builder
     */
    public Builder metadata(Map metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the synonyms.
     * Existing synonyms will be replaced.
     *
     * @param synonyms the synonyms
     * @return the CreateValueOptions builder
     */
    public Builder synonyms(List<String> synonyms) {
      this.synonyms = synonyms;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the CreateValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  private CreateValueOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.entity, "entity cannot be empty");
    Validator.notNull(builder.value, "value cannot be null");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    metadata = builder.metadata;
    synonyms = builder.synonyms;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a CreateValueOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the entity.
   *
   * The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the entity value.
   *
   * @return the metadata
   */
  public Map metadata() {
    return metadata;
  }

  /**
   * Gets the synonyms.
   *
   * An array of synonyms for the entity value.
   *
   * @return the synonyms
   */
  public List<String> synonyms() {
    return synonyms;
  }

  /**
   * Gets the value.
   *
   * The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}
