package com.gi.hrm.dto.response;

import org.springframework.http.HttpStatus;

import com.gi.hrm.common.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	private Integer status;
	private String message;
	private Object item;

	public static ApiResponse ApiResponseSuccess(Object object) {
		return new ApiResponse(Constants.HTTP_200, Constants.SUCCESS, object);
	}

	public static ApiResponse ApiResponseErrorHandler(HttpStatus status, Object object) {
		return new ApiResponse(status.value(), status.toString(), object);
	}
}
