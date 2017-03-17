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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class VisualRecognitionExample {

  public static void main(String[] args) {
    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    service.setApiKey("<api-key>");

    System.out.println("Classify an image");
    ClassifyImagesOptions options =
        new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/car.png")).build();
    VisualClassification result = service.classify(options).execute();
    System.out.println(result);


    System.out.println("Create a classifier with positive and negative images");
    ClassifierOptions createOptions = new ClassifierOptions.Builder().classifierName("foo")
        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
        .addClass("baseball", new File("src/test/resources/visual_recognition/baseball_positive.zip"))
        .negativeExamples(new File("src/test/resources/visual_recognition/negative.zip")).build();
    VisualClassifier foo = service.createClassifier(createOptions).execute();
    System.out.println(foo);

    System.out.println("Classify using the 'Car' classifier");
    options = new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/car.png"))
        .classifierIds("car").build();
    result = service.classify(options).execute();
    System.out.println(result);

    System.out.println("Update a classifier with more positive images");
    ClassifierOptions updateOptions = new ClassifierOptions.Builder()
        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip")).build();
    VisualClassifier updatedFoo = service.updateClassifier(foo.getId(), updateOptions).execute();
    System.out.println(updatedFoo);

  }
}
