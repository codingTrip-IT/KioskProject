package com.example.kiosk.level6.View;

import com.example.kiosk.level6.model.Cart;
import com.example.kiosk.level6.model.Menu;
import com.example.kiosk.level6.model.MenuItem;
import com.example.kiosk.level6.model.User;

import java.util.List;
import java.util.Scanner;

public class KioskView {

    // Scanner 선언
    Scanner sc = new Scanner(System.in);

    // chooseNumber: Scanner에서 숫자를 입력하는 함수
    public int chooseNumber() {
        return sc.nextInt();
    }

    // nextLine : Scanner에서 nextLine을 처리하는 함수
    public void nextLine() {
        sc.nextLine();
    }

    // showMainMenu : 메인 메뉴를 출력하는 함수
    public void showMainMenu(List<Menu> menuList, Cart cart) {
        System.out.println("\n[ MAIN MENU ]");
        for (Menu menu : menuList) {
            System.out.println((menuList.indexOf(menu) + 1) + ". " + menu.showCategory());
        }
        System.out.println("0. 종료      | 종료");

        //장바구니 리스트가 비어있지 않은 경우 4,5번 출력
        if (!cart.getCartList().isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
    }

    // showCart : 장바구니 메뉴를 출력하는 함수
    public void showCart(MenuItem menuItem) {
        System.out.printf("선택한 메뉴: %s | W %.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getInfo());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    // orderMenu : 메뉴를 주문하는 로직을 출력하는 함수
    public void orderMenu(Cart cart, List<MenuItem> cartList) {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (MenuItem c : cartList) {
            System.out.printf("%s | W %.1f | %s%n", c.getName(), c.getPrice(), c.getInfo());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f%n", cart.totalPriceCal());

        System.out.println("\n1. 주문       2. 메뉴판");
    }

    // showDiscount : 할인 정보를 보여주는 함수
    public void showDiscount() {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10% \n"+
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%");
    }

    // userDiscount : 사용자의 할인율에 따라 총 합계를 계산해서 출력하는 함수
    public double userDiscount(Cart cart, int chooseUser) {
        User user = User.findByVal(chooseUser);
        double totalPrice = cart.totalPriceCal();

        switch (user) {
            case VETERAN:
                totalPrice -= totalPrice * (User.VETERAN.getDiscountRate() / 100);
                break;
            case SOILDER:
                totalPrice -= totalPrice * (User.SOILDER.getDiscountRate() / 100);
                break;
            case STUDENT:
                totalPrice -= totalPrice * (User.STUDENT.getDiscountRate()/ 100);
                break;
            case GENERAL:
                totalPrice -= totalPrice * (User.GENERAL.getDiscountRate()/ 100);
                break;
            default:
                throw new IllegalStateException("잘못된 번호입니다.");
        }
        System.out.printf("주문이 완료되었습니다. 금액은 W %.2f 입니다.%n", totalPrice);
        return totalPrice;
    }
}

