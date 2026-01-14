/*
 * (C) Copyright IBM Corp. 2026.
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

/** The speaking time from the beginning of the transcript to the end. */
public class EnrichedResultsTranscriptTimestamp extends GenericModel {

  protected Float from;
  protected Float to;

  protected EnrichedResultsTranscriptTimestamp() {}

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
}
