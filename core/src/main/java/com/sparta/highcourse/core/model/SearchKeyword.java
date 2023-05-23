package com.sparta.highcourse.core.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String keyword;

    @Column(nullable = false)
    private Long searchCount;

    @Builder
    private SearchKeyword(String keyword) {
        this.keyword = keyword;
        this.searchCount = 1L;
    }

    public static SearchKeyword create(String keyword) {
        return builder()
                .keyword(keyword)
                .build();
    }

    public void incrementSearchCount() {
        this.searchCount++;
    }
}
