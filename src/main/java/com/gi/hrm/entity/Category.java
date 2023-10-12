package com.gi.hrm.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gi.hrm.common.entity.CommonEntity;
import com.gi.hrm.common.entity.CommonEntityProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = CommonEntityProperties.COLLECTION_CATEGORY)
public class Category {

	@Transient
	public static final String SEQUENCE_NAME = "categories_sequence";
	@Id
	private Integer id;
	private String name;
	private String color;
}
