package com.gi.hrm.service.workspace;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class WorkspaceRouterHandlerImpl implements WorkspaceRouterHandler {

	@Override
	public Mono<ServerResponse> search(ServerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ServerResponse> upsert(ServerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ServerResponse> delete(ServerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
