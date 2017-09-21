/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;

/**
 * Audio format supported by the {@link TextToSpeech} service.
 */
public class AudioFormat {

  /** FLAC format (value is "audio/flac"). */
  public static final AudioFormat FLAC = new AudioFormat(HttpMediaType.AUDIO_FLAC);

  /** OGG format (value is "audio/ogg; codecs=opus"). */
  public static final AudioFormat OGG = new AudioFormat(HttpMediaType.AUDIO_OGG);

  /** OGG_VORBIS format (value is "audio/ogg; codecs=vorbis"). */
  public static final AudioFormat OGG_VORBIS = new AudioFormat(HttpMediaType.AUDIO_OGG_VORBIS);

  /** WAV format (value is "audio/wav"). */
  public static final AudioFormat WAV = new AudioFormat(HttpMediaType.AUDIO_WAV);

  /** WEBM format (value is "audio/webm"). */
  public static final AudioFormat WEBM = new AudioFormat(HttpMediaType.AUDIO_WEBM);

  /** WEBM format (value is "audio/webm; codecs=vorbis"). */
  public static final AudioFormat WEBM_VORBIS = new AudioFormat(HttpMediaType.AUDIO_WEBM_VORBIS);

  /** WEBM format (value is "audio/webm; codecs=opus"). */
  public static final AudioFormat WEBM_OPUS = new AudioFormat(HttpMediaType.AUDIO_WEBM_OPUS);

  /**
   * BASIC format, single-channel audio encoded using 8-bit u-law (or mu-law) data sampled at 8 KHz (value is
   * "audio/basic").
   */
  public static final AudioFormat BASIC = new AudioFormat(HttpMediaType.AUDIO_BASIC);

  /**
   * Linear 16-bit Pulse-Code Modulation (PCM) format (value is "audio/l16").
   *
   * @param rate The sampling rate, in Hz.
   * @return AudioFormat  returns a new audio format with the given audio rate.g
   */
  public static AudioFormat getPCM(int rate) {
      return new AudioFormat(HttpMediaType.createAudioRaw(rate));
  }

  private String mediaType;

  /**
   * Instantiates a new audio format.
   *
   * @param mediaType the media type
   */
  public AudioFormat(String mediaType) {
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
