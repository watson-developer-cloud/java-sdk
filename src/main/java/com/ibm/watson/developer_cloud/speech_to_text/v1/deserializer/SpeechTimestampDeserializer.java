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

package com.ibm.watson.developer_cloud.speech_to_text.v1.deserializer;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechTimestamp;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


public class SpeechTimestampDeserializer implements JsonDeserializer<List<SpeechTimestamp>> {
  @Override
  public List<SpeechTimestamp> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    List<SpeechTimestamp> list = new List<SpeechTimestamp>(){};

    for(JsonElement element : json.getAsJsonArray()) {
      String word = element.getAsJsonArray().get(0).getAsString();
      float start = element.getAsJsonArray().get(1).getAsFloat();
      float end = element.getAsJsonArray().get(2).getAsFloat();
      list.add(new SpeechTimestamp(word, start, end));
    }

    return list;
  }
}
