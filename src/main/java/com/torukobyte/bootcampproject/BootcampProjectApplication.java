package com.torukobyte.bootcampproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootcampProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampProjectApplication.class, args);
    }

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
