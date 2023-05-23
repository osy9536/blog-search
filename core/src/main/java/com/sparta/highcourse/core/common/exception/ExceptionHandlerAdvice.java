package com.sparta.highcourse.core.common.exception;

import com.sparta.highcourse.core.common.response.ApiResponseDto;
import com.sparta.highcourse.core.common.response.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(ex);
        log.error("CustomException occurred: {}", errorResponse.getMessage());
        return ResponseEntity
                .status(errorResponse.getCode())
                .body(ResponseUtils.error(errorResponse));
    }
}
