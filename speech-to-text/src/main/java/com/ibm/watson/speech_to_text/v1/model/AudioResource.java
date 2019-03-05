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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AudioResource.
 */
public class AudioResource extends GenericModel {

  /**
   * The status of the audio resource:
   * * `ok`: The service successfully analyzed the audio data. The data can be used to train the custom model.
   * * `being_processed`: The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete.
   * * `invalid`: The audio data is not valid for training the custom model (possibly because it has the wrong format or
   * sampling rate, or because it is corrupted). For an archive file, the entire archive is invalid if any of its audio
   * files are invalid.
   */
  public interface Status {
    /** ok. */
    String OK = "ok";
    /** being_processed. */
    String BEING_PROCESSED = "being_processed";
    /** invalid. */
    String INVALID = "invalid";
  }

  private Double duration;
  private String name;
  private AudioDetails details;
  private String status;

  /**
   * Gets the duration.
   *
   * The total seconds of audio in the audio resource. The value is always a whole number.
   *
   * @return the duration
   */
  public Double getDuration() {
    return duration;
  }

  /**
   * Gets the name.
   *
   * **For an archive-type resource,** the user-specified name of the resource.
   *
   * **For an audio-type resource,** the user-specified name of the resource or the name of the audio file that the user
   * added for the resource. The value depends on the method that is called.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the details.
   *
   * An `AudioDetails` object that provides detailed information about the audio resource. The object is empty until the
   * service finishes processing the audio.
   *
   * @return the details
   */
  public AudioDetails getDetails() {
    return details;
  }

  /**
   * Gets the status.
   *
   * The status of the audio resource:
   * * `ok`: The service successfully analyzed the audio data. The data can be used to train the custom model.
   * * `being_processed`: The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete.
   * * `invalid`: The audio data is not valid for training the custom model (possibly because it has the wrong format or
   * sampling rate, or because it is corrupted). For an archive file, the entire archive is invalid if any of its audio
   * files are invalid.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}
