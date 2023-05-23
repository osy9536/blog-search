package com.sparta.highcourse.core.repository;

import com.sparta.highcourse.core.model.SearchKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchKeywordRepository extends JpaRepository<SearchKeyword, Long> {
    List<SearchKeyword> findTop10ByOrderBySearchCountDesc();

    SearchKeyword findByKeyword(String keyword);
}

