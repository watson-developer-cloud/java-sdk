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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechTimestamp;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechWordConfidence;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechTimestampTypeAdapter;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechWordConfidenceTypeAdapter;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;

/**
 * Tests for several TypeAdapters.
 */
public class TypeAdaptersTest {

  /**
   * Tests null (de)serialization of LongToDateTypeAdapter.
   */
  @Test
  public void testLongToDateNull() {
    final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new LongToDateTypeAdapter()).create();
    final List<Date> values = Collections.singletonList(null);
    final Type type = new TypeToken<List<Date>>() { }.getType();
    final String json = "[null]";

    assertEquals("[null]", gson.toJson(values));
    assertEquals(values, gson.fromJson(json, type));
  }

  /**
   * Tests serialization of {@link SpeechTimestampTypeAdapter}.
   */
  @Test
  public void testSpeechTimestampTypeAdapter() {
    final Gson gson =
        new GsonBuilder().registerTypeAdapter(SpeechTimestamp.class, new SpeechTimestampTypeAdapter()).create();
    final String json = "[\"test\",1.1,2.3]";
    final SpeechTimestamp value = new SpeechTimestamp();
    value.setWord("test");
    value.setStartTime(1.1);
    value.setEndTime(2.3);

    assertEquals(json, gson.toJson(value));
  }

  /**
   * Tests serialization of {@link SpeechWordConfidenceTypeAdapter}.
   */
  @Test
  public void testSpeechWordConfidenceTypeAdapter() {
    final Gson gson = new GsonBuilder()
        .registerTypeAdapter(SpeechWordConfidence.class, new SpeechWordConfidenceTypeAdapter()).create();
    final String json = "[\"test\",0.6]";
    final SpeechWordConfidence value = new SpeechWordConfidence();
    value.setWord("test");
    value.setConfidence(0.6);

    assertEquals(json, gson.toJson(value));
  }

}
