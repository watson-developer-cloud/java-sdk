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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Returns information from the document, including author name, title, RSS/ATOM feeds, prominent page image, and
 * publication date. Supports URL and HTML input types only.
 */
public class MetadataOptions extends GenericModel {

  /**
   * Builder.
   */
  public static class Builder {

    private Builder(MetadataOptions metadataOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MetadataOptions.
     *
     * @return the metadataOptions
     */
    public MetadataOptions build() {
      return new MetadataOptions(this);
    }
  }

  private MetadataOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a MetadataOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
