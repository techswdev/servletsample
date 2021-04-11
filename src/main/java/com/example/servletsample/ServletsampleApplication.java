package com.example.servletsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletsampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletsampleApplication.class, args);
    }

}
