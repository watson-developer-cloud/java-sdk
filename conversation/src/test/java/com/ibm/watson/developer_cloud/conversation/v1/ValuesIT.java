/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1;

import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListValuesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ValueCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.ValueExport;
import com.ibm.watson.developer_cloud.conversation.v1.model.Value;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(RetryRunner.class)
public class ValuesIT extends ConversationServiceTest {

  /**
   * Test createValue.
   */
  @Test
  public void testCreateValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();

    // metadata
    Map<String, Object> valueMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + entityValue;
    valueMetadata.put("key", metadataValue);

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    CreateValueOptions createOptions = new CreateValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .metadata(valueMetadata)
            .build();
    Value response = service.createValue(createOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getValueText());
      assertEquals(response.getValueText(), entityValue);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());
      assertNotNull(response.getMetadata());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      // metadata
      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute();
    }
  }

  /**
   * Test deleteValue.
   */
  @Test
  public void testDeleteValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions =
            new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
    Value response = service.createValue(createOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getValueText());
      assertEquals(response.getValueText(), entityValue);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());
      assertNull(response.getMetadata());
    } catch (Exception ex) {
      // Clean up
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute();
      fail(ex.getMessage());
    }

    DeleteValueOptions deleteOptions = new DeleteValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .build();
    service.deleteValue(deleteOptions).execute();

    try {
      GetValueOptions getOptions =
              new GetValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.getValue(getOptions).execute();
      fail("deleteValue failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getValue.
   */
  @Test
  public void testGetValue() {

    String entity = "beverage";
    String entityValue = "coffee" + UUID.randomUUID().toString();
    String synonym1 = "java";
    String synonym2 = "joe";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue)
            .synonyms(new ArrayList<String>(Arrays.asList(synonym1, synonym2)))
            .build();
    service.createValue(createOptions).execute();

    Date start = new Date();

    try {
      GetValueOptions getOptions =
              new GetValueOptions.Builder(workspaceId, entity, entityValue)
                      .export(true)
                      .build();
      ValueExport response = service.getValue(getOptions).execute();

      assertNotNull(response);
      assertNotNull(response.getValueText());
      assertEquals(response.getValueText(), entityValue);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      assertNotNull(response.getSynonyms());
      assertTrue(response.getSynonyms().size() == 2);
      assertTrue(response.getSynonyms().contains(synonym1));
      assertTrue(response.getSynonyms().contains(synonym2));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.deleteValue(deleteOptions).execute();
    }
  }

  /**
   * Test listValues.
   */
  @Test
  public void testListValues() {

    String entity = "beverage";
    String entityValue1 = "coffee";
    String entityValue2 = "orange juice";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
    try {
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      service.createValue(createOptions.newBuilder().value(entityValue2).build()).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListValuesOptions listOptions = new ListValuesOptions.Builder()
              .workspaceId(workspaceId)
              .entity(entity)
              .build();
      final ValueCollection response = service.listValues(listOptions).execute();
      assertNotNull(response);
      assertNotNull(response.getValues());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null
      if (response.getPagination().getNextUrl() == null) {
        assertNull(response.getPagination().getCursor());
      } else {
        assertNotNull(response.getPagination().getCursor());
      }

      assertTrue(response.getValues().size() >= 2);

      // Should not be paginated, but just to be sure
      if (response.getPagination().getNextUrl() == null) {
        //assertTrue(response.getValues().stream().filter(r -> r.getValue().equals(synonym1)).count() == 1);
        boolean found1 = false, found2 = false;
        for (ValueExport valueResponse : response.getValues()) {
          found1 |= valueResponse.getValueText().equals(entityValue1);
          found2 |= valueResponse.getValueText().equals(entityValue2);
        }
        assertTrue(found1 && found2);
      }

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.deleteValue(deleteOptions).execute();
      service.deleteValue(deleteOptions.newBuilder().value(entityValue2).build()).execute();
    }
  }

  /**
   * Test listValues with pagination.
   */
  @Test
  public void testListValuesWithPaging() {

    String entity = "beverage";
    String entityValue1 = "coffee";
    String entityValue2 = "orange juice";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
    try {
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      service.createValue(createOptions.newBuilder().value(entityValue2).build()).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListValuesOptions.Builder listOptionsBuilder
              = new ListValuesOptions.Builder(workspaceId, entity);
      listOptionsBuilder.sort("modified");
      listOptionsBuilder.pageLimit(1L);
      listOptionsBuilder.export(true);

      ValueCollection response =
              service.listValues(listOptionsBuilder.build()).execute();
      assertNotNull(response);
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getCursor());

      boolean found1 = false, found2 = false;
      while (true) {
        assertNotNull(response.getValues());
        assertTrue(response.getValues().size() == 1);
        found1 |= response.getValues().get(0).getValueText().equals(entityValue1);
        found2 |= response.getValues().get(0).getValueText().equals(entityValue2);
        if (response.getPagination().getCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getCursor();
        response = service.listValues(listOptionsBuilder.cursor(cursor).build()).execute();
      }

      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.deleteValue(deleteOptions).execute();
      service.deleteValue(deleteOptions.newBuilder().value(entityValue2).build()).execute();
    }
  }

  /**
   * Test updateValue.
   */
  @Test
  public void testUpdateValue() {

    String entity = "beverage";
    String entityValue1 = "coffee" + UUID.randomUUID().toString();
    String entityValue2 = "coffee" + UUID.randomUUID().toString();
    String synonym1 = "java";
    String synonym2 = "joe";

    // metadata
    Map<String, Object> valueMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + entityValue2;
    valueMetadata.put("key", metadataValue);

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue1).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    UpdateValueOptions updateOptions = new UpdateValueOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue1)
            .newValue(entityValue2)
            .newSynonyms(new ArrayList<String>(Arrays.asList(synonym1, synonym2)))
            .newMetadata(valueMetadata)
            .build();
    Value response = service.updateValue(updateOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getValueText());
      assertEquals(response.getValueText(), entityValue2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      //assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      GetValueOptions getOptions =
              new GetValueOptions.Builder(workspaceId, entity, entityValue2)
                      .export(true)
                      .build();
      ValueExport vResponse = service.getValue(getOptions).execute();

      assertNotNull(vResponse);
      assertNotNull(vResponse.getValueText());
      assertEquals(vResponse.getValueText(), entityValue2);
      assertNotNull(vResponse.getCreated());
      assertNotNull(vResponse.getUpdated());

      assertEquals(vResponse.getCreated(), response.getCreated());
      assertEquals(vResponse.getUpdated(), response.getUpdated());

      assertNotNull(vResponse.getSynonyms());
      assertTrue(vResponse.getSynonyms().size() == 2);
      assertTrue(vResponse.getSynonyms().contains(synonym1));
      assertTrue(vResponse.getSynonyms().contains(synonym2));

      // metadata
      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteValueOptions deleteOptions =
              new DeleteValueOptions.Builder(workspaceId, entity, entityValue2).build();
      service.deleteValue(deleteOptions).execute();
    }
  }
}
