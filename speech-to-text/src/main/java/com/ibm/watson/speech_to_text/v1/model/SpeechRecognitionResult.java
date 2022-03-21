/*
 * (C) Copyright IBM Corp. 2018, 2022.
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
import java.util.List;
import java.util.Map;

/** Component results for a speech recognition request. */
public class SpeechRecognitionResult extends GenericModel {

  /**
   * If the `split_transcript_at_phrase_end` parameter is `true`, describes the reason for the
   * split: * `end_of_data` - The end of the input audio stream. * `full_stop` - A full semantic
   * stop, such as for the conclusion of a grammatical sentence. The insertion of splits is
   * influenced by the base language model and biased by custom language models and grammars. *
   * `reset` - The amount of audio that is currently being processed exceeds the two-minute maximum.
   * The service splits the transcript to avoid excessive memory use. * `silence` - A pause or
   * silence that is at least as long as the pause interval.
   */
  public interface EndOfUtterance {
    /** end_of_data. */
    String END_OF_DATA = "end_of_data";
    /** full_stop. */
    String FULL_STOP = "full_stop";
    /** reset. */
    String RESET = "reset";
    /** silence. */
    String SILENCE = "silence";
  }

  @SerializedName("final")
  protected Boolean xFinal;

  protected List<SpeechRecognitionAlternative> alternatives;

  @SerializedName("keywords_result")
  protected Map<String, List<KeywordResult>> keywordsResult;

  @SerializedName("word_alternatives")
  protected List<WordAlternativeResults> wordAlternatives;

  @SerializedName("end_of_utterance")
  protected String endOfUtterance;

  /**
   * Gets the xFinal.
   *
   * <p>An indication of whether the transcription results are final: * If `true`, the results for
   * this utterance are final. They are guaranteed not to be updated further. * If `false`, the
   * results are interim. They can be updated with further interim results until final results are
   * eventually sent.
   *
   * <p>**Note:** Because `final` is a reserved word in Java and Swift, the field is renamed
   * `xFinal` in Java and is escaped with back quotes in Swift.
   *
   * @return the xFinal
   */
  public Boolean isXFinal() {
    return xFinal;
  }

  /**
   * Gets the alternatives.
   *
   * <p>An array of alternative transcripts. The `alternatives` array can include additional
   * requested output such as word confidence or timestamps.
   *
   * @return the alternatives
   */
  public List<SpeechRecognitionAlternative> getAlternatives() {
    return alternatives;
  }

  /**
   * Gets the keywordsResult.
   *
   * <p>A dictionary (or associative array) whose keys are the strings specified for `keywords` if
   * both that parameter and `keywords_threshold` are specified. The value for each key is an array
   * of matches spotted in the audio for that keyword. Each match is described by a `KeywordResult`
   * object. A keyword for which no matches are found is omitted from the dictionary. The dictionary
   * is omitted entirely if no matches are found for any keywords.
   *
   * @return the keywordsResult
   */
  public Map<String, List<KeywordResult>> getKeywordsResult() {
    return keywordsResult;
  }

  /**
   * Gets the wordAlternatives.
   *
   * <p>An array of alternative hypotheses found for words of the input audio if a
   * `word_alternatives_threshold` is specified.
   *
   * @return the wordAlternatives
   */
  public List<WordAlternativeResults> getWordAlternatives() {
    return wordAlternatives;
  }

  /**
   * Gets the endOfUtterance.
   *
   * <p>If the `split_transcript_at_phrase_end` parameter is `true`, describes the reason for the
   * split: * `end_of_data` - The end of the input audio stream. * `full_stop` - A full semantic
   * stop, such as for the conclusion of a grammatical sentence. The insertion of splits is
   * influenced by the base language model and biased by custom language models and grammars. *
   * `reset` - The amount of audio that is currently being processed exceeds the two-minute maximum.
   * The service splits the transcript to avoid excessive memory use. * `silence` - A pause or
   * silence that is at least as long as the pause interval.
   *
   * @return the endOfUtterance
   */
  public String getEndOfUtterance() {
    return endOfUtterance;
  }
}
