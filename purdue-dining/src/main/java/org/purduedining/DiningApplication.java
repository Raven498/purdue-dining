package org.purduedining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.erudite.erudite_node")
public class DiningApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiningApplication.class, args);
    }
}