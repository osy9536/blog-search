package com.sparta.highcourse.api.client;

import com.sparta.highcourse.api.dto.KakaoSearchRequestDto;
import com.sparta.highcourse.api.dto.KakaoSearchResponseDto;
import com.sparta.highcourse.api.dto.NaverSearchRequestDto;
import com.sparta.highcourse.api.dto.NaverSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BlogSearchClientImpl implements BlogSearchClient {
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_DISPLAY = 10;
    private static final int DEFAULT_START = 1;
    private static final String DEFAULT_SORT = "accuracy";
    private final RestTemplate restTemplate;
    @Value("${api.kakao.url}")
    private String kakaoApiUrl;
    @Value("${api.kakao.key}")
    private String kakaoApiKey;

    @Value("${api.naver.url}")
    private String apiUrl;
    @Value("${api.naver.clientId}")
    private String clientId;
    @Value("${api.naver.clientSecret}")
    private String clientSecret;

    @Override
    public List<KakaoSearchResponseDto.Document> kakaoSearchBlogs(KakaoSearchRequestDto requestDTO) {

        if (requestDTO.getPage() == null) {
            requestDTO.setPage(DEFAULT_PAGE);
        }
        if (requestDTO.getSize() == null) {
            requestDTO.setSize(DEFAULT_SIZE);
        }
        if (requestDTO.getSort() == null) {
            requestDTO.setSort(DEFAULT_SORT);
        }

        // Build API request URL with parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(kakaoApiUrl)
                .queryParam("query", requestDTO.getQuery())
                .queryParam("sort", requestDTO.getSort())
                .queryParam("page", requestDTO.getPage())
                .queryParam("size", requestDTO.getSize());

        // Set headers including API key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK "+ kakaoApiKey);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Send API request and retrieve response
        ResponseEntity<KakaoSearchResponseDto> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                KakaoSearchResponseDto.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            KakaoSearchResponseDto searchResponse = response.getBody();
            if (searchResponse != null) {
                return searchResponse.getDocuments();
            }
        }

        // Handle error response or empty response if needed
        return Collections.emptyList();
    }

    @Override
    public List<NaverSearchResponseDto.Item> naverSearchBlogs(NaverSearchRequestDto requestDTO) {
        if (requestDTO.getDisplay() == null) {
            requestDTO.setDisplay(DEFAULT_DISPLAY);
        }
        if (requestDTO.getStart() == null) {
            requestDTO.setStart(DEFAULT_START);
        }

        // Build API request URL with parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("query", requestDTO.getQuery())
                .queryParam("display", requestDTO.getDisplay())
                .queryParam("start", requestDTO.getStart());

        // Set headers including API key
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Send API request and retrieve response
        ResponseEntity<NaverSearchResponseDto> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                NaverSearchResponseDto.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            NaverSearchResponseDto searchResponse = response.getBody();
            if (searchResponse != null) {
                return searchResponse.getItems();
            }
        }

        // Handle error response or empty response if needed
        return Collections.emptyList();
    }
}