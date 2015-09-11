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
package com.ibm.watson.developer_cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Before;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * Utility class to test the Watson Services.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public abstract class WatsonServiceTest {

	/**
	 * Gets the string from input stream.
	 *
	 * @param is the input stream
	 * @return the string from input stream
	 */
	public static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	/** The prop. */
	protected Properties prop = new Properties();

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		String filename = "config.properties";
		InputStream input = WatsonServiceTest.class.getClassLoader().getResourceAsStream(filename);
		if(input == null)
			throw new RuntimeException(filename + " was not found.");

		//load a properties file from class path, inside static method
		prop.load(input);

		setupLogging();
	}

	/**
	 * Setup logging.
	 */
	private void setupLogging() {
		java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);
		java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(java.util.logging.Level.FINEST);
		
		// set logging level		
		Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.OFF);

//		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
//		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
//		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
//		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
//		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.conn", "debug");
//		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.client", "debug");
	}

}
