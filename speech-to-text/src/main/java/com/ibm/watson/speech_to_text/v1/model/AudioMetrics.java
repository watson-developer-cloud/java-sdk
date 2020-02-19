/*
 * (C) Copyright IBM Corp. 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * If audio metrics are requested, information about the signal characteristics of the input audio.
 */
public class AudioMetrics extends GenericModel {

  @SerializedName("sampling_interval")
  protected Float samplingInterval;
  protected AudioMetricsDetails accumulated;

  /**
   * Gets the samplingInterval.
   *
   * The interval in seconds (typically 0.1 seconds) at which the service calculated the audio metrics. In other words,
   * how often the service calculated the metrics. A single unit in each histogram (see the `AudioMetricsHistogramBin`
   * object) is calculated based on a `sampling_interval` length of audio.
   *
   * @return the samplingInterval
   */
  public Float getSamplingInterval() {
    return samplingInterval;
  }

  /**
   * Gets the accumulated.
   *
   * Detailed information about the signal characteristics of the input audio.
   *
   * @return the accumulated
   */
  public AudioMetricsDetails getAccumulated() {
    return accumulated;
  }
}

