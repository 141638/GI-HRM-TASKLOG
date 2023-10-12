package com.gi.hrm.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gi.hrm.common.entity.CommonEntity;
import com.gi.hrm.common.entity.CommonEntityProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(value = CommonEntityProperties.COLLECTION_WORKSPACE)
public class Workspace extends CommonEntity {
	private String name;
	private String alias;
	private Project project;
	private User member;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class Project {
		private Integer id;
		private String name;
	}
}
