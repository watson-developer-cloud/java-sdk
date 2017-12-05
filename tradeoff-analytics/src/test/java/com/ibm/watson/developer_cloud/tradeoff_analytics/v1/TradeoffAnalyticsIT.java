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

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.CategoricalColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.Goal;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.DateColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;

/**
 * The Class TradeoffAnalyticsTest.
 */
public class TradeoffAnalyticsIT extends WatsonServiceTest {

  /** The problem. */
  private Problem problem;

  /** The service. */
  private TradeoffAnalytics service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Ignore
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    String username = getProperty("tradeoff_analytics.username");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new TradeoffAnalytics();
    service.setUsernameAndPassword(username, getProperty("tradeoff_analytics.password"));
    service.setEndPoint(getProperty("tradeoff_analytics.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    problem = loadFixture("src/test/resources/tradeoff_analytics/problem.json", Problem.class);
  }

  /**
   * Test dilemmas.
   */
  @Ignore
  @Test
  public void testDilemmas() {
    Dilemma dilemma = service.dilemmas(problem, true).execute();
    assertNotNull(dilemma);
    assertNotNull(dilemma.getProblem());
    assertNotNull(dilemma.getResolution());
    assertNotNull(dilemma.getResolution().getMap());
    assertNotNull(dilemma.getResolution().getSolutions());
    assertNotNull(dilemma.getResolution().getMap().getAnchors());
    assertNotNull(dilemma.getResolution().getMap().getNodes());
    assertNotNull(dilemma.getResolution().getMap().getVersion());
  }

  /**
   * Test dilemmas.
   */
  @Ignore
  @Test
  public void testDilemmasWithProblem() {
    Problem problem = new Problem("phone");

    String price = "price";
    String ram = "ram";
    String screen = "screen";

    String os = "OS";
    String android = "Android";
    String windows = "Windows Phone";
    String blackberry = "BlackBerry";
    String ios = "IOS";

    // Define the objectives
    List<Column> columns = new ArrayList<Column>();
    problem.setColumns(columns);

    columns.add(new NumericColumn().range(0, 100).key(price).goal(Goal.MIN).objective(true));
    columns.add(new NumericColumn().key(screen).goal(Goal.MAX).objective(true));
    columns.add(new NumericColumn().key(ram).goal(Goal.MAX));

    CategoricalColumn osColumn = new CategoricalColumn();
    osColumn.key(os).goal(Goal.MIN).objective(true);
    osColumn.range(Arrays.asList(android, windows, blackberry, ios));
    osColumn.setPreference(Arrays.asList(android, ios));
    columns.add(osColumn);

    // Define the options to choose
    List<Option> options = new ArrayList<Option>();
    problem.setOptions(options);

    HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
    galaxySpecs.put(price, 50);
    galaxySpecs.put(ram, 45);
    galaxySpecs.put(screen, 5);
    galaxySpecs.put(os, android);
    options.add(new Option("1", "Galaxy S4").values(galaxySpecs));

    HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
    iphoneSpecs.put(price, 99);
    iphoneSpecs.put(ram, 40);
    iphoneSpecs.put(screen, 4);
    iphoneSpecs.put(os, ios);
    options.add(new Option("2", "iPhone 5").values(iphoneSpecs));

    HashMap<String, Object> optimusSpecs = new HashMap<String, Object>();
    optimusSpecs.put(price, 10);
    optimusSpecs.put(ram, 300);
    optimusSpecs.put(screen, 5);
    optimusSpecs.put(os, android);
    options.add(new Option("3", "LG Optimus G").values(optimusSpecs));

    // Call the service and get the resolution
    Dilemma dilemma = service.dilemmas(problem, false).execute();
    assertNotNull(dilemma);
    assertNotNull(dilemma.getProblem());
    assertNotNull(dilemma.getResolution());
  }

  /**
   * Test example.
   *
   * @throws Exception the exception
   */
  @Ignore
  @Test
  public void testExample() throws Exception {

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
    assertNotNull(dilemma);
  }

  /**
   * Test for data columns.
   *
   * @throws Exception the exception
   */
  @Ignore
  @Test
  public void testForDataColumns() throws Exception {

    // Define the objectives.
    String price = "price";
    String weight = "weight";
    String brand = "brand";
    String rDate = "rDate";

    List<String> categories = new ArrayList<String>();
    categories.add("Apple");
    categories.add("HTC");
    categories.add("Samsung");

    List<String> preferences = new ArrayList<String>();
    preferences.add("Samsung");
    preferences.add("Apple");
    preferences.add("HTC");

    NumericColumn priceColumn = new NumericColumn();
    priceColumn.key(price);
    priceColumn.goal(Goal.MIN);
    priceColumn.objective(true);
    priceColumn.fullName("Price");
    priceColumn.range(0, 400);
    priceColumn.setFormat("number:2");

    NumericColumn weightColumn = new NumericColumn();
    weightColumn.key(weight);
    weightColumn.goal(Goal.MIN);
    weightColumn.objective(true);
    weightColumn.fullName("Weight");
    weightColumn.setFormat("number:0");

    CategoricalColumn brandColumn = new CategoricalColumn();
    brandColumn.key(brand);
    brandColumn.goal(Goal.MIN);
    brandColumn.objective(true);
    brandColumn.fullName("Brand");
    brandColumn.setRange(categories);
    brandColumn.setPreference(preferences);

    DateColumn rDateColumn = new DateColumn();
    rDateColumn.key(rDate);
    rDateColumn.goal(Goal.MAX);
    rDateColumn.fullName("Release Date");
    rDateColumn.setFormat("date: 'MMM dd, yyyy'");

    List<Column> columns = new ArrayList<Column>();
    columns.add(priceColumn);
    columns.add(weightColumn);
    columns.add(brandColumn);
    columns.add(rDateColumn);

    Problem problem = new Problem("phones");
    problem.setColumns(columns);

    // Define the options.
    List<Option> options = new ArrayList<Option>();
    problem.setOptions(options);

    HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
    galaxySpecs.put(price, 249);
    galaxySpecs.put(weight, 130);
    galaxySpecs.put(brand, "Samsung");
    galaxySpecs.put(rDate, "2013-04-29T00:00:00Z");
    options.add(new Option("1", "Samsung Galaxy S4").values(galaxySpecs));

    HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
    iphoneSpecs.put(price, 449);
    iphoneSpecs.put(weight, 112);
    iphoneSpecs.put(brand, "Apple");
    iphoneSpecs.put(rDate, "2012-09-21T00:00:00Z");
    options.add(new Option("2", "Apple iPhone 5").values(iphoneSpecs));

    HashMap<String, Object> oneSpecs = new HashMap<String, Object>();
    oneSpecs.put(price, 299);
    oneSpecs.put(weight, 143);
    oneSpecs.put(brand, "HTC");
    oneSpecs.put(rDate, "2013-03-01T00:00:00Z");
    options.add(new Option("3", "HTC One").values(oneSpecs));

    // Call the service and get the resolution
    Dilemma dilemma = service.dilemmas(problem, false).execute();
    assertNotNull(dilemma);
    assertNotNull(dilemma.getProblem());
    assertNotNull(dilemma.getResolution());
  }

}
