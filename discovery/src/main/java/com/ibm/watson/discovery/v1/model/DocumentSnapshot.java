/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.discovery.v1.model;

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DocumentSnapshot.
 */
public class DocumentSnapshot extends GenericModel {

  /**
   * The step in the document conversion process that the snapshot object represents.
   */
  public interface Step {
    /** html_input. */
    String HTML_INPUT = "html_input";
    /** html_output. */
    String HTML_OUTPUT = "html_output";
    /** json_output. */
    String JSON_OUTPUT = "json_output";
    /** json_normalizations_output. */
    String JSON_NORMALIZATIONS_OUTPUT = "json_normalizations_output";
    /** enrichments_output. */
    String ENRICHMENTS_OUTPUT = "enrichments_output";
    /** normalizations_output. */
    String NORMALIZATIONS_OUTPUT = "normalizations_output";
  }

  private String step;
  private Map<String, Object> snapshot;

  /**
   * Gets the step.
   *
   * The step in the document conversion process that the snapshot object represents.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the snapshot.
   *
   * Snapshot of the conversion.
   *
   * @return the snapshot
   */
  public Map<String, Object> getSnapshot() {
    return snapshot;
  }
}
