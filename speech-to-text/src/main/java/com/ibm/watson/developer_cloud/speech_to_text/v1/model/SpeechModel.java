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
 * Speech model.
 */
public class SpeechModel extends GenericModel {
  
  /**  Modern Standard Arabic broadband model. */
  public static final SpeechModel AR_AR_BROADBANDMODEL = new SpeechModel("ar-AR_BroadbandModel");
  
  /**  UK English broadband model. */
  public static final SpeechModel EN_UK_BROADBANDMODEL = new SpeechModel("en-UK_BroadbandModel");
  
  /**  UK English narrowband model. */
  public static final SpeechModel EN_UK_NARROWBANDMODEL = new SpeechModel("en-UK_NarrowbandModel");

  /**  US English broadband model. */
  public static final SpeechModel EN_US_BROADBANDMODEL = new SpeechModel("en-US_BroadbandModel");

  /**  US English narrowband model. */
  public static final SpeechModel EN_US_NARROWBANDMODEL = new SpeechModel("en-US_NarrowbandModel");

  /**  Spanish broadband model. */
  public static final SpeechModel ES_ES_BROADBANDMODEL = new SpeechModel("es-ES_BroadbandModel");

  /**  Spanish narrowband model. */
  public static final SpeechModel ES_ES_NARROWBANDMODEL = new SpeechModel("es-ES_NarrowbandModel");

  /**  Japanese broadband model. */
  public static final SpeechModel JA_JP_BROADBANDMODEL = new SpeechModel("ja-JP_BroadbandModel");

  /**  French broadband model. */
  public static final SpeechModel FR_FR_BROADBANDMODEL = new SpeechModel("fr-FR_BroadbandModel");

  /**  Japanese narrowband model. */
  public static final SpeechModel JA_JP_NARROWBANDMODEL = new SpeechModel("ja-JP_NarrowbandModel");

  /**  Brazilian Portuguese broadband model. */
  public static final SpeechModel PT_BR_BROADBANDMODEL = new SpeechModel("pt-BR_BroadbandModel");

  /**  Brazilian Portuguese narrowband model. */
  public static final SpeechModel PT_BR_NARROWBANDMODEL = new SpeechModel("pt-BR_NarrowbandModel");

  /**  Mandarin broadband model. */
  public static final SpeechModel ZH_CN_BROADBANDMODEL = new SpeechModel("zh-CN_BroadbandModel");

  /**  Mandarin narrowband model. */
  public static final SpeechModel ZH_CN_NARROWBANDMODEL = new SpeechModel("zh-CN_NarrowbandModel");

  private String name;

  private int rate;

  private String sessions;

  private String description;

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
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
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
   * Sets the description.
   *
   * @param description The description
   */
  public void setDescription(String description) {
    this.description = description;
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
