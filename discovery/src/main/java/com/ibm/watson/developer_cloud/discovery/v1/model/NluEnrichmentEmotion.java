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
 * An object specifying the emotion detection enrichment and related parameters.
 */
public class NluEnrichmentEmotion extends GenericModel {

  private Boolean document;
  private List<String> targets;

  /**
   * Gets the document.
   *
   * When `true`, emotion detection is performed on the entire field.
   *
   * @return the document
   */
  public Boolean isDocument() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * A comma-separated list of target strings that will have any associated emotions detected.
   *
   * @return the targets
   */
  public List<String> getTargets() {
    return targets;
  }

  /**
   * Sets the document.
   *
   * @param document the new document
   */
  public void setDocument(final Boolean document) {
    this.document = document;
  }

  /**
   * Sets the targets.
   *
   * @param targets the new targets
   */
  public void setTargets(final List<String> targets) {
    this.targets = targets;
  }
}
