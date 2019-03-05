/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about faces in the image.
 */
public class ImageWithFaces extends GenericModel {

  private List<Face> faces;
  private String image;
  @SerializedName("source_url")
  private String sourceUrl;
  @SerializedName("resolved_url")
  private String resolvedUrl;
  private ErrorInfo error;

  /**
   * Gets the faces.
   *
   * Faces detected in the images.
   *
   * @return the faces
   */
  public List<Face> getFaces() {
    return faces;
  }

  /**
   * Gets the image.
   *
   * Relative path of the image file if uploaded directly. Not returned when the image is passed by URL.
   *
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the sourceUrl.
   *
   * Source of the image before any redirects. Not returned when the image is uploaded.
   *
   * @return the sourceUrl
   */
  public String getSourceUrl() {
    return sourceUrl;
  }

  /**
   * Gets the resolvedUrl.
   *
   * Fully resolved URL of the image after redirects are followed. Not returned when the image is uploaded.
   *
   * @return the resolvedUrl
   */
  public String getResolvedUrl() {
    return resolvedUrl;
  }

  /**
   * Gets the error.
   *
   * Information about what might have caused a failure, such as an image that is too large. Not returned when there is
   * no error.
   *
   * @return the error
   */
  public ErrorInfo getError() {
    return error;
  }
}
