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

/**
 * Location within an image.
 */
public class Location {
  private Integer height;
  private Integer left;
  private Integer top;
  private Integer width;

  /**
   * Gets the height.
   *
   * @return the height
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * Gets the left.
   *
   * @return the left
   */
  public Integer getLeft() {
    return left;
  }

  /**
   * Gets the top.
   *
   * @return the top
   */
  public Integer getTop() {
    return top;
  }

  /**
   * Gets the width.
   *
   * @return the width
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * Sets the height.
   *
   * @param height the new height
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  /**
   * Sets the left.
   *
   * @param left the new left
   */
  public void setLeft(Integer left) {
    this.left = left;
  }

  /**
   * Sets the top.
   *
   * @param top the new top
   */
  public void setTop(Integer top) {
    this.top = top;
  }

  /**
   * Sets the width.
   *
   * @param width the new width
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

}
