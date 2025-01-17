package com.example.kiosk.level6.Controller;

import com.example.kiosk.level6.View.KioskView;
import com.example.kiosk.level6.model.Cart;
import com.example.kiosk.level6.model.Menu;
import com.example.kiosk.level6.model.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;

public class KioskController {

    private final List<Menu> menuList;

    public KioskController(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {

        KioskView kiosk = new KioskView();
        Cart cart = new Cart();
        List<MenuItem> cartList = cart.getCartList();

        // 반복문 시작
        while (true) {
            System.out.println();

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            kiosk.showMainMenu(menuList, cart);

            try {
                // 숫자 선택하기
                int chooseMainMenu = kiosk.chooseNumber();

                if (chooseMainMenu < 0 || chooseMainMenu > 5) {
                    System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                } else if (chooseMainMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                } else if (chooseMainMenu == 4) {
                    if(!cart.getCartList().isEmpty()){
                        kiosk.orderMenu(cart, cartList);

                        // 숫자 선택하기
                        int chooseOrder = kiosk.chooseNumber();

                        if (chooseOrder == 1) {
                            kiosk.showDiscount();
                            int chooseUser = kiosk.chooseNumber();
                            kiosk.userDiscount(cart, chooseUser);
                            cartList.removeAll(cartList);
                        } else if (chooseOrder == 2) {
                            kiosk.nextLine();
                        }
                    } else {
                        System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                        kiosk.nextLine();
                    }
                } else if (chooseMainMenu == 5) {
                    if(!cart.getCartList().isEmpty()){
//                        System.out.println("진행중인 주문이 취소되었습니다. 장바구니가 초기화 됩니다.");
//                        cartList.removeAll(cartList);
                        cart.showCartList(cartList);
                        System.out.println("삭제할 메뉴 아이템을 선택하세요.");
                        int chooseMenuItemNumber = kiosk.chooseNumber();
                        cart.removeMenuItem(chooseMenuItemNumber,cartList);
                        cart.showCartList(cartList);
                    } else {
                        System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                        kiosk.nextLine();
                    }
                } else if (chooseMainMenu > 0 && chooseMainMenu < 4) {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                    Menu menu = menuList.get(chooseMainMenu - 1);
                    List<MenuItem> menuItems = menuList.get(chooseMainMenu - 1).getMenuItems();

                    if (ObjectUtils.isEmpty(menuItems)){
                        System.out.println("해당 메인 메뉴의 상세 메뉴가 없습니다.");
                        continue;
//                        object utils -> empty인지 아닌지확인하는 메서드
                    } else {
                        System.out.println("[ " + menuList.get(chooseMainMenu - 1).showCategory().toUpperCase() + " MENU ]");
                        // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                        menu.showMenuItem();
                    }
                    
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                    // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                    // 숫자를 입력 받기
//                    int chooseMenuItems = sc.nextInt();
                    int chooseMenuItems = kiosk.chooseNumber();

                    if (chooseMenuItems == 0){
                        kiosk.nextLine();
                    } else {
                        MenuItem menuItem = menuItems.get(chooseMenuItems - 1);
                        kiosk.showCart(menuItem);

                        // 숫자를 입력 받기
//                        int chooseCart = sc.nextInt();
                        int chooseCart = kiosk.chooseNumber();
                        cart.addCart(menuItem, chooseCart);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값입니다. 다시 입력하세요.");
//                sc.nextLine();
                kiosk.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
//                sc.nextLine();
                kiosk.nextLine();
            }
        }
    }
}


