/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Object containing an array of XPaths. */
public class XPathPatterns extends GenericModel {

  protected List<String> xpaths;

  /** Builder. */
  public static class Builder {
    private List<String> xpaths;

    private Builder(XPathPatterns xPathPatterns) {
      this.xpaths = xPathPatterns.xpaths;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a XPathPatterns.
     *
     * @return the new XPathPatterns instance
     */
    public XPathPatterns build() {
      return new XPathPatterns(this);
    }

    /**
     * Adds an xpaths to xpaths.
     *
     * @param xpaths the new xpaths
     * @return the XPathPatterns builder
     */
    public Builder addXpaths(String xpaths) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xpaths, "xpaths cannot be null");
      if (this.xpaths == null) {
        this.xpaths = new ArrayList<String>();
      }
      this.xpaths.add(xpaths);
      return this;
    }

    /**
     * Set the xpaths. Existing xpaths will be replaced.
     *
     * @param xpaths the xpaths
     * @return the XPathPatterns builder
     */
    public Builder xpaths(List<String> xpaths) {
      this.xpaths = xpaths;
      return this;
    }
  }

  protected XPathPatterns() {}

  protected XPathPatterns(Builder builder) {
    xpaths = builder.xpaths;
  }

  /**
   * New builder.
   *
   * @return a XPathPatterns builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xpaths.
   *
   * <p>An array to XPaths.
   *
   * @return the xpaths
   */
  public List<String> xpaths() {
    return xpaths;
  }
}
