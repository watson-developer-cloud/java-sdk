/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.List;

/** Information about an audio resource from a custom acoustic model. */
public class AudioListing extends GenericModel {

  /**
   * _For an audio-type resource_, the status of the resource: * `ok`: The service successfully
   * analyzed the audio data. The data can be used to train the custom model. * `being_processed`:
   * The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete. * `invalid`: The
   * audio data is not valid for training the custom model (possibly because it has the wrong format
   * or sampling rate, or because it is corrupted).
   *
   * <p>Omitted for an archive-type resource.
   */
  public interface Status {
    /** ok. */
    String OK = "ok";
    /** being_processed. */
    String BEING_PROCESSED = "being_processed";
    /** invalid. */
    String INVALID = "invalid";
  }

  protected Long duration;
  protected String name;
  protected AudioDetails details;
  protected String status;
  protected AudioResource container;
  protected List<AudioResource> audio;

  protected AudioListing() {}

  /**
   * Gets the duration.
   *
   * <p>_For an audio-type resource_, the total seconds of audio in the resource. Omitted for an
   * archive-type resource.
   *
   * @return the duration
   */
  public Long getDuration() {
    return duration;
  }

  /**
   * Gets the name.
   *
   * <p>_For an audio-type resource_, the user-specified name of the resource. Omitted for an
   * archive-type resource.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the details.
   *
   * <p>_For an audio-type resource_, an `AudioDetails` object that provides detailed information
   * about the resource. The object is empty until the service finishes processing the audio.
   * Omitted for an archive-type resource.
   *
   * @return the details
   */
  public AudioDetails getDetails() {
    return details;
  }

  /**
   * Gets the status.
   *
   * <p>_For an audio-type resource_, the status of the resource: * `ok`: The service successfully
   * analyzed the audio data. The data can be used to train the custom model. * `being_processed`:
   * The service is still analyzing the audio data. The service cannot accept requests to add new
   * audio resources or to train the custom model until its analysis is complete. * `invalid`: The
   * audio data is not valid for training the custom model (possibly because it has the wrong format
   * or sampling rate, or because it is corrupted).
   *
   * <p>Omitted for an archive-type resource.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the container.
   *
   * <p>_For an archive-type resource_, an object of type `AudioResource` that provides information
   * about the resource. Omitted for an audio-type resource.
   *
   * @return the container
   */
  public AudioResource getContainer() {
    return container;
  }

  /**
   * Gets the audio.
   *
   * <p>_For an archive-type resource_, an array of `AudioResource` objects that provides
   * information about the audio-type resources that are contained in the resource. Omitted for an
   * audio-type resource.
   *
   * @return the audio
   */
  public List<AudioResource> getAudio() {
    return audio;
  }
}
