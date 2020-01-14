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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The source type of the image.
 */
public class ImageSource extends GenericModel {

  /**
   * The source type of the image.
   */
  public interface Type {
    /** file. */
    String FILE = "file";
    /** url. */
    String URL = "url";
  }

  protected String type;
  protected String filename;
  @SerializedName("archive_filename")
  protected String archiveFilename;
  @SerializedName("source_url")
  protected String sourceUrl;
  @SerializedName("resolved_url")
  protected String resolvedUrl;

  /**
   * Gets the type.
   *
   * The source type of the image.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the filename.
   *
   * Name of the image file if uploaded. Not returned when the image is passed by URL.
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Gets the archiveFilename.
   *
   * Name of the .zip file of images if uploaded. Not returned when the image is passed directly or by URL.
   *
   * @return the archiveFilename
   */
  public String getArchiveFilename() {
    return archiveFilename;
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
}
