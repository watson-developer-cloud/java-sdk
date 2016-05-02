/*
 *
 * IBM Confidential
 * OCO Source Materials
 *
 * (C) Copyright IBM Corp. 2015, 2016
 *
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *
 */

package com.ibm.watson.developer_cloud.conversation_helper;

import android.util.Log;
import com.ibm.watson.developer_cloud.conversation_helper.internal.AudioConsumer;
import com.ibm.watson.developer_cloud.conversation_helper.internal.MicrophoneCaptureThread;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Captures raw audio data from the microphone and exposes it via an {@code InputStream}. Make sure
 * {@link #close()} gets called in order to free its resources appropriately.
 */
public final class MicrophoneInputStream extends InputStream implements AudioConsumer {
  private static final String TAG = MicrophoneInputStream.class.getName();

  private final MicrophoneCaptureThread captureThread;
  private final PipedOutputStream os;
  private final PipedInputStream is;

  private AmplitudeListener amplitudeListener;

  public MicrophoneInputStream() {
    captureThread = new MicrophoneCaptureThread(this);
    os = new PipedOutputStream();
    is = new PipedInputStream();
    try {
      is.connect(os);
    } catch (IOException e) {
      Log.e(TAG, e.getMessage());
    }
    captureThread.start();
  }

  @Override public int read() throws IOException {
    throw new UnsupportedOperationException("Call read(byte[]) or read(byte[], int, int)");
  }

  @Override public int read(byte[] buffer) throws IOException {
    return read(buffer, 0, buffer.length);
  }

  @Override public int read(byte[] buffer, int offset, int length) throws IOException {
    return is.read(buffer, offset, length);
  }

  @Override public void close() throws IOException {
    captureThread.end();
    os.close();
    is.close();
  }

  @Override public void consume(byte[] data, double amplitude, double volume) {
    if (amplitudeListener != null) {
      amplitudeListener.onSample(amplitude, volume);
    }

    try {
      os.write(data);
    } catch (IOException e) {
      Log.e(TAG, e.getMessage());
    }
  }

  /**
   * Receive amplitude (and volume) data per sample from the {@code MicrophoneInputStream}.
   *
   * @param listener Notified per sample with amplitude and volume data.
   */
  public void setOnAmplitudeListener(AmplitudeListener listener) {
    amplitudeListener = listener;
  }
}
