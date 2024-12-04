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

/** The updateProvider options. */
public class UpdateProviderOptions extends GenericModel {

  protected String providerId;
  protected ProviderSpecification specification;
  protected ProviderPrivate xPrivate;

  /** Builder. */
  public static class Builder {
    private String providerId;
    private ProviderSpecification specification;
    private ProviderPrivate xPrivate;

    /**
     * Instantiates a new Builder from an existing UpdateProviderOptions instance.
     *
     * @param updateProviderOptions the instance to initialize the Builder with
     */
    private Builder(UpdateProviderOptions updateProviderOptions) {
      this.providerId = updateProviderOptions.providerId;
      this.specification = updateProviderOptions.specification;
      this.xPrivate = updateProviderOptions.xPrivate;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param providerId the providerId
     * @param specification the specification
     * @param xPrivate the xPrivate
     */
    public Builder(
        String providerId, ProviderSpecification specification, ProviderPrivate xPrivate) {
      this.providerId = providerId;
      this.specification = specification;
      this.xPrivate = xPrivate;
    }

    /**
     * Builds a UpdateProviderOptions.
     *
     * @return the new UpdateProviderOptions instance
     */
    public UpdateProviderOptions build() {
      return new UpdateProviderOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the UpdateProviderOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the specification.
     *
     * @param specification the specification
     * @return the UpdateProviderOptions builder
     */
    public Builder specification(ProviderSpecification specification) {
      this.specification = specification;
      return this;
    }

    /**
     * Set the xPrivate.
     *
     * @param xPrivate the xPrivate
     * @return the UpdateProviderOptions builder
     */
    public Builder xPrivate(ProviderPrivate xPrivate) {
      this.xPrivate = xPrivate;
      return this;
    }
  }

  protected UpdateProviderOptions() {}

  protected UpdateProviderOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.providerId, "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.specification, "specification cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xPrivate, "xPrivate cannot be null");
    providerId = builder.providerId;
    specification = builder.specification;
    xPrivate = builder.xPrivate;
  }

  /**
   * New builder.
   *
   * @return a UpdateProviderOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * <p>Unique identifier of the conversational skill provider.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the specification.
   *
   * <p>The specification of the provider.
   *
   * @return the specification
   */
  public ProviderSpecification specification() {
    return specification;
  }

  /**
   * Gets the xPrivate.
   *
   * <p>Private information of the provider.
   *
   * @return the xPrivate
   */
  public ProviderPrivate xPrivate() {
    return xPrivate;
  }
}
