/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Language Model used by the {@link TranslationModel}.
 * 
 */
public class TranslationModel extends GenericModel {

  /** The Constant STATUS_AVAILABLE. */
  public static final String STATUS_AVAILABLE = "training";

  /** The Constant STATUS_ERROR. */
  public static final String STATUS_ERROR = "training";

  /** The Constant STATUS_TRAINING. */
  public static final String STATUS_TRAINING = "training";

  /** The base model id. */
  @SerializedName("base_model_id")
  private String baseModelId;

  /** The customizable. */
  private boolean customizable;

  /** The default model. */
  @SerializedName("default_model")
  private boolean defaultModel;

  /** The domain. */
  private String domain;

  /** The model id. */
  @SerializedName("model_id")
  private String id;

  /** The name. */
  private String name;

  /** The owner. */
  private String owner;

  /** The source. */
  private String source;

  /** The status. */
  private String status;

  /** The target. */
  private String target;

  /**
   * Gets the base model id.
   * 
   * @return The baseModelId
   */
  public String getBaseModelId() {
    return baseModelId;
  }

  /**
   * Gets the domain.
   * 
   * @return The domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Gets the model id.
   * 
   * @return The modelId
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the model id.
   * 
   * @deprecated Use {@link TranslationModel#getId()}
   * @return The modelId
   */
  public String getModelId() {
    return getId();
  }

  /**
   * Gets the name.
   * 
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the owner.
   * 
   * @return The owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the source.
   * 
   * @return The source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the status.
   * 
   * @return The status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the target.
   * 
   * @return The target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Checks if is customizable.
   * 
   * @return The customizable
   */
  public boolean isCustomizable() {
    return customizable;
  }

  /**
   * Checks if is default model.
   * 
   * @return The defaultModel
   */
  public boolean isDefaultModel() {
    return defaultModel;
  }

  /**
   * Sets the base model id.
   * 
   * @param baseModelId The base_model_id
   */
  public void setBaseModelId(final String baseModelId) {
    this.baseModelId = baseModelId;
  }

  /**
   * Sets the customizable.
   * 
   * @param customizable The customizable
   */
  public void setCustomizable(final boolean customizable) {
    this.customizable = customizable;
  }

  /**
   * Sets the default model.
   * 
   * @param defaultModel The default_model
   */
  public void setDefaultModel(final boolean defaultModel) {
    this.defaultModel = defaultModel;
  }

  /**
   * Sets the domain.
   * 
   * @param domain The domain
   */
  public void setDomain(final String domain) {
    this.domain = domain;
  }

  /**
   * Sets the model id.
   * 
   * @param id The model id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets the name.
   * 
   * @param name The name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the owner.
   * 
   * @param owner The owner
   */
  public void setOwner(final String owner) {
    this.owner = owner;
  }

  /**
   * Sets the source.
   * 
   * @param source The source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the status.
   * 
   * @param status The status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the target.
   * 
   * @param target The target
   */
  public void setTarget(final String target) {
    this.target = target;
  }
}
