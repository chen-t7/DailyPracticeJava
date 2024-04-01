package com.example.ioc.v1;

import com.example.ioc.v1.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(17);
        car.run();

        Car car2 = new Car(27);
        car2.run();
    }
}
