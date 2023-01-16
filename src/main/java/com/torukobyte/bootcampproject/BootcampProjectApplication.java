package com.torukobyte.bootcampproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BootcampProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootcampProjectApplication.class, args);
    }
}
