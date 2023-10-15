package com.gi.hrm.repository.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

public class CommonTemplateOperation {
	protected final ReactiveMongoTemplate mongoTemplate;
	protected Query query;

	@Autowired
	public CommonTemplateOperation(ReactiveMongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	protected void initQuery() {
		this.query = new Query();
	}

	protected void criteriaWhereLike(String field, String value, boolean caseSensity) {
		if (StringUtils.hasText(value)) {
			if (caseSensity) {
				this.query.addCriteria(Criteria.where(field).regex(String.format(".*%s.*", value)));
			} else {
				this.query.addCriteria(Criteria.where(field).regex(String.format(".*%s.*", value), "i"));
			}
		}
	}

	protected void criteriaWhereEqual(String field, String value) {
		if (StringUtils.hasText(value)) {
			this.query.addCriteria(Criteria.where(field).is(value));
		}
	}
}
