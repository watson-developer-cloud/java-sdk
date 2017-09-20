/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ImageWithFaces.
 */
public class ImageWithFaces extends GenericModel {

  @SerializedName("source_url")
  private String sourceUrl;
  @SerializedName("resolved_url")
  private String resolvedUrl;
  private String image;
  private ErrorInfo error;
  private List<Face> faces;

  /**
   * Gets the sourceUrl.
   *
   * Source image URL. Omitted if the image was uploaded. This is the URL as given to the service, before any redirects.
   *
   * @return the sourceUrl
   */
  public String getSourceUrl() {
    return sourceUrl;
  }

  /**
   * Gets the resolvedUrl.
   *
   * Fully-resolved image URL. Omitted if the image was uploaded. Redirects are followed, for example with URL
   * shorteners.
   *
   * @return the resolvedUrl
   */
  public String getResolvedUrl() {
    return resolvedUrl;
  }

  /**
   * Gets the image.
   *
   * Relative path of the image file if uploaded directly (e.g., inside a zip file). Omitted if image was passed by URL.
   *
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the error.
   *
   * @return the error
   */
  public ErrorInfo getError() {
    return error;
  }

  /**
   * Gets the faces.
   *
   * @return the faces
   */
  public List<Face> getFaces() {
    return faces;
  }

  /**
   * Sets the sourceUrl.
   *
   * @param sourceUrl the new sourceUrl
   */
  public void setSourceUrl(final String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  /**
   * Sets the resolvedUrl.
   *
   * @param resolvedUrl the new resolvedUrl
   */
  public void setResolvedUrl(final String resolvedUrl) {
    this.resolvedUrl = resolvedUrl;
  }

  /**
   * Sets the image.
   *
   * @param image the new image
   */
  public void setImage(final String image) {
    this.image = image;
  }

  /**
   * Sets the error.
   *
   * @param error the new error
   */
  public void setError(final ErrorInfo error) {
    this.error = error;
  }

  /**
   * Sets the faces.
   *
   * @param faces the new faces
   */
  public void setFaces(final List<Face> faces) {
    this.faces = faces;
  }
}
