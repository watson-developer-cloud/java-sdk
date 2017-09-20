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
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValue;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.EntityCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.EntityExport;
import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListEntitiesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ValueExport;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.util.RetryRunner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(RetryRunner.class)
public class EntitiesIT extends ConversationServiceTest {

  /**
   * Test createEntity.
   */
  @Test
  public void testCreateEntity() {

    String entity = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String entityDescription = "Description of " + entity;
    Map<String, Object> entityMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + entity;
    entityMetadata.put("key", metadataValue);

    Date start = new Date();

    CreateEntityOptions.Builder optionsBuilder = new CreateEntityOptions.Builder();
    optionsBuilder.workspaceId(workspaceId);
    optionsBuilder.entity(entity);
    optionsBuilder.description(entityDescription);
    optionsBuilder.metadata(entityMetadata);
    optionsBuilder.fuzzyMatch(true);   // default is false
    Entity response = service.createEntity(optionsBuilder.build()).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getEntityName());
      assertEquals(response.getEntityName(), entity);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), entityDescription);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue);

      assertNotNull(response.isFuzzyMatch());
      assertTrue(response.isFuzzyMatch());
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity).build();
      service.deleteEntity(deleteOptions).execute();
    }
  }

  /**
   * Test deleteEntity.
   */
  @Test
  public void testDeleteEntity() {

    String entity = "Hello" + UUID.randomUUID().toString();  // gotta be unique

    CreateEntityOptions options = new CreateEntityOptions.Builder(workspaceId, entity).build();
    Entity response = service.createEntity(options).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getEntityName());
      assertEquals(response.getEntityName(), entity);
      assertNull(response.getDescription());
      assertNull(response.getMetadata());
      assertTrue(response.isFuzzyMatch() == null || response.isFuzzyMatch().equals(Boolean.FALSE));
    } catch (Exception ex) {
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity).build();
      service.deleteEntity(deleteOptions).execute();
      fail(ex.getMessage());
    }

    DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity).build();
    service.deleteEntity(deleteOptions).execute();

    try {
      GetEntityOptions getOptions = new GetEntityOptions.Builder(workspaceId, entity).build();
      service.getEntity(getOptions).execute();
      fail("deleteEntity failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getEntity.
   */
  @Test
  public void testGetEntity() {

    String entity = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String entityDescription = "Description of " + entity;
    String entityValue = "Value of " + entity;
    List<CreateValue> entityValues = new ArrayList<CreateValue>();
    entityValues.add(new CreateValue.Builder().value(entityValue).build());

    CreateEntityOptions.Builder optionsBuilder = new CreateEntityOptions.Builder();
    optionsBuilder.workspaceId(workspaceId);
    optionsBuilder.entity(entity);
    optionsBuilder.description(entityDescription);
    optionsBuilder.values(entityValues);
    service.createEntity(optionsBuilder.build()).execute();

    Date start = new Date();

    try {
      GetEntityOptions getOptions = new GetEntityOptions.Builder(workspaceId, entity).export(true).build();
      EntityExport response = service.getEntity(getOptions).execute();
      assertNotNull(response);
      assertNotNull(response.getEntityName());
      assertEquals(response.getEntityName(), entity);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), entityDescription);
      assertNotNull(response.getValues());
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      List<ValueExport> values = response.getValues();
      assertTrue(values.size() == 1);
      assertEquals(values.get(0).getValueText(), entityValue);
      assertTrue(fuzzyBefore(values.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(values.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(values.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(values.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity).build();
      service.deleteEntity(deleteOptions).execute();
    }
  }

  /**
   * Test listEntities.
   */
  @Test
  @Ignore("To be run locally until we fix the Rate limitation issue")
  public void testListEntities() {

    String entity = "Hello" + UUID.randomUUID().toString();  // gotta be unique

    try {
      ListEntitiesOptions listOptions = new ListEntitiesOptions.Builder(workspaceId).build();
      EntityCollection response = service.listEntities(listOptions).execute();
      assertNotNull(response);
      assertNotNull(response.getEntities());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null

      // Now add an entity and make sure we get it back
      String entityDescription = "Description of " + entity;
      String entityValue = "Value of " + entity;
      CreateEntityOptions options = new CreateEntityOptions.Builder(workspaceId, entity)
              .description(entityDescription)
              .addValue(new CreateValue.Builder(entityValue).build())
              .build();
      service.createEntity(options).execute();

      ListEntitiesOptions listOptions2 = listOptions.newBuilder()
              .sort("-modified").pageLimit(5L).export(true).build();
      EntityCollection response2 = service.listEntities(listOptions2).execute();
      assertNotNull(response2);
      assertNotNull(response2.getEntities());

      List<EntityExport> entities = response2.getEntities();
      EntityExport ieResponse = null;
      for (EntityExport resp : entities) {
        if (resp.getEntityName().equals(entity)) {
          ieResponse = resp;
          break;
        }
      }

      assertNotNull(ieResponse);
      assertNotNull(ieResponse.getDescription());
      assertEquals(ieResponse.getDescription(), entityDescription);
      assertNotNull(ieResponse.getValues());
      assertTrue(ieResponse.getValues().size() == 1);
      assertTrue(ieResponse.getValues().get(0).getValueText().equals(entityValue));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity).build();
      service.deleteEntity(deleteOptions).execute();
    }
  }

  /**
   * Test listEntities with pagination.
   */
  @Test
  @Ignore("To be run locally until we fix the Rate limitation issue")
  public void testListEntitiesWithPaging() {

    String entity1 = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String entity2 = "Goodbye" + UUID.randomUUID().toString();  // gotta be unique

    CreateEntityOptions createOptions = new CreateEntityOptions.Builder(workspaceId, entity1).build();
    service.createEntity(createOptions).execute();
    service.createEntity(createOptions.newBuilder().entity(entity2).build()).execute();

    try {
      ListEntitiesOptions listOptions = new ListEntitiesOptions.Builder(workspaceId)
              .sort("entity")
              .pageLimit(1L)
              .build();
      EntityCollection response = service.listEntities(listOptions).execute();
      assertNotNull(response);
      assertNotNull(response.getEntities());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getCursor());
      assertTrue(!response.getEntities().get(0).getEntityName().equals(entity1));

      EntityExport ieResponse = null;
      while (response.getPagination().getCursor() != null) {
        assertNotNull(response.getEntities());
        assertTrue(response.getEntities().size() == 1);
        if (response.getEntities().get(0).getEntityName().equals(entity1)) {
          ieResponse = response.getEntities().get(0);
          break;
        }
        String cursor = response.getPagination().getCursor();
        response = service.listEntities(listOptions.newBuilder().cursor(cursor).build()).execute();
      }

      assertNotNull(ieResponse);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity1).build();
      service.deleteEntity(deleteOptions).execute();
      service.deleteEntity(deleteOptions.newBuilder().entity(entity2).build()).execute();
    }
  }

  /**
   * Test updateEntity.
   */
  @Test
  public void testUpdateEntity() {

    String entity = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String entity2 = "Goodbye" + UUID.randomUUID().toString();  // gotta be unique
    String entityDescription = "Description of " + entity;

    CreateEntityOptions.Builder createOptionsBuilder = new CreateEntityOptions.Builder();
    createOptionsBuilder.workspaceId(workspaceId);
    createOptionsBuilder.entity(entity);
    createOptionsBuilder.description(entityDescription);
    service.createEntity(createOptionsBuilder.build()).execute();

    try {
      String entityDescription2 = "Description of " + entity2;
      String entityValue2 = "Value of " + entity2;
      Map<String, Object> entityMetadata2 = new HashMap<String, Object>();
      String metadataValue2 = "value for " + entity2;
      entityMetadata2.put("key", metadataValue2);

      UpdateEntityOptions.Builder updateOptionsBuilder = new UpdateEntityOptions.Builder(workspaceId, entity);
      updateOptionsBuilder.newEntity(entity2);
      updateOptionsBuilder.newDescription(entityDescription2);
      updateOptionsBuilder.addValue(new CreateValue.Builder().value(entityValue2).build());
      updateOptionsBuilder.newMetadata(entityMetadata2);
      updateOptionsBuilder.newFuzzyMatch(true);

      Date start = new Date();

      Entity response = service.updateEntity(updateOptionsBuilder.build()).execute();
      assertNotNull(response);
      assertNotNull(response.getEntityName());
      assertEquals(response.getEntityName(), entity2);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), entityDescription2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue2);

      assertNotNull(response.isFuzzyMatch());
      assertTrue(response.isFuzzyMatch());
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteEntityOptions deleteOptions = new DeleteEntityOptions.Builder(workspaceId, entity2).build();
      service.deleteEntity(deleteOptions).execute();
    }
  }
}
