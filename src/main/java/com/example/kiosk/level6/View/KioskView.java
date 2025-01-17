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

    public int chooseNumber() {
        return sc.nextInt();
    }

    public void nextLine() {
        sc.nextLine();
    }

    public void showMainMenu(List<Menu> menuList, Cart cart) {
        System.out.println("[ MAIN MENU ]");
        for (Menu menu : menuList) {
            System.out.println((menuList.indexOf(menu) + 1) + ". " + menu.showCategory());
        }
        System.out.println("0. 종료      | 종료");

        if (cart.getCartList().size() != 0) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
    }

    public void showCart(MenuItem menuItem) {
        System.out.printf("선택한 메뉴: %s | W %.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getInfo());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

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


    public void showDiscount() {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10% \n"+
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%\n");
    }

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

