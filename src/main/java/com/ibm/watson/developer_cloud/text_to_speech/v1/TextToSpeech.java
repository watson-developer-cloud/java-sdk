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

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Request;


/**
 * The Text to Speech service uses IBM's speech synthesis capabilities to convert text to an audio
 * signal. The audio is streamed back to the client in a {@link InputStream}
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/text-to-speech.html"> Text
 *      to Speech</a>
 */
public class TextToSpeech extends WatsonService {

  private static final String ACCEPT = "accept";
  private static final String PATH_VOICES = "/v1/voices";
  private static final String PATH_VOICE = "/v1/voices/%s";
  private static final String PATH_SYNTHESIZE = "/v1/synthesize";
  private static final String PATH_GET_PRONUNCIATION = "/v1/pronunciation";
  private static final String SERVICE_NAME = "text_to_speech";
  private static final String TEXT = "text";
  private static final Type TYPE_GET_VOICES = new TypeToken<List<Voice>>() {}.getType();
  private final static String URL = "https://stream.watsonplatform.net/text-to-speech/api";
  private static final String VOICE = "voice";
  private static final String VOICES = "voices";
  private static final String FORMAT = "format";
  private static final String CUSTOMIZATION_ID = "customization_id";
  
  private final Customizations customizations;

  /**
   * Instantiates a new text to speech.
   */
  public TextToSpeech() {
    super(SERVICE_NAME);
    setEndPoint(URL);
    
    customizations = new Customizations(this);
  }

  /**
   * Gets the voices.
   * 
   * @return the list of {@link Voice}
   */
  public ServiceCall<List<Voice>> getVoices() {
    final Request request = RequestBuilder.get(PATH_VOICES).build();
    ResponseConverter<List<Voice>> converter = ResponseConverterUtils.getGenericObject(TYPE_GET_VOICES, VOICES);
    return createServiceCall(request, converter);
  }

  /**
   *  Gets the voice based on a given name.
   *
   *  @param voiceName the voice name
   *  @return the {@link Voice}
   */
  public ServiceCall<Voice> getVoice(final String voiceName) {
    Validator.notNull(voiceName, "name can not be null");

    Request request = RequestBuilder.get(String.format(PATH_VOICE, voiceName)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Voice.class));
  }

  /**
   * Returns the phonetic pronunciation for the <code>word</code> specified.
   *
   * @param word The word for which the pronunciation is requested.
   * @param voice the voice to obtain the pronunciation for the specified word in the language of
   *        that voice.
   * @param phoneme the phoneme set in which to return the pronunciation
   * @return the word pronunciation
   * @see Pronunciation
   */
  public ServiceCall<Pronunciation> getPronunciation(String word, Voice voice, Phoneme phoneme) {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_GET_PRONUNCIATION).query(TEXT, word);
    if (voice != null)
      requestBuilder.query(VOICE, voice.getName());
    if (phoneme != null)
      requestBuilder.query(FORMAT, phoneme);

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Pronunciation.class));
  }

  /**
   * Synthesize text using a voice.
   * 
   * @param text the text to synthesize
   * @param voice the voice
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice) {
    return synthesize(text, voice, null);
  }

  /**
   * Synthesize text using a {@link Voice} and {@link AudioFormat}.
   * 
   * @param text the text
   * @param voice the voice
   * @param audioFormat the {@link AudioFormat}
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final AudioFormat audioFormat) {
    return synthesize(text, voice, audioFormat, null);
  }
  
  /**
   * Synthesize text using a {@link Voice} and {@link AudioFormat}.
   * 
   * @param text the text
   * @param voice the voice
   * @param audioFormat the {@link AudioFormat}
   * @param customizationId the customization ID
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final AudioFormat audioFormat,
      String customizationId) {
    Validator.isTrue(text != null && !text.isEmpty(), "text cannot be null or empty");
    Validator.isTrue(voice != null, "voice cannot be null or empty");

    final RequestBuilder request = RequestBuilder.get(PATH_SYNTHESIZE);
    request.query(TEXT, text);
    request.query(VOICE, voice.getName());
    request.query(ACCEPT, audioFormat != null ? audioFormat : AudioFormat.WAV);

    if (customizationId != null) {
      request.query(CUSTOMIZATION_ID, customizationId);
    }

    return createServiceCall(request.build(), ResponseConverterUtils.getInputStream());
  }

  /**
   * Gets the Customizations service, which manages custom voice models and word
   * pronunciations.
   * 
   * @return the Customizations service
   */
  public Customizations getCustomizations() {
    return customizations;
  }

  /**
   * Creates the service call.
   * 
   * This method has been added to TextToSpeech, because Customizations uses it as proxy for making API requests.
   *
   * @param <T> the generic type
   * @param request the request
   * @param converter the converter
   * @return the service call
   */
  protected <T> ServiceCall<T> createNewServiceCall(final Request request, final ResponseConverter<T> converter) {
    return super.createServiceCall(request, converter);
  }
  
}
