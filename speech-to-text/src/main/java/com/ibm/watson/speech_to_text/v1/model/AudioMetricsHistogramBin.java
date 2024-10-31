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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A bin with defined boundaries that indicates the number of values in a range of signal
 * characteristics for a histogram. The first and last bins of a histogram are the boundary bins.
 * They cover the intervals between negative infinity and the first boundary, and between the last
 * boundary and positive infinity, respectively.
 */
public class AudioMetricsHistogramBin extends GenericModel {

  protected Float begin;
  protected Float end;
  protected Long count;

  protected AudioMetricsHistogramBin() {}

  /**
   * Gets the begin.
   *
   * <p>The lower boundary of the bin in the histogram.
   *
   * @return the begin
   */
  public Float getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * <p>The upper boundary of the bin in the histogram.
   *
   * @return the end
   */
  public Float getEnd() {
    return end;
  }

  /**
   * Gets the count.
   *
   * <p>The number of values in the bin of the histogram.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}
