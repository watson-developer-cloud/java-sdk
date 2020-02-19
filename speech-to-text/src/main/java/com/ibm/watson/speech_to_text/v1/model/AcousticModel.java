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
package com.ibm.watson.speech_to_text.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about an existing custom acoustic model.
 */
public class AcousticModel extends GenericModel {

  /**
   * The current status of the custom acoustic model:
   * * `pending`: The model was created but is waiting either for valid training data to be added or for the service to
   * finish analyzing added data.
   * * `ready`: The model contains valid data and is ready to be trained. If the model contains a mix of valid and
   * invalid resources, you need to set the `strict` parameter to `false` for the training to proceed.
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
  protected String customizationId;
  protected String created;
  protected String updated;
  protected String language;
  protected List<String> versions;
  protected String owner;
  protected String name;
  protected String description;
  @SerializedName("base_model_name")
  protected String baseModelName;
  protected String status;
  protected Long progress;
  protected String warnings;

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom acoustic model. The **Create a custom acoustic model** method returns
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
   * The date and time in Coordinated Universal Time (UTC) at which the custom acoustic model was created. The value is
   * provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the custom acoustic model was last modified. The
   * `created` and `updated` fields are equal when an acoustic model is first added but has yet to be updated. The value
   * is provided in full ISO 8601 format (YYYY-MM-DDThh:mm:ss.sTZD).
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the language.
   *
   * The language identifier of the custom acoustic model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the versions.
   *
   * A list of the available versions of the custom acoustic model. Each element of the array indicates a version of the
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
   * The GUID of the credentials for the instance of the service that owns the custom acoustic model.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the name.
   *
   * The name of the custom acoustic model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the custom acoustic model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the baseModelName.
   *
   * The name of the language model for which the custom acoustic model was created.
   *
   * @return the baseModelName
   */
  public String getBaseModelName() {
    return baseModelName;
  }

  /**
   * Gets the status.
   *
   * The current status of the custom acoustic model:
   * * `pending`: The model was created but is waiting either for valid training data to be added or for the service to
   * finish analyzing added data.
   * * `ready`: The model contains valid data and is ready to be trained. If the model contains a mix of valid and
   * invalid resources, you need to set the `strict` parameter to `false` for the training to proceed.
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
   * A percentage that indicates the progress of the custom acoustic model's current training. A value of `100` means
   * that the model is fully trained. **Note:** The `progress` field does not currently reflect the progress of the
   * training. The field changes from `0` to `100` when training is complete.
   *
   * @return the progress
   */
  public Long getProgress() {
    return progress;
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

