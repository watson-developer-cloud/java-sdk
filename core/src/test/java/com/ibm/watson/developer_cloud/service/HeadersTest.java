package com.ibm.watson.developer_cloud.service;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeadersTest extends WatsonServiceUnitTest {

  public class TestModel extends GenericModel { }

  public class TestService extends WatsonService {

    private static final String SERVICE_NAME = "test";

    public TestService() {
      super(SERVICE_NAME);
    }

    public ServiceCall<TestModel> testMethod() {
      RequestBuilder builder = RequestBuilder.get(HttpUrl.parse(getEndPoint() + "/v1/test"));
      return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TestModel.class));
    }
  }

  TestService service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new TestService();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  @Test
  public void testAddHeader() throws InterruptedException {
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"test_key\": \"test_value\"}"));

    String headerName = "X-Test";
    TestModel response = service.testMethod()
        .addHeader(headerName, "test")
        .execute();
    final RecordedRequest request = server.takeRequest();
    assertTrue(request.getHeader(headerName) != null);
  }
}
