/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
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
 * Created by nizar on 9/2/15.
 */
public class AlchemyEndPoints {

    /**
     * The Constant log.
     */
    private static final Logger log = Logger.getLogger(AlchemyEndPoints.class.getName());

    private static final String filePath = "src/main/resources/alchemy_endpoints.json";

    private static Map<String,Map<String,String>> endPoints;

    public enum AlchemyAPI {url, html, text,image }

    public enum AlchemyObjects {
        entities, keywords, concepts, sentiment, sentiment_targeted,
        category, relations, language, text, text_raw, authors,author, feeds,
        microformats, title,taxonomy, combined, image_link,
        image_keywords, image_recognition
    }

    private static void loadEndPointsFromJsonFile() {
        log.log(Level.INFO, "Parsing End Points JSON file ");
        endPoints = new HashMap<String, Map<String, String>>();
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JsonObject jsonObject = (JsonObject) obj;
            for (AlchemyObjects object : AlchemyObjects.values()) {
                if(jsonObject.get(object.name())==null) continue;;
                JsonElement elt = jsonObject.get(object.name()).getAsJsonObject();
                if (elt.isJsonObject()) {
                    Map<String, String> records = new HashMap<String, String>();
                    for (Map.Entry<String, JsonElement> e : elt.getAsJsonObject().entrySet()) {
                        records.put(e.getKey(), e.getValue().getAsString());
                    }
                    endPoints.put(object.name(),records);
                }
            }
        } catch (JsonParseException e) {
            log.log(Level.SEVERE, "Could not parse Alchemy json end points file " + filePath, e);
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "Could not parse Alchemy json end points file " + filePath, e);
        }
    }

    public static String getAlchemyAPI(String objectName,String apiType) {
        if(endPoints==null || endPoints.isEmpty())
            loadEndPointsFromJsonFile();
        Map<String,String> alchemyAPI = endPoints.get(objectName);
        return alchemyAPI.get(apiType);
    }

    public static void main(String[] args) {
        loadEndPointsFromJsonFile();
    }

}
