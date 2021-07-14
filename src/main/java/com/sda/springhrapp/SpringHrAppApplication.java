package com.sda.springhrapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringHrAppApplication {

    public static void main(String[] args) {
        log.info("Application started!");
        SpringApplication.run(SpringHrAppApplication.class, args);
        log.info("Application works, you can use it!");
    }
}
