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

/**
 * If enriched results are requested, transcription with inserted punctuation marks such as periods,
 * commas, question marks, and exclamation points.
 */
public class EnrichedResultsTranscript extends GenericModel {

  protected String text;
  protected EnrichedResultsTranscriptTimestamp timestamp;

  protected EnrichedResultsTranscript() {}

  /**
   * Gets the text.
   *
   * <p>The transcript text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the timestamp.
   *
   * <p>The speaking time from the beginning of the transcript to the end.
   *
   * @return the timestamp
   */
  public EnrichedResultsTranscriptTimestamp getTimestamp() {
    return timestamp;
  }
}
