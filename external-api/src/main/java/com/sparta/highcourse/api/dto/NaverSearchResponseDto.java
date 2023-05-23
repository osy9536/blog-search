package com.sparta.highcourse.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class NaverSearchResponseDto {
    private List<Item> items;

    // Getters and Setters

    public static class Item {
        private String title;
        private String link;
        private String description;

        // Getters and Setters

        @Override
        public String toString() {
            return "Item{" +
                    "title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NaverSearchResponseDto{" +
                "items=" + items +
                '}';
    }
}
