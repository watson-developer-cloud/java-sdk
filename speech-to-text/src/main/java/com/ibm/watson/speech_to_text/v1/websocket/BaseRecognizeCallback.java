/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.speech_to_text.v1.websocket;

import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An empty implementation of {@link RecognizeCallback} interface.
 */
public class BaseRecognizeCallback implements RecognizeCallback {

  private static final Logger LOG = Logger.getLogger(BaseRecognizeCallback.class.getName());

  /*
   * (non-Javadoc)
   * @see
   * RecognizeCallback#onTranscription(com.
   * ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults)
   */
  public void onTranscription(SpeechRecognitionResults speechResults) {
  };

  /*
   * (non-Javadoc)
   * @see RecognizeCallback#onConnected()
   */
  public void onConnected() {
  };

  /*
   * (non-Javadoc)
   * @see
   * RecognizeCallback#onError(java.lang
   * .Exception)
   */
  public void onError(Exception e) {
    LOG.log(Level.SEVERE, e.getMessage(), e);
  };

  /*
   * (non-Javadoc)
   * @see
   * RecognizeCallback#onDisconnected()
   */
  public void onDisconnected() {
  };

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.speech_to_text.v1.websocket
   * .RecognizeCallback#onInactivityTimeout(java.lang.RuntimeException)
   */
  @Override
  public void onInactivityTimeout(RuntimeException runtimeException) {
  };

  /*
   * (non-Javadoc)
   * @see RecognizeCallback#onListening()
   */
  @Override
  public void onListening() {
  };

  /*
   * (non-Javadoc)
   * @see RecognizeCallback#onTranscriptionComplete()
   */
  @Override
  public void onTranscriptionComplete() {
  };

}
