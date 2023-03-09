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
import java.util.List;

/** The complete results for a speech recognition request. */
public class SpeechRecognitionResults extends GenericModel {

  protected List<SpeechRecognitionResult> results;

  @SerializedName("result_index")
  protected Long resultIndex;

  @SerializedName("speaker_labels")
  protected List<SpeakerLabelsResult> speakerLabels;

  @SerializedName("processing_metrics")
  protected ProcessingMetrics processingMetrics;

  @SerializedName("audio_metrics")
  protected AudioMetrics audioMetrics;

  protected List<String> warnings;

  protected SpeechRecognitionResults() {}

  /**
   * Gets the results.
   *
   * <p>An array of `SpeechRecognitionResult` objects that can include interim and final results
   * (interim results are returned only if supported by the method). Final results are guaranteed
   * not to change; interim results might be replaced by further interim results and eventually
   * final results.
   *
   * <p>For the HTTP interfaces, all results arrive at the same time. For the WebSocket interface,
   * results can be sent as multiple separate responses. The service periodically sends updates to
   * the results list. The `result_index` is incremented to the lowest index in the array that has
   * changed for new results.
   *
   * <p>For more information, see [Understanding speech recognition
   * results](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-basic-response).
   *
   * @return the results
   */
  public List<SpeechRecognitionResult> getResults() {
    return results;
  }

  /**
   * Gets the resultIndex.
   *
   * <p>An index that indicates a change point in the `results` array. The service increments the
   * index for additional results that it sends for new audio for the same request. All results with
   * the same index are delivered at the same time. The same index can include multiple final
   * results that are delivered with the same response.
   *
   * @return the resultIndex
   */
  public Long getResultIndex() {
    return resultIndex;
  }

  /**
   * Gets the speakerLabels.
   *
   * <p>An array of `SpeakerLabelsResult` objects that identifies which words were spoken by which
   * speakers in a multi-person exchange. The array is returned only if the `speaker_labels`
   * parameter is `true`. When interim results are also requested for methods that support them, it
   * is possible for a `SpeechRecognitionResults` object to include only the `speaker_labels` field.
   *
   * @return the speakerLabels
   */
  public List<SpeakerLabelsResult> getSpeakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the processingMetrics.
   *
   * <p>If processing metrics are requested, information about the service's processing of the input
   * audio. Processing metrics are not available with the synchronous [Recognize audio](#recognize)
   * method.
   *
   * @return the processingMetrics
   */
  public ProcessingMetrics getProcessingMetrics() {
    return processingMetrics;
  }

  /**
   * Gets the audioMetrics.
   *
   * <p>If audio metrics are requested, information about the signal characteristics of the input
   * audio.
   *
   * @return the audioMetrics
   */
  public AudioMetrics getAudioMetrics() {
    return audioMetrics;
  }

  /**
   * Gets the warnings.
   *
   * <p>An array of warning messages associated with the request: * Warnings for invalid parameters
   * or fields can include a descriptive message and a list of invalid argument strings, for
   * example, `"Unknown arguments:"` or `"Unknown url query arguments:"` followed by a list of the
   * form `"{invalid_arg_1}, {invalid_arg_2}."` (If you use the `character_insertion_bias` parameter
   * with a previous-generation model, the warning message refers to the parameter as `lambdaBias`.)
   * * The following warning is returned if the request passes a custom model that is based on an
   * older version of a base model for which an updated version is available: `"Using previous
   * version of base model, because your custom model has been built with it. Please note that this
   * version will be supported only for a limited time. Consider updating your custom model to the
   * new base model. If you do not do that you will be automatically switched to base model when you
   * used the non-updated custom model."`
   *
   * <p>In both cases, the request succeeds despite the warnings.
   *
   * @return the warnings
   */
  public List<String> getWarnings() {
    return warnings;
  }
}
