/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

/** The getModel options. */
public class GetModelOptions extends GenericModel {

  /**
   * The identifier of the model in the form of its name from the output of the [List
   * models](#listmodels) method.
   */
  public interface ModelId {
    /** ar-MS_BroadbandModel. */
    String AR_MS_BROADBANDMODEL = "ar-MS_BroadbandModel";
    /** ar-MS_Telephony. */
    String AR_MS_TELEPHONY = "ar-MS_Telephony";
    /** cs-CZ_Telephony. */
    String CS_CZ_TELEPHONY = "cs-CZ_Telephony";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_Multimedia. */
    String DE_DE_MULTIMEDIA = "de-DE_Multimedia";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
    /** de-DE_Telephony. */
    String DE_DE_TELEPHONY = "de-DE_Telephony";
    /** en-AU. */
    String EN_AU = "en-AU";
    /** en-AU_BroadbandModel. */
    String EN_AU_BROADBANDMODEL = "en-AU_BroadbandModel";
    /** en-AU_Multimedia. */
    String EN_AU_MULTIMEDIA = "en-AU_Multimedia";
    /** en-AU_NarrowbandModel. */
    String EN_AU_NARROWBANDMODEL = "en-AU_NarrowbandModel";
    /** en-AU_Telephony. */
    String EN_AU_TELEPHONY = "en-AU_Telephony";
    /** en-GB. */
    String EN_GB = "en-GB";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_Multimedia. */
    String EN_GB_MULTIMEDIA = "en-GB_Multimedia";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-GB_Telephony. */
    String EN_GB_TELEPHONY = "en-GB_Telephony";
    /** en-IN. */
    String EN_IN = "en-IN";
    /** en-IN_Telephony. */
    String EN_IN_TELEPHONY = "en-IN_Telephony";
    /** en-US. */
    String EN_US = "en-US";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_Multimedia. */
    String EN_US_MULTIMEDIA = "en-US_Multimedia";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** en-US_ShortForm_NarrowbandModel. */
    String EN_US_SHORTFORM_NARROWBANDMODEL = "en-US_ShortForm_NarrowbandModel";
    /** en-US_Telephony. */
    String EN_US_TELEPHONY = "en-US_Telephony";
    /** en-WW_Medical_Telephony. */
    String EN_WW_MEDICAL_TELEPHONY = "en-WW_Medical_Telephony";
    /** es-AR. */
    String ES_AR = "es-AR";
    /** es-AR_BroadbandModel. */
    String ES_AR_BROADBANDMODEL = "es-AR_BroadbandModel";
    /** es-AR_NarrowbandModel. */
    String ES_AR_NARROWBANDMODEL = "es-AR_NarrowbandModel";
    /** es-CL. */
    String ES_CL = "es-CL";
    /** es-CL_BroadbandModel. */
    String ES_CL_BROADBANDMODEL = "es-CL_BroadbandModel";
    /** es-CL_NarrowbandModel. */
    String ES_CL_NARROWBANDMODEL = "es-CL_NarrowbandModel";
    /** es-CO. */
    String ES_CO = "es-CO";
    /** es-CO_BroadbandModel. */
    String ES_CO_BROADBANDMODEL = "es-CO_BroadbandModel";
    /** es-CO_NarrowbandModel. */
    String ES_CO_NARROWBANDMODEL = "es-CO_NarrowbandModel";
    /** es-ES. */
    String ES_ES = "es-ES";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** es-ES_Multimedia. */
    String ES_ES_MULTIMEDIA = "es-ES_Multimedia";
    /** es-ES_Telephony. */
    String ES_ES_TELEPHONY = "es-ES_Telephony";
    /** es-LA_Telephony. */
    String ES_LA_TELEPHONY = "es-LA_Telephony";
    /** es-MX. */
    String ES_MX = "es-MX";
    /** es-MX_BroadbandModel. */
    String ES_MX_BROADBANDMODEL = "es-MX_BroadbandModel";
    /** es-MX_NarrowbandModel. */
    String ES_MX_NARROWBANDMODEL = "es-MX_NarrowbandModel";
    /** es-PE. */
    String ES_PE = "es-PE";
    /** es-PE_BroadbandModel. */
    String ES_PE_BROADBANDMODEL = "es-PE_BroadbandModel";
    /** es-PE_NarrowbandModel. */
    String ES_PE_NARROWBANDMODEL = "es-PE_NarrowbandModel";
    /** fr-CA. */
    String FR_CA = "fr-CA";
    /** fr-CA_BroadbandModel. */
    String FR_CA_BROADBANDMODEL = "fr-CA_BroadbandModel";
    /** fr-CA_Multimedia. */
    String FR_CA_MULTIMEDIA = "fr-CA_Multimedia";
    /** fr-CA_NarrowbandModel. */
    String FR_CA_NARROWBANDMODEL = "fr-CA_NarrowbandModel";
    /** fr-CA_Telephony. */
    String FR_CA_TELEPHONY = "fr-CA_Telephony";
    /** fr-FR. */
    String FR_FR = "fr-FR";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_Multimedia. */
    String FR_FR_MULTIMEDIA = "fr-FR_Multimedia";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
    /** fr-FR_Telephony. */
    String FR_FR_TELEPHONY = "fr-FR_Telephony";
    /** hi-IN_Telephony. */
    String HI_IN_TELEPHONY = "hi-IN_Telephony";
    /** it-IT_BroadbandModel. */
    String IT_IT_BROADBANDMODEL = "it-IT_BroadbandModel";
    /** it-IT_NarrowbandModel. */
    String IT_IT_NARROWBANDMODEL = "it-IT_NarrowbandModel";
    /** it-IT_Multimedia. */
    String IT_IT_MULTIMEDIA = "it-IT_Multimedia";
    /** it-IT_Telephony. */
    String IT_IT_TELEPHONY = "it-IT_Telephony";
    /** ja-JP. */
    String JA_JP = "ja-JP";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_Multimedia. */
    String JA_JP_MULTIMEDIA = "ja-JP_Multimedia";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ja-JP_Telephony. */
    String JA_JP_TELEPHONY = "ja-JP_Telephony";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_Multimedia. */
    String KO_KR_MULTIMEDIA = "ko-KR_Multimedia";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** ko-KR_Telephony. */
    String KO_KR_TELEPHONY = "ko-KR_Telephony";
    /** nl-BE_Telephony. */
    String NL_BE_TELEPHONY = "nl-BE_Telephony";
    /** nl-NL_BroadbandModel. */
    String NL_NL_BROADBANDMODEL = "nl-NL_BroadbandModel";
    /** nl-NL_Multimedia. */
    String NL_NL_MULTIMEDIA = "nl-NL_Multimedia";
    /** nl-NL_NarrowbandModel. */
    String NL_NL_NARROWBANDMODEL = "nl-NL_NarrowbandModel";
    /** nl-NL_Telephony. */
    String NL_NL_TELEPHONY = "nl-NL_Telephony";
    /** pt-BR. */
    String PT_BR = "pt-BR";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_Multimedia. */
    String PT_BR_MULTIMEDIA = "pt-BR_Multimedia";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** pt-BR_Telephony. */
    String PT_BR_TELEPHONY = "pt-BR_Telephony";
    /** sv-SE_Telephony. */
    String SV_SE_TELEPHONY = "sv-SE_Telephony";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
    /** zh-CN_Telephony. */
    String ZH_CN_TELEPHONY = "zh-CN_Telephony";
  }

  protected String modelId;

  /** Builder. */
  public static class Builder {
    private String modelId;

    /**
     * Instantiates a new Builder from an existing GetModelOptions instance.
     *
     * @param getModelOptions the instance to initialize the Builder with
     */
    private Builder(GetModelOptions getModelOptions) {
      this.modelId = getModelOptions.modelId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param modelId the modelId
     */
    public Builder(String modelId) {
      this.modelId = modelId;
    }

    /**
     * Builds a GetModelOptions.
     *
     * @return the new GetModelOptions instance
     */
    public GetModelOptions build() {
      return new GetModelOptions(this);
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the GetModelOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }
  }

  protected GetModelOptions() {}

  protected GetModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a GetModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the modelId.
   *
   * <p>The identifier of the model in the form of its name from the output of the [List
   * models](#listmodels) method.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }
}
