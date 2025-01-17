package com.example.kiosk.level6.model;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cart {

    private final List<MenuItem> cartList = new ArrayList<>();

    public List<MenuItem> getCartList() {
        return cartList;
    }

    public void addCart(MenuItem menuItem, int number){
        if(number == 1){
            cartList.add(menuItem);
            System.out.printf("%s 이 장바구니에 추가되었습니다.", menuItem.getName());
        } else if (number == 2){
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        }
    }

    public void showCartList(List<MenuItem> cartList){
        System.out.println("장바구니 목록");
        for (MenuItem c : cartList) {
            System.out.printf("%d. %s | W %.1f | %s%n", cartList.indexOf(c)+1, c.getName(), c.getPrice(), c.getInfo());
        }
    }

    public void removeMenuItem(int chooseMenuItemNumber, List<MenuItem> cartList) {
        //stream 활용 전 코드 작성 - 주석처리
//        for (int i = 0 ;i<cartList.size();i++) {
//            MenuItem cartItem = cartList.get(i);
//            if(cartList.indexOf(cartItem)+1 == chooseMenuItemNumber){
//                cartList.remove(cartList.indexOf(cartItem));
//                System.out.println(cartItem.getName()+" 해당 메뉴가 장바구니에서 삭제되었습니다.\n");
//            }
//        }

        cartList.stream()
                .filter(cartItem -> cartList.indexOf(cartItem) + 1 == chooseMenuItemNumber)
                .findFirst()
                .ifPresent(cartItem -> {
                    cartList.remove(cartItem);
                    System.out.println(cartItem.getName() + " 해당 메뉴가 장바구니에서 삭제되었습니다.\n");
                });
    }

//    public double totalPriceCal(List<MenuItem> cartList){
    public double totalPriceCal(){
            double totalPrice = 0.0;
            for (MenuItem c : cartList) {
                totalPrice += c.getPrice();
            }
            return totalPrice;
        }


}
