package com.example.kiosk.level3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        MenuItem shackBurger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem SmokeShack = new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem Cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem Hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");

        // List.of() 사용하기
        Kiosk kiosk = new Kiosk(List.of(shackBurger,SmokeShack,Cheeseburger,Hamburger));

        kiosk.start();

    }
}
