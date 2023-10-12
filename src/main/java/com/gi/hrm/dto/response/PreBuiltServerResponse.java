package com.gi.hrm.dto.response;

import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class PreBuiltServerResponse {
	private PreBuiltServerResponse() {
		throw new IllegalStateException("Utility class");
	}

	public static Mono<ServerResponse> success(Object responseObject) {
		return ServerResponse.ok().body(responseObject, ApiResponse.class);
	}

	public static Mono<ServerResponse> badRequest(Object responseObject) {
		return ServerResponse.badRequest().body(responseObject, ApiResponse.class);
	}
}
