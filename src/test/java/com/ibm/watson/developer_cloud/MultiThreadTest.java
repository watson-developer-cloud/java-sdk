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

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

/**
 * MultiThread Environment test.
 */
public class MultiThreadTest extends WatsonServiceTest{

	/** The service. */
	private LanguageTranslation service;
	
	/**
	 * The Class LTSenderRunnable.
	 */
	private class LTSenderRunnable implements Runnable {

		/** The log. */
		private final Logger log = Logger.getLogger(LTSenderRunnable.class.getName());
		
		/** The service. */
		private LanguageTranslation service;

		/**
		 * Instantiates a new LT sender runnable.
		 *
		 * @param service the service
		 */
		public LTSenderRunnable(LanguageTranslation service) {
			this.service = service;
		}

		/**
		 * Send request.
		 */
		public void sendRequest() {
			try {
				service.translate("This is a test - "+ Math.random(), "en-es");
			} catch (Exception e) {
				log.severe("ERROR: " + e.getLocalizedMessage());
			} 
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			long threadId = Thread.currentThread().getId();
			while (true) {
				sendRequest();
				log.info("sendRequest: " + threadId);
			}

		}

	}
	
	/* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new LanguageTranslation();
		service.setUsernameAndPassword(
				prop.getProperty("language_translation.username"),
				prop.getProperty("language_translation.password")
				);
		service.setEndPoint(prop.getProperty("language_translation.url"));
	}

	/**
	 * Test multi thread environments.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	@Ignore
	public void testMultiThreadEnvironments() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new LTSenderRunnable(service));
			thread.start();
			Thread.sleep(10);
		}
	}

}
