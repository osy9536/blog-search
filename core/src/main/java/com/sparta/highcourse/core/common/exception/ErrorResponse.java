package com.sparta.highcourse.core.common.exception;

import lombok.Builder;
import lombok.Getter;

import javax.lang.model.type.ErrorType;

@Getter
public class ErrorResponse {
    private String message;
    private int code;

    @Builder
    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static ErrorResponse of(CustomException e) {
        return ErrorResponse.builder()
                .code(e.getHttpStatus().value())
                .message(e.getMessage())
                .build();
    }
}
