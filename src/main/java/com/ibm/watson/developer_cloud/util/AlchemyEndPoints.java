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
package com.ibm.watson.developer_cloud.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class AlchemyEndPoints.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class AlchemyEndPoints {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(AlchemyEndPoints.class.getName());

	/**  The file where alchemy endpoints are described. */
	private static final String filePath = "src/main/resources/alchemy_endpoints.json";

	/** The alchemy operations. */
	private static Map<String, Map<String, String>> operations;

	static {
		loadEndPointsFromJsonFile();
	}

	/**
	 * The AlchemyOperations.
	 */
	public enum AlchemyAPI {
		
		/** The entities. */
		entities,
		
		/** The keywords. */
		keywords,
		
		/** The concepts. */
		concepts,
		
		/** The sentiment. */
		sentiment,
		
		/** The sentiment_targeted. */
		sentiment_targeted,
		
		/** The relations. */
		relations,
		
		/** The language. */
		language,
		
		/** The text. */
		text,
		
		/** The text_raw. */
		text_raw,
		
		/** The authors. */
		authors,
		
		/** The feeds. */
		feeds,
		
		/** The microformats. */
		microformats,
		
		/** The title. */
		title,
		
		/** The taxonomy. */
		taxonomy,
		
		/** The combined. */
		combined,
		
		/** The image_link. */
		image_link,
		
		/** The image_keywords. */
		image_keywords,
		
		/** The image_recognition. */
		image_recognition
	}

	/**
	 * Load the endpoints from json file.
	 */
	private static void loadEndPointsFromJsonFile() {
		log.log(Level.FINE, "Parsing End Points JSON file ");
		operations = new HashMap<String, Map<String, String>>();
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(filePath));
			JsonObject jsonObject = (JsonObject) obj;
			for (AlchemyAPI object : AlchemyAPI.values()) {
				if (jsonObject.get(object.name()) == null)
					continue;;
				JsonElement elt = jsonObject.get(object.name()).getAsJsonObject();
				if (elt.isJsonObject()) {
					Map<String, String> records = new HashMap<String, String>();
					for (Map.Entry<String, JsonElement> e : elt.getAsJsonObject().entrySet()) {
						records.put(e.getKey(), e.getValue().getAsString());
					}
					operations.put(object.name(), records);
				}
			}
		} catch (JsonParseException e) {
			log.log(Level.SEVERE, "Could not parse json file: " + filePath, e);
		} catch (FileNotFoundException e) {
			log.log(Level.SEVERE, "File not found: " + filePath, e);
		}
	}

	/**
	 * Gets the path based on the operation and input type.
	 *
	 * @param operation            the operation
	 * @param inputType            the input type
	 * @return the string that represent the path based on the operation
	 * and input type
	 */
	public static String getPath(AlchemyAPI operation, String inputType) {
		if ((operations.get(operation.name()) != null) && operations.get(operation.name()).get(inputType) != null)
			return operations.get(operation.name()).get(inputType);
		else {
			String error = "Operation: "+ operation + ", inputType: "+inputType+" not found";
			log.log(Level.SEVERE,error);
            throw new IllegalArgumentException(error);
		}
	}

}
