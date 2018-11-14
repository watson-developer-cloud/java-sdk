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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A pair of `nature` and `party` objects. The `nature` object identifies the effect of the element on the identified
 * `party`, and the `party` object identifies the affected party.
 */
public class Label extends GenericModel {

  private String nature;
  private String party;

  /**
   * Gets the nature.
   *
   * The identified `nature` of the element.
   *
   * @return the nature
   */
  public String getNature() {
    return nature;
  }

  /**
   * Gets the party.
   *
   * The identified `party` of the element.
   *
   * @return the party
   */
  public String getParty() {
    return party;
  }

  /**
   * Sets the nature.
   *
   * @param nature the new nature
   */
  public void setNature(final String nature) {
    this.nature = nature;
  }

  /**
   * Sets the party.
   *
   * @param party the new party
   */
  public void setParty(final String party) {
    this.party = party;
  }
}
