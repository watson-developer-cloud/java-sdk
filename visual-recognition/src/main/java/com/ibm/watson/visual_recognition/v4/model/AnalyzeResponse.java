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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Results for all images. */
public class AnalyzeResponse extends GenericModel {

  protected List<Image> images;
  protected List<Warning> warnings;
  protected String trace;

  /**
   * Gets the images.
   *
   * <p>Analyzed images.
   *
   * @return the images
   */
  public List<Image> getImages() {
    return images;
  }

  /**
   * Gets the warnings.
   *
   * <p>Information about what might cause less than optimal output.
   *
   * @return the warnings
   */
  public List<Warning> getWarnings() {
    return warnings;
  }

  /**
   * Gets the trace.
   *
   * <p>A unique identifier of the request. Included only when an error or warning is returned.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }
}
