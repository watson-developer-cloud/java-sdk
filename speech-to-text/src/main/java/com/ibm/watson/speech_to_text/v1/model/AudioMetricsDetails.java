/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
 * Detailed information about the signal characteristics of the input audio.
 */
public class AudioMetricsDetails extends GenericModel {

  @SerializedName("final")
  protected Boolean xFinal;
  @SerializedName("end_time")
  protected Float endTime;
  @SerializedName("signal_to_noise_ratio")
  protected Float signalToNoiseRatio;
  @SerializedName("speech_ratio")
  protected Float speechRatio;
  @SerializedName("high_frequency_loss")
  protected Float highFrequencyLoss;
  @SerializedName("direct_current_offset")
  protected List<AudioMetricsHistogramBin> directCurrentOffset;
  @SerializedName("clipping_rate")
  protected List<AudioMetricsHistogramBin> clippingRate;
  @SerializedName("speech_level")
  protected List<AudioMetricsHistogramBin> speechLevel;
  @SerializedName("non_speech_level")
  protected List<AudioMetricsHistogramBin> nonSpeechLevel;

  /**
   * Gets the xFinal.
   *
   * If `true`, indicates the end of the audio stream, meaning that transcription is complete. Currently, the field is
   * always `true`. The service returns metrics just once per audio stream. The results provide aggregated audio metrics
   * that pertain to the complete audio stream.
   *
   * @return the xFinal
   */
  public Boolean isXFinal() {
    return xFinal;
  }

  /**
   * Gets the endTime.
   *
   * The end time in seconds of the block of audio to which the metrics apply.
   *
   * @return the endTime
   */
  public Float getEndTime() {
    return endTime;
  }

  /**
   * Gets the signalToNoiseRatio.
   *
   * The signal-to-noise ratio (SNR) for the audio signal. The value indicates the ratio of speech to noise in the
   * audio. A valid value lies in the range of 0 to 100 decibels (dB). The service omits the field if it cannot compute
   * the SNR for the audio.
   *
   * @return the signalToNoiseRatio
   */
  public Float getSignalToNoiseRatio() {
    return signalToNoiseRatio;
  }

  /**
   * Gets the speechRatio.
   *
   * The ratio of speech to non-speech segments in the audio signal. The value lies in the range of 0.0 to 1.0.
   *
   * @return the speechRatio
   */
  public Float getSpeechRatio() {
    return speechRatio;
  }

  /**
   * Gets the highFrequencyLoss.
   *
   * The probability that the audio signal is missing the upper half of its frequency content.
   * * A value close to 1.0 typically indicates artificially up-sampled audio, which negatively impacts the accuracy of
   * the transcription results.
   * * A value at or near 0.0 indicates that the audio signal is good and has a full spectrum.
   * * A value around 0.5 means that detection of the frequency content is unreliable or not available.
   *
   * @return the highFrequencyLoss
   */
  public Float getHighFrequencyLoss() {
    return highFrequencyLoss;
  }

  /**
   * Gets the directCurrentOffset.
   *
   * An array of `AudioMetricsHistogramBin` objects that defines a histogram of the cumulative direct current (DC)
   * component of the audio signal.
   *
   * @return the directCurrentOffset
   */
  public List<AudioMetricsHistogramBin> getDirectCurrentOffset() {
    return directCurrentOffset;
  }

  /**
   * Gets the clippingRate.
   *
   * An array of `AudioMetricsHistogramBin` objects that defines a histogram of the clipping rate for the audio
   * segments. The clipping rate is defined as the fraction of samples in the segment that reach the maximum or minimum
   * value that is offered by the audio quantization range. The service auto-detects either a 16-bit Pulse-Code
   * Modulation(PCM) audio range (-32768 to +32767) or a unit range (-1.0 to +1.0). The clipping rate is between 0.0 and
   * 1.0, with higher values indicating possible degradation of speech recognition.
   *
   * @return the clippingRate
   */
  public List<AudioMetricsHistogramBin> getClippingRate() {
    return clippingRate;
  }

  /**
   * Gets the speechLevel.
   *
   * An array of `AudioMetricsHistogramBin` objects that defines a histogram of the signal level in segments of the
   * audio that contain speech. The signal level is computed as the Root-Mean-Square (RMS) value in a decibel (dB) scale
   * normalized to the range 0.0 (minimum level) to 1.0 (maximum level).
   *
   * @return the speechLevel
   */
  public List<AudioMetricsHistogramBin> getSpeechLevel() {
    return speechLevel;
  }

  /**
   * Gets the nonSpeechLevel.
   *
   * An array of `AudioMetricsHistogramBin` objects that defines a histogram of the signal level in segments of the
   * audio that do not contain speech. The signal level is computed as the Root-Mean-Square (RMS) value in a decibel
   * (dB) scale normalized to the range 0.0 (minimum level) to 1.0 (maximum level).
   *
   * @return the nonSpeechLevel
   */
  public List<AudioMetricsHistogramBin> getNonSpeechLevel() {
    return nonSpeechLevel;
  }
}
