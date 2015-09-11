package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.google.common.collect.Lists;

/**
 * Utility class to transform training data to CSV
 */
public class TrainingDataUtils {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(TrainingDataUtils.class.getName());

	/**
	 * Converts a training like argument list to a CSV representation.
	 *
	 * @param data the training data data
	 * @return the string with the CSV representation fo the training data 
	 */
	public static String toCSV(final TrainingData... data) {
		if (data == null || data.length == 0)
			throw new IllegalArgumentException("data can't be null or empty");
		
		StringWriter stringWriter = new StringWriter();
		try {
			CSVPrinter printer = new CSVPrinter(stringWriter, CSVFormat.EXCEL);
			for (TrainingData trainingData : data) {
				if (trainingData.getText() == null || trainingData.getClasses() == null || trainingData.getClasses().isEmpty())
					log.log(Level.WARNING, trainingData +  " couldn't be converted to a csv record");
				else {
					List<String> record = Lists.newArrayList(trainingData.getText());
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
}
