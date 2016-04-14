/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.ResponseConverter;
import com.ibm.watson.developer_cloud.service.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 * The Text to Speech service uses IBM's speech synthesis capabilities to convert English or Spanish
 * text to an audio signal. The audio is streamed back to the client with minimal delay.
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/text-to-speech.html"> Text
 *      to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  private static final String ACCEPT = "accept";
  private static final String VOICE = "voice";
  private static final String TEXT = "text";
  private static final String PATH_SYNTHESIZE = "/v1/synthesize";
  private final static Type listVoiceType = new TypeToken<List<Voice>>() {}.getType();
  private final static String URL = "https://stream.watsonplatform.net/text-to-speech/api";


  /**
   * Instantiates a new text to speech.
   */
  public TextToSpeech() {
    super("text_to_speech");
    setEndPoint(URL);
  }

  /**
   * Gets the voices.
   * 
   * @return the list of {@link Voice}
   */
  public ServiceCall<List<Voice>> getVoices() {
    final okhttp3.Request request = RequestBuilder.get("/v1/voices").build3();
    return createServiceCall(createCall(request), ResponseUtil.getVoiceListConverter(listVoiceType));
  }

  /**
   * Synthesize text using a provided format
   * 
   * @param text the text to synthesize
   * @param format the format, it needs to be an audio mime type, for example: audio/wav or
   *        audio/ogg; codecs=opus
   * @return the input stream with the synthesized audio doesn't have the content-length set.
   */
  public ServiceCall<InputStream> synthesize(final String text, final String format) {
    return synthesize(text, Voice.EN_LISA, format);
  }

  /**
   * Synthesize text using a voice.
   * 
   * @param text the text to synthesize
   * @param voice the voice
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice) {
    return synthesize(text, voice, HttpMediaType.AUDIO_WAV);
  }

  /**
   * Synthesize text using a voice and format.
   * 
   * @param text the text
   * @param voice the voice
   * @param outputFormat the output format. e.g: audio/wav or audio/ogg; codecs=opus
   * @return the input stream
   */
  private okhttp3.Request synthesizeRequest(final String text, final Voice voice, final String outputFormat) {
    Validate.isTrue(text != null && !text.isEmpty(), "text cannot be null or empty");
    Validate.isTrue(voice != null, "voice cannot be null or empty");

    final RequestBuilder request = RequestBuilder.get(PATH_SYNTHESIZE);
    request.withQuery(TEXT, text);
    request.withQuery(VOICE, voice.getName());

    if (outputFormat != null && !outputFormat.startsWith("audio/"))
      throw new IllegalArgumentException(
              "format needs to be an audio mime type, for example: audio/wav or audio/ogg; codecs=opus");

    request.withQuery(ACCEPT, outputFormat != null ? outputFormat : HttpMediaType.AUDIO_WAV);

    return request.build3();
  }

  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final String outputFormat) {
    return createServiceCall(createCall(synthesizeRequest(text, voice, outputFormat)),
        new ResponseConverter<InputStream>() {
          @Override public InputStream convert(okhttp3.Response response) {
            return ResponseUtil.getInputStream(response);
          }
        });
  }
}
