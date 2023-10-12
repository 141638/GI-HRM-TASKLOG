package com.gi.hrm.config.router;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RouterFunctions.Builder;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gi.hrm.common.CommonRouterProperties;
import com.gi.hrm.service.category.CategoryServiceHandler;

@Configuration
public class CategoryRouterConfig extends CommonRouterProperties {

	@Bean
	RouterFunction<ServerResponse> categoryRouterFunction(CategoryServiceHandler categoryService) {
		Consumer<Builder> consumerBuilder = builder -> {
			builder.GET("list", categoryService::list);
			builder.POST("upsert", categoryService::upsert);
			builder.DELETE("delete", categoryService::delete);
		};

		return RouterFunctions.route().path(CATEGORY_ENDPOINT, consumerBuilder).build();
	}
}
