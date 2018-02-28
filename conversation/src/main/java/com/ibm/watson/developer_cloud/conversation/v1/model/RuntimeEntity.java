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
   * Gets the entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("entity"), entityType);
  }

  /**
   * Gets the location.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("location"), locationType);
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("value"), valueType);
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("confidence"), confidenceType);
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("metadata"), metadataType);
  }

  /**
   * Gets the groups.
   *
   * @return the groups
   */
  public List<CaptureGroup> getGroups() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("groups"), groupsType);
  }
}
