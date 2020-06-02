/*
 * (C) Copyright IBM Corp. 2018, 2019.
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
package com.ibm.watson.assistant.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.DeleteValueOptions;
import com.ibm.watson.assistant.v1.model.GetValueOptions;
import com.ibm.watson.assistant.v1.model.ListValuesOptions;
import com.ibm.watson.assistant.v1.model.UpdateValueOptions;
import com.ibm.watson.assistant.v1.model.Value;
import com.ibm.watson.assistant.v1.model.ValueCollection;
import com.ibm.watson.common.RetryRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/** The Class ValuesIT. */
@RunWith(RetryRunner.class)
public class ValuesIT extends AssistantServiceTest {

  private Assistant service;
  private String workspaceId;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
    this.workspaceId = getWorkspaceId();
  }

  /** Test createValue. */
  @Test
  public void testCreateValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();

    // metadata
    Map<String, Object> valueMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + entityValue;
    valueMetadata.put("key", metadataValue);

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .metadata(valueMetadata)
            .build();
    Value response = service.createValue(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.value());
      assertEquals(response.value(), entityValue);
      assertNotNull(response.metadata());

      // metadata
      assertNotNull(response.metadata());
      assertNotNull(response.metadata().get("key"));
      assertEquals(response.metadata().get("key"), metadataValue);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute().getResult();
    }
  }

  /** Test deleteValue. */
  @Test
  public void testDeleteValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
    Value response = service.createValue(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.value());
      assertEquals(response.value(), entityValue);
      assertNull(response.metadata());
    } catch (Exception ex) {
      // Clean up
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute().getResult();
      fail(ex.getMessage());
    }

    DeleteValueOptions deleteOptions =
        new DeleteValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .build();
    service.deleteValue(deleteOptions).execute().getResult();

    try {
      GetValueOptions getOptions =
          new GetValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.getValue(getOptions).execute().getResult();
      fail("deleteValue failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /** Test getValue. */
  @Test
  public void testGetValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();
    String synonym1 = "java";
    String synonym2 = "joe";

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder(workspaceId, entity, entityValue)
            .synonyms(new ArrayList<String>(Arrays.asList(synonym1, synonym2)))
            .build();
    service.createValue(createOptions).execute().getResult();

    Date start = new Date();

    try {
      GetValueOptions getOptions =
          new GetValueOptions.Builder(workspaceId, entity, entityValue)
              .export(true)
              .includeAudit(true)
              .build();
      Value response = service.getValue(getOptions).execute().getResult();

      assertNotNull(response);
      assertNotNull(response.value());
      assertEquals(response.value(), entityValue);
      assertNotNull(response.created());
      assertNotNull(response.updated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.created(), now));
      assertTrue(fuzzyAfter(response.created(), start));
      assertTrue(fuzzyBefore(response.updated(), now));
      assertTrue(fuzzyAfter(response.updated(), start));

      assertNotNull(response.synonyms());
      assertTrue(response.synonyms().size() == 2);
      assertTrue(response.synonyms().contains(synonym1));
      assertTrue(response.synonyms().contains(synonym2));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute().getResult();
    }
  }

  /** Test listValues. */
  @Test
  public void testListValues() {

    String entity = "beverage";
    String entityValue1 = "coffee";
    String entityValue2 = "orange juice";

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
    try {
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      service
          .createValue(createOptions.newBuilder().value(entityValue2).build())
          .execute()
          .getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListValuesOptions listOptions =
          new ListValuesOptions.Builder().workspaceId(workspaceId).entity(entity).build();
      final ValueCollection response = service.listValues(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getValues());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null
      if (response.getPagination().getNextUrl() == null) {
        assertNull(response.getPagination().getNextCursor());
      } else {
        assertNotNull(response.getPagination().getNextCursor());
      }

      assertTrue(response.getValues().size() >= 2);

      // Should not be paginated, but just to be sure
      if (response.getPagination().getNextUrl() == null) {
        // assertTrue(response.getValues().stream().filter(r ->
        // r.getValue().equals(synonym1)).count() == 1);
        boolean found1 = false;
        boolean found2 = false;
        for (Value valueResponse : response.getValues()) {
          found1 |= valueResponse.value().equals(entityValue1);
          found2 |= valueResponse.value().equals(entityValue2);
        }
        assertTrue(found1 && found2);
      }

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.deleteValue(deleteOptions).execute().getResult();
      service
          .deleteValue(deleteOptions.newBuilder().value(entityValue2).build())
          .execute()
          .getResult();
    }
  }

  /** Test listValues with pagination. */
  @Test
  public void testListValuesWithPaging() {

    String entity = "beverage";
    String entityValue1 = "coffee";
    String entityValue2 = "orange juice";

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
    try {
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      service
          .createValue(createOptions.newBuilder().value(entityValue2).build())
          .execute()
          .getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListValuesOptions.Builder listOptionsBuilder =
          new ListValuesOptions.Builder(workspaceId, entity);
      listOptionsBuilder.sort("updated");
      listOptionsBuilder.pageLimit(1L);
      listOptionsBuilder.export(true);

      ValueCollection response =
          service.listValues(listOptionsBuilder.build()).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false;
      boolean found2 = false;
      while (true) {
        assertNotNull(response.getValues());
        assertTrue(response.getValues().size() == 1);
        found1 |= response.getValues().get(0).value().equals(entityValue1);
        found2 |= response.getValues().get(0).value().equals(entityValue2);
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response =
            service.listValues(listOptionsBuilder.cursor(cursor).build()).execute().getResult();
      }

      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.deleteValue(deleteOptions).execute().getResult();
      service
          .deleteValue(deleteOptions.newBuilder().value(entityValue2).build())
          .execute()
          .getResult();
    }
  }

  /** Test updateValue. */
  @Test
  public void testUpdateValue() {

    String entity = "beverage";
    String entityValue1 = "coffee" + UUID.randomUUID().toString();
    String entityValue2 = "coffee" + UUID.randomUUID().toString();
    String synonym1 = "java";
    String synonym2 = "joe";

    // metadata
    Map<String, Object> valueMetadata = new HashMap<>();
    String metadataValue = "value for " + entityValue2;
    valueMetadata.put("key", metadataValue);

    try {
      CreateEntityOptions createOptions =
          new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions =
          new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    UpdateValueOptions updateOptions =
        new UpdateValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue1)
            .newValue(entityValue2)
            .newSynonyms(new ArrayList<>(Arrays.asList(synonym1, synonym2)))
            .newMetadata(valueMetadata)
            .build();
    Value response = service.updateValue(updateOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.value());
      assertEquals(response.value(), entityValue2);

      GetValueOptions getOptions =
          new GetValueOptions.Builder(workspaceId, entity, entityValue2)
              .export(true)
              .includeAudit(true)
              .build();
      Value vResponse = service.getValue(getOptions).execute().getResult();

      assertNotNull(vResponse);
      assertNotNull(vResponse.value());
      assertEquals(vResponse.value(), entityValue2);
      assertNotNull(vResponse.created());
      assertNotNull(vResponse.updated());

      assertNotNull(vResponse.synonyms());
      assertTrue(vResponse.synonyms().size() == 2);
      assertTrue(vResponse.synonyms().contains(synonym1));
      assertTrue(vResponse.synonyms().contains(synonym2));

      // metadata
      assertNotNull(response.metadata());
      assertNotNull(response.metadata().get("key"));
      assertEquals(response.metadata().get("key"), metadataValue);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteValueOptions deleteOptions =
          new DeleteValueOptions.Builder(workspaceId, entity, entityValue2).build();
      service.deleteValue(deleteOptions).execute().getResult();
    }
  }
}
