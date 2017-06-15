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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * XPathPatterns.
 */
public class XPathPatterns extends GenericModel {

  private List<String> xpaths;

  /**
   * Gets the xpaths.
   *
   * @return the xpaths
   */
  public List<String> getXpaths() {
    return xpaths;
  }

  /**
   * Sets the xpaths.
   *
   * @param xpaths the new xpaths
   */
  public void setXpaths(final List<String> xpaths) {
    this.xpaths = xpaths;
  }
}
