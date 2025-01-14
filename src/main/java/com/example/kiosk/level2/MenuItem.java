package com.example.kiosk.level2;

public class MenuItem {
    private String name;
    private Double price;
    private String info;

    public MenuItem(String name, Double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }
}
