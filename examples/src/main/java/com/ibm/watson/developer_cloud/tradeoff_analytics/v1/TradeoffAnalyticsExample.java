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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.Goal;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;

public class TradeoffAnalyticsExample {

  public static void main(String[] args) {
    TradeoffAnalytics service = new TradeoffAnalytics();
    service.setUsernameAndPassword("<username>", "<password>");

    Problem problem = new Problem("phone");

    String price = "price";
    String ram = "ram";
    String screen = "screen";

    // Define the objectives
    List<Column> columns = new ArrayList<Column>();
    problem.setColumns(columns);

    columns.add(new NumericColumn().range(0, 100).key(price).goal(Goal.MIN).objective(true));
    columns.add(new NumericColumn().key(screen).goal(Goal.MAX).objective(true));
    columns.add(new NumericColumn().key(ram).goal(Goal.MAX));

    // Define the options to choose
    List<Option> options = new ArrayList<Option>();
    problem.setOptions(options);

    HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
    galaxySpecs.put(price, 50);
    galaxySpecs.put(ram, 45);
    galaxySpecs.put(screen, 5);
    options.add(new Option("1", "Galaxy S4").values(galaxySpecs));

    HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
    iphoneSpecs.put(price, 99);
    iphoneSpecs.put(ram, 40);
    iphoneSpecs.put(screen, 4);
    options.add(new Option("2", "iPhone 5").values(iphoneSpecs));

    HashMap<String, Object> optimusSpecs = new HashMap<String, Object>();
    optimusSpecs.put(price, 10);
    optimusSpecs.put(ram, 300);
    optimusSpecs.put(screen, 5);
    options.add(new Option("3", "LG Optimus G").values(optimusSpecs));

    // Call the service and get the resolution
    Dilemma dilemma = service.dilemmas(problem).execute();

    System.out.println(dilemma);
  }
}
