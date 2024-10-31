/*
 * (C) Copyright IBM Corp. 2024.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The createSpeakerModel options. */
public class CreateSpeakerModelOptions extends GenericModel {

  protected String speakerName;
  protected InputStream audio;

  /** Builder. */
  public static class Builder {
    private String speakerName;
    private InputStream audio;

    /**
     * Instantiates a new Builder from an existing CreateSpeakerModelOptions instance.
     *
     * @param createSpeakerModelOptions the instance to initialize the Builder with
     */
    private Builder(CreateSpeakerModelOptions createSpeakerModelOptions) {
      this.speakerName = createSpeakerModelOptions.speakerName;
      this.audio = createSpeakerModelOptions.audio;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param speakerName the speakerName
     * @param audio the audio
     */
    public Builder(String speakerName, InputStream audio) {
      this.speakerName = speakerName;
      this.audio = audio;
    }

    /**
     * Builds a CreateSpeakerModelOptions.
     *
     * @return the new CreateSpeakerModelOptions instance
     */
    public CreateSpeakerModelOptions build() {
      return new CreateSpeakerModelOptions(this);
    }

    /**
     * Set the speakerName.
     *
     * @param speakerName the speakerName
     * @return the CreateSpeakerModelOptions builder
     */
    public Builder speakerName(String speakerName) {
      this.speakerName = speakerName;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the CreateSpeakerModelOptions builder
     */
    public Builder audio(InputStream audio) {
      this.audio = audio;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the CreateSpeakerModelOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      this.audio = new FileInputStream(audio);
      return this;
    }
  }

  protected CreateSpeakerModelOptions() {}

  protected CreateSpeakerModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.speakerName, "speakerName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.audio, "audio cannot be null");
    speakerName = builder.speakerName;
    audio = builder.audio;
  }

  /**
   * New builder.
   *
   * @return a CreateSpeakerModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the speakerName.
   *
   * <p>The name of the speaker that is to be added to the service instance. * Include a maximum of
   * 49 characters in the name. * Include only alphanumeric characters and `_` (underscores) in the
   * name. * Do not include XML sensitive characters (double quotes, single quotes, ampersands,
   * angle brackets, and slashes) in the name. * Do not use the name of an existing speaker that is
   * already defined for the service instance.
   *
   * @return the speakerName
   */
  public String speakerName() {
    return speakerName;
  }

  /**
   * Gets the audio.
   *
   * <p>An enrollment audio file that contains a sample of the speaker’s voice. * The enrollment
   * audio must be in WAV format and must have a minimum sampling rate of 16 kHz. The service
   * accepts audio with higher sampling rates. It transcodes all audio to 16 kHz before processing
   * it. * The length of the enrollment audio is limited to 1 minute. Speaking one or two paragraphs
   * of text that include five to ten sentences is recommended.
   *
   * @return the audio
   */
  public InputStream audio() {
    return audio;
  }
}
