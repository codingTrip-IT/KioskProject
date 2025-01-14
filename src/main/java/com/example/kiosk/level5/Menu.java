package com.example.kiosk.level5;

import java.util.List;

public class Menu {

    // MenuItem 클래스를 List로 관리
    // List 선언 및 초기화
    private List<MenuItem> menuItems;
    private String categroy;

    public Menu(String categroy) {
        this.categroy = categroy;
    }

    public String showCategory(){
        return categroy;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItem(){
        for (MenuItem menuItem : menuItems) {
            int index = menuItems.indexOf(menuItem)+1;
            System.out.printf("%d. %s | W %.1f | %s%n",index, menuItem.getName(),menuItem.getPrice(),menuItem.getInfo());
        }
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
