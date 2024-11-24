package com.tecnocampus.agile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;

@SpringBootApplication(exclude = {PropertyPlaceholderAutoConfiguration.class})
public class AgileApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgileApplication.class, args);
    }

}
