package com.sparta.highcourse.web.controller;

import com.sparta.highcourse.core.common.response.ApiResponseDto;
import com.sparta.highcourse.core.common.response.MsgType;
import com.sparta.highcourse.core.common.response.ResponseUtils;
import com.sparta.highcourse.core.model.SearchKeyword;
import com.sparta.highcourse.core.service.SearchKeywordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
@Tag(name = "검색 횟수 조회 API") // Swagger 태그 추가
public class SearchKeywordController {
    private final SearchKeywordService searchKeywordService;

    @GetMapping("/topKeywords")
    @Operation(summary = "검색 횟수 조회", description = "검색 횟수가 가장 많은 10개의 키워드를 보여줍니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "검색 횟수 조회 성공",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\" :\"검색 횟수 조회 성공\",\"data\" :[{\"id\": 1,\"keyword\":\"자바\",\"searchCount\":1}]}"))),
            @ApiResponse(responseCode = "400", description = "검색 횟소 조회 실패",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"error\" :{\"message\":\"인기 검색어가 존재하지 않습니다.\",\"code\" :400}}")))
    })
    public ApiResponseDto<List<SearchKeyword>> getTopSearchKeywords() {
        return ResponseUtils.ok(searchKeywordService.getTopSearchKeywords(), MsgType.SEARCH_COUNT_CHECK_SUCCESSFULLY);
    }
}

