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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The addAudio options.
 */
public class AddAudioOptions extends GenericModel {

  /**
   * The type of the input: application/zip, application/gzip, audio/basic, audio/flac, audio/l16, audio/mp3,
   * audio/mpeg, audio/mulaw, audio/ogg, audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm,
   * audio/webm;codecs=opus, or audio/webm;codecs=vorbis.
   */
  public interface ContentType {
    /** application/zip. */
    String APPLICATION_ZIP = "application/zip";
    /** application/gzip. */
    String APPLICATION_GZIP = "application/gzip";
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/l16. */
    String AUDIO_L16 = "audio/l16";
    /** audio/mp3. */
    String AUDIO_MP3 = "audio/mp3";
    /** audio/mpeg. */
    String AUDIO_MPEG = "audio/mpeg";
    /** audio/mulaw. */
    String AUDIO_MULAW = "audio/mulaw";
    /** audio/ogg. */
    String AUDIO_OGG = "audio/ogg";
    /** audio/ogg;codecs=opus. */
    String AUDIO_OGG_CODECS_OPUS = "audio/ogg;codecs=opus";
    /** audio/ogg;codecs=vorbis. */
    String AUDIO_OGG_CODECS_VORBIS = "audio/ogg;codecs=vorbis";
    /** audio/wav. */
    String AUDIO_WAV = "audio/wav";
    /** audio/webm. */
    String AUDIO_WEBM = "audio/webm";
    /** audio/webm;codecs=opus. */
    String AUDIO_WEBM_CODECS_OPUS = "audio/webm;codecs=opus";
    /** audio/webm;codecs=vorbis. */
    String AUDIO_WEBM_CODECS_VORBIS = "audio/webm;codecs=vorbis";
  }

  /**
   * For an archive-type resource that contains audio files whose format is not `audio/wav`, specifies the format of the
   * audio files. The header accepts all of the audio formats supported for use with speech recognition and with the
   * `Content-Type` header, including the `rate`, `channels`, and `endianness` parameters that are used with some
   * formats. For a complete list of supported audio formats, see [Audio
   * formats](/docs/services/speech-to-text/input.html#formats).
   */
  public interface ContainedContentType {
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/l16. */
    String AUDIO_L16 = "audio/l16";
    /** audio/mp3. */
    String AUDIO_MP3 = "audio/mp3";
    /** audio/mpeg. */
    String AUDIO_MPEG = "audio/mpeg";
    /** audio/mulaw. */
    String AUDIO_MULAW = "audio/mulaw";
    /** audio/ogg. */
    String AUDIO_OGG = "audio/ogg";
    /** audio/ogg;codecs=opus. */
    String AUDIO_OGG_CODECS_OPUS = "audio/ogg;codecs=opus";
    /** audio/ogg;codecs=vorbis. */
    String AUDIO_OGG_CODECS_VORBIS = "audio/ogg;codecs=vorbis";
    /** audio/wav. */
    String AUDIO_WAV = "audio/wav";
    /** audio/webm. */
    String AUDIO_WEBM = "audio/webm";
    /** audio/webm;codecs=opus. */
    String AUDIO_WEBM_CODECS_OPUS = "audio/webm;codecs=opus";
    /** audio/webm;codecs=vorbis. */
    String AUDIO_WEBM_CODECS_VORBIS = "audio/webm;codecs=vorbis";
  }

  private String customizationId;
  private String audioName;
  private InputStream audioResource;
  private String contentType;
  private String containedContentType;
  private Boolean allowOverwrite;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String audioName;
    private InputStream audioResource;
    private String contentType;
    private String containedContentType;
    private Boolean allowOverwrite;

    private Builder(AddAudioOptions addAudioOptions) {
      customizationId = addAudioOptions.customizationId;
      audioName = addAudioOptions.audioName;
      audioResource = addAudioOptions.audioResource;
      contentType = addAudioOptions.contentType;
      containedContentType = addAudioOptions.containedContentType;
      allowOverwrite = addAudioOptions.allowOverwrite;
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
     * Builds a AddAudioOptions.
     *
     * @return the addAudioOptions
     */
    public AddAudioOptions build() {
      return new AddAudioOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddAudioOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the audioName.
     *
     * @param audioName the audioName
     * @return the AddAudioOptions builder
     */
    public Builder audioName(String audioName) {
      this.audioName = audioName;
      return this;
    }

    /**
     * Set the audioResource.
     *
     * @param audioResource the audioResource
     * @return the AddAudioOptions builder
     */
    public Builder audioResource(InputStream audioResource) {
      this.audioResource = audioResource;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the AddAudioOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the containedContentType.
     *
     * @param containedContentType the containedContentType
     * @return the AddAudioOptions builder
     */
    public Builder containedContentType(String containedContentType) {
      this.containedContentType = containedContentType;
      return this;
    }

    /**
     * Set the allowOverwrite.
     *
     * @param allowOverwrite the allowOverwrite
     * @return the AddAudioOptions builder
     */
    public Builder allowOverwrite(Boolean allowOverwrite) {
      this.allowOverwrite = allowOverwrite;
      return this;
    }

    /**
     * Set the audioResource.
     *
     * @param audioResource the audioResource
     * @return the AddAudioOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audioResource(File audioResource) throws FileNotFoundException {
      this.audioResource = new FileInputStream(audioResource);
      return this;
    }
  }

  private AddAudioOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.audioName, "audioName cannot be empty");
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    customizationId = builder.customizationId;
    audioName = builder.audioName;
    audioResource = builder.audioResource;
    contentType = builder.contentType;
    containedContentType = builder.containedContentType;
    allowOverwrite = builder.allowOverwrite;
  }

  /**
   * New builder.
   *
   * @return a AddAudioOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of the custom acoustic model to which an audio resource is to be added. You must make the request with
   * service credentials created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the audioName.
   *
   * The name of the audio resource that is to be added to the custom acoustic model. The name cannot contain spaces.
   * Use a localized name that matches the language of the custom model.
   *
   * @return the audioName
   */
  public String audioName() {
    return audioName;
  }

  /**
   * Gets the audioResource.
   *
   * @return the audioResource
   */
  public InputStream audioResource() {
    return audioResource;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input: application/zip, application/gzip, audio/basic, audio/flac, audio/l16, audio/mp3,
   * audio/mpeg, audio/mulaw, audio/ogg, audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm,
   * audio/webm;codecs=opus, or audio/webm;codecs=vorbis.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the containedContentType.
   *
   * For an archive-type resource that contains audio files whose format is not `audio/wav`, specifies the format of the
   * audio files. The header accepts all of the audio formats supported for use with speech recognition and with the
   * `Content-Type` header, including the `rate`, `channels`, and `endianness` parameters that are used with some
   * formats. For a complete list of supported audio formats, see [Audio
   * formats](/docs/services/speech-to-text/input.html#formats).
   *
   * @return the containedContentType
   */
  public String containedContentType() {
    return containedContentType;
  }

  /**
   * Gets the allowOverwrite.
   *
   * Indicates whether the specified audio resource is to overwrite an existing resource with the same name. If a
   * resource with the same name already exists, the request fails unless `allow_overwrite` is set to `true`; by
   * default, the parameter is `false`. The parameter has no effect if a resource with the same name does not already
   * exist.
   *
   * @return the allowOverwrite
   */
  public Boolean allowOverwrite() {
    return allowOverwrite;
  }
}
