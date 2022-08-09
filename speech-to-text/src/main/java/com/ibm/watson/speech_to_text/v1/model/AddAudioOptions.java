/*
 * (C) Copyright IBM Corp. 2018, 2022.
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

/** The addAudio options. */
public class AddAudioOptions extends GenericModel {

  /**
   * _For an archive-type resource_, specify the format of the audio files that are contained in the
   * archive file if they are of type `audio/alaw`, `audio/basic`, `audio/l16`, or `audio/mulaw`.
   * Include the `rate`, `channels`, and `endianness` parameters where necessary. In this case, all
   * audio files that are contained in the archive file must be of the indicated type.
   *
   * <p>For all other audio formats, you can omit the header. In this case, the audio files can be
   * of multiple types as long as they are not of the types listed in the previous paragraph.
   *
   * <p>The parameter accepts all of the audio formats that are supported for use with speech
   * recognition. For more information, see **Content types for audio-type resources** in the method
   * description.
   *
   * <p>_For an audio-type resource_, omit the header.
   */
  public interface ContainedContentType {
    /** audio/alaw. */
    String AUDIO_ALAW = "audio/alaw";
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/g729. */
    String AUDIO_G729 = "audio/g729";
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

  protected String customizationId;
  protected String audioName;
  protected InputStream audioResource;
  protected String contentType;
  protected String containedContentType;
  protected Boolean allowOverwrite;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String audioName;
    private InputStream audioResource;
    private String contentType;
    private String containedContentType;
    private Boolean allowOverwrite;

    private Builder(AddAudioOptions addAudioOptions) {
      this.customizationId = addAudioOptions.customizationId;
      this.audioName = addAudioOptions.audioName;
      this.audioResource = addAudioOptions.audioResource;
      this.contentType = addAudioOptions.contentType;
      this.containedContentType = addAudioOptions.containedContentType;
      this.allowOverwrite = addAudioOptions.allowOverwrite;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param audioName the audioName
     * @param audioResource the audioResource
     */
    public Builder(String customizationId, String audioName, InputStream audioResource) {
      this.customizationId = customizationId;
      this.audioName = audioName;
      this.audioResource = audioResource;
    }

    /**
     * Builds a AddAudioOptions.
     *
     * @return the new AddAudioOptions instance
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
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audioResource(File audioResource) throws FileNotFoundException {
      this.audioResource = new FileInputStream(audioResource);
      return this;
    }
  }

  protected AddAudioOptions() {}

  protected AddAudioOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.audioName, "audioName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.audioResource, "audioResource cannot be null");
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
   * Gets the audioName.
   *
   * <p>The name of the new audio resource for the custom acoustic model. Use a localized name that
   * matches the language of the custom model and reflects the contents of the resource. * Include a
   * maximum of 128 characters in the name. * Do not use characters that need to be URL-encoded. For
   * example, do not use spaces, slashes, backslashes, colons, ampersands, double quotes, plus
   * signs, equals signs, questions marks, and so on in the name. (The service does not prevent the
   * use of these characters. But because they must be URL-encoded wherever used, their use is
   * strongly discouraged.) * Do not use the name of an audio resource that has already been added
   * to the custom model.
   *
   * @return the audioName
   */
  public String audioName() {
    return audioName;
  }

  /**
   * Gets the audioResource.
   *
   * <p>The audio resource that is to be added to the custom acoustic model, an individual audio
   * file or an archive file.
   *
   * <p>With the `curl` command, use the `--data-binary` option to upload the file for the request.
   *
   * @return the audioResource
   */
  public InputStream audioResource() {
    return audioResource;
  }

  /**
   * Gets the contentType.
   *
   * <p>For an audio-type resource, the format (MIME type) of the audio. For more information, see
   * **Content types for audio-type resources** in the method description.
   *
   * <p>For an archive-type resource, the media type of the archive file. For more information, see
   * **Content types for archive-type resources** in the method description.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the containedContentType.
   *
   * <p>_For an archive-type resource_, specify the format of the audio files that are contained in
   * the archive file if they are of type `audio/alaw`, `audio/basic`, `audio/l16`, or
   * `audio/mulaw`. Include the `rate`, `channels`, and `endianness` parameters where necessary. In
   * this case, all audio files that are contained in the archive file must be of the indicated
   * type.
   *
   * <p>For all other audio formats, you can omit the header. In this case, the audio files can be
   * of multiple types as long as they are not of the types listed in the previous paragraph.
   *
   * <p>The parameter accepts all of the audio formats that are supported for use with speech
   * recognition. For more information, see **Content types for audio-type resources** in the method
   * description.
   *
   * <p>_For an audio-type resource_, omit the header.
   *
   * @return the containedContentType
   */
  public String containedContentType() {
    return containedContentType;
  }

  /**
   * Gets the allowOverwrite.
   *
   * <p>If `true`, the specified audio resource overwrites an existing audio resource with the same
   * name. If `false`, the request fails if an audio resource with the same name already exists. The
   * parameter has no effect if an audio resource with the same name does not already exist.
   *
   * @return the allowOverwrite
   */
  public Boolean allowOverwrite() {
    return allowOverwrite;
  }
}
