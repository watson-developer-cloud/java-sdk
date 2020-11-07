/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Container for the list of collections that have objects detected in an image. */
public class DetectedObjects extends GenericModel {

  protected List<CollectionObjects> collections;

  /**
   * Gets the collections.
   *
   * <p>The collections with identified objects.
   *
   * @return the collections
   */
  public List<CollectionObjects> getCollections() {
    return collections;
  }
}
