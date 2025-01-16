package com.example.kiosk.level4;

import java.util.*;

public class Kiosk {

    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true) {
            System.out.println();

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (Menu menu : menuList) {
                System.out.println((menuList.indexOf(menu) + 1) + ". " + menu.showCategory());
            }
            System.out.println("0. 종료      | 종료");

            try {
                // 숫자를 입력 받기
                int inputFirstNumber = sc.nextInt();

                if (inputFirstNumber == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                Menu menu = menuList.get(inputFirstNumber - 1);
                List<MenuItem> menuItems = menuList.get(inputFirstNumber - 1).getMenuItems();

                System.out.println("[ " + menuList.get(inputFirstNumber - 1).showCategory().toUpperCase() + " MENU ]");

                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                menu.showMenuItem();

                System.out.println("0. 뒤로가기");

                // 숫자 입력 받기
                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                // 숫자를 입력 받기
                int inputSecondNumber = sc.nextInt();

                MenuItem menuItem;
                switch (inputSecondNumber) {
                    case 0:
                        System.out.println("뒤로 갑니다.");
                        break;
                    case 1:
                         menuItem = menuItems.get(0);
                         System.out.printf("1. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        break;
                    case 2:
                        menuItem = menuItems.get(1);
                        System.out.printf("2. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        break;
                    case 3:
                        menuItem = menuItems.get(2);
                        System.out.printf("3. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        break;
                    case 4:
                        menuItem = menuItems.get(3);
                        System.out.printf("4. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
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
            } catch (NullPointerException e) {
                System.out.println("상세 내역이 없는 메뉴입니다. 다시 입력해주세요.");
                sc.nextLine();
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}


