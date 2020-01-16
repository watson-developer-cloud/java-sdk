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

import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateSynonymOptions;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.DeleteSynonymOptions;
import com.ibm.watson.assistant.v1.model.GetSynonymOptions;
import com.ibm.watson.assistant.v1.model.ListSynonymsOptions;
import com.ibm.watson.assistant.v1.model.Synonym;
import com.ibm.watson.assistant.v1.model.SynonymCollection;
import com.ibm.watson.assistant.v1.model.UpdateSynonymOptions;
import com.ibm.watson.common.RetryRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(RetryRunner.class)
public class SynonymsIT extends AssistantServiceTest {

  private Assistant service;
  private String workspaceId;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
    this.workspaceId = getWorkspaceId();
  }

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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder()
        .workspaceId(workspaceId)
        .entity(entity)
        .value(entityValue)
        .synonym(synonym)
        .build();
    Synonym response = service.createSynonym(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.synonym());
      assertEquals(response.synonym(), synonym);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
        .build();
    Synonym response = service.createSynonym(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.synonym());
      assertEquals(response.synonym(), synonym);
    } catch (Exception ex) {
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
      fail(ex.getMessage());
    }

    DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder()
        .workspaceId(workspaceId)
        .entity(entity)
        .value(entityValue)
        .synonym(synonym)
        .build();
    service.deleteSynonym(deleteOptions).execute().getResult();

    try {
      GetSynonymOptions getOptions = new GetSynonymOptions.Builder(workspaceId, entity, entityValue, synonym).build();
      service.getSynonym(getOptions).execute().getResult();
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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    Date start = new Date();

    CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
        .build();
    service.createSynonym(createOptions).execute().getResult();

    try {
      GetSynonymOptions getOptions = new GetSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
          .includeAudit(true)
          .build();
      Synonym response = service.getSynonym(getOptions).execute().getResult();

      assertNotNull(response);
      assertNotNull(response.synonym());
      assertEquals(response.synonym(), synonym);
      assertNotNull(response.created());
      assertNotNull(response.updated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.created(), now));
      assertTrue(fuzzyAfter(response.created(), start));
      assertTrue(fuzzyBefore(response.updated(), now));
      assertTrue(fuzzyAfter(response.updated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1)
          .build();
      service.createSynonym(createOptions).execute().getResult();
      service.createSynonym(createOptions.newBuilder().synonym(synonym2).build()).execute().getResult();
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
      final SynonymCollection response = service.listSynonyms(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getSynonyms());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null
      if (response.getPagination().getNextUrl() == null) {
        assertNull(response.getPagination().getNextCursor());
      } else {
        assertNotNull(response.getPagination().getNextCursor());
      }

      assertTrue(response.getSynonyms().size() >= 2);

      // Should not be paginated, but just to be sure
      if (response.getPagination().getNextUrl() == null) {
        //assertTrue(response.getSynonyms().stream().filter(r -> r.getSynonym().equals(synonym1)).count() == 1);
        boolean found1 = false;
        boolean found2 = false;
        for (Synonym synonymResponse : response.getSynonyms()) {
          found1 |= synonymResponse.synonym().equals(synonym1);
          found2 |= synonymResponse.synonym().equals(synonym2);
        }
        assertTrue(found1 && found2);
      }

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
      service.deleteSynonym(deleteOptions.newBuilder().synonym(synonym2).build()).execute().getResult();
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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1)
        .build();
    try {
      service.createSynonym(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }
    try {
      service.createSynonym(createOptions.newBuilder().synonym(synonym2).build()).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      ListSynonymsOptions.Builder listOptionsBuilder = new ListSynonymsOptions.Builder(workspaceId, entity,
          entityValue);
      listOptionsBuilder.sort("modified");
      listOptionsBuilder.pageLimit(1L);

      SynonymCollection response = service.listSynonyms(listOptionsBuilder.build()).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false, found2 = false;
      while (true) {
        assertNotNull(response.getSynonyms());
        assertTrue(response.getSynonyms().size() == 1);
        found1 |= response.getSynonyms().get(0).synonym().equals(synonym1);
        found2 |= response.getSynonyms().get(0).synonym().equals(synonym2);
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response = service.listSynonyms(listOptionsBuilder.cursor(cursor).build()).execute().getResult();
      }

      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
      service.deleteSynonym(deleteOptions.newBuilder().synonym(synonym2).build()).execute().getResult();
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
      service.createEntity(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateValueOptions createOptions = new CreateValueOptions.Builder(workspaceId, entity, entityValue).build();
      service.createValue(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    try {
      CreateSynonymOptions createOptions = new CreateSynonymOptions.Builder(workspaceId, entity, entityValue, synonym1)
          .build();
      service.createSynonym(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }

    UpdateSynonymOptions updateOptions = new UpdateSynonymOptions.Builder()
        .workspaceId(workspaceId)
        .entity(entity)
        .value(entityValue)
        .synonym(synonym1)
        .newSynonym(synonym2)
        .build();
    Synonym response = service.updateSynonym(updateOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.synonym());
      assertEquals(response.synonym(), synonym2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteSynonymOptions deleteOptions = new DeleteSynonymOptions.Builder(workspaceId, entity, entityValue, synonym2)
          .build();
      service.deleteSynonym(deleteOptions).execute().getResult();
    }
  }
}
