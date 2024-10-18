/*
 * (C) Copyright IBM Corp. 2024.
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

/**
 * A compressed newline delimited JSON (NDJSON) file containing the document. The NDJSON format is
 * used to describe structured data. The file name format is `{batch_id}.ndjson.gz`. For more
 * information, see [Binary attachment from the pull batches
 * method](/docs/discovery-data?topic=discovery-data-external-enrichment#binary-attachment-pull-batches).
 */
public class PullBatchesResponse extends GenericModel {

  protected String file;

  protected PullBatchesResponse() {}

  /**
   * Gets the file.
   *
   * <p>A compressed NDJSON file containing the document.
   *
   * @return the file
   */
  public String getFile() {
    return file;
  }
}
