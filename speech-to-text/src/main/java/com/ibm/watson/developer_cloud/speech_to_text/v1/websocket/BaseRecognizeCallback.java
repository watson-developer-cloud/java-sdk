/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.websocket;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

/**
 * An empty implementation of {@link RecognizeCallback} interface.
 */
public class BaseRecognizeCallback implements RecognizeCallback {

  private static final Logger LOG = Logger.getLogger(BaseRecognizeCallback.class.getName());

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback# onTranscription(com.
   * ibm.watson.watson.developer_cloud.speech_to_text.v1.model.SpeechResults)
   */
  @Override
  public void onTranscription(SpeechResults speechResults) { };

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback#onConnected ()
   */
  @Override
  public void onConnected() { };

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback#onError( java.lang
   * .Exception)
   */
  @Override
  public void onError(Exception e) {
    LOG.log(Level.SEVERE, e.getMessage(), e);
  };

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback# onDisconnected()
   */
  @Override
  public void onDisconnected() { };

}
