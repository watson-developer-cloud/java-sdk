/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Structure that stores all metadata entries for document when indexing
 *
 * @see DocumentConversion
 */
public class Metadata extends GenericModel {

  private static final String METADATA = "metadata";
  private Map<String, String> metadata;

  /**
   * Gets the metadata
   *
   * @return Map of metadata values
   */
  public Map<String, String> getMetadata() { return metadata; }

  /**
   * Sets the metadata
   *
   * @param metadata The Map of metadata values
   */
  public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    List<MetadataEntry> metadata = new ArrayList<MetadataEntry>();
    for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
      metadata.add(new MetadataEntry(entry.getKey(), entry.getValue()));
    }
    Map<String, List<MetadataEntry>> metadataMap = new HashMap<String, List<MetadataEntry>>();
    metadataMap.put(METADATA, metadata);
    return GsonSingleton.getGson().toJson(metadataMap);
  }

  private static class MetadataEntry extends GenericModel {
    private String name, value;

    MetadataEntry(String name, String value) {
      this.name = name;
      this.value = value;
    }
  }

}
