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
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechTimestamp;

/**
 * Type adapter to transform timestamp from json into objects and viseversa.
 */
public class SpeechTimestampTypeAdapter extends TypeAdapter<SpeechTimestamp> {

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public SpeechTimestamp read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    final SpeechTimestamp speechTimestamp = new SpeechTimestamp();
    reader.beginArray();

    if (reader.peek() == JsonToken.STRING) {
      speechTimestamp.setWord(reader.nextString());
    }
    if (reader.peek() == JsonToken.NUMBER) {
      speechTimestamp.setStartTime(reader.nextDouble());
    }
    if (reader.peek() == JsonToken.NUMBER) {
      speechTimestamp.setEndTime(reader.nextDouble());
    }

    reader.endArray();
    return speechTimestamp;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, SpeechTimestamp speechTimestamp) throws IOException {
    writer.beginArray();

    writer.value(speechTimestamp.getWord());
    writer.value(speechTimestamp.getStartTime());
    writer.value(speechTimestamp.getEndTime());

    writer.endArray();
    writer.flush();
  }
}
