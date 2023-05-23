package com.sparta.highcourse.core.service;

import com.sparta.highcourse.core.common.exception.CustomException;
import com.sparta.highcourse.core.model.SearchKeyword;
import com.sparta.highcourse.core.repository.SearchKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchKeywordService {
    private final SearchKeywordRepository searchKeywordRepository;

    public List<SearchKeyword> getTopSearchKeywords() {
        List<SearchKeyword> topKeywords = searchKeywordRepository.findTop10ByOrderBySearchCountDesc();
        if (topKeywords.isEmpty()) {
            throw new CustomException("인기 검색어가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        return topKeywords;
    }

    public void incrementSearchCount(String keyword) {
        SearchKeyword searchKeyword = searchKeywordRepository.findByKeyword(keyword);
        if (searchKeyword != null) {
            searchKeyword.incrementSearchCount();
        } else {
            searchKeyword = SearchKeyword.create(keyword);
        }
        searchKeywordRepository.save(searchKeyword);
    }
}
