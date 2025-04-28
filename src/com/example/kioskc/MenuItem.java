package com.example.kioskc;

public class MenuItem {
    // 속성. 캡슐화를 위해 private로 설정. 외부에서 MenuItem의 정보(이름, 가격, 설명)을 변경 불가
    private String name; // 이름
    private double price; // 가격
    private String description; // 설명

    // 기능
    // getter - MenuItem의 정보(이름, 가격, 설명)을 외부에서 가져갈때 사용
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
    // MenuItem 객체 생성 시 이름, 가격, 설명을 설정
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
