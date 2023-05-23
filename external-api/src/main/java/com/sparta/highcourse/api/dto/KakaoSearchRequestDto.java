package com.sparta.highcourse.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoSearchRequestDto {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;
}
