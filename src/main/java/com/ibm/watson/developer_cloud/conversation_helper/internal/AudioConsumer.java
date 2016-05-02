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

/**
 * Delegate for consuming audio data from {@link MicrophoneCaptureThread}.
 */
public interface AudioConsumer {
  /**
   * Data that has been recorded in the most recent sample and is ready for consumption.
   *
   * @param data Buffer of audio data in raw form.
   * @param amplitude Amplitude from sample.
   * @param volume Volume from sample.
   */
  void consume(byte[] data, double amplitude, double volume);
}
