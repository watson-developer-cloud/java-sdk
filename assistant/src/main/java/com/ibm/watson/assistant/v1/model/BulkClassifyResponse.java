/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** BulkClassifyResponse. */
public class BulkClassifyResponse extends GenericModel {

  protected List<BulkClassifyOutput> output;

  /**
   * Gets the output.
   *
   * <p>An array of objects that contain classification information for the submitted input
   * utterances.
   *
   * @return the output
   */
  public List<BulkClassifyOutput> getOutput() {
    return output;
  }
}
