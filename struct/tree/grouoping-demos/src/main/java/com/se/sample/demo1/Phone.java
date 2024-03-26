package com.se.sample.demo1;

public class Phone{

    private String name;
    private String company;
    private int price;

    public Phone(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }


    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}