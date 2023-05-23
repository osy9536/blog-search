package com.sparta.highcourse.api.client;

import com.sparta.highcourse.api.dto.KakaoSearchRequestDto;
import com.sparta.highcourse.api.dto.KakaoSearchResponseDto;
import com.sparta.highcourse.api.dto.NaverSearchRequestDto;
import com.sparta.highcourse.api.dto.NaverSearchResponseDto;

import java.util.List;

public interface BlogSearchClient {
    List<KakaoSearchResponseDto.Document> kakaoSearchBlogs(KakaoSearchRequestDto requestDTO);
    List<NaverSearchResponseDto.Item> naverSearchBlogs(NaverSearchRequestDto requestDTO);

}
