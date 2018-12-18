package com.beam.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class LaunchService {


    @Autowired
    private static ApplicationContext context;

    public static void main(String str[]) {
        SpringApplication.run(LaunchService.class, str);
    }
}