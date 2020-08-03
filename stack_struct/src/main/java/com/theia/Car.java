package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Car {

    private String model;
    private float price;

    public Car(String model, float price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
