package com.gi.hrm.common.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity {

	@Id
	private Integer id;

	private Date createdAt;

	private Integer createdBy;

	private Date updatedAt;

	private Integer updatedBy;

	private Boolean deleteFlag;

	public void setCommonRegist() {
		this.createdAt = new Date();
		this.updatedAt = this.createdAt;
		this.deleteFlag = false;
	}

	public void setCommonUpdate() {
		this.createdAt = new Date();
	}

	public void setCommonDelete() {
		this.deleteFlag = false;
		this.setCommonUpdate();
	}
}
