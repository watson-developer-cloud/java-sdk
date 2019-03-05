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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AudioListing.
 */
public class AudioListing extends GenericModel {

  /**
   * **For an audio-type resource,** the status of the resource:
   * * `ok`: The service successfully analyzed the audio data. The data can be used to train the custom model.
   * * `being_processed`: The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete.
   * * `invalid`: The audio data is not valid for training the custom model (possibly because it has the wrong format or
   * sampling rate, or because it is corrupted).
   *
   * Omitted for an archive-type resource.
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
  private AudioResource container;
  private List<AudioResource> audio;

  /**
   * Gets the duration.
   *
   * **For an audio-type resource,** the total seconds of audio in the resource. The value is always a whole number.
   * Omitted for an archive-type resource.
   *
   * @return the duration
   */
  public Double getDuration() {
    return duration;
  }

  /**
   * Gets the name.
   *
   * **For an audio-type resource,** the user-specified name of the resource. Omitted for an archive-type resource.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the details.
   *
   * **For an audio-type resource,** an `AudioDetails` object that provides detailed information about the resource. The
   * object is empty until the service finishes processing the audio. Omitted for an archive-type resource.
   *
   * @return the details
   */
  public AudioDetails getDetails() {
    return details;
  }

  /**
   * Gets the status.
   *
   * **For an audio-type resource,** the status of the resource:
   * * `ok`: The service successfully analyzed the audio data. The data can be used to train the custom model.
   * * `being_processed`: The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete.
   * * `invalid`: The audio data is not valid for training the custom model (possibly because it has the wrong format or
   * sampling rate, or because it is corrupted).
   *
   * Omitted for an archive-type resource.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the container.
   *
   * **For an archive-type resource,** an object of type `AudioResource` that provides information about the resource.
   * Omitted for an audio-type resource.
   *
   * @return the container
   */
  public AudioResource getContainer() {
    return container;
  }

  /**
   * Gets the audio.
   *
   * **For an archive-type resource,** an array of `AudioResource` objects that provides information about the
   * audio-type resources that are contained in the resource. Omitted for an audio-type resource.
   *
   * @return the audio
   */
  public List<AudioResource> getAudio() {
    return audio;
  }
}
