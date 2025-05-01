package com.example.kioskc;

public class CartItem {
    // 속성
    private final MenuItem menuItem; // 장바구니에 있는 메뉴 항목
    private int quantity; // 장바구니에 있는 메뉴의 수량

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

    public String getName() {
        return this.menuItem.getName();
    }

    public double getPrice() {
        return this.menuItem.getPrice();
    }

    public String getDescription() {
        return this.menuItem.getDescription();
    }

    // 수량을 1 증가시키는 메서드
    public void increaseQuantity() {
        this.quantity++;
    } 
}
