package com.example.kiosk.level3;

import java.util.*;

public class Kiosk {

    // List 선언 및 초기화
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start(){
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

                try {
                    // 숫자를 입력 받기
                    int inputNumber = sc.nextInt();

                    switch (inputNumber){
                        case 0:
                            System.out.println("프로그램을 종료합니다.");
                            return;
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
                } catch (InputMismatchException e) {
                    System.out.println("숫자가 아닌 값입니다. 다시 입력하세요.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                    sc.nextLine();
                }

        }

    }
}
