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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * A term from the request that was identified as an entity.
 */
public class RuntimeEntity extends DynamicModel {
  private Type entityType = new TypeToken<String>() {
  }.getType();
  private Type locationType = new TypeToken<List<Long>>() {
  }.getType();
  private Type valueType = new TypeToken<String>() {
  }.getType();
  private Type confidenceType = new TypeToken<Double>() {
  }.getType();
  private Type metadataType = new TypeToken<Map>() {
  }.getType();
  private Type groupsType = new TypeToken<List<CaptureGroup>>() {
  }.getType();

  /**
   * Builder.
   */
  public static class Builder {
    private String entity;
    private List<Long> location;
    private String value;
    private Double confidence;
    private Map metadata;
    private List<CaptureGroup> groups;

    private Builder(RuntimeEntity runtimeEntity) {
      entity = runtimeEntity.entity;
      location = runtimeEntity.location;
      value = runtimeEntity.value;
      confidence = runtimeEntity.confidence;
      metadata = runtimeEntity.metadata;
      groups = runtimeEntity.groups;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entity the entity
     * @param location the location
     * @param value the value
     */
    public Builder(String entity, List<Long> location, String value) {
      this.entity = entity;
      this.location = location;
      this.value = value;
    }

    /**
     * Builds a RuntimeEntity.
     *
     * @return the runtimeEntity
     */
    public RuntimeEntity build() {
      RuntimeEntity runtimeEntity = new RuntimeEntity();
      runtimeEntity.put("entity", this.entity);
      runtimeEntity.put("location", this.location);
      runtimeEntity.put("value", this.value);
      runtimeEntity.put("confidence", this.confidence);
      runtimeEntity.put("metadata", this.metadata);
      runtimeEntity.put("groups", this.groups);
      return runtimeEntity;
    }

    /**
     * Adds an location to location.
     *
     * @param location the new location
     * @return the RuntimeEntity builder
     */
    public Builder addLocation(Long location) {
      Validator.notNull(location, "location cannot be null");
      if (this.location == null) {
        this.location = new ArrayList<Long>();
      }
      this.location.add(location);
      return this;
    }

    /**
     * Adds an groups to groups.
     *
     * @param groups the new groups
     * @return the RuntimeEntity builder
     */
    public Builder addGroups(CaptureGroup groups) {
      Validator.notNull(groups, "groups cannot be null");
      if (this.groups == null) {
        this.groups = new ArrayList<CaptureGroup>();
      }
      this.groups.add(groups);
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the RuntimeEntity builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the location.
     * Existing location will be replaced.
     *
     * @param location the location
     * @return the RuntimeEntity builder
     */
    public Builder location(List<Long> location) {
      this.location = location;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuntimeEntity builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the confidence.
     *
     * @param confidence the confidence
     * @return the RuntimeEntity builder
     */
    public Builder confidence(Double confidence) {
      this.confidence = confidence;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the RuntimeEntity builder
     */
    public Builder metadata(Map metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the groups.
     * Existing groups will be replaced.
     *
     * @param groups the groups
     * @return the RuntimeEntity builder
     */
    public Builder groups(List<CaptureGroup> groups) {
      this.groups = groups;
      return this;
    }
  }

  private RuntimeEntity(Builder builder) {
    Validator.notNull(builder.entity, "entity cannot be null");
    Validator.notNull(builder.location, "location cannot be null");
    Validator.notNull(builder.value, "value cannot be null");
    entity = builder.entity;
    location = builder.location;
    value = builder.value;
    confidence = builder.confidence;
    metadata = builder.metadata;
    groups = builder.groups;
  }

  /**
   * New builder.
   *
   * @return a RuntimeEntity builder
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
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("entity"), entityType);
  }

  /**
   * Gets the location.
   *
   * @return the location
   */
  public List<Long> location() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("location"), locationType);
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String value() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("value"), valueType);
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double confidence() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("confidence"), confidenceType);
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map metadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("metadata"), metadataType);
  }

  /**
   * Gets the groups.
   *
   * @return the groups
   */
  public List<CaptureGroup> groups() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("groups"), groupsType);
  }
}
