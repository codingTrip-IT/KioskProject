package com.example.kiosk.level4;

// 이름, 가격, 설명 필드 선언하여 관리
// 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

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
