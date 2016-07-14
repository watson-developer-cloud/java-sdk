package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Focuson on 16-7-13.
 */
public class WordAlternativeTypeAdapter extends TypeAdapter<WordAlternative> {
    @Override
    public void write(JsonWriter writer, WordAlternative value) throws IOException {
        writer.beginObject();

        writer.name("confidence");
        writer.value(value.getConfidence());
        writer.name("word");
        writer.value(value.getWord());

        writer.endObject();
        writer.flush();
    }

    @Override
    public WordAlternative read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        Double confidence = null;
        String word = null;

        List<WordAlternative> alternatives = new LinkedList<WordAlternative>();

        reader.beginObject();

        if(reader.nextName().equals("confidence")) {
            confidence = reader.nextDouble();
        }
        if (reader.nextName().equals("word")) {
            word = reader.nextString();
        }

        reader.endObject();

        WordAlternative wordAlternative = new WordAlternative(confidence, word);
        return wordAlternative;
    }
}