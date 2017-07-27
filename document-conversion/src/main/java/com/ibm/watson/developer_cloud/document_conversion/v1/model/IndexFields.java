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
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Index Fields configuration object. The fields that you want to map, fields that you want to include, and the fields
 * that you want to exclude during indexing
 */
public class IndexFields extends GenericModel {
  /**
   * Builder.
   */
  public static class Builder {
    private List<String> exclude;
    private List<String> include;
    private Map<String, String> mappings;

    private Builder(IndexFields fields) {
      mappings = fields.mappings;
      include = fields.include;
      exclude = fields.exclude;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the index fields.
     *
     * @return the index fields
     */
    public IndexFields build() {
      return new IndexFields(this);
    }

    /**
     * Field to exclude during indexing.
     *
     * @param exclude field to exclude
     * @return the index fields builder
     */
    public Builder exclude(String exclude) {
      if (this.exclude == null) {
        this.exclude = new ArrayList<String>();
      }
      this.exclude.add(exclude);
      return this;
    }

    /**
     * Field to include during indexing.
     *
     * @param include field to include
     * @return the index fields builder
     */
    public Builder include(String include) {
      if (this.include == null) {
        this.include = new ArrayList<String>();
      }
      this.include.add(include);
      return this;
    }

    /**
     * Field to map during indexing.
     *
     * @param from the field name to map
     * @param to to field name to map the field to
     * @return the index fields builder
     */
    public Builder mappings(String from, String to) {
      if (mappings == null) {
        mappings = new HashMap<String, String>();
      }
      mappings.put(from, to);
      return this;
    }
  }

  /**
   * List of fields to exclude during indexing.
   */
  private List<String> exclude;

  /**
   * List of fields to include during indexing.
   */
  private List<String> include;

  /**
   * List of field mappings.
   */
  private Map<String, String> mappings;

  private IndexFields(Builder builder) {
    include = builder.include;
  }

  /**
   * Fields to exclude during indexing.
   *
   * @return list of fields to exclude during indexing
   */
  public List<String> exclude() {
    return exclude;
  }

  /**
   * Fields to include during indexing.
   *
   * @return list of fields to include during indexing
   */
  public List<String> include() {
    return include;
  }

  /**
   * Field mappings to use during indexing.
   *
   * @return field mappings
   */
  public Map<String, String> mappings() {
    return mappings;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
