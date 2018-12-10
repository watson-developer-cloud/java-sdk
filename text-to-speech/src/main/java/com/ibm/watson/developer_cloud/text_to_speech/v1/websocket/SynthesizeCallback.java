package com.ibm.watson.developer_cloud.text_to_speech.v1.websocket;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Marks;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Timings;

public interface SynthesizeCallback {
  /**
   * Called when a WebSocket connection was made.
   */
  void onConnected();

  /**
   * Called when there is an error in the WebSocket connection.
   *
   * @param e the exception
   */
  void onError(Exception e);

  /**
   * Called when there is a warning in the WebSocket connection.
   *
   * @param e the exception
   */
  void onWarning(Exception e);

  /**
   * Called when a WebSocket connection was closed.
   */
  void onDisconnected();

  /**
   * Called when the service returns the type of audio it will be sending back.
   *
   * @param contentType the content type of the synthesized audio
   */
  void onContentType(String contentType);

  /**
   * Called when the service returns word timing information.
   *
   * @param timings array of words and their start and end times
   */
  void onTimings(Timings timings);

  /**
   * Called when the service returns SSML mark information.
   *
   * @param marks array of marks and their appearance times
   */
  void onMarks(Marks marks);

  /**
   * Called when the service returns byte info in the specified audio format as
   * a result of synthesis.
   *
   * @param bytes array of bytes in the specified audio format or the default
   *              (audio/ogg;codecs=opus)
   */
  void onAudioStream(byte[] bytes);
}
