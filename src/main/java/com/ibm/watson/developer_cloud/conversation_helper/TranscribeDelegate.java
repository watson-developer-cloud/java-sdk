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

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import java.io.InputStream;

/**
 * Receives {@code SpeechResults} from
 * {@link ConversationHelper#sendVoiceContinuous(InputStream, TranscribeDelegate)} (interim results
 * included).
 */
public interface TranscribeDelegate {
  /**
   * Receives {@code SpeechResults} (or any errors) from
   * {@link ConversationHelper#sendVoiceContinuous(InputStream, TranscribeDelegate)}.
   *
   * @param results Either a final or interim result.
   * @param e Error for a request sent by
   * {@link ConversationHelper#sendVoiceContinuous(InputStream, TranscribeDelegate)}.
   */
  void onTranscribe(SpeechResults results, Exception e);

  /**
   * The connection to the underlying {@code SpeechToText} service has closed. No more data will
   * be sent to {@link #onTranscribe(SpeechResults, Exception)}.
   */
  void onClose();
}
