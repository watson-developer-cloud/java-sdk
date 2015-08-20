package com.ibm.watson.developer_cloud.language_translation.v2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.language_translation.v2.model.*;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import io.netty.handler.codec.http.HttpHeaders;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;
import org.mockserver.verify.VerificationTimes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * Created by nizar on 8/18/15.
 */
public class LanguageTranslationTest extends WatsonServiceTest {

    /** The model id. */
    private String modelId;

    /** The service. */
    private LanguageTranslation service;

    /** Watson Mock Server **/
    private ClientAndServer mockServer;

    /** The text. */
    private String text;

    /** language translation path **/
    private final static String LANGUAGE_TRANSLATION_PATH= "/v2/translate";

    /** identifiable languages path **/
    private final static String IDENTIFIABLE_LANGUAGES_PATH= "/v2/identifiable_languages";

    /** GET MODEL PATH **/
    private final static String GET_MODELS_PATH= "/v2/models";

    /** "/v2/identify" **/
    private final static String IDENTITY_PATH= "/v2/identify";


    @Before
    public void startMockServer() {
        try {
            mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
            service = new LanguageTranslation();
            service.setApiKey("");
            service.setEndPoint("http://" + prop.getProperty("mock.server.host") + ":" + prop.getProperty("mock.server.port"));
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
        }

    }

    @After
    public void stopMockServer() {
        mockServer.stop();
    }

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
       modelId = prop.getProperty("language_translation.model_id");
       text = "The IBM Watson team is awesome";
    }

    /**
     * Test translate.
     */
  @Test
    public void testTranslate() {

        // Mocking the response
      Map<String,Object> response = new HashMap<String, Object>();
      List<Translation> translations = new ArrayList<Translation>();

      Translation t = new Translation().withTranslation("El equipo es increible IBM Watson");
      translations.add(t);

      response.put("word_count",6);
      response.put("character_count", 20);
      response.put("translations",translations);

      System.out.println(GsonSingleton.getGson().toJson(response));

      String [] text1 = new String[]{(String) text};

      JsonObject contentJson = new JsonObject();
      JsonArray paragraphs = new JsonArray();
      for (String paragraph : text1) {
          paragraphs.add(new JsonPrimitive(paragraph));
      }
      contentJson.add(LanguageTranslation.TEXT, paragraphs);
      mockServer
               .when(
                       request().withMethod("POST")
                               .withPath(LANGUAGE_TRANSLATION_PATH)
                               .withQueryStringParameter(new Parameter(LanguageTranslation.MODEL_ID, modelId))
                               .withBody(contentJson.toString())

               )

               .respond(
                       response()
                               .withHeaders(
                                       new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                               )
                               .withBody(GsonSingleton.getGson().toJson(response))
        );


       TranslationResult translationResult = service.translate(text, modelId);
       testTranslationResult(text, translationResult);

        Map<String, Object> params = new HashMap<String,Object>();
        params.put(LanguageTranslation.TEXT, new String[] {text});
        params.put(LanguageTranslation.MODEL_ID,modelId);

        translationResult = service.translate(params);
        testTranslationResult(text, translationResult);
    }


    /**
     * Test translation result.
     *
     * @param text the text
     * @param translationResult the translation result
     */
    private void testTranslationResult(String text,
                                       TranslationResult translationResult) {
        Assert.assertNotNull(translationResult);
        Assert.assertEquals(translationResult.getWordCount(), text.split(" ").length);
        Assert.assertNotNull(translationResult.getTranslations());
        Assert.assertNotNull(translationResult.getTranslations().get(0).getTranslation());
    }



    /**
     * Test Get Identifiable languages.
     */
    @Test
    public void testGetIdentifiableLanguages() {

        Map<String,Object> response = new HashMap<String, Object>();
        List<IdentifiableLanguage> langs = new ArrayList<IdentifiableLanguage>();
        langs.add(new IdentifiableLanguage("af","Afrikaans"));
        langs.add(new IdentifiableLanguage("ar","Arabic"));
        langs.add(new IdentifiableLanguage("az", "Azerbaijani"));
        langs.add(new IdentifiableLanguage("zh", "Chinese"));
        response.put("languages", langs);

        System.out.println(GsonSingleton.getGson().toJson(response));

        mockServer
                .when(
                        request()
                                .withPath(IDENTIFIABLE_LANGUAGES_PATH)
                )
                .respond(
                        response()
                                .withHeaders(
                                        new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                                )
                                .withBody(GsonSingleton.getGson().toJson(response))
                );

        List<IdentifiableLanguage> languages = service.getIdentifiableLanguages();

        mockServer.verify(
                request()
                        .withPath(IDENTIFIABLE_LANGUAGES_PATH),
                VerificationTimes.exactly(1)
        );
        Assert.assertNotNull(languages);
        Assert.assertFalse(languages.containsAll(langs));
    }

    /**
     * Test Get Identifiable languages.
     */
    @Test
    public void testGetModel() {
        // Mock response
        TranslationModel tm = new TranslationModel();
        String model_id = "e87190c1-3c02-4b50-a1be-162bb76d7ff7";
        tm.setModelId(model_id);
        tm.setSource("en");
        tm.setBaseModelId("en-es");
        tm.setDomain("news");
        tm.setCustomizable(false);
        tm.setDefaultModel(false);
        tm.setOwner("4b4b465b-136c-448d-a745-b19517c1ce99");
        tm.setStatus("error");
        tm.setName("custom-english-to-spanish");

        System.out.println(GsonSingleton.getGson().toJson(tm));

        mockServer
                .when(
                        request()
                                .withPath(GET_MODELS_PATH + "/" + model_id)
                )
                .respond(
                        response()
                                .withHeaders(
                                        new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                                )
                                .withBody(GsonSingleton.getGson().toJson(tm))
                );

        TranslationModel model = service.getModel("e87190c1-3c02-4b50-a1be-162bb76d7ff7");

        mockServer.verify(
                request()
                        .withPath(GET_MODELS_PATH + "/" + model_id),
                VerificationTimes.exactly(1)
        );
        Assert.assertNotNull(model);
        //Assert.assertEquals(model.getModelId(),tm.getModelId());
    }

    /**
     * Test Get Models.
     */
    @Test
    public void testGetModels() {

        Map<String,Object> response = new HashMap<String, Object>();
        List<TranslationModel> tsModels = new ArrayList<TranslationModel>();

        TranslationModel tm = new TranslationModel();
        tm.setModelId("e87190c1-3c02-4b50-a1be-162bb76d7ff7");
        tm.setSource("en");
        tm.setBaseModelId("en-es");
        tm.setDomain("news");
        tm.setCustomizable(false);
        tm.setDefaultModel(false);
        tm.setOwner("4b4b465b-136c-448d-a745-b19517c1ce99");
        tm.setStatus("error");
        tm.setName("custom-english-to-spanish");
        tsModels.add(tm);

        TranslationModel tm1 = new TranslationModel();
        tm1.setModelId("f7efd838-8197-4fa9-843a-70e80cfa8c87");
        tm1.setSource("en");
        tm1.setBaseModelId("es");
        tm1.setDomain("news");
        tm1.setCustomizable(false);
        tm1.setDefaultModel(false);
        tm1.setOwner("4b4b465b-136c-448d-a745-b19517c1ce99");
        tm1.setStatus("error");
        tm1.setName("custom-english-to-spanish");
        tsModels.add(tm1);

        TranslationModel tm2 = new TranslationModel();
        tm2.setModelId("ar-en");
        tm2.setSource("en");
        tm2.setBaseModelId("");
        tm2.setDomain("news");
        tm2.setCustomizable(true);
        tm2.setDefaultModel(true);
        tm2.setOwner("");
        tm2.setStatus("available");
        tm2.setName("custom-english-to-spanish");
        tsModels.add(tm2);

        response.put("models", tsModels);


        mockServer
                .when(
                        request()
                                .withPath(GET_MODELS_PATH)
                )
                .respond(
                        response()
                                .withHeaders(
                                        new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                                )
                                .withBody(GsonSingleton.getGson().toJson(response))
                );

        List<TranslationModel> models = service.getModels();

        mockServer.verify(
                request()
                        .withPath(GET_MODELS_PATH),
                VerificationTimes.exactly(1)
        );
        Assert.assertNotNull(models);


        Assert.assertNotNull(models);
        Assert.assertFalse(models.isEmpty());
        Assert.assertNotNull(models.containsAll(tsModels));

    }


    /**
     * Test Identify.
     */
    @Test
    public void testIdentify() {

            Map<String,Object> response = new HashMap<String, Object>();
            List<IdentifiedLanguage> langs = new ArrayList<IdentifiedLanguage>();
            langs.add(new IdentifiedLanguage("en",0.877159));
            langs.add(new IdentifiedLanguage("af",0.0752636));
            langs.add(new IdentifiedLanguage("nl", 0.0301593));

            response.put("languages", langs);

        mockServer
                .when(
                        request().withMethod("POST")
                                .withPath(IDENTITY_PATH)
                                .withBody(text)
                )
                .respond(
                        response()
                                .withHeaders(
                                        new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                                )
                                .withBody(GsonSingleton.getGson().toJson(response))
                );


        List<IdentifiedLanguage> identifiedLanguages = service.identify(text);
        Assert.assertNotNull(identifiedLanguages);
        Assert.assertFalse(identifiedLanguages.isEmpty());
        Assert.assertNotNull(identifiedLanguages.containsAll(langs));
    }

//    /**
//     * Test Create Model.
//     */
//    @Test
//    @Ignore
//    public void testCreateDeleteModel() {
//        String name = "custom-english-to-spanish";
//
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("name", name);
//        params.put("base_model_id", "en-es");
//        params.put("forced_glossary", new File("src/test/resources/glossary.tmx"));
//
//        TranslationModel model = service.createModel(params);
//        service.deleteModel(model.getModelId());
//        Assert.assertNotNull(model);
//        Assert.assertEquals(model.getName(), name);
//        Assert.assertEquals(model.getStatus(), TranslationModel.STATUS_TRAINING);
//
//
//
//    }
    /**
     * Test Translate with an invalid model.
     */
    @Test
    public void testTranslateNotSupported() {
        boolean fail = true;
        try {

            // Mocking the response

            service.translate("X", "FOO-BAR-FOO");

        } catch (Exception e) {
            fail = false;
        }
        Assert.assertFalse(fail);
    }
}
