/*
 * (C) Copyright IBM Corp. 2026.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The detectLanguage options. */
public class DetectLanguageOptions extends GenericModel {

  protected Float lidConfidence;
  protected InputStream audio;
  protected String contentType;

  /** Builder. */
  public static class Builder {
    private Float lidConfidence;
    private InputStream audio;
    private String contentType;

    /**
     * Instantiates a new Builder from an existing DetectLanguageOptions instance.
     *
     * @param detectLanguageOptions the instance to initialize the Builder with
     */
    private Builder(DetectLanguageOptions detectLanguageOptions) {
      this.lidConfidence = detectLanguageOptions.lidConfidence;
      this.audio = detectLanguageOptions.audio;
      this.contentType = detectLanguageOptions.contentType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param lidConfidence the lidConfidence
     * @param audio the audio
     */
    public Builder(Float lidConfidence, InputStream audio) {
      this.lidConfidence = lidConfidence;
      this.audio = audio;
    }

    /**
     * Builds a DetectLanguageOptions.
     *
     * @return the new DetectLanguageOptions instance
     */
    public DetectLanguageOptions build() {
      return new DetectLanguageOptions(this);
    }

    /**
     * Set the lidConfidence.
     *
     * @param lidConfidence the lidConfidence
     * @return the DetectLanguageOptions builder
     */
    public Builder lidConfidence(Float lidConfidence) {
      this.lidConfidence = lidConfidence;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the DetectLanguageOptions builder
     */
    public Builder audio(InputStream audio) {
      this.audio = audio;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the DetectLanguageOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the DetectLanguageOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      this.audio = new FileInputStream(audio);
      return this;
    }
  }

  protected DetectLanguageOptions() {}

  protected DetectLanguageOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.lidConfidence, "lidConfidence cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.audio, "audio cannot be null");
    lidConfidence = builder.lidConfidence;
    audio = builder.audio;
    contentType = builder.contentType;
  }

  /**
   * New builder.
   *
   * @return a DetectLanguageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the lidConfidence.
   *
   * <p>Set a custom confidence threshold for detection.
   *
   * @return the lidConfidence
   */
  public Float lidConfidence() {
    return lidConfidence;
  }

  /**
   * Gets the audio.
   *
   * <p>The audio to transcribe.
   *
   * @return the audio
   */
  public InputStream audio() {
    return audio;
  }

  /**
   * Gets the contentType.
   *
   * <p>The type of the input.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }
}
