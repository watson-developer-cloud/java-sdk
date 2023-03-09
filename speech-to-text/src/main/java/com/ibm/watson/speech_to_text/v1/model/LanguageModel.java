/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Information about an existing custom language model. */
public class LanguageModel extends GenericModel {

  /**
   * The current status of the custom language model: * `pending`: The model was created but is
   * waiting either for valid training data to be added or for the service to finish analyzing added
   * data. * `ready`: The model contains valid data and is ready to be trained. If the model
   * contains a mix of valid and invalid resources, you need to set the `strict` parameter to
   * `false` for the training to proceed. * `training`: The model is currently being trained. *
   * `available`: The model is trained and ready to use. * `upgrading`: The model is currently being
   * upgraded. * `failed`: Training of the model failed.
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
  protected String customizationId;

  protected String created;
  protected String updated;
  protected String language;
  protected String dialect;
  protected List<String> versions;
  protected String owner;
  protected String name;
  protected String description;

  @SerializedName("base_model_name")
  protected String baseModelName;

  protected String status;
  protected Long progress;
  protected String error;
  protected String warnings;

  protected LanguageModel() {}

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom language model. The [Create a custom language
   * model](#createlanguagemodel) method returns only this field of the object; it does not return
   * the other fields.
   *
   * @return the customizationId
   */
  public String getCustomizationId() {
    return customizationId;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the custom language model was
   * created. The value is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the custom language model was
   * last modified. The `created` and `updated` fields are equal when a language model is first
   * added but has yet to be updated. The value is provided in full ISO 8601 format
   * (YYYY-MM-DDThh:mm:ss.sTZD).
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the language.
   *
   * <p>The language identifier of the custom language model (for example, `en-US`). The value
   * matches the five-character language identifier from the name of the base model for the custom
   * model. This value might be different from the value of the `dialect` field.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the dialect.
   *
   * <p>The dialect of the language for the custom language model. _For custom models that are based
   * on non-Spanish previous-generation models and on next-generation models,_ the field matches the
   * language of the base model; for example, `en-US` for one of the US English models. _For custom
   * models that are based on Spanish previous-generation models,_ the field indicates the dialect
   * with which the model was created. The value can match the name of the base model or, if it was
   * specified by the user, can be one of the following: * `es-ES` for Castilian Spanish (`es-ES`
   * models) * `es-LA` for Latin American Spanish (`es-AR`, `es-CL`, `es-CO`, and `es-PE` models) *
   * `es-US` for Mexican (North American) Spanish (`es-MX` models)
   *
   * <p>Dialect values are case-insensitive.
   *
   * @return the dialect
   */
  public String getDialect() {
    return dialect;
  }

  /**
   * Gets the versions.
   *
   * <p>A list of the available versions of the custom language model. Each element of the array
   * indicates a version of the base model with which the custom model can be used. Multiple
   * versions exist only if the custom model has been upgraded to a new version of its base model.
   * Otherwise, only a single version is shown.
   *
   * @return the versions
   */
  public List<String> getVersions() {
    return versions;
  }

  /**
   * Gets the owner.
   *
   * <p>The GUID of the credentials for the instance of the service that owns the custom language
   * model.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the custom language model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the custom language model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the baseModelName.
   *
   * <p>The name of the language model for which the custom language model was created.
   *
   * @return the baseModelName
   */
  public String getBaseModelName() {
    return baseModelName;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the custom language model: * `pending`: The model was created but is
   * waiting either for valid training data to be added or for the service to finish analyzing added
   * data. * `ready`: The model contains valid data and is ready to be trained. If the model
   * contains a mix of valid and invalid resources, you need to set the `strict` parameter to
   * `false` for the training to proceed. * `training`: The model is currently being trained. *
   * `available`: The model is trained and ready to use. * `upgrading`: The model is currently being
   * upgraded. * `failed`: Training of the model failed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the progress.
   *
   * <p>A percentage that indicates the progress of the custom language model's current training. A
   * value of `100` means that the model is fully trained. **Note:** The `progress` field does not
   * currently reflect the progress of the training. The field changes from `0` to `100` when
   * training is complete.
   *
   * @return the progress
   */
  public Long getProgress() {
    return progress;
  }

  /**
   * Gets the error.
   *
   * <p>If an error occurred while adding a grammar file to the custom language model, a message
   * that describes an `Internal Server Error` and includes the string `Cannot compile grammar`. The
   * status of the custom model is not affected by the error, but the grammar cannot be used with
   * the model.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the warnings.
   *
   * <p>If the request included unknown parameters, the following message: `Unexpected query
   * parameter(s) ['parameters'] detected`, where `parameters` is a list that includes a quoted
   * string for each unknown parameter.
   *
   * @return the warnings
   */
  public String getWarnings() {
    return warnings;
  }
}
