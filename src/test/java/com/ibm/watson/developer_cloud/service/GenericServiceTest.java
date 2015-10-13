package com.ibm.watson.developer_cloud.service;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsightsTest;

public class GenericServiceTest extends WatsonServiceTest {

	private static final String POST = "POST";

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(PersonalityInsightsTest.class.getName());

	/** The service. */
	private PersonalityInsights service;

	/** Mock Server *. */
	private ClientAndServer mockServer;

	private String sampleText = "this is a test";

	private final static String GET_PROFILE_PATH = "/v2/profile";

	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new PersonalityInsights();
			service.setApiKey("");
			service.setEndPoint("http://" + prop.getProperty("mock.server.host") + ":"
					+ prop.getProperty("mock.server.port"));
		} catch (NumberFormatException e) {
			log.log(Level.SEVERE, "Error mocking the service", e);
		}
	}

	/**
	 * Stop mock server.
	 */
	@After
	public void stopMockServer() {
		mockServer.stop();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		PersonalityInsights service = new PersonalityInsights();
		service.setEndPoint(null);
		service .getProfile(sampleText);
	}

	/**
	 * Mock an API call and return an error.
	 *
	 * @param code the code
	 * @param errorMessage the error message
	 */
	private void mockAPICallWithError(int code, String errorMessage) {
		mockServer.when(request().withMethod(POST).withPath(GET_PROFILE_PATH)).respond(
				response().withStatusCode(code).withBody("{\"code\":" + code + ", \"error\":\"" + errorMessage + "\"}"));
	}

	@Test(expected = BadRequestException.class)
	public void testBadRequestException() {
		mockAPICallWithError(400, "Bad request");
		service.getProfile(sampleText);
	}

	@Test(expected = ForbiddenException.class)
	public void testForbiddenException() {
		mockAPICallWithError(403, "Bad request");
		service.getProfile(sampleText);
	}

	@Test(expected = InternalServerErrorException.class)
	public void testInternalServerErrorException() {
		mockAPICallWithError(500, "Bad request");
		service.getProfile(sampleText);
	}

	@Test(expected = NotFoundException.class)
	public void testNotFoundException() {
		mockAPICallWithError(404, "Bad request");
		service.getProfile(sampleText);
	}

	@Test(expected = RequestTooLargeException.class)
	public void testRequestTooLargeException() {
		mockAPICallWithError(413, "Bad request");
		service.getProfile(sampleText);
	}

	@Test(expected = ServiceUnavailableException.class)
	public void ServiceUnavailableException() {
		mockAPICallWithError(503, "ServiceUnavailableException");
		service.getProfile(sampleText);
	}

	@Test(expected = TooManyRequestsException.class)
	public void testTooManyRequestsException() {
		mockAPICallWithError(429, "TooManyRequestsException");
		service.getProfile(sampleText);
	}

	@Test(expected = UnauthorizedException.class)
	public void testUnauthorizedException() {
		mockAPICallWithError(401, "UnauthorizedException");
		service.getProfile(sampleText);
	}

	@Test(expected = UnsupportedException.class)
	public void testUnsupportedException() {
		mockAPICallWithError(415, "UnsupportedException");
		service.getProfile(sampleText);
	}
	
	@Test(expected = ServiceUnavailableException.class)
	public void testServiceUnavailableException() {
		mockAPICallWithError(503, "Service Unavailable");
		service.getProfile(sampleText);
	}
}
