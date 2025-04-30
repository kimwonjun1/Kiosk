package com.example.kioskc;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private final List<MenuItem> cartItems = new ArrayList<>();
    private double totalPrice = 0;

    // 기능
    // getter
    public List<MenuItem> getCartItem() {
        return this.cartItems;
    }

    // 장바구니에 선택한 메뉴를 추가하는 기능
    public void addItem(MenuItem menuItem) {
        this.cartItems.add(menuItem);
    }

    public double getTotalPrice() {return totalPrice; }

    // 장바구니에 추가된 메뉴들을 출력하는 기능
    public void printOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                            "5. Cancel       | 진행중인 주문을 취소합니다.");
    }

    public void printOrders(int cartNum) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[Orders]");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.printf(" %-15s| w %.1f | %-100s\n" ,
                    cartItems.get(i).getName(),
                    cartItems.get(i).getPrice(),
                    cartItems.get(i).getDescription());
            this.totalPrice += cartItems.get(i).getPrice();
        }
        System.out.println("[Total]");
        System.out.printf("w %.1f\n", this.totalPrice);
    }

}
