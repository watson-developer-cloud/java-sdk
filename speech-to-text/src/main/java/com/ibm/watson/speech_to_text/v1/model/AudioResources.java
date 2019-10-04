/*
 * (C) Copyright IBM Corp. 2019.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the audio resources from a custom acoustic model.
 */
public class AudioResources extends GenericModel {

  @SerializedName("total_minutes_of_audio")
  private Double totalMinutesOfAudio;
  private List<AudioResource> audio;

  /**
   * Gets the totalMinutesOfAudio.
   *
   * The total minutes of accumulated audio summed over all of the valid audio resources for the custom acoustic model.
   * You can use this value to determine whether the custom model has too little or too much audio to begin training.
   *
   * @return the totalMinutesOfAudio
   */
  public Double getTotalMinutesOfAudio() {
    return totalMinutesOfAudio;
  }

  /**
   * Gets the audio.
   *
   * An array of `AudioResource` objects that provides information about the audio resources of the custom acoustic
   * model. The array is empty if the custom model has no audio resources.
   *
   * @return the audio
   */
  public List<AudioResource> getAudio() {
    return audio;
  }
}
