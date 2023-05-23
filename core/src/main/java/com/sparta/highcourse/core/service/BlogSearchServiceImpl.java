package com.sparta.highcourse.core.service;

import com.sparta.highcourse.api.client.BlogSearchClient;
import com.sparta.highcourse.api.dto.KakaoSearchRequestDto;
import com.sparta.highcourse.api.dto.NaverSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BlogSearchServiceImpl implements BlogSearchService {
    private final BlogSearchClient kakaoBlogSearchClient;
    private final BlogSearchClient naverBlogSearchClient;
    private final SearchKeywordService searchKeywordService;
    @Override
    public List<?> searchKakaoBlogs(KakaoSearchRequestDto requestDto) {
        try {
            return kakaoBlogSearchClient.kakaoSearchBlogs(requestDto);
        } catch (RuntimeException e){
            String sort = Objects.equals(requestDto.getSort(), "accuracy") ? "sim" : "date";
            NaverSearchRequestDto naverRequestDto = NaverSearchRequestDto.of(requestDto.getQuery(), requestDto.getSize()*requestDto.getPage(), 1, sort);
            return naverBlogSearchClient.naverSearchBlogs(naverRequestDto);
        } finally {
            searchKeywordService.incrementSearchCount(requestDto.getQuery());
        }
    }
}
