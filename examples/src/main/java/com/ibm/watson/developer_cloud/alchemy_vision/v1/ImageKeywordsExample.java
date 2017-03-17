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
package com.ibm.watson.developer_cloud.alchemy_vision.v1;


import java.io.File;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;

public class ImageKeywordsExample {

  public static void main(String[] args) {
    AlchemyVision service = new AlchemyVision();
    service.setApiKey("<api_key>");

    File image = new File("src/test/resources/alchemy/obama.jpg");
    ImageKeywords keywords = service.getImageKeywords(image, true, true).execute();

    System.out.println(keywords);
  }

}
