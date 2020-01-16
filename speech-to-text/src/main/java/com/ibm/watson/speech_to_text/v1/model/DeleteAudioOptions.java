/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
 * The deleteAudio options.
 */
public class DeleteAudioOptions extends GenericModel {

  protected String customizationId;
  protected String audioName;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String audioName;

    private Builder(DeleteAudioOptions deleteAudioOptions) {
      this.customizationId = deleteAudioOptions.customizationId;
      this.audioName = deleteAudioOptions.audioName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param audioName the audioName
     */
    public Builder(String customizationId, String audioName) {
      this.customizationId = customizationId;
      this.audioName = audioName;
    }

    /**
     * Builds a DeleteAudioOptions.
     *
     * @return the deleteAudioOptions
     */
    public DeleteAudioOptions build() {
      return new DeleteAudioOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the DeleteAudioOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the audioName.
     *
     * @param audioName the audioName
     * @return the DeleteAudioOptions builder
     */
    public Builder audioName(String audioName) {
      this.audioName = audioName;
      return this;
    }
  }

  protected DeleteAudioOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
        "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.audioName,
        "audioName cannot be empty");
    customizationId = builder.customizationId;
    audioName = builder.audioName;
  }

  /**
   * New builder.
   *
   * @return a DeleteAudioOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom acoustic model that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the audioName.
   *
   * The name of the audio resource for the custom acoustic model.
   *
   * @return the audioName
   */
  public String audioName() {
    return audioName;
  }
}
