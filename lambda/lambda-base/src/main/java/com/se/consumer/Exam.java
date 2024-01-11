package com.se.consumer;

public class Exam {
    private String name;
    private String version;

    public Exam(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}