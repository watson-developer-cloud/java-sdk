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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** ProviderSpecificationServersItem. */
public class ProviderSpecificationServersItem extends GenericModel {

  protected String url;

  /** Builder. */
  public static class Builder {
    private String url;

    /**
     * Instantiates a new Builder from an existing ProviderSpecificationServersItem instance.
     *
     * @param providerSpecificationServersItem the instance to initialize the Builder with
     */
    private Builder(ProviderSpecificationServersItem providerSpecificationServersItem) {
      this.url = providerSpecificationServersItem.url;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderSpecificationServersItem.
     *
     * @return the new ProviderSpecificationServersItem instance
     */
    public ProviderSpecificationServersItem build() {
      return new ProviderSpecificationServersItem(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ProviderSpecificationServersItem builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected ProviderSpecificationServersItem() {}

  protected ProviderSpecificationServersItem(Builder builder) {
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a ProviderSpecificationServersItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * <p>The URL of the conversational skill provider.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}
