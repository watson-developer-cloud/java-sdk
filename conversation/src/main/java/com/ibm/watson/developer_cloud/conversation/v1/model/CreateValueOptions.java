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
 * The createValue options.
 */
public class CreateValueOptions extends GenericModel {

  /**
   * Specifies the type of value (`synonyms` or `patterns`). The default value is `synonyms`.
   */
  public interface ValueType {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  private String workspaceId;
  private String entity;
  private String value;
  private Map metadata;
  private List<String> synonyms;
  private List<String> patterns;
  private String valueType;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private Map metadata;
    private List<String> synonyms;
    private List<String> patterns;
    private String valueType;

    private Builder(CreateValueOptions createValueOptions) {
      workspaceId = createValueOptions.workspaceId;
      entity = createValueOptions.entity;
      value = createValueOptions.value;
      metadata = createValueOptions.metadata;
      synonyms = createValueOptions.synonyms;
      patterns = createValueOptions.patterns;
      valueType = createValueOptions.valueType;
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
     * Adds an pattern to patterns.
     *
     * @param pattern the new pattern
     * @return the CreateValueOptions builder
     */
    public Builder addPattern(String pattern) {
      Validator.notNull(pattern, "pattern cannot be null");
      if (this.patterns == null) {
        this.patterns = new ArrayList<String>();
      }
      this.patterns.add(pattern);
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
     * Set the value.
     *
     * @param value the value
     * @return the CreateValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
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
     * Set the patterns.
     * Existing patterns will be replaced.
     *
     * @param patterns the patterns
     * @return the CreateValueOptions builder
     */
    public Builder patterns(List<String> patterns) {
      this.patterns = patterns;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the CreateValueOptions builder
     */
    public Builder valueType(String valueType) {
      this.valueType = valueType;
      return this;
    }
  }

  private CreateValueOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.entity, "entity cannot be empty");
    Validator.notNull(builder.value, "value cannot be null");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    metadata = builder.metadata;
    synonyms = builder.synonyms;
    patterns = builder.patterns;
    valueType = builder.valueType;
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
   * Gets the value.
   *
   * The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
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
   * Gets the patterns.
   *
   * An array of patterns for the entity value. A pattern is specified as a regular expression.
   *
   * @return the patterns
   */
  public List<String> patterns() {
    return patterns;
  }

  /**
   * Gets the valueType.
   *
   * Specifies the type of value (`synonyms` or `patterns`). The default value is `synonyms`.
   *
   * @return the valueType
   */
  public String valueType() {
    return valueType;
  }
}
