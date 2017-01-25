/**
 * Copyright IBM Corporation 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.ibm.watson.developer_cloud.android.library.audio;

import android.util.Log;
import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
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

  public final ContentType CONTENT_TYPE;

  private final MicrophoneCaptureThread captureThread;
  private final PipedOutputStream os;
  private final PipedInputStream is;

  private AmplitudeListener amplitudeListener;

  public MicrophoneInputStream() {
    captureThread = new MicrophoneCaptureThread(this, false);
    CONTENT_TYPE = ContentType.RAW;
    os = new PipedOutputStream();
    is = new PipedInputStream();
    try {
      is.connect(os);
    } catch (IOException e) {
      Log.e(TAG, e.getMessage());
    }
    captureThread.start();
  }

  public MicrophoneInputStream(boolean opusEncoded) {
    captureThread = new MicrophoneCaptureThread(this, opusEncoded);
    if(opusEncoded == true) {
      CONTENT_TYPE = ContentType.OPUS;
    } else {
      CONTENT_TYPE = ContentType.RAW;
    }
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

  @Override public void consume(byte[] data) {
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

  /**
   * Get the audio format from the {@code MicrophoneInputStream}
   * @return audio/l16;rate=16000
   */
  public String getContentType() {
    return CONTENT_TYPE.toString();
  }
}
