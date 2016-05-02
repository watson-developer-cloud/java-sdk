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

package com.ibm.watson.developer_cloud.conversation_helper.internal;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Dedicated thread for capturing raw audio data from the microphone. Captured data is passed to
 * an {@link AudioConsumer}. To begin capturing data, call {@link #start()}.  Ensure {@link #end()}
 * is called to stop this thread from running and to clean up its resources appropriately.
 */
public final class MicrophoneCaptureThread extends Thread {
  private static final String TAG = MicrophoneCaptureThread.class.getName();
  private static final int SAMPLE_RATE = 16000;

  private final AudioConsumer consumer;
  private boolean stop;
  private boolean stopped;

  /**
   * This only initializes data associated with the thread. To start recording microphone data,
   * call {@link #start()}. Ensure that there is a corresponding call to {@link #end()} when
   * finished recording data.
   *
   * @param consumer Delegate for consuming audio data from the microphone.
   */
  public MicrophoneCaptureThread(AudioConsumer consumer) {
    android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_AUDIO);
    this.consumer = consumer;
  }

  @Override public void run() {
    int bufferSize = Math.max(SAMPLE_RATE / 2, AudioRecord.getMinBufferSize(SAMPLE_RATE,
        AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT));
    short[] buffer = new short[bufferSize]; // use short to hold 16-bit PCM encoding

    AudioRecord record = new AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLE_RATE,
        AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize);
    record.startRecording();

    while (!stop) {
      int r = record.read(buffer, 0, buffer.length);

      // calculate amplitude and volume
      long v = 0;
      for (int i = 0; i < r; i++) {
        v += buffer[i] * buffer[i];
      }

      double amplitude = v / (double) r;
      double volume = 0;
      if (amplitude > 0) {
        volume = 10 * Math.log10(amplitude);
      }

      // convert short buffer to bytes
      ByteBuffer bufferBytes = ByteBuffer.allocate(r * 2); // 2 bytes per short
      bufferBytes.order(ByteOrder.LITTLE_ENDIAN); // save little-endian byte from short buffer
      bufferBytes.asShortBuffer().put(buffer, 0, r);
      byte[] bytes = bufferBytes.array();

      consumer.consume(bytes, amplitude, volume);
    }

    record.stop();
    record.release();
    stopped = true;
  }

  /**
   * Gracefully stops recording microphone data. Make sure this is called when data no longer needs
   * to be collected to ensure this thread and its resources are properly cleaned up.
   */
  public void end() {
    stop = true;

    while (!stopped) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        Log.e(TAG, e.getMessage());
      }
    }
  }
}
