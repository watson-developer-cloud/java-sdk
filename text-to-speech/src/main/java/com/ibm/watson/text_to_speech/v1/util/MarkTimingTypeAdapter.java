package com.ibm.watson.text_to_speech.v1.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.text_to_speech.v1.model.MarkTiming;
import java.io.IOException;

public class MarkTimingTypeAdapter extends TypeAdapter<MarkTiming> {
  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public MarkTiming read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }

    final MarkTiming markTiming = new MarkTiming();
    in.beginArray();

    if (in.peek() == JsonToken.STRING) {
      markTiming.setMark(in.nextString());
    }
    if (in.peek() == JsonToken.NUMBER) {
      markTiming.setTime(in.nextDouble());
    }

    in.endArray();
    return markTiming;
  }

  /*
   * (non-Javadoc)
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter out, MarkTiming markTiming) throws IOException {
    out.beginArray();

    out.value(markTiming.getMark());
    out.value(markTiming.getTime());

    out.endArray();
    out.flush();
  }
}
