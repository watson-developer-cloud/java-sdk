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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * CreateEntity.
 */
public class CreateEntity extends GenericModel {

  /** The name of the entity. */
  private String entity;
  /** The description of the entity. */
  private String description;
  /** An array of entity values. */
  private List<CreateValue> values;

  /**
   * Builder.
   */
  public static class Builder {
    private String entity;
    private String description;
    private List<CreateValue> values;

    private Builder(CreateEntity createEntity) {
      entity = createEntity.entity;
      description = createEntity.description;
      values = createEntity.values;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the CreateEntity.
     *
     * @return the createEntity
     */
    public CreateEntity build() {
      return new CreateEntity(this);
    }

    /**
     * Adds an values to values.
     *
     * @param values the new values
     * @return the builder
     */
    public Builder values(CreateValue values) {
      if (this.values == null) {
        this.values = new ArrayList<CreateValue>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return a CreateEntity Builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return a CreateEntity Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the values.
     * Existing values will be replaced.
     *
     * @param values the values
     * @return a CreateEntity Builder
     */
    public Builder values(List<CreateValue> values) {
      this.values = values;
      return this;
    }
  }

  private CreateEntity(Builder builder) {
    Validator.notNull(builder.entity, "entity cannot be null");
    entity = builder.entity;
    description = builder.description;
    values = builder.values;
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
   * Gets the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<CreateValue> values() {
    return values;
  }
}
