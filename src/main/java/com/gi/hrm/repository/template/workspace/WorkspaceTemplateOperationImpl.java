package com.gi.hrm.repository.template.workspace;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

import com.gi.hrm.common.CommonDocumentField;
import com.gi.hrm.common.entity.CommonEntityProperties;
import com.gi.hrm.entity.Workspace;
import com.gi.hrm.repository.template.CommonTemplateOperation;

import reactor.core.publisher.Flux;

@Repository
public class WorkspaceTemplateOperationImpl extends CommonTemplateOperation implements WorkspaceTemplateOperation {

	public WorkspaceTemplateOperationImpl(ReactiveMongoTemplate mongoTemplate) {
		super(mongoTemplate);
	}

	@Override
	public Flux<Workspace> search(String name, String projectId, String staffId) {
		initQuery();

		criteriaWhereLike(CommonDocumentField.WORKSPACE_NAME, name, false);
		criteriaWhereEqual(CommonDocumentField.WORKSPACE_PROJECT_ID, projectId);
		criteriaWhereEqual(CommonDocumentField.WORKSPACE_MEMBER_ID, staffId);

		return mongoTemplate.find(query, Workspace.class, CommonEntityProperties.COLLECTION_WORKSPACE);
	}
}
