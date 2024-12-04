/*
 * (C) Copyright IBM Corp. 2024.
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

/** Detailed timing information about the service's processing of the input audio. */
public class ProcessedAudio extends GenericModel {

  protected Float received;

  @SerializedName("seen_by_engine")
  protected Float seenByEngine;

  protected Float transcription;

  @SerializedName("speaker_labels")
  protected Float speakerLabels;

  protected ProcessedAudio() {}

  /**
   * Gets the received.
   *
   * <p>The seconds of audio that the service has received as of this response. The value of the
   * field is greater than the values of the `transcription` and `speaker_labels` fields during
   * speech recognition processing, since the service first has to receive the audio before it can
   * begin to process it. The final value can also be greater than the value of the `transcription`
   * and `speaker_labels` fields by a fractional number of seconds.
   *
   * @return the received
   */
  public Float getReceived() {
    return received;
  }

  /**
   * Gets the seenByEngine.
   *
   * <p>The seconds of audio that the service has passed to its speech-processing engine as of this
   * response. The value of the field is greater than the values of the `transcription` and
   * `speaker_labels` fields during speech recognition processing. The `received` and
   * `seen_by_engine` fields have identical values when the service has finished processing all
   * audio. This final value can be greater than the value of the `transcription` and
   * `speaker_labels` fields by a fractional number of seconds.
   *
   * @return the seenByEngine
   */
  public Float getSeenByEngine() {
    return seenByEngine;
  }

  /**
   * Gets the transcription.
   *
   * <p>The seconds of audio that the service has processed for speech recognition as of this
   * response.
   *
   * @return the transcription
   */
  public Float getTranscription() {
    return transcription;
  }

  /**
   * Gets the speakerLabels.
   *
   * <p>If speaker labels are requested, the seconds of audio that the service has processed to
   * determine speaker labels as of this response. This value often trails the value of the
   * `transcription` field during speech recognition processing. The `transcription` and
   * `speaker_labels` fields have identical values when the service has finished processing all
   * audio.
   *
   * @return the speakerLabels
   */
  public Float getSpeakerLabels() {
    return speakerLabels;
  }
}
