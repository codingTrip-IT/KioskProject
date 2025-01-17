package com.example.kiosk.level1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true){
            // 메뉴 아이템 출력
            System.out.println("[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료      | 종료");

            // 숫자 입력 받기
            int inputNumber = sc.nextInt();

            switch (inputNumber){
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n");
                    break;
                case 2:
                    System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n");
                    break;
                case 3:
                    System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n");
                    break;
                case 4:
                    System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n");
                    break;
                default:
                    throw new IllegalStateException("보기 중에 없는 번호이거나 숫자가 아닙니다. 다시 입력해주세요.");
            }
        }

    }
}