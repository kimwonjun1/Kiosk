package com.example.kioskc;

public class CartItem {
    // 속성
    private final MenuItem menuItem;
    private int quantity;

    // 생성자
    public CartItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.quantity = 1;  // 최초 추가 시 수량은 1
    }

    // 기능
    // getter
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

}
