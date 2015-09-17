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
package com.ibm.watson.developer_cloud.visual_recognition.v1;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.LabelSet;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.RecognizedImage;

/**
 * The Class VisualRecognitionTest.
 */
public class VisualRecognitionTest extends WatsonServiceTest {

	/** The service. */
	private VisualRecognition service;
	
	/** The image. */
	private File image;

	/* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new VisualRecognition();
		service.setUsernameAndPassword(
				prop.getProperty("visual_recognition.username"),
				prop.getProperty("visual_recognition.password")
				);
		service.setEndPoint(prop.getProperty("visual_recognition.url"));
		image = new File(getClass().getClassLoader().getResource("car.png").toURI());

	}

	/**
	 * Test recognize all.
	 * 
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@Test
	public void testRecognizeAll() throws URISyntaxException {
		RecognizedImage recognizedImage = service.recognize(image);
		Assert.assertNotNull(recognizedImage);
		Assert.assertNotNull(recognizedImage.getName());
		Assert.assertNotNull(recognizedImage.getLabels());
		Assert.assertFalse(recognizedImage.getLabels().isEmpty());
	}

	/**
	 * Test recognize with labels.
	 * 
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@Test
	public void testRecognizeWithLabels() throws URISyntaxException {
		File image = new File(getClass().getClassLoader().getResource("car.png").toURI());
		LabelSet labelSet = new LabelSet();

		labelSet.withLabelGroup("Animal").withLabelGroup("Food");

		RecognizedImage recognizedImage = service.recognize(image,labelSet);
		Assert.assertNotNull(recognizedImage);
		Assert.assertNotNull(recognizedImage.getName());
		Assert.assertNotNull(recognizedImage.getLabels());
		Assert.assertFalse(recognizedImage.getLabels().isEmpty());
	}

	/**
	 * Test get labels.
	 */
	@Test
	public void testGetLabels() {
		LabelSet labels = service.getLabelSet();

		Assert.assertNotNull(labels);
		Assert.assertFalse(labels.getLabelGroups().isEmpty());
		Assert.assertFalse(labels.getLabels().isEmpty());
	}

}
