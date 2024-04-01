package com.example.ioc.v1;

public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        this.bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
