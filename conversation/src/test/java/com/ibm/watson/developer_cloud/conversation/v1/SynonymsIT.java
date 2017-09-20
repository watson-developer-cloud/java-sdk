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
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListSynonymsOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.SynonymCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.Synonym;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateSynonymOptions;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(RetryRunner.class)
public class SynonymsIT extends ConversationServiceTest {

  /**
   * Test createSynonym.
   */
  @Test
  public void testCreateSynonym() {

    String entity = "beverage";
    String entityValue = "orange juice";
    String synonym = "OJ";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .synonym(synonym)
            .build();
    Synonym response = service.createSynonym(createOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getSynonymText());
      assertEquals(response.getSynonymText(), synonym);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      service.deleteSynonym(deleteOptions).execute();
    }
  }

  /**
   * Test deleteSynonym.
   */
  @Test
  public void testDeleteSynonym() {

    String entity = "beverage";
    String entityValue = "orange juice";
    String synonym = "OJ";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateSynonymOptions createOptions =
            new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
    Synonym response = service.createSynonym(createOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getSynonymText());
      assertEquals(response.getSynonymText(), synonym);
    } catch (Exception ex) {
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      service.deleteSynonym(deleteOptions).execute();
      fail(ex.getMessage());
    }

    DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .synonym(synonym)
            .build();
    service.deleteSynonym(deleteOptions).execute();

    try {
      GetSynonymOptions getOptions =
              new GetSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      service.getSynonym(getOptions).execute();
      fail("deleteSynonym failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getSynonym.
   */
  @Test
  public void testGetSynonym() {

    String entity = "beverage";
    String entityValue = "orange juice";
    String synonym = "OJ";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    CreateSynonymOptions createOptions =
            new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
    service.createSynonym(createOptions).execute();

    try {
      GetSynonymOptions getOptions =
              new GetSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      Synonym response = service.getSynonym(getOptions).execute();

      assertNotNull(response);
      assertNotNull(response.getSynonymText());
      assertEquals(response.getSynonymText(), synonym);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      service.deleteSynonym(deleteOptions).execute();
    }
  }

  /**
   * Test listSynonyms.
   */
  @Test
  public void testListSynonyms() {

    String entity = "beverage";
    String entityValue = "coffee";
    String synonym1 = "java";
    String synonym2 = "joe";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateSynonymOptions createOptions =
              new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1).build();
      service.createSynonym(createOptions).execute();
      service.createSynonym(createOptions.newBuilder().synonym(synonym2).build()).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListSynonymsOptions listOptions = new ListSynonymsOptions.Builder()
              .workspaceId(workspaceId)
              .entity(entity)
              .value(entityValue)
              .build();
      final SynonymCollection response = service.listSynonyms(listOptions).execute();
      assertNotNull(response);
      assertNotNull(response.getSynonyms());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null
      if (response.getPagination().getNextUrl() == null) {
        assertNull(response.getPagination().getCursor());
      } else {
        assertNotNull(response.getPagination().getCursor());
      }

      assertTrue(response.getSynonyms().size() >= 2);

      // Should not be paginated, but just to be sure
      if (response.getPagination().getNextUrl() == null) {
        //assertTrue(response.getSynonyms().stream().filter(r -> r.getSynonym().equals(synonym1)).count() == 1);
        boolean found1 = false, found2 = false;
        for (Synonym synonymResponse : response.getSynonyms()) {
          found1 |= synonymResponse.getSynonymText().equals(synonym1);
          found2 |= synonymResponse.getSynonymText().equals(synonym2);
        }
        assertTrue(found1 && found2);
      }

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1).build();
      service.deleteSynonym(deleteOptions).execute();
      service.deleteSynonym(deleteOptions.newBuilder().synonym(synonym2).build()).execute();
    }
  }

  /**
   * Test listSynonyms with pagination.
   */
  @Test
  public void testListSynonymsWithPaging() {

    String entity = "beverage";
    String entityValue = "coffee";
    String synonym1 = "java";
    String synonym2 = "joe";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateSynonymOptions createOptions =
            new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1).build();
    try {
      service.createSynonym(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }
    try {
      service.createSynonym(createOptions.newBuilder().synonym(synonym2).build()).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListSynonymsOptions.Builder listOptionsBuilder
              = new ListSynonymsOptions.Builder(workspaceId, entity, entityValue);
      listOptionsBuilder.sort("modified");
      listOptionsBuilder.pageLimit(1L);

      SynonymCollection response =
              service.listSynonyms(listOptionsBuilder.build()).execute();
      assertNotNull(response);
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getCursor());

      boolean found1 = false, found2 = false;
      while (true) {
        assertNotNull(response.getSynonyms());
        assertTrue(response.getSynonyms().size() == 1);
        found1 |= response.getSynonyms().get(0).getSynonymText().equals(synonym1);
        found2 |= response.getSynonyms().get(0).getSynonymText().equals(synonym2);
        if (response.getPagination().getCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getCursor();
        response = service.listSynonyms(listOptionsBuilder.cursor(cursor).build()).execute();
      }

      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1).build();
      service.deleteSynonym(deleteOptions).execute();
      service.deleteSynonym(deleteOptions.newBuilder().synonym(synonym2).build()).execute();
    }
  }

  /**
   * Test updateSynonym.
   */
  @Test
  public void testUpdateSynonym() {

    String entity = "beverage";
    String entityValue = "coffee";
    String synonym1 = "joe";
    String synonym2 = "mud";

    try {
      CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity).build();
      service.createEntity(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateSynonymOptions createOptions =
              new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1).build();
      service.createSynonym(createOptions).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    UpdateSynonymOptions updateOptions = new UpdateSynonymOptions.Builder()
            .workspaceId(workspaceId)
            .entity(entity)
            .value(entityValue)
            .synonym(synonym1)
            .newSynonym(synonym2)
            .build();
    Synonym response = service.updateSynonym(updateOptions).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getSynonymText());
      assertEquals(response.getSynonymText(), synonym2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      //assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteSynonymOptions deleteOptions =
              new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym2).build();
      service.deleteSynonym(deleteOptions).execute();
    }
  }
}
