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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * LinkedDataResult.
 */
public class LinkedDataResult extends GenericModel {

  private String source;
  private String link;

  /**
   * Gets the source.
   *
   * Name of the Linked Data source
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the link.
   *
   * URL to the Linked Data page
   *
   * @return the link
   */
  public String getLink() {
    return link;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the link.
   *
   * @param link the new link
   */
  public void setLink(final String link) {
    this.link = link;
  }
}
