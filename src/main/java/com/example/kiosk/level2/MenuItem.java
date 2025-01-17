package com.example.kiosk.level2;

public class MenuItem {

    private String name;  // 메뉴 아이템명
    private Double price; // 가격
    private String info;  // 상세 설명

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
