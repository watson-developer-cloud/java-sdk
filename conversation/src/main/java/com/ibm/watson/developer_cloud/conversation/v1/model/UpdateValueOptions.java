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
 * the updateValue options.
 */
public class UpdateValueOptions extends GenericModel {

  private String workspaceId;
  private String entity;
  private String value;
  private List<String> newSynonyms;
  private Map newMetadata;
  private String newValue;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private List<String> newSynonyms;
    private Map newMetadata;
    private String newValue;

    private Builder(UpdateValueOptions updateValueOptions) {
      workspaceId = updateValueOptions.workspaceId;
      entity = updateValueOptions.entity;
      value = updateValueOptions.value;
      newSynonyms = updateValueOptions.newSynonyms;
      newMetadata = updateValueOptions.newMetadata;
      newValue = updateValueOptions.newValue;
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
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateValueOptions builder
     */
    public Builder newMetadata(Map newMetadata) {
      this.newMetadata = newMetadata;
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
  }

  private UpdateValueOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    Validator.notEmpty(builder.entity, "entity cannot be empty");
    Validator.notEmpty(builder.value, "value cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    newSynonyms = builder.newSynonyms;
    newMetadata = builder.newMetadata;
    newValue = builder.newValue;
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
   * Gets the newSynonyms.
   *
   * An array of synonyms for the entity value.
   *
   * @return the newSynonyms
   */
  public List<String> newSynonyms() {
    return newSynonyms;
  }

  /**
   * Gets the newMetadata.
   *
   * Any metadata related to the entity value.
   *
   * @return the newMetadata
   */
  public Map newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newValue.
   *
   * The text of the entity value.
   *
   * @return the newValue
   */
  public String newValue() {
    return newValue;
  }
}
