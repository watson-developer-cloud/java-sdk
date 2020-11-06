/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Results for all images. */
public class ClassifiedImages extends GenericModel {

  @SerializedName("custom_classes")
  protected Long customClasses;

  @SerializedName("images_processed")
  protected Long imagesProcessed;

  protected List<ClassifiedImage> images;
  protected List<WarningInfo> warnings;

  /**
   * Gets the customClasses.
   *
   * <p>Number of custom classes identified in the images.
   *
   * @return the customClasses
   */
  public Long getCustomClasses() {
    return customClasses;
  }

  /**
   * Gets the imagesProcessed.
   *
   * <p>Number of images processed for the API call.
   *
   * @return the imagesProcessed
   */
  public Long getImagesProcessed() {
    return imagesProcessed;
  }

  /**
   * Gets the images.
   *
   * <p>Classified images.
   *
   * @return the images
   */
  public List<ClassifiedImage> getImages() {
    return images;
  }

  /**
   * Gets the warnings.
   *
   * <p>Information about what might cause less than optimal output. For example, a request sent
   * with a corrupt .zip file and a list of image URLs will still complete, but does not return the
   * expected output. Not returned when there is no warning.
   *
   * @return the warnings
   */
  public List<WarningInfo> getWarnings() {
    return warnings;
  }
}
