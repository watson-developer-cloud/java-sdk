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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Response payload for models.
 */
public class TranslationModel extends GenericModel {

  /**
   * Availability of a model.
   */
  public interface Status {
    /** uploading. */
    String UPLOADING = "uploading";
    /** uploaded. */
    String UPLOADED = "uploaded";
    /** dispatching. */
    String DISPATCHING = "dispatching";
    /** queued. */
    String QUEUED = "queued";
    /** training. */
    String TRAINING = "training";
    /** trained. */
    String TRAINED = "trained";
    /** publishing. */
    String PUBLISHING = "publishing";
    /** available. */
    String AVAILABLE = "available";
    /** deleted. */
    String DELETED = "deleted";
    /** error. */
    String ERROR = "error";
  }

  @SerializedName("model_id")
  private String modelId;
  private String name;
  private String source;
  private String target;
  @SerializedName("base_model_id")
  private String baseModelId;
  private String domain;
  private Boolean customizable;
  @SerializedName("default_model")
  private Boolean defaultModel;
  private String owner;
  private String status;

  /**
   * Gets the modelId.
   *
   * A globally unique string that identifies the underlying model that is used for translation. This string contains
   * all the information about source language, target language, domain, and various other related configurations.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the name.
   *
   * If a model is trained by a user, there might be an optional “name” parameter attached during training to help the
   * user identify the model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the source.
   *
   * Source language in two letter language code. Use the five letter code when clarifying between multiple supported
   * languages. When model_id is used directly, it will override the source-target language combination. Also, when a
   * two letter language code is used, but no suitable default is found, it returns an error.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the target.
   *
   * Target language in two letter language code.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the baseModelId.
   *
   * If this model is a custom model, this returns the base model that it is trained on. For a base model, this response
   * value is empty.
   *
   * @return the baseModelId
   */
  public String getBaseModelId() {
    return baseModelId;
  }

  /**
   * Gets the domain.
   *
   * The domain of the translation model.
   *
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Gets the customizable.
   *
   * Whether this model can be used as a base for customization. Customized models are not further customizable, and we
   * don't allow the customization of certain base models.
   *
   * @return the customizable
   */
  public Boolean isCustomizable() {
    return customizable;
  }

  /**
   * Gets the defaultModel.
   *
   * Whether this model is considered a default model and is used when the source and target languages are specified
   * without the model_id.
   *
   * @return the defaultModel
   */
  public Boolean isDefaultModel() {
    return defaultModel;
  }

  /**
   * Gets the owner.
   *
   * Returns the Bluemix ID of the instance that created the model, or an empty string if it is a model that is trained
   * by IBM.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the status.
   *
   * Availability of a model.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the modelId.
   *
   * @param modelId the new modelId
   */
  public void setModelId(final String modelId) {
    this.modelId = modelId;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the target.
   *
   * @param target the new target
   */
  public void setTarget(final String target) {
    this.target = target;
  }

  /**
   * Sets the baseModelId.
   *
   * @param baseModelId the new baseModelId
   */
  public void setBaseModelId(final String baseModelId) {
    this.baseModelId = baseModelId;
  }

  /**
   * Sets the domain.
   *
   * @param domain the new domain
   */
  public void setDomain(final String domain) {
    this.domain = domain;
  }

  /**
   * Sets the customizable.
   *
   * @param customizable the new customizable
   */
  public void setCustomizable(final Boolean customizable) {
    this.customizable = customizable;
  }

  /**
   * Sets the defaultModel.
   *
   * @param defaultModel the new defaultModel
   */
  public void setDefaultModel(final Boolean defaultModel) {
    this.defaultModel = defaultModel;
  }

  /**
   * Sets the owner.
   *
   * @param owner the new owner
   */
  public void setOwner(final String owner) {
    this.owner = owner;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }
}
