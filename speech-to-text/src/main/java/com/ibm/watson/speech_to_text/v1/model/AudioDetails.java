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

/** Information about an audio resource from a custom acoustic model. */
public class AudioDetails extends GenericModel {

  /**
   * The type of the audio resource: * `audio` for an individual audio file * `archive` for an
   * archive (**.zip** or **.tar.gz**) file that contains audio files * `undetermined` for a
   * resource that the service cannot validate (for example, if the user mistakenly passes a file
   * that does not contain audio, such as a JPEG file).
   */
  public interface Type {
    /** audio. */
    String AUDIO = "audio";
    /** archive. */
    String ARCHIVE = "archive";
    /** undetermined. */
    String UNDETERMINED = "undetermined";
  }

  /**
   * _For an archive-type resource_, the format of the compressed archive: * `zip` for a **.zip**
   * file * `gzip` for a **.tar.gz** file
   *
   * <p>Omitted for an audio-type resource.
   */
  public interface Compression {
    /** zip. */
    String ZIP = "zip";
    /** gzip. */
    String GZIP = "gzip";
  }

  protected String type;
  protected String codec;
  protected Long frequency;
  protected String compression;

  protected AudioDetails() {}

  /**
   * Gets the type.
   *
   * <p>The type of the audio resource: * `audio` for an individual audio file * `archive` for an
   * archive (**.zip** or **.tar.gz**) file that contains audio files * `undetermined` for a
   * resource that the service cannot validate (for example, if the user mistakenly passes a file
   * that does not contain audio, such as a JPEG file).
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the codec.
   *
   * <p>_For an audio-type resource_, the codec in which the audio is encoded. Omitted for an
   * archive-type resource.
   *
   * @return the codec
   */
  public String getCodec() {
    return codec;
  }

  /**
   * Gets the frequency.
   *
   * <p>_For an audio-type resource_, the sampling rate of the audio in Hertz (samples per second).
   * Omitted for an archive-type resource.
   *
   * @return the frequency
   */
  public Long getFrequency() {
    return frequency;
  }

  /**
   * Gets the compression.
   *
   * <p>_For an archive-type resource_, the format of the compressed archive: * `zip` for a **.zip**
   * file * `gzip` for a **.tar.gz** file
   *
   * <p>Omitted for an audio-type resource.
   *
   * @return the compression
   */
  public String getCompression() {
    return compression;
  }
}
