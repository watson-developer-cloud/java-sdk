/**
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

package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;

/**
 * SceneText by the {@link AlchemyVision} service.
 *
 */
public class ImageSceneText extends AlchemyGenericModel {

  /** The scene text. */
  private String sceneText;

  /** The image text lines. */
  private List<ImageSceneTextLine> sceneTextLines;

  /** The url. */
  private String url;

  /**
   * Gets the scene text.
   *
   * @return The scene text
   */
  public String getSceneText() {
    return sceneText;
  }

  /**
   * Gets the image faces.
   *
   * @return The imageFaces
   */
  public List<ImageSceneTextLine> getSceneTextLines() {
    return sceneTextLines;
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
   * Sets the image texts.
   *
   * @param imageTexts The imageTexts
   */
  public void setSceneTextLines(List<ImageSceneTextLine> imageTexts) {
    sceneTextLines = imageTexts;
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
