/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteSpeakerModel options. */
public class DeleteSpeakerModelOptions extends GenericModel {

  protected String speakerId;

  /** Builder. */
  public static class Builder {
    private String speakerId;

    private Builder(DeleteSpeakerModelOptions deleteSpeakerModelOptions) {
      this.speakerId = deleteSpeakerModelOptions.speakerId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param speakerId the speakerId
     */
    public Builder(String speakerId) {
      this.speakerId = speakerId;
    }

    /**
     * Builds a DeleteSpeakerModelOptions.
     *
     * @return the new DeleteSpeakerModelOptions instance
     */
    public DeleteSpeakerModelOptions build() {
      return new DeleteSpeakerModelOptions(this);
    }

    /**
     * Set the speakerId.
     *
     * @param speakerId the speakerId
     * @return the DeleteSpeakerModelOptions builder
     */
    public Builder speakerId(String speakerId) {
      this.speakerId = speakerId;
      return this;
    }
  }

  protected DeleteSpeakerModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.speakerId, "speakerId cannot be empty");
    speakerId = builder.speakerId;
  }

  /**
   * New builder.
   *
   * @return a DeleteSpeakerModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the speakerId.
   *
   * <p>The speaker ID (GUID) of the speaker model. You must make the request with service
   * credentials for the instance of the service that owns the speaker model.
   *
   * @return the speakerId
   */
  public String speakerId() {
    return speakerId;
  }
}
