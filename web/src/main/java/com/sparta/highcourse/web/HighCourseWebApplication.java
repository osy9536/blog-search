package com.sparta.highcourse.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sparta.highcourse"})
@EnableJpaRepositories(basePackages = {"com.sparta.highcourse.core.repository"})
@EntityScan(basePackages = {"com.sparta.highcourse.core.model"})
public class HighCourseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighCourseWebApplication.class, args);
    }

}
