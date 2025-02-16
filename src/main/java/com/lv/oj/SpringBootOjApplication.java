package com.lv.oj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootOjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOjApplication.class, args);
    }

}
