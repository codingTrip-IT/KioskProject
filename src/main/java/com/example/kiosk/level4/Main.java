package com.example.kiosk.level4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Menu 객체 생성을 통해 이름 설정
        Menu burgers = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        // List.of() 사용해서 위의 상위 메뉴들을 리스트에 추가하기
        List<Menu> menuList = List.of(burgers,drinks,desserts);

        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        MenuItem shackBurger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem SmokeShack = new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem Cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem Hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");

        // List.of() 사용해서 위의 메뉴 아이템들을 메뉴 아이템 리스트에 추가하기
        burgers.setMenuItems(List.of(shackBurger,SmokeShack,Cheeseburger,Hamburger));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuList);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();

    }
}
