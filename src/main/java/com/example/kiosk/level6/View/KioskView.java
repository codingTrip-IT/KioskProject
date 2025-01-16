package com.example.kiosk.level6.View;

import com.example.kiosk.level6.model.Cart;
import com.example.kiosk.level6.model.Menu;
import com.example.kiosk.level6.model.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KioskView {

    Scanner sc = new Scanner(System.in);
    Cart cart;

    public void showMainMenu(List<Menu> menuList, Cart cart) {
        System.out.println("[ MAIN MENU ]");
        for (Menu menu : menuList) {
            System.out.println((menuList.indexOf(menu) + 1) + ". " + menu.showCategory());
        }
        System.out.println("0. 종료      | 종료\n");

        if(cart.getCartList().size()!=0){
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
    }

    public void orderMenu(List<MenuItem> cartList) {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (MenuItem c : cartList) {
            System.out.printf("%s | W %.1f | %s%n", c.getName(), c.getPrice(), c.getInfo());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f%n",totalPriceCal(cartList));

        System.out.println("\n1. 주문       2. 메뉴판");
        int inputThirdNumber = sc.nextInt();

        if (inputThirdNumber == 1) {
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", totalPriceCal(cartList));
            cartList.removeAll(cartList);
        } else if (inputThirdNumber == 2) {
            sc.nextLine();
        }
    }

    public double totalPriceCal(List<MenuItem> cartList){
        double totalPrice = 0.0;
        for (MenuItem c : cartList) {
            totalPrice += c.getPrice();
        }
        return totalPrice;
    }
}


