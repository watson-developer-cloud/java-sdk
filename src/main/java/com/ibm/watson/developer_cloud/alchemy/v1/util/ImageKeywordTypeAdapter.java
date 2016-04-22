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
package com.ibm.watson.developer_cloud.alchemy.v1.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeyword;

/**
 * Type adapter for the {@link ImageKeyword} class.
 */
public class ImageKeywordTypeAdapter extends TypeAdapter<ImageKeyword> {

  private static final String KNOWLEDGE_GRAPH = "knowledgeGraph";
  private static final String SCORE = "score";
  private static final String TEXT = "text";
  private static final String TYPE_HIERARCHY = "typeHierarchy";

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public ImageKeyword read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    final ImageKeyword ImageKeyword = new ImageKeyword();
    reader.beginObject();
    while (reader.hasNext()) {
      final String name = reader.nextName();

      if (name.equals(TEXT)) {
        final String text = reader.nextString();
        ImageKeyword.setText(text);
      } else if (name.equals(SCORE)) {
        final String score = reader.nextString();
        if (score != null && !score.isEmpty())
          ImageKeyword.setScore(Double.valueOf(score));
      } else if (name.equals(KNOWLEDGE_GRAPH)) {
        reader.beginObject();
        if (reader.hasNext() && reader.nextName().equals(TYPE_HIERARCHY)) {
          final String hierarchy = reader.nextString();
          ImageKeyword.setHierarchy(hierarchy);
        }
        while (reader.hasNext()) {
          reader.skipValue();
        }
        reader.endObject();
      } else {
        reader.skipValue();
      }
    }
    reader.endObject();
    return ImageKeyword;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, ImageKeyword value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }

    writer.beginObject();

    if (value.getScore() != null)
      writer.name(SCORE).value(value.getScore());
    if (value.getText() != null)
      writer.name(TEXT).value(value.getText());

    writer.endObject();
    writer.flush();
  }


}
