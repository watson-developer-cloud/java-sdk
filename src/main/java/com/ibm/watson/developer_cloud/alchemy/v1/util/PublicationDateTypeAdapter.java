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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.alchemy.v1.model.PublicationDate;

/**
 * The Class PublicationDateTypeAdapter.
 */
public class PublicationDateTypeAdapter extends TypeAdapter<PublicationDate> {

  /** The Constant LOG. */
  private static final Logger LOG = Logger.getLogger(PublicationDateTypeAdapter.class.getName());

  /** The dateFormat. */
  private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");


  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public PublicationDate read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    final PublicationDate publicationDate = new PublicationDate();
    publicationDate.setConfident(true);
    reader.beginObject();
    while (reader.hasNext()) {
      final String name = reader.nextName();

      if (name.equals("confident")) {
        final String confidentAsString = reader.nextString();
        publicationDate.setConfident(confidentAsString != null && !confidentAsString.equals("no")
            && !confidentAsString.equals("false"));
      } else if (name.equals("date")) {
        final String dateAsString = reader.nextString();
        if (dateAsString != null && !dateAsString.isEmpty())
          try {
            publicationDate.setDate(dateFormat.parse(dateAsString));
          } catch (final ParseException e) {
            LOG.log(Level.SEVERE, "Error parsing: " + dateAsString, e);
          }
      } else {
        reader.skipValue();
      }
    }
    reader.endObject();
    return publicationDate;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, PublicationDate value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }

    writer.beginObject();

    if (value.getDate() != null)
      writer.name("date").value(dateFormat.format(value.getDate()));
    if (value.getConfident() != null)
      writer.name("confident").value(String.valueOf(value.getConfident() ? "yes" : "no"));

    writer.endObject();
    writer.flush();
  }

}
