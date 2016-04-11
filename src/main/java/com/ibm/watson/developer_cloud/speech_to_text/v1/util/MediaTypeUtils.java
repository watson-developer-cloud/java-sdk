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
package com.ibm.watson.developer_cloud.speech_to_text.v1.util;

import java.io.File;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * The utilities required for processing audio files using the {@link SpeechToText} service.
 * 
 * @see SpeechToText
 */
public class MediaTypeUtils {
  private static String[] SUPPORTED_EXTENSION = {".wav", ".ogg", ".oga", ".flac", ".raw"};

  private static String[] SUPPORTED_MEDIA_TYPES = {HttpMediaType.AUDIO_WAV, HttpMediaType.AUDIO_OGG,
      HttpMediaType.AUDIO_OGG, HttpMediaType.AUDIO_FLAC, HttpMediaType.AUDIO_RAW};

  /**
   * Returns the media type for a given file.
   * 
   * @param file the file object for which media type needs to be provided
   * @return Internet media type for the file
   */
  public static String getMediaTypeFromFile(final File file) {
    if (file != null) {
      final String fileName = file.getName().toLowerCase();
      for (int i = 0; i < SUPPORTED_MEDIA_TYPES.length; i++) {
        if (fileName.endsWith(SUPPORTED_EXTENSION[i])) {
          return SUPPORTED_MEDIA_TYPES[i];
        }
      }
    }
    return null;
  }

  /**
   * Checks if the media type is supported by the service.
   * 
   * @param mediaType Internet media type for the file
   * @return true if it is supported, false if not.
   */
  public static Boolean isValidMediaType(final String mediaType) {
    if (mediaType != null) {
      for (final String supportedMediaType : SUPPORTED_MEDIA_TYPES) {
        if (mediaType.equalsIgnoreCase(supportedMediaType)) {
          return true;
        }
      }
    }
    return false;
  }

}
