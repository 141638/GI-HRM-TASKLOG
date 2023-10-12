package com.gi.hrm.service.category;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gi.hrm.dto.request.category.CategoryUpserRequest;
import com.gi.hrm.dto.response.PreBuiltServerResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryServiceHandler {
	private final CategoryDetailService detailService;

	@Override
	public Mono<ServerResponse> upsert(ServerRequest request) {
		return request.bodyToMono(CategoryUpserRequest.class).map(detailService::upsertCategory)
		        .flatMap(PreBuiltServerResponse::success);
	}

	@Override
	public Mono<ServerResponse> list(ServerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ServerResponse> delete(ServerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
