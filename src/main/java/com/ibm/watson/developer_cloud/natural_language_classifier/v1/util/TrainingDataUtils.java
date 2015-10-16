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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.TrainingData;
import com.ibm.watson.developer_cloud.util.Validate;


/**
 * Utility class to transform training data to CSV.
 */
public class TrainingDataUtils {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(TrainingDataUtils.class.getName());

	/**
	 * Converts a training like argument list to a CSV representation.
	 * 
	 * @param data
	 *            the training data data
	 * @return the string with the CSV representation for the training data
	 */
	public static String toCSV(final TrainingData... data) {
		Validate.notEmpty(data, "data cannot be null or empty");

		StringWriter stringWriter = new StringWriter();
		try {
			CSVPrinter printer = new CSVPrinter(stringWriter, CSVFormat.EXCEL);
			for (TrainingData trainingData : data) {
				if (trainingData.getText() == null || trainingData.getClasses() == null
						|| trainingData.getClasses().isEmpty())
					log.log(Level.WARNING, trainingData + " couldn't be converted to a csv record");
				else {
					List<String> record = new ArrayList<String>();
					record.add(trainingData.getText());
					record.addAll(trainingData.getClasses());
					printer.printRecord(record.toArray());
				}
			}
			printer.close();
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error creating the csv", e);
		}

		return stringWriter.toString();
	}

	/**
	 * Creates the training data list based on a csv file. 
	 * File format needs to be UTF-8
	 *
	 * @param file            the CSV file
	 * @param format the CSV format. See <a href="https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVFormat.html">available formats</a>.
	 * @return the training data list
	 */
	public static List<TrainingData> fromCSV(final File file, CSVFormat format) {
		if (file == null || !file.exists())
			throw new IllegalArgumentException("file must exists and be different than null");

		List<TrainingData> trainingData = new ArrayList<TrainingData>();
		
		CSVParser parser;
		try {
			parser = CSVParser.parse(file,Charset.forName("UTF-8"), format);
		for (CSVRecord record : parser) {
			if (record.size() > 1){
				trainingData.add(getTrainigDataFromCSVRecord(record));
			} else {
				log.warning(record.toString() + "skiped.");
			}
		}
		} catch (IOException e) {
			log.log(Level.SEVERE,"Error parsing the CSV", e);
		}

		return trainingData;
	}

	/**
	 * Transform a {@link Record} into a {@link TrainingData}.
	 *
	 * @param record the record
	 * @return the trainig data from csv record
	 */
	private static TrainingData getTrainigDataFromCSVRecord(CSVRecord record) {
		TrainingData trainingData = new TrainingData();
		trainingData.setText(record.get(0));
		for (int i = 1; i < record.size(); i++) {
			trainingData.addClass(record.get(i));
		}
		return trainingData;
	}
}
