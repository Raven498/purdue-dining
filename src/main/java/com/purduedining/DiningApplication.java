package com.purduedining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.purduedining")
public class DiningApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiningApplication.class, args);
    }
}