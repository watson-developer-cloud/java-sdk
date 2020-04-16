/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.visual_recognition.v3;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.UpdateClassifierOptions;
import java.io.File;
import java.io.FileNotFoundException;

public class VisualRecognitionExample {

  public static void main(String[] args) throws FileNotFoundException {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    VisualRecognition service = new VisualRecognition(VERSION, authenticator);

    System.out.println("Classify an image");
    ClassifyOptions options =
        new ClassifyOptions.Builder()
            .imagesFile(new File("src/test/resources/visual_recognition/car.png"))
            .imagesFilename("car.png")
            .build();
    ClassifiedImages result = service.classify(options).execute().getResult();
    System.out.println(result);

    System.out.println("Create a classifier with positive and negative images");
    CreateClassifierOptions createOptions =
        new CreateClassifierOptions.Builder()
            .name("foo")
            .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
            .addClass(
                "baseball", new File("src/test/resources/visual_recognition/baseball_positive.zip"))
            .negativeExamples(new File("src/test/resources/visual_recognition/negative.zip"))
            .build();
    Classifier foo = service.createClassifier(createOptions).execute().getResult();
    System.out.println(foo);

    System.out.println("Classify using the 'Car' classifier");
    options =
        new ClassifyOptions.Builder()
            .imagesFile(new File("src/test/resources/visual_recognition/car.png"))
            .imagesFilename("car.png")
            .addClassifierId(foo.getClassifierId())
            .build();
    result = service.classify(options).execute().getResult();
    System.out.println(result);

    System.out.println("Update a classifier with more positive images");
    UpdateClassifierOptions updateOptions =
        new UpdateClassifierOptions.Builder()
            .classifierId(foo.getClassifierId())
            .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
            .build();
    Classifier updatedFoo = service.updateClassifier(updateOptions).execute().getResult();
    System.out.println(updatedFoo);
  }
}
