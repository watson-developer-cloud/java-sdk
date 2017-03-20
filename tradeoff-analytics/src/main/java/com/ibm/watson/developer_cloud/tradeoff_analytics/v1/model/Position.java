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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

/**
 * Position.
 */
public class Position {

  private Double x;
  private Double y;

  /**
   * Gets the x.
   *
   * @return the x
   */
  public Double getX() {
    return x;
  }

  /**
   * Gets the y.
   *
   * @return the y
   */
  public Double getY() {
    return y;
  }

  /**
   * Sets the x.
   *
   * @param x the new x
   */
  public void setX(Double x) {
    this.x = x;
  }

  /**
   * Sets the y.
   *
   * @param y the new y
   */
  public void setY(Double y) {
    this.y = y;
  }

}
