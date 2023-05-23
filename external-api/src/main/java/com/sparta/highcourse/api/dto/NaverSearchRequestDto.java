package com.sparta.highcourse.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverSearchRequestDto {
    private String query;
    private Integer display;
    private Integer start;
    private String sort;

    @Builder
    private NaverSearchRequestDto(String query, Integer display, Integer start, String sort) {
        this.query = query;
        this.display = display;
        this.start = start;
        this.sort = sort;
    }

    public static NaverSearchRequestDto of(String query, Integer display, Integer start, String sort) {
        return builder()
                .display(display)
                .query(query)
                .sort(sort)
                .start(start)
                .build();
    }
}
