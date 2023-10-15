package com.gi.hrm.repository.template.workspace;

import com.gi.hrm.entity.Workspace;

import reactor.core.publisher.Flux;

public interface WorkspaceTemplateOperation {
	Flux<Workspace> search(String name, String projectId, String staffId);
}
