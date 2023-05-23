package com.sparta.highcourse.core.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MsgType {
    SEARCH_SUCCESSFULLY("블로그 검색 성공"),
    SEARCH_COUNT_CHECK_SUCCESSFULLY("검색 횟수 조회 성공"),
    ;

    private final String msg;
}
