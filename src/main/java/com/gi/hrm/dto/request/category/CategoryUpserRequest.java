package com.gi.hrm.dto.request.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryUpserRequest {
	private Integer id;
	private String name;
	private String color;
}
