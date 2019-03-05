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
package com.ibm.watson.speech_to_text.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * LanguageModel.
 */
public class LanguageModel extends GenericModel {

  /**
   * The current status of the custom language model:
   * * `pending`: The model was created but is waiting either for training data to be added or for the service to finish
   * analyzing added data.
   * * `ready`: The model contains data and is ready to be trained.
   * * `training`: The model is currently being trained.
   * * `available`: The model is trained and ready to use.
   * * `upgrading`: The model is currently being upgraded.
   * * `failed`: Training of the model failed.
   */
  public interface Status {
    /** pending. */
    String PENDING = "pending";
    /** ready. */
    String READY = "ready";
    /** training. */
    String TRAINING = "training";
    /** available. */
    String AVAILABLE = "available";
    /** upgrading. */
    String UPGRADING = "upgrading";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("customization_id")
  private String customizationId;
  private String created;
  private String language;
  private String dialect;
  private List<String> versions;
  private String owner;
  private String name;
  private String description;
  @SerializedName("base_model_name")
  private String baseModelName;
  private String status;
  private Long progress;
  private String error;
  private String warnings;

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom language model. The **Create a custom language model** method returns
   * only this field of the object; it does not return the other fields.
   *
   * @return the customizationId
   */
  public String getCustomizationId() {
    return customizationId;
  }

  /**
   * Gets the created.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the custom language model was created. The value is
   * provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the language.
   *
   * The language identifier of the custom language model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the dialect.
   *
   * The dialect of the language for the custom language model. By default, the dialect matches the language of the base
   * model; for example, `en-US` for either of the US English language models. For Spanish models, the field indicates
   * the dialect for which the model was created:
   * * `es-ES` for Castilian Spanish (the default)
   * * `es-LA` for Latin American Spanish
   * * `es-US` for North American (Mexican) Spanish.
   *
   * @return the dialect
   */
  public String getDialect() {
    return dialect;
  }

  /**
   * Gets the versions.
   *
   * A list of the available versions of the custom language model. Each element of the array indicates a version of the
   * base model with which the custom model can be used. Multiple versions exist only if the custom model has been
   * upgraded; otherwise, only a single version is shown.
   *
   * @return the versions
   */
  public List<String> getVersions() {
    return versions;
  }

  /**
   * Gets the owner.
   *
   * The GUID of the credentials for the instance of the service that owns the custom language model.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the name.
   *
   * The name of the custom language model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the custom language model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the baseModelName.
   *
   * The name of the language model for which the custom language model was created.
   *
   * @return the baseModelName
   */
  public String getBaseModelName() {
    return baseModelName;
  }

  /**
   * Gets the status.
   *
   * The current status of the custom language model:
   * * `pending`: The model was created but is waiting either for training data to be added or for the service to finish
   * analyzing added data.
   * * `ready`: The model contains data and is ready to be trained.
   * * `training`: The model is currently being trained.
   * * `available`: The model is trained and ready to use.
   * * `upgrading`: The model is currently being upgraded.
   * * `failed`: Training of the model failed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the progress.
   *
   * A percentage that indicates the progress of the custom language model's current training. A value of `100` means
   * that the model is fully trained. **Note:** The `progress` field does not currently reflect the progress of the
   * training. The field changes from `0` to `100` when training is complete.
   *
   * @return the progress
   */
  public Long getProgress() {
    return progress;
  }

  /**
   * Gets the error.
   *
   * If an error occurred while adding a grammar file to the custom language model, a message that describes an
   * `Internal Server Error` and includes the string `Cannot compile grammar`. The status of the custom model is not
   * affected by the error, but the grammar cannot be used with the model.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the warnings.
   *
   * If the request included unknown parameters, the following message: `Unexpected query parameter(s) ['parameters']
   * detected`, where `parameters` is a list that includes a quoted string for each unknown parameter.
   *
   * @return the warnings
   */
  public String getWarnings() {
    return warnings;
  }
}
