/*
 * (C) Copyright IBM Corp. 2018, 2021.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The upgradeAcousticModel options. */
public class UpgradeAcousticModelOptions extends GenericModel {

  protected String customizationId;
  protected String customLanguageModelId;
  protected Boolean force;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String customLanguageModelId;
    private Boolean force;

    private Builder(UpgradeAcousticModelOptions upgradeAcousticModelOptions) {
      this.customizationId = upgradeAcousticModelOptions.customizationId;
      this.customLanguageModelId = upgradeAcousticModelOptions.customLanguageModelId;
      this.force = upgradeAcousticModelOptions.force;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a UpgradeAcousticModelOptions.
     *
     * @return the new UpgradeAcousticModelOptions instance
     */
    public UpgradeAcousticModelOptions build() {
      return new UpgradeAcousticModelOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the UpgradeAcousticModelOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the customLanguageModelId.
     *
     * @param customLanguageModelId the customLanguageModelId
     * @return the UpgradeAcousticModelOptions builder
     */
    public Builder customLanguageModelId(String customLanguageModelId) {
      this.customLanguageModelId = customLanguageModelId;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the UpgradeAcousticModelOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected UpgradeAcousticModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    customLanguageModelId = builder.customLanguageModelId;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a UpgradeAcousticModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom acoustic model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the customLanguageModelId.
   *
   * <p>If the custom acoustic model was trained with a custom language model, the customization ID
   * (GUID) of that custom language model. The custom language model must be upgraded before the
   * custom acoustic model can be upgraded. The custom language model must be fully trained and
   * available. The credentials specified with the request must own both custom models.
   *
   * @return the customLanguageModelId
   */
  public String customLanguageModelId() {
    return customLanguageModelId;
  }

  /**
   * Gets the force.
   *
   * <p>If `true`, forces the upgrade of a custom acoustic model for which no input data has been
   * modified since it was last trained. Use this parameter only to force the upgrade of a custom
   * acoustic model that is trained with a custom language model, and only if you receive a 400
   * response code and the message `No input data modified since last training`. See [Upgrading a
   * custom acoustic
   * model](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-custom-upgrade#custom-upgrade-acoustic).
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}
