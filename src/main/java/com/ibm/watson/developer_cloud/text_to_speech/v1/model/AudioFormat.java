/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;

/**
 * Audio format supported by the {@link TextToSpeech} service.
 */
public enum AudioFormat {

  /** FLAC format (value is "audio/flac"). */
  FLAC(HttpMediaType.AUDIO_FLAC),

  /** OGG format (value is "audio/ogg; codecs=opus"). */
  OGG(HttpMediaType.AUDIO_OGG),

  /** OGG_VORBIS format (value is "audio/ogg; codecs=vorbis"). */
  OGG_VORBIS(HttpMediaType.AUDIO_OGG_VORBIS),
  
  /** WAV format (value is "audio/wav"). */
  WAV(HttpMediaType.AUDIO_WAV),

  /** Linear 16-bit Pulse-Code Modulation (PCM) format (value is "audio/l16"). */
  PCM(HttpMediaType.AUDIO_PCM),
  
  /** BASIC format, single-channel audio encoded using 8-bit u-law (or mu-law) data sampled at 8 KHz (value is "audio/basic"). */
  BASIC(HttpMediaType.AUDIO_BASIC);
  
  private String mediaType;

  /**
   * Instantiates a new audio format.
   *
   * @param mediaType the media type
   */
  AudioFormat(String mediaType) {
    this.mediaType = mediaType;
  }


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return mediaType;
  }
}
