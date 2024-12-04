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

/** ProviderAuthenticationTypeAndValue. */
public class ProviderAuthenticationTypeAndValue extends GenericModel {

  /** The type of property observed in "value". */
  public interface Type {
    /** value. */
    String VALUE = "value";
  }

  protected String type;
  protected String value;

  /** Builder. */
  public static class Builder {
    private String type;
    private String value;

    /**
     * Instantiates a new Builder from an existing ProviderAuthenticationTypeAndValue instance.
     *
     * @param providerAuthenticationTypeAndValue the instance to initialize the Builder with
     */
    private Builder(ProviderAuthenticationTypeAndValue providerAuthenticationTypeAndValue) {
      this.type = providerAuthenticationTypeAndValue.type;
      this.value = providerAuthenticationTypeAndValue.value;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationTypeAndValue.
     *
     * @return the new ProviderAuthenticationTypeAndValue instance
     */
    public ProviderAuthenticationTypeAndValue build() {
      return new ProviderAuthenticationTypeAndValue(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ProviderAuthenticationTypeAndValue builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ProviderAuthenticationTypeAndValue builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ProviderAuthenticationTypeAndValue() {}

  protected ProviderAuthenticationTypeAndValue(Builder builder) {
    type = builder.type;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationTypeAndValue builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * <p>The type of property observed in "value".
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the value.
   *
   * <p>The stored information of the value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}
