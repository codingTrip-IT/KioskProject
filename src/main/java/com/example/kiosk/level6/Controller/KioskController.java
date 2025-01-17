package com.example.kiosk.level6.Controller;

import com.example.kiosk.level6.View.KioskView;
import com.example.kiosk.level6.model.Cart;
import com.example.kiosk.level6.model.Menu;
import com.example.kiosk.level6.model.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;

public class KioskController {

    // List 선언
    private final List<Menu> menuList;

    //생선자를 통해 선언한 List 초기화
    public KioskController(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // start() : 키오스크를 실행하는 메서드
    public void start() {

        //KioskView 객체 생성
        KioskView kiosk = new KioskView();

        //Cart 객체 생성
        Cart cart = new Cart();

        //장바구니 리스트 생성 및 초기화
        List<MenuItem> cartList = cart.getCartList();

        // 반복문 시작
        while (true) {
            System.out.println();

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            kiosk.showMainMenu(menuList, cart);

            try {
                // 메인 메뉴 선택하기
                int chooseMainMenu = kiosk.chooseNumber();

                // 입력 받은 숫자에 따른 결과를 조건문으로 처리
                // 비정상 로직
                if (chooseMainMenu < 0 || chooseMainMenu > 5) {
                    System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                // 종료 로직
                } else if (chooseMainMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                // 정상 로직
                // 4번 : 주문하기
                } else if (chooseMainMenu == 4) {
                    if(!cart.getCartList().isEmpty()){
                        // orderMenu : 메뉴를 주문하는 로직을 출력하는 함수
                        kiosk.orderMenu(cart, cartList);

                        // 주문 여부 선택하기
                        int chooseOrder = kiosk.chooseNumber();

                        // 1번 : 주문 -> 할인율 선택 -> 주문완료 -> 장바구니 리스트 초기화
                        if (chooseOrder == 1) {
                            kiosk.showDiscount();
                            int chooseUser = kiosk.chooseNumber();
                            kiosk.userDiscount(cart, chooseUser);
                            cartList.removeAll(cartList);
                        // 2번 : 취소
                        } else if (chooseOrder == 2) {
                            kiosk.nextLine();
                        }
                    } else {
                        System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                        kiosk.nextLine();
                    }
                // 5번 : 선택한 메뉴 아이템 장비구니에서 삭제
                } else if (chooseMainMenu == 5) {
                    if(!cart.getCartList().isEmpty()){
                        // showCartList : 장바구니 목록을 출력하는 함수
                        cart.showCartList(cartList);

                        System.out.println("삭제할 메뉴 아이템을 선택하세요.");
                        // 장바구니에서 삭제할 메뉴 아이템 선택하기
                        int chooseMenuItemNumber = kiosk.chooseNumber();
                        //removeMenuItem : 장바구니 리스트에서 선택한 번호의 메뉴 아이템을 삭제하는 함수
                        cart.removeMenuItem(chooseMenuItemNumber,cartList);
                        // showCartList : 장바구니 목록을 출력하는 함수
                        cart.showCartList(cartList);
                    } else {
                        System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                        kiosk.nextLine();
                    }
                // 보기에 있는 번호일 경우
                } else if (chooseMainMenu > 0 && chooseMainMenu < 4) {
                    // List<Menu>에 인덱스로 접근하면 Menu만 추출하기
                    Menu menu = menuList.get(chooseMainMenu - 1);
                    List<MenuItem> menuItems = menuList.get(chooseMainMenu - 1).getMenuItems();

                    // 메뉴 아이템 리스트가 비어 있는 경우
                    if (ObjectUtils.isEmpty(menuItems)){
                        System.out.println("해당 메인 메뉴의 상세 메뉴가 없습니다.");
                        continue;
                    } else {
                        System.out.println("[ " + menuList.get(chooseMainMenu - 1).showCategory().toUpperCase() + " MENU ]");
                        // showMenuItem(): List에 들어있는 MenuItem을 순차적으로 보여주는 함수
                        menu.showMenuItem();
                    }

                    // 메뉴 아이템 선택하기
                    int chooseMenuItems = kiosk.chooseNumber();

                    // 0번 : 뒤로가기
                    if (chooseMenuItems == 0){
                        kiosk.nextLine();
                    } else {
                        MenuItem menuItem = menuItems.get(chooseMenuItems - 1);
                        // showCart : 장바구니 메뉴를 출력하는 함수
                        kiosk.showCart(menuItem);

                        // 메뉴 아이템을 장바구니 추가 여부 선택하기
                        int chooseCart = kiosk.chooseNumber();
                        // addCart : 장바구니에 메뉴 아이템을 추가하는 함수
                        cart.addCart(menuItem, chooseCart);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값입니다. 다시 입력하세요.");
                kiosk.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("보기 중에 없는 번호입니다. 다시 입력해주세요.");
                kiosk.nextLine();
            }
        }
    }
}


