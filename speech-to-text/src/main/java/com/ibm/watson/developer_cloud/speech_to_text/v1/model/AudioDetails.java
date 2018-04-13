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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * AudioDetails.
 */
public class AudioDetails extends GenericModel {

  /**
   * The type of the audio resource: * `audio` for an individual audio file * `archive` for an archive (**.zip** or
   * **.tar.gz**) file that contains audio files.
   */
  public interface Type {
    /** audio. */
    String AUDIO = "audio";
    /** archive. */
    String ARCHIVE = "archive";
  }

  /**
   * **For an archive-type resource,** the format of the compressed archive: * `zip` for a **.zip** file * `gzip` for a
   * **.tar.gz** file Omitted for an audio-type resource.
   */
  public interface Compression {
    /** zip. */
    String ZIP = "zip";
    /** gzip. */
    String GZIP = "gzip";
  }

  private String type;
  private String codec;
  private Long frequency;
  private String compression;

  /**
   * Gets the type.
   *
   * The type of the audio resource: * `audio` for an individual audio file * `archive` for an archive (**.zip** or
   * **.tar.gz**) file that contains audio files.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the codec.
   *
   * **For an audio-type resource,** the codec in which the audio is encoded. Omitted for an archive-type resource.
   *
   * @return the codec
   */
  public String getCodec() {
    return codec;
  }

  /**
   * Gets the frequency.
   *
   * **For an audio-type resource,** the sampling rate of the audio in Hertz (samples per second). Omitted for an
   * archive-type resource.
   *
   * @return the frequency
   */
  public Long getFrequency() {
    return frequency;
  }

  /**
   * Gets the compression.
   *
   * **For an archive-type resource,** the format of the compressed archive: * `zip` for a **.zip** file * `gzip` for a
   * **.tar.gz** file Omitted for an audio-type resource.
   *
   * @return the compression
   */
  public String getCompression() {
    return compression;
  }
}
