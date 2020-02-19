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
package com.ibm.watson.visual_recognition.v4.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Basic information about an image.
 */
public class ImageSummary extends GenericModel {

  @SerializedName("image_id")
  protected String imageId;
  protected Date updated;

  /**
   * Gets the imageId.
   *
   * The identifier of the image.
   *
   * @return the imageId
   */
  public String getImageId() {
    return imageId;
  }

  /**
   * Gets the updated.
   *
   * Date and time in Coordinated Universal Time (UTC) that the image was most recently updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}

