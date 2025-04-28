package com.example.kiosk;

public class MenuItem {
    // 속성. 캡슐화를 위해 private로 설정
    private String name; // 이름
    private double price; // 가격
    private String description; // 설명

    // setter

    // getter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // 생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
