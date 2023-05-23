package com.sparta.highcourse.core.service;

import com.sparta.highcourse.api.dto.KakaoSearchRequestDto;

import java.util.List;

public interface BlogSearchService {
    List<?> searchKakaoBlogs(KakaoSearchRequestDto requestDTO);
}
