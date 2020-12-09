/*
 * (C) Copyright IBM Corp. 2020.
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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the RuntimeEntityInterpretation model. */
public class RuntimeEntityInterpretationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeEntityInterpretation() throws Throwable {
    RuntimeEntityInterpretation runtimeEntityInterpretationModel =
        new RuntimeEntityInterpretation.Builder()
            .calendarType("testString")
            .datetimeLink("testString")
            .festival("testString")
            .granularity("day")
            .rangeLink("testString")
            .rangeModifier("testString")
            .relativeDay(Double.valueOf("72.5"))
            .relativeMonth(Double.valueOf("72.5"))
            .relativeWeek(Double.valueOf("72.5"))
            .relativeWeekend(Double.valueOf("72.5"))
            .relativeYear(Double.valueOf("72.5"))
            .specificDay(Double.valueOf("72.5"))
            .specificDayOfWeek("testString")
            .specificMonth(Double.valueOf("72.5"))
            .specificQuarter(Double.valueOf("72.5"))
            .specificYear(Double.valueOf("72.5"))
            .numericValue(Double.valueOf("72.5"))
            .subtype("testString")
            .partOfDay("testString")
            .relativeHour(Double.valueOf("72.5"))
            .relativeMinute(Double.valueOf("72.5"))
            .relativeSecond(Double.valueOf("72.5"))
            .specificHour(Double.valueOf("72.5"))
            .specificMinute(Double.valueOf("72.5"))
            .specificSecond(Double.valueOf("72.5"))
            .timezone("testString")
            .build();
    assertEquals(runtimeEntityInterpretationModel.calendarType(), "testString");
    assertEquals(runtimeEntityInterpretationModel.datetimeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModel.festival(), "testString");
    assertEquals(runtimeEntityInterpretationModel.granularity(), "day");
    assertEquals(runtimeEntityInterpretationModel.rangeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModel.rangeModifier(), "testString");
    assertEquals(runtimeEntityInterpretationModel.relativeDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeWeek(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeWeekend(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificDayOfWeek(), "testString");
    assertEquals(runtimeEntityInterpretationModel.specificMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificQuarter(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.numericValue(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.subtype(), "testString");
    assertEquals(runtimeEntityInterpretationModel.partOfDay(), "testString");
    assertEquals(runtimeEntityInterpretationModel.relativeHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.timezone(), "testString");

    String json = TestUtilities.serialize(runtimeEntityInterpretationModel);

    RuntimeEntityInterpretation runtimeEntityInterpretationModelNew =
        TestUtilities.deserialize(json, RuntimeEntityInterpretation.class);
    assertTrue(runtimeEntityInterpretationModelNew instanceof RuntimeEntityInterpretation);
    assertEquals(runtimeEntityInterpretationModelNew.calendarType(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.datetimeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.festival(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.granularity(), "day");
    assertEquals(runtimeEntityInterpretationModelNew.rangeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.rangeModifier(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.relativeDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeWeek(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeWeekend(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificDayOfWeek(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.specificMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificQuarter(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.numericValue(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.subtype(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.partOfDay(), "testString");
    assertEquals(runtimeEntityInterpretationModelNew.relativeHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.relativeSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.specificSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModelNew.timezone(), "testString");
  }
}
