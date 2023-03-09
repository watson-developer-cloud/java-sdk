/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

/** Object specifying the training queries contained in the identified training set. */
public class TrainingQuerySet extends GenericModel {

  protected List<TrainingQuery> queries;

  protected TrainingQuerySet() {}

  /**
   * Gets the queries.
   *
   * <p>Array of training queries. At least 50 queries are required for training to begin. A maximum
   * of 10,000 queries are returned.
   *
   * @return the queries
   */
  public List<TrainingQuery> getQueries() {
    return queries;
  }
}
