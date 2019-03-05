/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

/**
 * An object defining the event being created.
 */
public class CreateEventResponse extends GenericModel {

  /**
   * The event type that was created.
   */
  public interface Type {
    /** click. */
    String CLICK = "click";
  }

  private String type;
  private EventData data;

  /**
   * Gets the type.
   *
   * The event type that was created.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the data.
   *
   * Query event data object.
   *
   * @return the data
   */
  public EventData getData() {
    return data;
  }
}
