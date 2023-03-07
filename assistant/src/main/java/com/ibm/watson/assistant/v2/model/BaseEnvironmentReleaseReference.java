/*
 * (C) Copyright IBM Corp. 2023.
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

/** An object describing the release that is currently deployed in the environment. */
public class BaseEnvironmentReleaseReference extends GenericModel {

  protected String release;

  /** Builder. */
  public static class Builder {
    private String release;

    /**
     * Instantiates a new Builder from an existing BaseEnvironmentReleaseReference instance.
     *
     * @param baseEnvironmentReleaseReference the instance to initialize the Builder with
     */
    private Builder(BaseEnvironmentReleaseReference baseEnvironmentReleaseReference) {
      this.release = baseEnvironmentReleaseReference.release;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a BaseEnvironmentReleaseReference.
     *
     * @return the new BaseEnvironmentReleaseReference instance
     */
    public BaseEnvironmentReleaseReference build() {
      return new BaseEnvironmentReleaseReference(this);
    }

    /**
     * Set the release.
     *
     * @param release the release
     * @return the BaseEnvironmentReleaseReference builder
     */
    public Builder release(String release) {
      this.release = release;
      return this;
    }
  }

  protected BaseEnvironmentReleaseReference() {}

  protected BaseEnvironmentReleaseReference(Builder builder) {
    release = builder.release;
  }

  /**
   * New builder.
   *
   * @return a BaseEnvironmentReleaseReference builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the release.
   *
   * <p>The name of the deployed release.
   *
   * @return the release
   */
  public String release() {
    return release;
  }
}
