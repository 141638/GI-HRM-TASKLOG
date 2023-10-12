package com.gi.hrm.service.category;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.gi.hrm.dto.request.category.CategoryUpserRequest;
import com.gi.hrm.entity.Category;
import com.gi.hrm.repository.CategoryRepository;
import com.gi.hrm.service.mongo.MongoUtilService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CategoryDetailService {
	private final CategoryRepository categoryRepository;
	private final MongoUtilService mongoService;

	public Mono<Category> upsertCategory(CategoryUpserRequest request) {
		Integer id = request.getId();
		String name = request.getName();
		String color = request.getColor();
		if (Objects.nonNull(id)) {
			return categoryRepository.findById(id).switchIfEmpty(Mono.just(null)).flatMap(category -> {
				category.setName(name);
				category.setColor(color);
				return categoryRepository.save(category);
			});

		} else {
			return mongoService.generateSequence(Category.SEQUENCE_NAME).map(idSeq -> new Category(idSeq, name, color))
			        .flatMap(categoryRepository::save);
		}
	}
}
