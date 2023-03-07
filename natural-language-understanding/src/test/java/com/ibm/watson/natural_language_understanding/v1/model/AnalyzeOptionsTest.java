/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.natural_language_understanding.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the AnalyzeOptions model. */
public class AnalyzeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnalyzeOptions() throws Throwable {
    ClassificationsOptions classificationsOptionsModel =
        new ClassificationsOptions.Builder().model("testString").build();
    assertEquals(classificationsOptionsModel.model(), "testString");

    ConceptsOptions conceptsOptionsModel =
        new ConceptsOptions.Builder().limit(Long.valueOf("50")).build();
    assertEquals(conceptsOptionsModel.limit(), Long.valueOf("50"));

    EmotionOptions emotionOptionsModel =
        new EmotionOptions.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(emotionOptionsModel.document(), Boolean.valueOf(true));
    assertEquals(emotionOptionsModel.targets(), java.util.Arrays.asList("testString"));

    EntitiesOptions entitiesOptionsModel =
        new EntitiesOptions.Builder()
            .limit(Long.valueOf("250"))
            .mentions(false)
            .model("testString")
            .sentiment(false)
            .emotion(false)
            .build();
    assertEquals(entitiesOptionsModel.limit(), Long.valueOf("250"));
    assertEquals(entitiesOptionsModel.mentions(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModel.model(), "testString");
    assertEquals(entitiesOptionsModel.sentiment(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModel.emotion(), Boolean.valueOf(false));

    KeywordsOptions keywordsOptionsModel =
        new KeywordsOptions.Builder()
            .limit(Long.valueOf("250"))
            .sentiment(false)
            .emotion(false)
            .build();
    assertEquals(keywordsOptionsModel.limit(), Long.valueOf("250"));
    assertEquals(keywordsOptionsModel.sentiment(), Boolean.valueOf(false));
    assertEquals(keywordsOptionsModel.emotion(), Boolean.valueOf(false));

    RelationsOptions relationsOptionsModel =
        new RelationsOptions.Builder().model("testString").build();
    assertEquals(relationsOptionsModel.model(), "testString");

    SemanticRolesOptions semanticRolesOptionsModel =
        new SemanticRolesOptions.Builder()
            .limit(Long.valueOf("26"))
            .keywords(false)
            .entities(false)
            .build();
    assertEquals(semanticRolesOptionsModel.limit(), Long.valueOf("26"));
    assertEquals(semanticRolesOptionsModel.keywords(), Boolean.valueOf(false));
    assertEquals(semanticRolesOptionsModel.entities(), Boolean.valueOf(false));

    SentimentOptions sentimentOptionsModel =
        new SentimentOptions.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(sentimentOptionsModel.document(), Boolean.valueOf(true));
    assertEquals(sentimentOptionsModel.targets(), java.util.Arrays.asList("testString"));

    SummarizationOptions summarizationOptionsModel =
        new SummarizationOptions.Builder().limit(Long.valueOf("10")).build();
    assertEquals(summarizationOptionsModel.limit(), Long.valueOf("10"));

    CategoriesOptions categoriesOptionsModel =
        new CategoriesOptions.Builder()
            .explanation(false)
            .limit(Long.valueOf("10"))
            .model("testString")
            .build();
    assertEquals(categoriesOptionsModel.explanation(), Boolean.valueOf(false));
    assertEquals(categoriesOptionsModel.limit(), Long.valueOf("10"));
    assertEquals(categoriesOptionsModel.model(), "testString");

    SyntaxOptionsTokens syntaxOptionsTokensModel =
        new SyntaxOptionsTokens.Builder().lemma(true).partOfSpeech(true).build();
    assertEquals(syntaxOptionsTokensModel.lemma(), Boolean.valueOf(true));
    assertEquals(syntaxOptionsTokensModel.partOfSpeech(), Boolean.valueOf(true));

    SyntaxOptions syntaxOptionsModel =
        new SyntaxOptions.Builder().tokens(syntaxOptionsTokensModel).sentences(true).build();
    assertEquals(syntaxOptionsModel.tokens(), syntaxOptionsTokensModel);
    assertEquals(syntaxOptionsModel.sentences(), Boolean.valueOf(true));

    Features featuresModel =
        new Features.Builder()
            .classifications(classificationsOptionsModel)
            .concepts(conceptsOptionsModel)
            .emotion(emotionOptionsModel)
            .entities(entitiesOptionsModel)
            .keywords(keywordsOptionsModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .relations(relationsOptionsModel)
            .semanticRoles(semanticRolesOptionsModel)
            .sentiment(sentimentOptionsModel)
            .summarization(summarizationOptionsModel)
            .categories(categoriesOptionsModel)
            .syntax(syntaxOptionsModel)
            .build();
    assertEquals(featuresModel.classifications(), classificationsOptionsModel);
    assertEquals(featuresModel.concepts(), conceptsOptionsModel);
    assertEquals(featuresModel.emotion(), emotionOptionsModel);
    assertEquals(featuresModel.entities(), entitiesOptionsModel);
    assertEquals(featuresModel.keywords(), keywordsOptionsModel);
    assertEquals(
        featuresModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(featuresModel.relations(), relationsOptionsModel);
    assertEquals(featuresModel.semanticRoles(), semanticRolesOptionsModel);
    assertEquals(featuresModel.sentiment(), sentimentOptionsModel);
    assertEquals(featuresModel.summarization(), summarizationOptionsModel);
    assertEquals(featuresModel.categories(), categoriesOptionsModel);
    assertEquals(featuresModel.syntax(), syntaxOptionsModel);

    AnalyzeOptions analyzeOptionsModel =
        new AnalyzeOptions.Builder()
            .features(featuresModel)
            .text("testString")
            .html("testString")
            .url("testString")
            .clean(true)
            .xpath("testString")
            .fallbackToRaw(true)
            .returnAnalyzedText(false)
            .language("testString")
            .limitTextCharacters(Long.valueOf("26"))
            .build();
    assertEquals(analyzeOptionsModel.features(), featuresModel);
    assertEquals(analyzeOptionsModel.text(), "testString");
    assertEquals(analyzeOptionsModel.html(), "testString");
    assertEquals(analyzeOptionsModel.url(), "testString");
    assertEquals(analyzeOptionsModel.clean(), Boolean.valueOf(true));
    assertEquals(analyzeOptionsModel.xpath(), "testString");
    assertEquals(analyzeOptionsModel.fallbackToRaw(), Boolean.valueOf(true));
    assertEquals(analyzeOptionsModel.returnAnalyzedText(), Boolean.valueOf(false));
    assertEquals(analyzeOptionsModel.language(), "testString");
    assertEquals(analyzeOptionsModel.limitTextCharacters(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeOptionsError() throws Throwable {
    new AnalyzeOptions.Builder().build();
  }
}
