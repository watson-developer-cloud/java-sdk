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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * CreateValue.
 */
public class CreateValue extends GenericModel {

  /**
   * Specifies the type of value (`synonyms` or `patterns`). The default value is `synonyms`.
   */
  public interface ValueType {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  private String value;
  private Map metadata;
  private List<String> synonyms;
  private List<String> patterns;
  @SerializedName("type")
  private String valueType;

  /**
   * Builder.
   */
  public static class Builder {
    private String value;
    private Map metadata;
    private List<String> synonyms;
    private List<String> patterns;
    private String valueType;

    private Builder(CreateValue createValue) {
      value = createValue.value;
      metadata = createValue.metadata;
      synonyms = createValue.synonyms;
      patterns = createValue.patterns;
      valueType = createValue.valueType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param value the value
     */
    public Builder(String value) {
      this.value = value;
    }

    /**
     * Builds a CreateValue.
     *
     * @return the createValue
     */
    public CreateValue build() {
      return new CreateValue(this);
    }

    /**
     * Adds an synonym to synonyms.
     *
     * @param synonym the new synonym
     * @return the CreateValue builder
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
     * @return the CreateValue builder
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
     * Set the value.
     *
     * @param value the value
     * @return the CreateValue builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateValue builder
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
     * @return the CreateValue builder
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
     * @return the CreateValue builder
     */
    public Builder patterns(List<String> patterns) {
      this.patterns = patterns;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the CreateValue builder
     */
    public Builder valueType(String valueType) {
      this.valueType = valueType;
      return this;
    }
  }

  private CreateValue(Builder builder) {
    Validator.notNull(builder.value, "value cannot be null");
    value = builder.value;
    metadata = builder.metadata;
    synonyms = builder.synonyms;
    patterns = builder.patterns;
    valueType = builder.valueType;
  }

  /**
   * New builder.
   *
   * @return a CreateValue builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
