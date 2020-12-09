/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Brief information about the input document. */
public class ShortDoc extends GenericModel {

  protected String title;
  protected String hash;

  /** Builder. */
  public static class Builder {
    private String title;
    private String hash;

    private Builder(ShortDoc shortDoc) {
      this.title = shortDoc.title;
      this.hash = shortDoc.hash;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ShortDoc.
     *
     * @return the new ShortDoc instance
     */
    public ShortDoc build() {
      return new ShortDoc(this);
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the ShortDoc builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the hash.
     *
     * @param hash the hash
     * @return the ShortDoc builder
     */
    public Builder hash(String hash) {
      this.hash = hash;
      return this;
    }
  }

  protected ShortDoc(Builder builder) {
    title = builder.title;
    hash = builder.hash;
  }

  /**
   * New builder.
   *
   * @return a ShortDoc builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the title.
   *
   * <p>The title of the input document, if identified.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the hash.
   *
   * <p>The MD5 hash of the input document.
   *
   * @return the hash
   */
  public String hash() {
    return hash;
  }
}
