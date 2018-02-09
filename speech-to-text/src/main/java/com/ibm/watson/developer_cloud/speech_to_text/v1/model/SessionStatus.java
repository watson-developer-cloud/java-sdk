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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SessionStatus.
 */
public class SessionStatus extends GenericModel {

  private SpeechSession session;

  /**
   * Gets the session.
   *
   * Information about the specified existing session.
   *
   * @return the session
   */
  public SpeechSession getSession() {
    return session;
  }

  /**
   * Sets the session.
   *
   * @param session the new session
   */
  public void setSession(final SpeechSession session) {
    this.session = session;
  }
}
