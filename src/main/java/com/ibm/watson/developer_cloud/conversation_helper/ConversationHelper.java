/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential */
/* OCO Source Materials */
/*                                                                   */
/* (C) Copyright IBM Corp. 2015, 2016 */
/*                                                                   */
/* The source code for this program is not published or otherwise */
/* divested of its trade secrets, irrespective of what has been */
/* deposited with the U.S. Copyright Office. */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.developer_cloud.conversation_helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationResponse;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.CredentialUtils;

/**
 * Converse with the Conversation Service through text and voice. Operations on a
 * {@code ConversationHelper} are implicitly async.
 *
 * @see Builder
 */
public final class ConversationHelper {
  /** The Constant log. */
  private static final Logger log = Logger.getLogger(CredentialUtils.class.getName());

  private final String workspaceId;
  private final Executor executor;
  private final Conversation conversation;
  private final SpeechToText sttService;
  private final TextToSpeech ttsService;

  private ConversationHelper(String workspaceId, String conversationApiVersion, Executor executor, Conversation conversation,
      SpeechToText sttService, TextToSpeech ttsService) {
    this.workspaceId = workspaceId;
    this.executor = executor;
    this.conversation = conversation;
    this.sttService = sttService;
    this.ttsService = ttsService;
  }

  /**
   * Send a text message to the {@code Conversation}. This method is useful for when there is
   * no prior context and a new {@code ConversationHelper} is starting.
   *
   * @param message Text message that's sent to the {@code Conversation}.
   * @param handler Notified when there is a response (or error) from the
   *        {@code Conversation}.
   */
  public void sendText(String message, CompletionHandler<ConversationResponse> handler) {
    sendText(message, Collections.<String, Object>emptyMap(), handler);
  }

  /**
   * Send a text message and some existing context to the {@code Conversation}. Use this when
   * an existing {@code ConversationHelper} is already active.
   *
   * @param message Text message that's sent to the {@code Conversation}.
   * @param context Context from a previous point in a {@code ConversationHelper}. This can be
   *        retrieved from the {@code ConversationResponse} that's passed to a successful
   *        {@link CompletionHandler}.
   * @param handler Notified when there's a response (or error) from the {@code Conversation}
   *        .
   */
  public void sendText(final String message, final Map<String, Object> context,
      final CompletionHandler<ConversationResponse> handler) {
    invokeService(new ServiceRequester<ConversationResponse>() {
      @Override public ConversationResponse request() throws ServiceResponseException {
        return conversation.message(workspaceId, new ConversationRequest(message, context)).execute();
      }
    }, handler);
  }

  /**
   * Send a voice file for transcription to the {@code SpeechToText} service. This expects an audio
   * file with WAV encoding.
   *
   * @param voice File with voice data for transcribing.
   * @param handler Notified when there's a response (or error) from the {@code SpeechToText}
   *        service.
   */
  public void sendVoice(File voice, CompletionHandler<SpeechResults> handler) {
    RecognizeOptions options = new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_WAV).build();
    sendVoice(voice, handler, options);
  }

  /**
   * Send a voice file for transcription to the {@code SpeechToText} service.
   *
   * @param voice File with voice data for transcribing.
   * @param handler Notified when there's a response (or error) from the {@code SpeechToText}
   *        service.
   * @param options Options for the request being made (e.g. media type, timeout, etc...).
   */
  public void sendVoice(final File voice, final CompletionHandler<SpeechResults> handler,
      final RecognizeOptions options) {

    invokeService(new ServiceRequester<SpeechResults>() {
      @Override public SpeechResults request() throws ServiceResponseException {
        return sttService.recognize(voice, options).execute();
      }
    }, handler);
  }

  /**
   * Continuously sends voice data from the {@code audioStream} to the {@code SpeechToText} service.
   * Interim results are transcribed and passed to the {@code delegate}. This operation is ideal for
   * recording microphone input via {@link MicrophoneInputStream}.
   *
   * @param audioStream Stream of voice data for transcribing.
   * @param delegate Notified when as responses (or errors) come in from the @{@code SpeechToText}
   *        service.
   *
   * @see MicrophoneInputStream
   */
  public void sendVoiceContinuous(InputStream audioStream, TranscribeDelegate delegate) {
    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).contentType("audio/l16;rate=16000")
        .interimResults(true).build();
    sendVoiceContinuous(audioStream, delegate, options);
  }

  /**
   * Continuously sends voice data from the {@code audioStream} to the {@code SpeechToText} service.
   * Interim results are transcribed and passed to the {@code delegate}. This operation is ideal for
   * recording microphone input via {@link MicrophoneInputStream}.
   *
   * @param audioStream Stream of voice data for transcribing.
   * @param delegate Notified when as responses (or errors) come in from the @{@code SpeechToText}
   *        service.
   * @param options Options for the request being made (e.g. media type, timeout, etc...).
   *
   * @see MicrophoneInputStream
   */
  public void sendVoiceContinuous(final InputStream audioStream, final TranscribeDelegate delegate,
      final RecognizeOptions options) {
    executor.execute(new Runnable() {
      @Override public void run() {
        sttService.recognizeUsingWebSocket(audioStream, options, new BaseRecognizeCallback() {
          @Override public void onTranscription(SpeechResults speechResults) {
            delegate.onTranscribe(speechResults, null);
          }

          @Override public void onConnected() {
            // not implemented
          }

          @Override public void onError(Exception e) {
            delegate.onTranscribe(null, e);
            try {
              audioStream.close();
            } catch (IOException e1) {
              log.log(Level.SEVERE, e.getMessage(), e);
            }
          }

          @Override public void onDisconnected() {
            delegate.onClose();
            try {
              audioStream.close();
            } catch (IOException e) {
              log.log(Level.SEVERE, e.getMessage(), e);
            }
          }
        });
      }
    });
  }

  /**
   * Sends a text message to the {@code TextToSpeech} service for conversion to a stream of audio
   * data. The default voice is "EN"; call {@link #synthesize(String, CompletionHandler, Voice)} to
   * use a different voice.
   *
   * @param text Text message that is sent to the {@code TextToSpeech} service.
   * @param handler Notified when there's a response (or error) from the {@code TextToSpeech}
   *        service.
   */
  public void synthesize(String text, CompletionHandler<InputStream> handler) {
    synthesize(text, handler, Voice.EN_LISA);
  }

  /**
   * Sends a text message to the {@code TextToSpeech} service for conversion to a stream of audio
   * data.
   *
   * @param text Text message that is sent to the {@code TextToSpeech} service.
   * @param handler Notified when there's a response (or error) from the {@code TextToSpeech}
   *        service.
   * @param voice Voice persona for speaking the synthesized text.
   */
  public void synthesize(final String text, CompletionHandler<InputStream> handler, final Voice voice) {
    invokeService(new ServiceRequester<InputStream>() {
      @Override public InputStream request() throws ServiceResponseException {
        return ttsService.synthesize(text, voice).execute();
      }
    }, handler);
  }

  private <T> void invokeService(final ServiceRequester<T> requester, final CompletionHandler<T> handler) {
    executor.execute(new Runnable() {
      @Override public void run() {
        try {
          T result = requester.request();
          handler.onComplete(result, null);
        } catch (ServiceResponseException e) {
          handler.onComplete(null, e);
        }
      }
    });
  }

  private interface ServiceRequester<T> {
    T request() throws ServiceResponseException;
  }

  /**
   * Configures and creates a new {@link ConversationHelper} object.
   */
  public static class Builder {
    private final String workspaceId;
    private final String conversationApiVersion;
    private Conversation conversation;
    private SpeechToText sttService;
    private TextToSpeech ttsService;
    private Executor executor;

    /**
     * Creates a {@code Builder} for configuring a {@link ConversationHelper} with the specified
     * {@code workspaceId}.
     *
     * @param workspaceId Workspace ID for the Conversation Service
     */
    public Builder(String workspaceId, String conversationApiVersion) {
      this.workspaceId = workspaceId;
      if(this.workspaceId == null || this.workspaceId.isEmpty()){
        throw new IllegalArgumentException("The workspace id is a required parameter, it may not be null or empty");
      }
      this.conversationApiVersion = conversationApiVersion;
      if(this.conversationApiVersion == null || this.conversationApiVersion.isEmpty()){
        throw new IllegalArgumentException("The conversation api version is a required parameter, it may not be null or empty");
      }
    }

    /**
     * Provide a custom {@code Conversation} instance for the {@link ConversationHelper} to
     * use. This is necessary for configuring a service with a custom URL or auth credentials, for
     * instance.
     *
     * @param conversation Custom instance of {@code Conversation}.
     * @return This {@code Builder} for chaining.
     */
    public Builder conversation(Conversation conversation) {
      this.conversation = conversation;
      return this;
    }

    /**
     * Provide a custom {@code SpeechToText} instance for the {@link ConversationHelper} to use.
     * This is necessary for configuring a service with a custom URL or auth credentials, for
     * instance.
     *
     * @param sttService Custom instance of {@code SpeechToText}.
     * @return This {@code Builder} for chaining.
     */
    public Builder sttService(SpeechToText sttService) {
      this.sttService = sttService;
      return this;
    }

    /**
     * Provide a custom {@code TextToSpeech} instance for the {@link ConversationHelper} to use.
     * This is necessary for configuring a service with a custom URL or auth credentials, for
     * instance.
     *
     * @param ttsService Custom instance of {@code TextToSpeech}.
     * @return This {@code Builder} for chaining.
     */
    public Builder ttsService(TextToSpeech ttsService) {
      this.ttsService = ttsService;
      return this;
    }

    /**
     * Specify the thread of execution for work performed by the {@link ConversationHelper} class.
     * By default it will use a single, dedicated background thread for work. Controlling the
     * {@code Executor} to run on can be helpful for testing or when multiple calls need to run in
     * parallel.
     *
     * @param executor The {@code Executor} for the {@link ConversationHelper} to run its work on.
     * @return This {@code Builder} for chaining.
     */
    public Builder executor(Executor executor) {
      this.executor = executor;
      return this;
    }

    /**
     * @return New {@link ConversationHelper} based on the configured {@code Builder}.
     */
    public ConversationHelper build() {
      // provide sane defaults
      if (conversation == null)
        conversation = new Conversation(this.conversationApiVersion);
      if (sttService == null)
        sttService = new SpeechToText();
      if (ttsService == null)
        ttsService = new TextToSpeech();
      if (executor == null)
        executor = Executors.newSingleThreadExecutor();

      return new ConversationHelper(workspaceId, this.conversationApiVersion, executor, conversation, sttService, ttsService);
    }
  }
}
