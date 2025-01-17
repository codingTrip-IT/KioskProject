package com.example.kiosk.level5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // List 선언
    private final List<Menu> menuList;

    //생선자를 통해 선언한 List 초기화
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // start() : 키오스크를 실행하는 메서드
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

                // 입력받은 숫자가 0인 경우 프로그램 종료
                if (inputFirstNumber == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                // List<Menu>에 인덱스로 접근하면 Menu만 추출하기
                Menu menus = menuList.get(inputFirstNumber - 1); //index는 입력 받은 숫자 -1
                List<MenuItem> menuItems = menuList.get(inputFirstNumber - 1).getMenuItems();
                System.out.println("[ " + menuList.get(inputFirstNumber - 1).showCategory().toUpperCase() + " MENU ]");

                // showMenuItem() : Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                menus.showMenuItem();

                System.out.println("0. 뒤로가기");

                // 숫자를 입력 받기
                int inputSecondNumber = sc.nextInt();

                // MenuItem 타입 변수 생성
                MenuItem menuItem;

                // menuItem에 선택한 메뉴 아이템의 정보를 가져와서 출력
                switch (inputSecondNumber) {
                    case 0:
                        System.out.println("뒤로 갑니다.");
                        break;
                    case 1:
                         menuItem = menuItems.get(inputSecondNumber-1);
                         System.out.printf("1. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                         System.out.println("주문이 왼료되었습니다.");
                        break;
                    case 2:
                        menuItem = menuItems.get(inputSecondNumber-1);
                        System.out.printf("2. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        System.out.println("주문이 왼료되었습니다.");
                        break;
                    case 3:
                        menuItem = menuItems.get(inputSecondNumber-1);
                        System.out.printf("3. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        System.out.println("주문이 왼료되었습니다.");
                        break;
                    case 4:
                        menuItem = menuItems.get(inputSecondNumber-1);
                        System.out.printf("4. %s | W %.1f | %s%n", menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
                        System.out.println("주문이 왼료되었습니다.");
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


