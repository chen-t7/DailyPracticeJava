package com.example.ioc.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    public void doConfiguration() {
        System.out.println("doConfiguration...");
    }
}
