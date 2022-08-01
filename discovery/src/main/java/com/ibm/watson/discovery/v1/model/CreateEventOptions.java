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

/** The createEvent options. */
public class CreateEventOptions extends GenericModel {

  /** The event type to be created. */
  public interface Type {
    /** click. */
    String CLICK = "click";
  }

  protected String type;
  protected EventData data;

  /** Builder. */
  public static class Builder {
    private String type;
    private EventData data;

    private Builder(CreateEventOptions createEventOptions) {
      this.type = createEventOptions.type;
      this.data = createEventOptions.data;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param data the data
     */
    public Builder(String type, EventData data) {
      this.type = type;
      this.data = data;
    }

    /**
     * Builds a CreateEventOptions.
     *
     * @return the new CreateEventOptions instance
     */
    public CreateEventOptions build() {
      return new CreateEventOptions(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateEventOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the data.
     *
     * @param data the data
     * @return the CreateEventOptions builder
     */
    public Builder data(EventData data) {
      this.data = data;
      return this;
    }
  }

  protected CreateEventOptions() {}

  protected CreateEventOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type, "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.data, "data cannot be null");
    type = builder.type;
    data = builder.data;
  }

  /**
   * New builder.
   *
   * @return a CreateEventOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * <p>The event type to be created.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the data.
   *
   * <p>Query event data object.
   *
   * @return the data
   */
  public EventData data() {
    return data;
  }
}
