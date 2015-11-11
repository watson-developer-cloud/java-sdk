/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.io.File;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;

/**
 * This class shows how to invoke the wrapper methods in {@link RetrieveAndRank} class.
 * 
 * @version v1
 */

public class RetrieveAndRankRankerExample {
  /** Ranker status */
  private static final String RANKER_TRAINING_STATUS = "Training";
  private static final String RANKER_AVAILABLE_STATUS = "Available";

  /** The client */
  private static RetrieveAndRank client;

  /**
   * Initializes the client
   * 
   * @param userName
   * @param password
   * @param url
   */
  public void initializeRankerClient(String userName, String password, String url) {
    client = new RetrieveAndRank();
    client.setUsernameAndPassword(userName, password);
    client.setEndPoint(url);
  }

  /**
   * Creates a ranker
   * 
   * @param name
   * @param trainingFilePath
   * @return id of ranker if created, otherwise null
   */
  public String createRanker(String name, String trainingFilePath) {
    final File trainingFile = new File(trainingFilePath);
    final Ranker ranker = client.createRanker(name, trainingFile);
    if (ranker != null) {
      System.out.println("ranker id = " + ranker.getId());
      return ranker.getId();
    }
    return null;
  }

  /**
   * Checks the status of the ranker and returns when the ranker is 'Available' (i.e., when training
   * is done)
   * 
   * @param rankerID
   */
  public void returnWhenAvailable(String rankerID) {
    /**
     * keep checking its status until it has finished training
     */
    while (true) {
      final String status = client.getRankerStatus(rankerID).getStatus().toString();
      System.out.println("ranker is " + status);
      if (!RANKER_TRAINING_STATUS.equalsIgnoreCase(status)) {
        if (!RANKER_AVAILABLE_STATUS.equalsIgnoreCase(status)) {
          throw new RuntimeException("Problem with training ranker (status=" + status + ")");
        }
        System.out.println("Ranker is Available!");
        break;
      }
      try {
        /** wait time between two checks */
        Thread.sleep(2000);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Lists the rankers owned by the user
   */
  public void listRankers() {
    final Rankers rankers = client.getRankers();
    System.out.println("Ranker List:");
    if (rankers != null) {
      for (final Ranker r : rankers.getRanker()) {
        System.out.println(r.getId());
      }
    }
  }

  /**
   * This method takes a set of test instances to rank
   * 
   * @param rankerID
   * @param testInstance
   * @param topAnswers
   * @return results of the ranking
   */
  public Ranking rank(String rankerID, File testInstance, int topAnswers) {
    final Ranking ranking = client.rank(rankerID, testInstance, topAnswers);
    if (ranking != null) {
      System.out.println("top answer = " + ranking.getTopAnswer());
    }
    return ranking;
  }

  /**
   * Deletes a ranker
   * 
   * @param rankerID
   */
  public void deleteRanker(String rankerID) {
    client.deleteRanker(rankerID);
  }

  public static void main(String[] args) {
    final RetrieveAndRankRankerExample rr = new RetrieveAndRankRankerExample();
    rr.initializeRankerClient("<user>", "<pass>", "<url>");
    final String rankerID = rr.createRanker("example-ranker-1", "<path_to_training_csv>");
    rr.returnWhenAvailable(rankerID);
    rr.listRankers();

    final File testFile = new File("<path_to_test_csv>");
    rr.rank(rankerID, testFile, 5);

    rr.deleteRanker(rankerID);
    rr.listRankers();
  }
}
