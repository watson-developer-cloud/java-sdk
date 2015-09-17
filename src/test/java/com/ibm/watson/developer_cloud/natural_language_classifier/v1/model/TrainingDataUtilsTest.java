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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.io.File;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.junit.Assert;
import org.junit.Test;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.util.TrainingDataUtils;

/**
 * Test for {@link TrainingDataUtils}.
 */
public class TrainingDataUtilsTest {

	/**
	 * Test for POJO to CSV conversion.
	 */
	@Test
	public void testToCSV() {
    	Assert.assertEquals("foo,class1,class2,class3\r\nfoo2,class3\r\nfoo3,class3\r\n",
    			TrainingDataUtils.toCSV(new TrainingData().withText("foo").withClasses("class1","class2","class3"),
    			new TrainingData().withText("foo2").withClasses("class3"),
    			new TrainingData().withText("foo3").withClasses("class3"),
    			new TrainingData().withText("foo4"),
    			new TrainingData().withClasses("class4")));
	}

	/**
	 * Test conversion from CSV to training data.
	 */
	@Test
	public void testToTrainingData() {
		File file = new File("src/test/resources/weather_data_train.csv");
		List<TrainingData> trainingData = TrainingDataUtils.fromCSV(file, CSVFormat.DEFAULT);
		System.out.println(trainingData);
		Assert.assertNotNull(trainingData);
		Assert.assertNotEquals(0,trainingData.size());
	}
	
}
