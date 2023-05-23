package com.sparta.highcourse.core.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.highcourse.core.common.exception.ErrorResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T> {
    private ErrorResponse error;
    private String message;
    private T data;

    @Builder
    public ApiResponseDto(ErrorResponse error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }
}
