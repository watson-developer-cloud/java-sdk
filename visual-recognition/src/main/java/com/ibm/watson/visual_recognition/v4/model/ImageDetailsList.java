/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * List of information about the images.
 */
public class ImageDetailsList extends GenericModel {

  private List<ImageDetails> images;
  private List<Warning> warnings;
  private String trace;

  /**
   * Gets the images.
   *
   * The images in the collection.
   *
   * @return the images
   */
  public List<ImageDetails> getImages() {
    return images;
  }

  /**
   * Gets the warnings.
   *
   * Information about what might cause less than optimal output.
   *
   * @return the warnings
   */
  public List<Warning> getWarnings() {
    return warnings;
  }

  /**
   * Gets the trace.
   *
   * A unique identifier of the request. Included only when an error or warning is returned.
   *
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }
}
