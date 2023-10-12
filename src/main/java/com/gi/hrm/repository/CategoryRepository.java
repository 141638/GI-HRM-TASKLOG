package com.gi.hrm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.gi.hrm.entity.Category;

import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, Integer> {

//	Mono<Category> findByIdAndDeleteFlagFalse(Integer id);
}
