/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Speech model
 */
public class SpeechModel extends GenericModel {

  /** US English broadband model (16KHz). */
  public static final SpeechModel EN_BROADBAND16K = new SpeechModel("en-US_BroadbandModel");

  /** US English narrowband model (8KHz). */
  public static final SpeechModel EN_NARROWBAND8K = new SpeechModel("en-US_NarrowbandModel");

  /** Spanish broadband model (16KHz). */
  public static final SpeechModel ES_BROADBAND16K = new SpeechModel("es-ES_BroadbandModel");

  /** Brazilian Portuguese broadband model (16KHz). */
  public static final SpeechModel PT_BROADBAND16K = new SpeechModel("pt-BR_BroadbandModel");

  /** The name. */
  private String name;

  /** The rate. */
  private int rate;

  /** The sessions. */
  private String sessions;

  /**
   * Instantiates a new speech model.
   * 
   * @param name the name
   */
  public SpeechModel(String name) {
    super();
    this.name = name;
  }

  /**
   * Gets the name.
   * 
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the rate.
   * 
   * @return The rate
   */
  public int getRate() {
    return rate;
  }

  /**
   * Gets the sessions.
   * 
   * @return the sessions
   */
  public String getSessions() {
    return sessions;
  }

  /**
   * Sets the name.
   * 
   * @param name The name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the rate.
   * 
   * @param rate The rate
   */
  public void setRate(final int rate) {
    this.rate = rate;
  }

  /**
   * Sets the sessions.
   * 
   * @param sessions the new sessions
   */
  public void setSessions(final String sessions) {
    this.sessions = sessions;
  }

}
