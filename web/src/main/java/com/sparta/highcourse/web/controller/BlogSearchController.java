package com.sparta.highcourse.web.controller;

import com.sparta.highcourse.api.dto.KakaoSearchRequestDto;
import com.sparta.highcourse.core.common.response.ApiResponseDto;
import com.sparta.highcourse.core.common.response.MsgType;
import com.sparta.highcourse.core.common.response.ResponseUtils;
import com.sparta.highcourse.core.service.BlogSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
@Tag(name = "블로그 검색 API") // Swagger 태그 추가
public class BlogSearchController {
    private final BlogSearchService blogSearchService;

    @GetMapping("/search")
    @Operation(summary = "블로그 검색", description = "키워드를 통해 블로그를 검색합니다.")// Swagger API 설명 추가
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "블로그 검색 성공",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\" :\"블로그 검색 성공\",\"data\" :[{\"title\": \"string\",\"contents\":\"내용\",\"url\":\"주소\",\"blogname\":\"블로그 이름\",\"thumbnail\":\"\",\"datetime\":\"2023-05-22T12:24:50.000+09:00\"}]}"))),
            @ApiResponse(responseCode = "400", description = "블로그 검색 실패",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"error\" :{\"message\":\"요청이 잘못되었습니다.\",\"code\" :400}}")))
    })
    public ApiResponseDto<List<?>> searchBlogs(@RequestBody KakaoSearchRequestDto requestDto) {

        return ResponseUtils.ok(blogSearchService.searchKakaoBlogs(requestDto), MsgType.SEARCH_SUCCESSFULLY);
    }
}

