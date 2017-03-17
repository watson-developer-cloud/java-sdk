/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.speech_to_text.v1.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechWordConfidence;

/**
 * Type adapter to transform word confidence from json into objects and viseversa..
 */
public class SpeechWordConfidenceTypeAdapter extends TypeAdapter<SpeechWordConfidence> {

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public SpeechWordConfidence read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    final SpeechWordConfidence speechWordConfidence = new SpeechWordConfidence();
    reader.beginArray();

    if (reader.peek() == JsonToken.STRING) {
      speechWordConfidence.setWord(reader.nextString());
    }
    if (reader.peek() == JsonToken.NUMBER) {
      speechWordConfidence.setConfidence(reader.nextDouble());
    }

    reader.endArray();
    return speechWordConfidence;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, SpeechWordConfidence speechWordConfidence) throws IOException {
    writer.beginArray();

    writer.value(speechWordConfidence.getWord());
    writer.value(speechWordConfidence.getConfidence());

    writer.endArray();
    writer.flush();
  }
}
