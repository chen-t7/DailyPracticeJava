package com.example.ioc.v1;

public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        this.tire = new Tire(size);
        System.out.println("bottom init...");
    }
}
