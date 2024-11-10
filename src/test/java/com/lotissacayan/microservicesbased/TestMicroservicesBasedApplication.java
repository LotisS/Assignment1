package com.lotissacayan.microservicesbased;

import org.springframework.boot.SpringApplication;

public class TestMicroservicesBasedApplication {

    public static void main(String[] args) {
        SpringApplication.from(MicroservicesBasedApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
