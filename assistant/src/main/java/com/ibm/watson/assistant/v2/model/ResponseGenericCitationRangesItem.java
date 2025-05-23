/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** ResponseGenericCitationRangesItem. */
public class ResponseGenericCitationRangesItem extends GenericModel {

  protected Long start;
  protected Long end;

  protected ResponseGenericCitationRangesItem() {}

  /**
   * Gets the start.
   *
   * <p>The offset of the start of the citation in the generated response.
   *
   * @return the start
   */
  public Long getStart() {
    return start;
  }

  /**
   * Gets the end.
   *
   * <p>The offset of the end of the citation in the generated response.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
  }
}
