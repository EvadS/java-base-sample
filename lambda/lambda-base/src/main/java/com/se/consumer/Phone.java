package com.se.consumer;

public class Phone {
    private  String isbn;
    private String name;
    private int available;

    public Phone(String isbn, String name, int available) {
        this.isbn = isbn;
        this.name = name;
        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
