/*
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * The utilities required for processing audio files using the {@link SpeechToText} service.
 *
 * @see SpeechToText
 */
public final class MediaTypeUtils {

  private static final Map<String, String> MEDIA_TYPES;

  static {
    MEDIA_TYPES = new HashMap<String, String>();

    MEDIA_TYPES.put(".wav", HttpMediaType.AUDIO_WAV);
    MEDIA_TYPES.put(".ogg", HttpMediaType.AUDIO_OGG);
    MEDIA_TYPES.put(".oga", HttpMediaType.AUDIO_OGG);
    MEDIA_TYPES.put(".flac", HttpMediaType.AUDIO_FLAC);
    MEDIA_TYPES.put(".raw", HttpMediaType.AUDIO_RAW);
    MEDIA_TYPES.put(".mp3", HttpMediaType.AUDIO_MP3);
    MEDIA_TYPES.put(".mpeg", HttpMediaType.AUDIO_MPEG);
    MEDIA_TYPES.put(".webm", HttpMediaType.AUDIO_WEBM);
  }

  private MediaTypeUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Returns the media type for a given file.
   *
   * @param file the file object for which media type needs to be provided
   * @return Internet media type for the file, or null if none found
   */
  public static String getMediaTypeFromFile(final File file) {
    if (file == null) {
      return null;
    }

    final String fileName = file.getName();
    final int i = fileName.lastIndexOf('.');

    if (i == -1) {
      return null;
    }

    return MEDIA_TYPES.get(fileName.substring(i).toLowerCase());
  }

  /**
   * Checks if the media type is supported by the service.
   *
   * @param mediaType Internet media type for the file
   * @return true if it is supported, false if not.
   */
  public static boolean isValidMediaType(final String mediaType) {
    return (mediaType != null) && MEDIA_TYPES.values().contains(mediaType.toLowerCase());
  }

}
