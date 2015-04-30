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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;

public class TradeoffAnalyticsExample {


	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		TradeoffAnalytics service = new TradeoffAnalytics();
		service.setUsernameAndPassword("<username>", "<password>");

		Problem problem = new Problem("phone");

		// Define the objectives
		List<Column> columns = new ArrayList<Column>();
		problem.setColumns(columns);
		columns.add(new Column("price", "Price", "NUMERIC", true, "MIN"));
		columns.add(new Column("ram", "Ram", "NUMERIC", false, "MAX"));
		columns.add(new Column("screen", "Screen", "NUMERIC", true, "MAX"));

		// Define the options to choose
		List<Option> options = new ArrayList<Option>();
		problem.setOptions(options);

		HashMap<String, String> galaxySpecs = new HashMap<String, String>();
		galaxySpecs.put("price", "300");
		galaxySpecs.put("ram", "45");
		galaxySpecs.put("screen", "5");
		options.add(new Option("1", "Galaxy S4", galaxySpecs, ""));

		HashMap<String, String> iphoneSpecs = new HashMap<String, String>();
		iphoneSpecs.put("price", "400");
		iphoneSpecs.put("ram", "40");
		iphoneSpecs.put("screen", "4");
		options.add(new Option("2", "iPhone 5", iphoneSpecs, ""));

		HashMap<String, String> optimusSpecs = new HashMap<String, String>();
		optimusSpecs.put("price", "300");
		optimusSpecs.put("ram", "300");
		optimusSpecs.put("screen", "5");
		options.add(new Option("3", "LG Optimus G", optimusSpecs, ""));

		// Call the service and get the resolution
		Dilemma dilemma = service.dilemmas(problem);

		System.out.println(dilemma);
	}
}
