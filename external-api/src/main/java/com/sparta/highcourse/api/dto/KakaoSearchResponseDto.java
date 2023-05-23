package com.sparta.highcourse.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class KakaoSearchResponseDto {
    private Meta meta;
    private List<Document> documents;


    public static class Meta {
        private Integer total_count;
        private Integer pageable_count;
        private Boolean is_end;

    }
    @NoArgsConstructor
    @Getter
    public static class Document {
        private String title;
        private String contents;
        private String url;
        private String blogname;
        private String thumbnail;
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        private String datetime;

    }
}
