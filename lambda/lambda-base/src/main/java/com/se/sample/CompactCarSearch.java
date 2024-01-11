package com.se.sample;

public class CompactCarSearch implements Searchable {
    public boolean test(Car car) {
        return car.getType().equals(CarTypes.COMPACT);
    }
}