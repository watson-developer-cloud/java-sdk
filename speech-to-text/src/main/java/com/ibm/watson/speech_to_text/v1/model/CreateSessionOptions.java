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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createSession options.
 */
public class CreateSessionOptions extends GenericModel {

  /**
   * The identifier of the model to be used by the new session. (Use `GET /v1/models` or `GET /v1/models/{model_id}` for
   * information about available models.).
   */
  public interface Model {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
  }

  private String model;
  private String customizationId;
  private String acousticCustomizationId;
  private Double customizationWeight;
  private String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String model;
    private String customizationId;
    private String acousticCustomizationId;
    private Double customizationWeight;
    private String version;

    private Builder(CreateSessionOptions createSessionOptions) {
      model = createSessionOptions.model;
      customizationId = createSessionOptions.customizationId;
      acousticCustomizationId = createSessionOptions.acousticCustomizationId;
      customizationWeight = createSessionOptions.customizationWeight;
      version = createSessionOptions.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateSessionOptions.
     *
     * @return the createSessionOptions
     */
    public CreateSessionOptions build() {
      return new CreateSessionOptions(this);
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the CreateSessionOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the CreateSessionOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the acousticCustomizationId.
     *
     * @param acousticCustomizationId the acousticCustomizationId
     * @return the CreateSessionOptions builder
     */
    public Builder acousticCustomizationId(String acousticCustomizationId) {
      this.acousticCustomizationId = acousticCustomizationId;
      return this;
    }

    /**
     * Set the customizationWeight.
     *
     * @param customizationWeight the customizationWeight
     * @return the CreateSessionOptions builder
     */
    public Builder customizationWeight(Double customizationWeight) {
      this.customizationWeight = customizationWeight;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateSessionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  private CreateSessionOptions(Builder builder) {
    model = builder.model;
    customizationId = builder.customizationId;
    acousticCustomizationId = builder.acousticCustomizationId;
    customizationWeight = builder.customizationWeight;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a CreateSessionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the model.
   *
   * The identifier of the model to be used by the new session. (Use `GET /v1/models` or `GET /v1/models/{model_id}` for
   * information about available models.).
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of a custom language model that is to be used with the new session. The base model of the specified custom
   * language model must match the model specified with the `model` parameter. You must make the request with service
   * credentials created for the instance of the service that owns the custom model. By default, no custom language
   * model is used.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the acousticCustomizationId.
   *
   * The GUID of a custom acoustic model that is to be used with the new session. The base model of the specified custom
   * acoustic model must match the model specified with the `model` parameter. You must make the request with service
   * credentials created for the instance of the service that owns the custom model. By default, no custom acoustic
   * model is used.
   *
   * @return the acousticCustomizationId
   */
  public String acousticCustomizationId() {
    return acousticCustomizationId;
  }

  /**
   * Gets the customizationWeight.
   *
   * If you specify a `customization_id` when you create the session, you can use the `customization_weight` parameter
   * to tell the service how much weight to give to words from the custom language model compared to those from the base
   * model for recognition requests made with the session. Specify a value between 0.0 and 1.0. Unless a different
   * customization weight was specified for the custom model when it was trained, the default value is 0.3. A
   * customization weight that you specify overrides a weight that was specified when the custom model was trained. The
   * default value yields the best performance in general. Assign a higher value if your audio makes frequent use of OOV
   * words from the custom model. Use caution when setting the weight: a higher value can improve the accuracy of
   * phrases from the custom model's domain, but it can negatively affect performance on non-domain phrases.
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the version.
   *
   * The version of the specified base `model` that is to be used with the new session. Multiple versions of a base
   * model can exist when a model is updated for internal improvements. The parameter is intended primarily for use with
   * custom models that have been upgraded for a new base model. The default value depends on whether the parameter is
   * used with or without a custom model. For more information, see [Base model
   * version](https://console.bluemix.net/docs/services/speech-to-text/input.html#version).
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}
