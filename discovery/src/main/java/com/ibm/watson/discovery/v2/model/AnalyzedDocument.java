/*
 * (C) Copyright IBM Corp. 2020, 2022.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * An object that contains the converted document and any identified enrichments. Root-level fields
 * from the original file are returned also.
 */
public class AnalyzedDocument extends GenericModel {

  protected List<Notice> notices;
  protected AnalyzedResult result;

  /**
   * Gets the notices.
   *
   * <p>Array of notices that are triggered when the files are processed.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return notices;
  }

  /**
   * Gets the result.
   *
   * <p>Result of the document analysis.
   *
   * @return the result
   */
  public AnalyzedResult getResult() {
    return result;
  }
}
