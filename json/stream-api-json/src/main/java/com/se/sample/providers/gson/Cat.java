package com.se.sample.providers.gson;

public class Cat {
    public String name; // имя
    public int age; // возраст
    public int color; // цвет

    // Конструктор
    public Cat(){

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                '}';
    }
}
