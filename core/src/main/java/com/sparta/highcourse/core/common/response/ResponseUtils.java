package com.sparta.highcourse.core.common.response;
import com.sparta.highcourse.core.common.exception.ErrorResponse;

public class ResponseUtils {

    public static <T> ApiResponseDto<T> ok(T data, MsgType message) {
        return ApiResponseDto.<T>builder()
                .data(data)
                .message(message.getMsg())
                .build();
    }

    public static ApiResponseDto<Void> ok(String message) {
        return ApiResponseDto.<Void>builder()
                .message(message)
                .build();
    }

    public static ApiResponseDto<Void> error(ErrorResponse error) {
        return ApiResponseDto.<Void>builder()
                .error(error)
                .build();
    }
}
