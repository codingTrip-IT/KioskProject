package com.example.kiosk.level2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입 List.of()
        MenuItem shackBurger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add(shackBurger);
        MenuItem SmokeShack = new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItems.add(SmokeShack);
        MenuItem Cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItems.add(Cheeseburger);
        MenuItem Hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(Hamburger);
//        List.of(shackBurger,SmokeShack,Cheeseburger,Hamburger);


        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println();
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (MenuItem item : menuItems) {
//                System.out.println((menuItems.indexOf(item)+1)+". "+item.getName() +" | W "+item.getPrice()+" | "+item.getInfo());
                System.out.println((menuItems.indexOf(item)+1)+". "+item.getName());
            }
            System.out.println("0. 종료      | 종료");

            // 숫자를 입력 받기
            int inputNumber = sc.nextInt();

            // 입력된 숫자에 따른 처리
            // 프로그램을 종료
                if(inputNumber==0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            // 선택한 메뉴 : 이름, 가격, 설명
                switch (inputNumber){
                    case 1:
                        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                        break;
                    case 2:
                        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                        break;
                    case 3:
                        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                        break;
                    case 4:
                        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                        break;
                    default:
                        throw new IllegalArgumentException("보기 중에 없는 번호이거나 숫자가 아닙니다. 다시 입력해주세요.");
                }
        }

    }
}
