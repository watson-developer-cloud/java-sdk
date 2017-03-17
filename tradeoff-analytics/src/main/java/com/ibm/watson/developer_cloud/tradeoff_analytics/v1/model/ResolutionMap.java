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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.List;
import java.util.Map;

/**
 * Resolution map.
 */
public class ResolutionMap {

  private List<Anchor> anchors;
  private ResolutionConfig config;
  private Map<String, Object> metrics;
  private List<Node> nodes;
  private String version;

  /**
   * Gets the anchors.
   *
   * @return the anchors
   */
  public List<Anchor> getAnchors() {
    return anchors;
  }

  /**
   * Gets the config.
   *
   * @return the config
   */
  public ResolutionConfig getConfig() {
    return config;
  }

  /**
   * Gets the metrics.
   *
   * @return the metrics
   */
  public Map<String, Object> getMetrics() {
    return metrics;
  }

  /**
   * Gets the nodes.
   *
   * @return the nodes
   */
  public List<Node> getNodes() {
    return nodes;
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets the anchors.
   *
   * @param anchors the new anchors
   */
  public void setAnchors(List<Anchor> anchors) {
    this.anchors = anchors;
  }

  /**
   * Sets the config.
   *
   * @param config the new config
   */
  public void setConfig(ResolutionConfig config) {
    this.config = config;
  }

  /**
   * Sets the metrics.
   *
   * @param metrics the metrics
   */
  public void setMetrics(Map<String, Object> metrics) {
    this.metrics = metrics;
  }

  /**
   * Sets the nodes.
   *
   * @param nodes the new nodes
   */
  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(String version) {
    this.version = version;
  }

}
