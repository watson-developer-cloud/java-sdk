/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

/** Information about the speakers from speech recognition results. */
public class SpeakerLabelsResult extends GenericModel {

  protected Float from;
  protected Float to;
  protected Long speaker;
  protected Float confidence;

  @SerializedName("final")
  protected Boolean xFinal;

  protected SpeakerLabelsResult() {}

  /**
   * Gets the from.
   *
   * <p>The start time of a word from the transcript. The value matches the start time of a word
   * from the `timestamps` array.
   *
   * @return the from
   */
  public Float getFrom() {
    return from;
  }

  /**
   * Gets the to.
   *
   * <p>The end time of a word from the transcript. The value matches the end time of a word from
   * the `timestamps` array.
   *
   * @return the to
   */
  public Float getTo() {
    return to;
  }

  /**
   * Gets the speaker.
   *
   * <p>The numeric identifier that the service assigns to a speaker from the audio. Speaker IDs
   * begin at `0` initially but can evolve and change across interim results (if supported by the
   * method) and between interim and final results as the service processes the audio. They are not
   * guaranteed to be sequential, contiguous, or ordered.
   *
   * @return the speaker
   */
  public Long getSpeaker() {
    return speaker;
  }

  /**
   * Gets the confidence.
   *
   * <p>A score that indicates the service's confidence in its identification of the speaker in the
   * range of 0.0 to 1.0.
   *
   * @return the confidence
   */
  public Float getConfidence() {
    return confidence;
  }

  /**
   * Gets the xFinal.
   *
   * <p>An indication of whether the service might further change word and speaker-label results. A
   * value of `true` means that the service guarantees not to send any further updates for the
   * current or any preceding results; `false` means that the service might send further updates to
   * the results.
   *
   * @return the xFinal
   */
  public Boolean isXFinal() {
    return xFinal;
  }
}
