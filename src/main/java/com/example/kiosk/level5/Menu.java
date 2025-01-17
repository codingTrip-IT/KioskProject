package com.example.kiosk.level5;

import java.util.List;

public class Menu {

    // List 선언
    private List<MenuItem> menuItems;
    private String categroy; // 상위 메뉴

    // 생성자를 통해 메인 메뉴 값 초기화하기
    public Menu(String categroy) {
        this.categroy = categroy;
    }

    // getMenuItems() : List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // showCategory() : 카테고리를 리턴하는 함수
    public String showCategory(){
        return categroy;
    }

    // setMenuItems : menuItems 리스트 값 세팅하는 함수
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // showMenuItem(): List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItem(){
        for (MenuItem menuItem : menuItems) {
            int index = menuItems.indexOf(menuItem)+1;
            System.out.printf("%d. %s | W %.1f | %s%n",index, menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
        }
    }


}
