/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package alchemy_vision.v1.model;

import alchemy_vision.v1.AlchemyVision;
import service_core.service.model.AlchemyGenericModel;

import java.util.List;

/**
 * FaceTag by the {@link AlchemyVision} service.
 * 
 */
public class ImageFaces extends AlchemyGenericModel {

  /** The image faces. */
  private List<ImageFace> imageFaces;

  /** The url. */
  private String url;

  /**
   * Gets the image faces.
   * 
   * @return The imageFaces
   */
  public List<ImageFace> getImageFaces() {
    return imageFaces;
  }

  /**
   * Gets the url.
   * 
   * @return The url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the image faces.
   * 
   * @param imageFaces The imageFaces
   */
  public void setImageFaces(List<ImageFace> imageFaces) {
    this.imageFaces = imageFaces;
  }

  /**
   * Sets the url.
   * 
   * @param url The url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
