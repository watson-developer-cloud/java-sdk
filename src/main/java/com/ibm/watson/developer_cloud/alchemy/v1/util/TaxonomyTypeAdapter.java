/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.alchemy.v1.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy;

/**
 * The Class TaxonomyTypeAdapter.
 */
public class TaxonomyTypeAdapter extends TypeAdapter<Taxonomy> {

	/* (non-Javadoc)
	 * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
	 */
	@Override
	public Taxonomy read(JsonReader reader) throws IOException {
		if (reader.peek() == JsonToken.NULL) {
			reader.nextNull();
			return null;
		}

		Taxonomy taxonomy = new Taxonomy();
		taxonomy.setConfident(true);
		
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();

			if (name.equals("confident")) {
				String confidentAsString = reader.nextString();
				taxonomy.setConfident(confidentAsString == null || !confidentAsString.equals("no"));
			} else if (name.equals("label")) {
				String label = reader.nextString();
				taxonomy.setLabel(label);
			} else if (name.equals("score")) {
				Double score = reader.nextDouble();
				taxonomy.setScore(score);
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return taxonomy;
	}

	/* (non-Javadoc)
	 * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
	 */
	@Override
	public void write(JsonWriter writer, Taxonomy value) throws IOException {
		if (value == null) {
			writer.nullValue();
			return;
		}

		writer.beginObject();

		if (value.getScore() != null)
			writer.name("score").value(value.getScore());
		if (value.getConfident() != null)
			writer.name("confident").value(value.getConfident());
		if (value.getLabel() != null)
			writer.name("label").value(value.getLabel());

		writer.endObject();
		writer.flush();
	}

}
