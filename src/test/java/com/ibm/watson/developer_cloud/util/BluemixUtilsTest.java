package com.ibm.watson.developer_cloud.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;

public class BluemixUtilsTest extends WatsonServiceTest {
	private static final String API_KEY_FREE = "bm90LWEtZnJlZS11c2VybmFtZTpub3QtYS1mcmVlLXBhc3N3b3Jk";
	private static final String API_KEY_STANDARD = "bm90LWEtdXNlcm5hbWU6bm90LWEtcGFzc3dvcmQ=";
	private static final String VCAP_SERVICES = "vcap_services.json";
	private static final String SERVICE_NAME = "personality_insights";

	@Before
	public void setup() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(VCAP_SERVICES);
		String vcapServices = getStringFromInputStream(in);
		BluemixUtils.setServices(vcapServices);
	}

	/**
	 * Test get api key with null or empty service.
	 * There are two instances of Personality Insights: ['free', 'standard']
	 */
	@Test
	public void testGetAPIKeyWithNullOrEmptyService() {
		assertNull(BluemixUtils.getAPIKey(null, null));
		assertNull(BluemixUtils.getAPIKey("", ""));

		assertEquals(API_KEY_FREE, BluemixUtils.getAPIKey(SERVICE_NAME, null));
		assertEquals(API_KEY_FREE, BluemixUtils.getAPIKey(SERVICE_NAME, BluemixUtils.PLAN_FREE));
		assertEquals(API_KEY_STANDARD, BluemixUtils.getAPIKey(SERVICE_NAME, BluemixUtils.PLAN_STANDARD));
	}
}
