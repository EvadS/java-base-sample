package com.se.sample.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Order {

    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;


    public Order() {
    }

    public Order(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
