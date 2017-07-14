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
package com.ibm.watson.developer_cloud.personality_insights_v3_example;

import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;

public class PersonalityInsightsExample {

  public static void main(String[] args) {
    PersonalityInsights service = new PersonalityInsights("2016-10-19");
    service.setUsernameAndPassword("<username>", "<password>");

    String text = "Call me Ishmael. Some years ago-never mind how long "
        + "precisely-having little or no money in my purse, and nothing "
        + "particular to interest me on shore, I thought I would sail about "
        + "a little and see the watery part of the world. It is a way "
        + "I have of driving off the spleen and regulating the circulation. "
        + "Whenever I find myself growing grim about the mouth; whenever it "
        + "is a damp, drizzly November in my soul; whenever I find myself "
        + "involuntarily pausing before coffin warehouses, and bringing up "
        + "the rear of every funeral I meet; and especially whenever my "
        + "hypos get such an upper hand of me, that it requires a strong "
        + "moral principle to prevent me from deliberately stepping into "
        + "the street, and methodically knocking people's hats off-then, "
        + "I account it high time to get to sea as soon as I can.";

    ProfileOptions options = new ProfileOptions.Builder().text(text).build();
    Profile profile = service.profile(options).execute();

    System.out.println(profile);
  }
}
