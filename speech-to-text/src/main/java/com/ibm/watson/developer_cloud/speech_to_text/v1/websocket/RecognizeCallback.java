/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import okhttp3.WebSocket;


/**
 * The recognize callback used during a {@link WebSocket} recognition by the {@link SpeechToText} service.
 */
public interface RecognizeCallback {

  /**
   * Called when a {@link SpeechResults} was received.
   *
   * @param speechResults the speech results
   */
  void onTranscription(SpeechResults speechResults);

  /**
   * Called when a WebSocket connection was made.
   */
  void onConnected();

  /**
   * Called when there is an error in the Web Socket connection.
   *
   * @param e the exception
   */
  void onError(Exception e);

  /**
   * Called when a WebSocket connection was closed.
   */
  void onDisconnected();

  /**
   * Called when there is an inactivity timeout.
   *
   * @param runtimeException the runtime exception
   */
  void onInactivityTimeout(RuntimeException runtimeException);

  /**
   * Called when the service is listening for audio.
   */
  void onListening();

  /**
   * Called after the service returns the final result for the transcription.
   */
  void onTranscriptionComplete();
}
