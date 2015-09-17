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
package com.ibm.watson.developer_cloud.question_and_answer.v1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.Question;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.QuestionAndAnswerDataset;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonAnswer;

/**
 * The Class QuestionAndAnswerTest.
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class QuestionAndAnswerTest extends WatsonServiceTest {

	/**
	 * The service.
	 */
	private QuestionAndAnswer service;

	/* (non-Javadoc)
	 * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
	 */
	/**
	 * Method setUp.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new QuestionAndAnswer();
		service.setUsernameAndPassword(
				prop.getProperty("question_and_answer.username"),
				prop.getProperty("question_and_answer.password")
				);
		service.setEndPoint(prop.getProperty("question_and_answer.url"));
	}

	/**
	 * Test ask String.
	 */
	@Test
	public void testAskWatsonQuestion() {
		service.setDataset(QuestionAndAnswerDataset.HEALTHCARE);
		Question question = new Question()
		.withItems(2)
		.withQuestionText("What is HIV?");

		WatsonAnswer watsonAnswers = service.ask(question);
		Assert.assertNotNull(watsonAnswers.getAnswers());
		Assert.assertEquals(watsonAnswers.getAnswers().size(), 2);

	}

	/**
	 * Test ask.
	 */
	@Test
	public void testAskTextQuestion() {
		service.setDataset(QuestionAndAnswerDataset.HEALTHCARE);
		WatsonAnswer watsonAnswers = service.ask("What is HIV?");
		Assert.assertNotNull(watsonAnswers);
	}

	/**
	 * Test missing dataset.
	 */
	@Test
	public void testMissingDataset() {
		boolean fail = true;
		service.setDataset(null);
		try {
			service.ask("X");
		} catch (Exception e) {
			fail = false;
		}
		Assert.assertFalse(fail);
	}

}
