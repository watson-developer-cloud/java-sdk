/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.language_translator.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

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
  protected String modelId;
  protected String name;
  protected String source;
  protected String target;
  @SerializedName("base_model_id")
  protected String baseModelId;
  protected String domain;
  protected Boolean customizable;
  @SerializedName("default_model")
  protected Boolean defaultModel;
  protected String owner;
  protected String status;

  /**
   * Gets the modelId.
   *
   * A globally unique string that identifies the underlying model that is used for translation.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the name.
   *
   * Optional name that can be specified when the model is created.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the source.
   *
   * Translation source language code.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the target.
   *
   * Translation target language code.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the baseModelId.
   *
   * Model ID of the base model that was used to customize the model. If the model is not a custom model, this will be
   * an empty string.
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
   * Whether this model can be used as a base for customization. Customized models are not further customizable, and
   * some base models are not customizable.
   *
   * @return the customizable
   */
  public Boolean isCustomizable() {
    return customizable;
  }

  /**
   * Gets the defaultModel.
   *
   * Whether or not the model is a default model. A default model is the model for a given language pair that will be
   * used when that language pair is specified in the source and target parameters.
   *
   * @return the defaultModel
   */
  public Boolean isDefaultModel() {
    return defaultModel;
  }

  /**
   * Gets the owner.
   *
   * Either an empty string, indicating the model is not a custom model, or the ID of the service instance that created
   * the model.
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
}
