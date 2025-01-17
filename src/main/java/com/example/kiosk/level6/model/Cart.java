package com.example.kiosk.level6.model;

import java.util.ArrayList;
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
//            menuList.stream().filter(item -> !item.getMenuItems().equals(menuItem))
//                    .collect(Collectors.toList());
            System.out.printf("%s 이 장바구니에 추가되었습니다.", menuItem.getName());
        } else if (number == 2){
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        }
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
