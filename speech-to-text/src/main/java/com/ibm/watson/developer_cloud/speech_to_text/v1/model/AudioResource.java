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
 * AudioResource.
 */
public class AudioResource extends GenericModel {

  /**
   * The status of the audio resource: * `ok` indicates that the service has successfully analyzed the audio data. The
   * data can be used to train the custom model. * `being_processed` indicates that the service is still analyzing the
   * audio data. The service cannot accept requests to add new audio resources or to train the custom model until its
   * analysis is complete. * `invalid` indicates that the audio data is not valid for training the custom model
   * (possibly because it has the wrong format or sampling rate, or because it is corrupted). For an archive file, the
   * entire archive is invalid if any of its audio files are invalid.
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
   * The total seconds of audio in the audio resource.
   *
   * @return the duration
   */
  public Double getDuration() {
    return duration;
  }

  /**
   * Gets the name.
   *
   * The name of the audio resource.
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
   * The status of the audio resource: * `ok` indicates that the service has successfully analyzed the audio data. The
   * data can be used to train the custom model. * `being_processed` indicates that the service is still analyzing the
   * audio data. The service cannot accept requests to add new audio resources or to train the custom model until its
   * analysis is complete. * `invalid` indicates that the audio data is not valid for training the custom model
   * (possibly because it has the wrong format or sampling rate, or because it is corrupted). For an archive file, the
   * entire archive is invalid if any of its audio files are invalid.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the duration.
   *
   * @param duration the new duration
   */
  public void setDuration(final Double duration) {
    this.duration = duration;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the details.
   *
   * @param details the new details
   */
  public void setDetails(final AudioDetails details) {
    this.details = details;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }
}
