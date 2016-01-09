/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.visual_recognition.v2;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.ClassifierSet;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.RecognizedImage;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualRecognitionImages;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

/**
 * The Class VisualRecognitionTest.
 */
public class VisualRecognitionIT extends WatsonServiceTest {

    /** The image. */
    private File image;

    /** The service. */
    private VisualRecognition service;

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = new VisualRecognition();
        service.setUsernameAndPassword(getValidProperty("visual_recognition.username"),
                getValidProperty("visual_recognition.password"));
        service.setEndPoint(getValidProperty("visual_recognition.url"));
        image = new File("src/test/resources/visual_recognition/car.png");

    }

    /**
     * Test get classifiers.
     */
    @Test
    public void testGetLabels() {
        final ClassifierSet classifiers = service.getClassifierSet();

        Assert.assertNotNull(classifiers);
        Assert.assertFalse(classifiers.getClassifierGroups().isEmpty());
        Assert.assertFalse(classifiers.getClassifiers().isEmpty());
    }

    /**
     * Test recognize all.
     *
     * @throws URISyntaxException the URI syntax exception
     */
    @Test
    public void testRecognizeAll() throws URISyntaxException {
        final VisualRecognitionImages recognizedImages = service.recognize(image);
        Assert.assertFalse(recognizedImages.getImages().isEmpty());
        final RecognizedImage recognizedImage = recognizedImages.getImages().get(0);
        Assert.assertNotNull(recognizedImage);
        Assert.assertNotNull(recognizedImage.getName());
        Assert.assertNotNull(recognizedImage.getScores());
        Assert.assertFalse(recognizedImage.getScores().isEmpty());
    }

    /**
     * Test recognize with classifiers.
     *
     * @throws URISyntaxException the URI syntax exception
     */
    @Test
    public void testRecognizeWithLabels() throws URISyntaxException {
        final ClassifierSet classifierSet = new ClassifierSet();

        classifierSet.withClassifierGroup("Animal").withClassifierGroup("Food");

        final VisualRecognitionImages recognizedImages = service.recognize(image, classifierSet);
        Assert.assertNotNull(recognizedImages);
        Assert.assertFalse(recognizedImages.getImages().isEmpty());
        final RecognizedImage recognizedImage = recognizedImages.getImages().get(0);
        Assert.assertNotNull(recognizedImage.getName());
        Assert.assertNotNull(recognizedImage.getScores());
        Assert.assertFalse(recognizedImage.getScores().isEmpty());
    }

}
