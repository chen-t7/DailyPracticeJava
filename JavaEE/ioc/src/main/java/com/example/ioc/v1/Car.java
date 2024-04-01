package com.example.ioc.v1;

public class Car {
    private Framework framework;

    public Car(int size) {
        this.framework = new Framework(size);
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
