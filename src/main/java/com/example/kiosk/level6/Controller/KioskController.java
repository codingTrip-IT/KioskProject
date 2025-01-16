package com.example.kiosk.level6.Controller;

import com.example.kiosk.level6.View.KioskView;
import com.example.kiosk.level6.model.Cart;
import com.example.kiosk.level6.model.Menu;
import com.example.kiosk.level6.model.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KioskController {

    private final List<Menu> menuList;

    public KioskController(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        KioskView kiosk = new KioskView();
        Cart cart = new Cart();
        List<MenuItem> cartList = cart.getCartList();

        // 반복문 시작
        while (true) {
            System.out.println();

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            kiosk.showMainMenu(menuList, cart);

            try {
                // 숫자를 입력 받기
                int inputFirstNumber = sc.nextInt();

                if (inputFirstNumber < 0 || inputFirstNumber > 5) {
                    throw new IllegalStateException("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                } else if (inputFirstNumber == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                } else if (inputFirstNumber == 4) {
                    kiosk.orderMenu(cartList);
                } else if (inputFirstNumber == 5) {
                    System.out.println("진행중인 주문이 취소되었습니다. 장바구니가 초기화 됩니다.");
                    cartList.removeAll(cartList);
                } else if (inputFirstNumber > 0 && inputFirstNumber < 4) {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                    Menu menu = menuList.get(inputFirstNumber - 1);
                    List<MenuItem> menuItems = menuList.get(inputFirstNumber - 1).getMenuItems();
                    System.out.println("[ " + menuList.get(inputFirstNumber - 1).showCategory().toUpperCase() + " MENU ]");

                    // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                    menu.showMenuItem();

                    // 숫자 입력 받기
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                    // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                    // 숫자를 입력 받기
                    int inputSecondNumber = sc.nextInt();

                    MenuItem menuItem = menuItems.get(inputSecondNumber - 1);
                    cart.showCart(menuItem);

                    // 숫자를 입력 받기
                    int inputThirdNumber = sc.nextInt();
                    cart.addCart(menuItem, inputThirdNumber);
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
            }
        }
    }
}


