package com.example.ioc.v2;

public class Framework {
    private Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom = bottom;
        System.out.println("framework init...");
    }
}
