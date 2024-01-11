package com.se.sample;

public class Car {

    private CarTypes type;
    private int cost ;

    public Car(CarTypes type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    public CarTypes getType() {
        return type;
    }

    public void setType(CarTypes type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carTypes=" + type +
                ", cost=" + cost +
                '}';
    }
}
