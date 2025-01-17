package com.example.kiosk.level6.model;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cart {

    // 장바구니 리스트 선언
    private final List<MenuItem> cartList = new ArrayList<>();

    // 장바구니 리스트를 반환하는 함수(getter)
    public List<MenuItem> getCartList() {
        return cartList;
    }

    // addCart : 장바구니에 메뉴 아이템을 추가하는 함수
    public void addCart(MenuItem menuItem, int number){
        if(number == 1){
            cartList.add(menuItem);
            System.out.printf("%s 이 장바구니에 추가되었습니다.", menuItem.getName());
        } else if (number == 2){
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        }
    }

    // showCartList : 장바구니 목록을 출력하는 함수
    public void showCartList(List<MenuItem> cartList){
        System.out.println("장바구니 목록");
        for (MenuItem c : cartList) {
            System.out.printf("%d. %s | W %.1f | %s%n", cartList.indexOf(c)+1, c.getName(), c.getPrice(), c.getInfo());
        }
    }

    //removeMenuItem : 장바구니 리스트에서 선택한 번호의 메뉴 아이템을 삭제하는 함수
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

    // totalPriceCal : 장바구니의 총합계를 계산하는 함수
    public double totalPriceCal(){
            double totalPrice = 0.0;
            for (MenuItem c : cartList) {
                totalPrice += c.getPrice();
            }
            return totalPrice;
        }


}
