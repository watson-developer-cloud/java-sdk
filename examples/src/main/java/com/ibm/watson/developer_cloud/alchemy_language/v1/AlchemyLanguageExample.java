/**
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
package com.ibm.watson.developer_cloud.alchemy_language.v1;


import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

public class AlchemyLanguageExample {

  public static void main(String[] args) {
    AlchemyLanguage service = new AlchemyLanguage();
    service.setApiKey("<api_key>");

    Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, "IBM Watson won the Jeopardy television show hosted by Alex Trebek");

    // get sentiment
    DocumentSentiment sentiment = service.getSentiment(params).execute();
    System.out.println("Sentiment: " + sentiment);

    // get entities
    Entities entities = service.getEntities(params).execute();
    System.out.println("Entities: " + entities);

    // get typed relations
    TypedRelations relations = service.getTypedRelations(params).execute();
    System.out.println("Relations: " + relations);

  }

}
