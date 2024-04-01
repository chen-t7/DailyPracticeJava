package com.example.ioc.component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void doComponent() {
        System.out.println("doComponent...");
    }
}
