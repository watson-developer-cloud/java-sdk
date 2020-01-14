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
package com.ibm.watson.compare_comply.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Key-value pairs detected across cell boundaries.
 */
public class KeyValuePair extends GenericModel {

  protected Key key;
  protected List<Value> value;

  /**
   * Gets the key.
   *
   * A key in a key-value pair.
   *
   * @return the key
   */
  public Key getKey() {
    return key;
  }

  /**
   * Gets the value.
   *
   * A list of values in a key-value pair.
   *
   * @return the value
   */
  public List<Value> getValue() {
    return value;
  }
}
