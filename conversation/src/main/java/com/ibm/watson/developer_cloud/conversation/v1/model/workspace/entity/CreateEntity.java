package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

public class CreateEntity {

	private String entity;
//	The name of the entity.
	private String description;
//	The description of the entity.
	
	private String type;
//	Reserved for future use.
	
	private String source;
//	The source of the entity. For system entities, system.entities is returned.
	
	private boolean open_list;
//	Reserved for future use.
	
	private List<CreateValue>	values;
//	An array of entity values.
}
