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
 * CreateValue.
 */
public class CreateValue extends GenericModel {

  /** The text of the entity value. */
  private String value;
  /** Any metadata related to the entity value. */
  private Map<String, Object> metadata;
  /** Any array of synonyms for the entity value. */
  private List<String> synonyms;

  /**
   * Builder.
   */
  public static class Builder {
    private String value;
    private Map<String, Object> metadata;
    private List<String> synonyms;

    private Builder(CreateValue createValue) {
      value = createValue.value;
      metadata = createValue.metadata;
      synonyms = createValue.synonyms;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the CreateValue.
     *
     * @return the createValue
     */
    public CreateValue build() {
      return new CreateValue(this);
    }

    /**
     * Adds an synonyms to synonyms.
     *
     * @param synonyms the new synonyms
     * @return the builder
     */
    public Builder synonyms(String synonyms) {
      if (this.synonyms == null) {
        this.synonyms = new ArrayList<String>();
      }
      this.synonyms.add(synonyms);
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return a CreateValue Builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return a CreateValue Builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the synonyms.
     * Existing synonyms will be replaced.
     *
     * @param synonyms the synonyms
     * @return a CreateValue Builder
     */
    public Builder synonyms(List<String> synonyms) {
      this.synonyms = synonyms;
      return this;
    }
  }

  private CreateValue(Builder builder) {
    Validator.notNull(builder.value, "value cannot be null");
    value = builder.value;
    metadata = builder.metadata;
    synonyms = builder.synonyms;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the synonyms.
   *
   * @return the synonyms
   */
  public List<String> synonyms() {
    return synonyms;
  }
}
