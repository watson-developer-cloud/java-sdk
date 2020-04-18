package com.ibm.watson.text_to_speech.v1.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.text_to_speech.v1.model.WordTiming;
import java.io.IOException;

public class WordTimingTypeAdapter extends TypeAdapter<WordTiming> {
  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public WordTiming read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }

    final WordTiming wordTiming = new WordTiming();
    in.beginArray();

    if (in.peek() == JsonToken.STRING) {
      wordTiming.setWord(in.nextString());
    }
    if (in.peek() == JsonToken.NUMBER) {
      wordTiming.setStartTime(in.nextDouble());
    }
    if (in.peek() == JsonToken.NUMBER) {
      wordTiming.setEndTime(in.nextDouble());
    }

    in.endArray();
    return wordTiming;
  }

  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter out, WordTiming wordTiming) throws IOException {
    out.beginArray();

    out.value(wordTiming.getWord());
    out.value(wordTiming.getStartTime());
    out.value(wordTiming.getEndTime());

    out.endArray();
    out.flush();
  }
}
