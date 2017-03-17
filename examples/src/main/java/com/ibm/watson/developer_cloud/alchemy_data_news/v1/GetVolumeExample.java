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
package com.ibm.watson.developer_cloud.alchemy_data_news.v1;


import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.VolumeResult;

/**
 * Getting The number for ingested documents in the last 7 days with a 12 hour period using the {@link AlchemyDataNews}
 * API.
 *
 */
public class GetVolumeExample {

  public static void main(String[] args) {
    AlchemyDataNews service = new AlchemyDataNews();
    service.setApiKey("<api_key>");

    VolumeResult result = service.getVolume("now-7d", "now", "12h").execute();

    System.out.println(result);
  }

}
