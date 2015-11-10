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

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * The Text to Speech service uses IBM's speech synthesis capabilities to convert English or Spanish
 * text to an audio signal. The audio is streamed back to the client with minimal delay.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/text-to-speech.html">
 *      Text to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  /** The list voice type. */
  private final static Type listVoiceType = new TypeToken<List<Voice>>() {}.getType();

  /** The url. */
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
  public List<Voice> getVoices() {
    final Request request = RequestBuilder.get("/v1/voices").build();
    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<Voice> voices =
        GsonSingleton.getGson().fromJson(jsonObject.get("voices"), listVoiceType);
    return voices;
  }

  /**
   * Synthesize text using format.
   * 
   * @param text the text to synthesize
   * @param format the format, it needs to be an audio mime type, for example: audio/wav or
   *        audio/ogg; codecs=opus
   * @return the input stream with the synthesized audio
   */
  public InputStream synthesize(final String text, final String format) {
    return synthesize(text, Voice.EN_LISA, format);
  }

  /**
   * Synthesize text using a voice.
   * 
   * @param text the text to synthesize
   * @param voice the voice
   * @return the input stream
   */
  public InputStream synthesize(final String text, final Voice voice) {
    return synthesize(text, voice, HttpMediaType.AUDIO_WAV);
  }

  /**
   * Synthesize text using a voice and format.
   * 
   * @param text the text
   * @param voice the voice
   * @param format the output format
   * @return the input stream
   */
  public InputStream synthesize(final String text, final Voice voice, final String format) {
    if (text == null)
      throw new IllegalArgumentException("text cannot be null");
    if (voice == null)
      throw new IllegalArgumentException("voice cannot be null");

    final RequestBuilder request = RequestBuilder.get("/v1/synthesize");
    request.withQuery("text", text);
    request.withQuery("voice", voice.getName());

    if (format != null && !format.startsWith("audio/"))
      throw new IllegalArgumentException(
          "format needs to be an audio mime type, for example: audio/wav or audio/ogg; codecs=opus");

    request.withQuery("accept", format != null ? format : HttpMediaType.AUDIO_WAV);

    final Response response = execute(request.build());
    return ResponseUtil.getInputStream(response);
  }
}
