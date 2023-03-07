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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** IntegrationReference. */
public class IntegrationReference extends GenericModel {

  @SerializedName("integration_id")
  protected String integrationId;

  protected String type;

  /** Builder. */
  public static class Builder {
    private String integrationId;
    private String type;

    /**
     * Instantiates a new Builder from an existing IntegrationReference instance.
     *
     * @param integrationReference the instance to initialize the Builder with
     */
    private Builder(IntegrationReference integrationReference) {
      this.integrationId = integrationReference.integrationId;
      this.type = integrationReference.type;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a IntegrationReference.
     *
     * @return the new IntegrationReference instance
     */
    public IntegrationReference build() {
      return new IntegrationReference(this);
    }

    /**
     * Set the integrationId.
     *
     * @param integrationId the integrationId
     * @return the IntegrationReference builder
     */
    public Builder integrationId(String integrationId) {
      this.integrationId = integrationId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the IntegrationReference builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected IntegrationReference() {}

  protected IntegrationReference(Builder builder) {
    integrationId = builder.integrationId;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a IntegrationReference builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the integrationId.
   *
   * <p>The integration ID of the integration.
   *
   * @return the integrationId
   */
  public String integrationId() {
    return integrationId;
  }

  /**
   * Gets the type.
   *
   * <p>The type of the integration.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}
