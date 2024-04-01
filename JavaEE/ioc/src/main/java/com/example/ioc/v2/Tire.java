package com.example.ioc.v2;

public class Tire {
    private int size;
    private String color;

    public Tire(int size, String color) {
        this.size = size;
        System.out.println("tire init..." + size + color);
    }
}
