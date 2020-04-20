package com.ibm.watson.text_to_speech.v1.websocket;

import com.ibm.watson.text_to_speech.v1.model.Marks;
import com.ibm.watson.text_to_speech.v1.model.Timings;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseSynthesizeCallback implements SynthesizeCallback {
  private static final Logger LOG = Logger.getLogger(BaseSynthesizeCallback.class.getName());

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onConnected()
   */
  public void onConnected() {}

  /*
   * (non-Javadoc)
   * @see
   * com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onError(java.lang
   * .Exception)
   */
  public void onError(Exception e) {
    LOG.log(Level.SEVERE, e.getMessage(), e);
  }

  /*
   * (non-Javadoc)
   * @see
   * com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onWarning(java.lang
   * .Exception)
   */
  public void onWarning(Exception e) {
    LOG.log(Level.WARNING, e.getMessage(), e);
  }

  /*
   * (non-Javadoc)
   * @see
   * com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onDisconnected()
   */
  public void onDisconnected() {}

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onContentType()
   */
  @Override
  public void onContentType(String contentType) {}

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onTimings()
   */
  @Override
  public void onTimings(Timings timings) {}

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onMarks()
   */
  @Override
  public void onMarks(Marks marks) {}

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.text_to_speech.v1.websocket.SynthesizeCallback#onAudioStream()
   */
  @Override
  public void onAudioStream(byte[] bytes) {}
}
