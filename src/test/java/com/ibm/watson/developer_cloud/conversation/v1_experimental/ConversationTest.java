package com.ibm.watson.developer_cloud.conversation.v1_experimental;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationResponse;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

public class ConversationTest extends WatsonServiceUnitTest {
  private Conversation service;
  private static final String FIXTURE = "src/test/resources/conversation/conversation.json";
  private static final String PATH = "/v1/workspaces/{id}/message";
  private static final String WORKSPACE_ID = "123";

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override @Before public void setUp() throws Exception {
    super.setUp();
    service = new Conversation(Conversation.VERSION_DATE_2016_01_24);
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

  }

  @Test public void testSendMessage() throws FileNotFoundException {
    ConversationResponse response = loadFixture(FIXTURE, ConversationResponse.class);
    final JsonObject contentJson = new JsonObject();
    final JsonObject input = new JsonObject();
    input.addProperty("text", "I'd like to get a quote to replace my windows");
    contentJson.add("input", input);
    mockServer
        .when(request().withMethod(POST).withPath(PATH.replace("{id}", WORKSPACE_ID))
            .withQueryStringParameter("version", Conversation.VERSION_DATE_2016_01_24).withBody(contentJson.toString()))
        .respond(response().withHeader(HttpHeaders.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
            .withBody(response.toString()));

    // Call the service and compare the result
    Assert.assertEquals(response, service
        .message(WORKSPACE_ID, new Gson().fromJson(contentJson.toString(), ConversationRequest.class)).execute());
  }
}
