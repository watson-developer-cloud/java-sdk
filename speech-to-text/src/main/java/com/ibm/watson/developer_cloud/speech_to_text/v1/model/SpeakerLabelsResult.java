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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeakerLabelsResult.
 */
public class SpeakerLabelsResult extends GenericModel {

  private Float from;
  private Float to;
  private Long speaker;
  private Float confidence;
  @SerializedName("final")
  private Boolean xfinal;

  /**
   * Gets the from.
   *
   * The start time of a word from the transcript. The value matches the start time of a word from the `timestamps`
   * array.
   *
   * @return the from
   */
  public Float getFrom() {
    return from;
  }

  /**
   * Gets the to.
   *
   * The end time of a word from the transcript. The value matches the end time of a word from the `timestamps` array.
   *
   * @return the to
   */
  public Float getTo() {
    return to;
  }

  /**
   * Gets the speaker.
   *
   * The numeric identifier that the service assigns to a speaker from the audio. Speaker IDs begin at `0` initially but
   * can evolve and change across interim results (if supported by the method) and between interim and final results as
   * the service processes the audio. They are not guaranteed to be sequential, contiguous, or ordered.
   *
   * @return the speaker
   */
  public Long getSpeaker() {
    return speaker;
  }

  /**
   * Gets the confidence.
   *
   * A score that indicates the service's confidence in its identification of the speaker in the range of 0 to 1.
   *
   * @return the confidence
   */
  public Float getConfidence() {
    return confidence;
  }

  /**
   * Gets the xfinal.
   *
   * An indication of whether the service might further change word and speaker-label results. A value of `true` means
   * that the service guarantees not to send any further updates for the current or any preceding results; `false` means
   * that the service might send further updates to the results.
   *
   * @return the xfinal
   */
  public Boolean isFinal() {
    return xfinal;
  }

  /**
   * Sets the from.
   *
   * @param from the new from
   */
  public void setFrom(final Float from) {
    this.from = from;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(final Float to) {
    this.to = to;
  }

  /**
   * Sets the speaker.
   *
   * @param speaker the new speaker
   */
  public void setSpeaker(final long speaker) {
    this.speaker = speaker;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Float confidence) {
    this.confidence = confidence;
  }

  /**
   * Sets the xfinal.
   *
   * @param xfinal the new xfinal
   */
  public void setFinal(final Boolean xfinal) {
    this.xfinal = xfinal;
  }
}
