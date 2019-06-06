/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The updateValue options.
 */
public class UpdateValueOptions extends GenericModel {

  /**
   * Specifies the type of entity value.
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
  private String newValue;
  private Map<String, Object> newMetadata;
  private String valueType;
  private List<String> newSynonyms;
  private List<String> newPatterns;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private String newValue;
    private Map<String, Object> newMetadata;
    private String valueType;
    private List<String> newSynonyms;
    private List<String> newPatterns;

    private Builder(UpdateValueOptions updateValueOptions) {
      this.workspaceId = updateValueOptions.workspaceId;
      this.entity = updateValueOptions.entity;
      this.value = updateValueOptions.value;
      this.newValue = updateValueOptions.newValue;
      this.newMetadata = updateValueOptions.newMetadata;
      this.valueType = updateValueOptions.valueType;
      this.newSynonyms = updateValueOptions.newSynonyms;
      this.newPatterns = updateValueOptions.newPatterns;
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
     * Builds a UpdateValueOptions.
     *
     * @return the updateValueOptions
     */
    public UpdateValueOptions build() {
      return new UpdateValueOptions(this);
    }

    /**
     * Adds an synonym to newSynonyms.
     *
     * @param synonym the new synonym
     * @return the UpdateValueOptions builder
     */
    public Builder addSynonym(String synonym) {
      Validator.notNull(synonym, "synonym cannot be null");
      if (this.newSynonyms == null) {
        this.newSynonyms = new ArrayList<String>();
      }
      this.newSynonyms.add(synonym);
      return this;
    }

    /**
     * Adds an pattern to newPatterns.
     *
     * @param pattern the new pattern
     * @return the UpdateValueOptions builder
     */
    public Builder addPattern(String pattern) {
      Validator.notNull(pattern, "pattern cannot be null");
      if (this.newPatterns == null) {
        this.newPatterns = new ArrayList<String>();
      }
      this.newPatterns.add(pattern);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateValueOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the UpdateValueOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the UpdateValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the newValue.
     *
     * @param newValue the newValue
     * @return the UpdateValueOptions builder
     */
    public Builder newValue(String newValue) {
      this.newValue = newValue;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateValueOptions builder
     */
    public Builder newMetadata(Map<String, Object> newMetadata) {
      this.newMetadata = newMetadata;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the UpdateValueOptions builder
     */
    public Builder valueType(String valueType) {
      this.valueType = valueType;
      return this;
    }

    /**
     * Set the newSynonyms.
     * Existing newSynonyms will be replaced.
     *
     * @param newSynonyms the newSynonyms
     * @return the UpdateValueOptions builder
     */
    public Builder newSynonyms(List<String> newSynonyms) {
      this.newSynonyms = newSynonyms;
      return this;
    }

    /**
     * Set the newPatterns.
     * Existing newPatterns will be replaced.
     *
     * @param newPatterns the newPatterns
     * @return the UpdateValueOptions builder
     */
    public Builder newPatterns(List<String> newPatterns) {
      this.newPatterns = newPatterns;
      return this;
    }
  }

  private UpdateValueOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.entity, "entity cannot be empty");
    Validator.notEmpty(builder.value, "value cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    newValue = builder.newValue;
    newMetadata = builder.newMetadata;
    valueType = builder.valueType;
    newSynonyms = builder.newSynonyms;
    newPatterns = builder.newPatterns;
  }

  /**
   * New builder.
   *
   * @return a UpdateValueOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * Unique identifier of the workspace.
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
   * Gets the newValue.
   *
   * The text of the entity value. This string must conform to the following restrictions:
   * - It cannot contain carriage return, newline, or tab characters.
   * - It cannot consist of only whitespace characters.
   *
   * @return the newValue
   */
  public String newValue() {
    return newValue;
  }

  /**
   * Gets the newMetadata.
   *
   * Any metadata related to the entity value.
   *
   * @return the newMetadata
   */
  public Map<String, Object> newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the valueType.
   *
   * Specifies the type of entity value.
   *
   * @return the valueType
   */
  public String valueType() {
    return valueType;
  }

  /**
   * Gets the newSynonyms.
   *
   * An array of synonyms for the entity value. A value can specify either synonyms or patterns (depending on the value
   * type), but not both. A synonym must conform to the following resrictions:
   * - It cannot contain carriage return, newline, or tab characters.
   * - It cannot consist of only whitespace characters.
   *
   * @return the newSynonyms
   */
  public List<String> newSynonyms() {
    return newSynonyms;
  }

  /**
   * Gets the newPatterns.
   *
   * An array of patterns for the entity value. A value can specify either synonyms or patterns (depending on the value
   * type), but not both. A pattern is a regular expression; for more information about how to specify a pattern, see
   * the
   * [documentation]
   * (https://cloud.ibm.com/docs/services/assistant?topic=assistant-entities#entities-create-dictionary-based).
   *
   * @return the newPatterns
   */
  public List<String> newPatterns() {
    return newPatterns;
  }
}
