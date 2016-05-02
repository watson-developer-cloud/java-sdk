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

/**
 * Receives amplitude and volume data per sample from {@link MicrophoneInputStream}.
 */
public interface AmplitudeListener {
  /**
   * Amplitude and volume data from the audio sample.
   *
   * @param amplitude Amplitude from sample.
   * @param volume Volume from sample.
   */
  void onSample(double amplitude, double volume);
}
