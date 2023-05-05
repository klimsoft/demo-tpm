package com.example.demotpm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SystemTest {
    private static final String BASE_URL = "http://localhost:8080/";

    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void setup() {
        SpringApplication application = new SpringApplication(DemoTpmApplication.class);
        context = application.run();
    }

    @AfterAll
    public static void cleanup() {
        context.stop();
    }
}
