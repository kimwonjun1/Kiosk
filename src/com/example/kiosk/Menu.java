package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 속성
    private final String categoryName; // Burgers, Drinks, Desserts 등 menuItem 의 상위 개념
    private final List<MenuItem> menuItems = new ArrayList<>(); // ShackBurger, SmokeShack,Cheeseburger(MenuItem) 등 실제 메뉴 (List 형식)

    // 생성자
    // Menu 객체 생성시 categoryName 설정
    // initMenuItems 메서드를 통해 menu 객체(Burgers 등)의 menuItems ArrayList에 ShackBurger, SmokeShack,Cheeseburger 등을 추가
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        initMenuItems();
    }

    // 기능
    // getter - categoryName을 외부에 접근 시 사용
    public String getCategoryName() {
        return this.categoryName;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 메서드
    // categoryName에 따라 categoryName에 맞는 메뉴와 각 메뉴의 정보(이름, 가격, 설명)를 출력
    public void viewMenuItem() {
        int menuItemSize = 0;
        switch (this.categoryName) {
            case "Burgers" :
                System.out.println("[ BURGERS MENU ]");
                break;
            case "Drinks" :
                System.out.println("[ DRINKS MENU ]");
                break;
            case "Desserts" :
                System.out.println("[ DESSERTS MENU ]");
                break;
        } // while문으로 menuItems ArrayList의 크기만큼 반복하며 각각의 menuItems에 대해 menuItems의 이름, 가격 설명을 getter를 통해 가져와 출력
        while (menuItemSize != this.menuItems.size()) {
            System.out.printf("%2d. %-15s| w %.1f | %-100s\n",
                    menuItemSize + 1,
                    this.menuItems.get(menuItemSize).getName(),
                    this.menuItems.get(menuItemSize).getPrice(),
                    this.menuItems.get(menuItemSize).getDescription());
            menuItemSize++;
        }
        System.out.println("0. 뒤로가기");
    }

    // 선택한 메뉴의 정보(이름, 가격, 설명)을 출력하는 메서드
    public void selectMenuItem(int orderMenuNum) {
        if (orderMenuNum >= 1 && orderMenuNum <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(orderMenuNum - 1);
            System.out.printf("선택한 메뉴 : %-15s| w %.1f | %-100s\n",
                    selectedItem.getName(),
                    selectedItem.getPrice(),
                    selectedItem.getDescription());
        } else {
            System.out.println("메뉴(번호)를 잘못 입력하였습니다. 다시 입력해주세요.");
        }
    }

    // categoryName에 맞게 menuItems ArrayList에 MenuItem객체를 생성하며 추가(초기화)하는 메서드
    private void initMenuItems() {
        switch (this.categoryName) { // Menu의 categoryName에 따라
            case "Burgers": // categoryName이 Burgers인 경우 아래 객체를 생성하며 menuItems ArrayList에 추가
                this.menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                break;
            case "Drinks": // categoryName이 Drinks인 경우 아래 객체를 생성하며 menuItems ArrayList에 추가
                this.menuItems.add(new MenuItem("Strawberry Peach Tea", 5.7, "레몬에이드에 아이스티와 딸기, 복숭아 맛을 더한 시즈널 레몬에이드"));
                this.menuItems.add(new MenuItem("Lemonade", 5.2, "매장에서 직접 만드는 상큼한 레몬에이드"));
                this.menuItems.add(new MenuItem("Fresh Brewed Iced Tea", 4.4, "직접 유기농 홍차를 우려낸 아이스 티"));
                this.menuItems.add(new MenuItem("Shack Latte", 4.5, "쉑 블렌드 원두로 내린 에스프레소에 부드러운 우유를 더한 라떼"));
                break;
            case "Desserts": // categoryName이 Desserts인 경우 아래 객체를 생성하며 menuItems ArrayList에 추가
                this.menuItems.add(new MenuItem("Cherry Pepper Fries", 7.2, "고소하고 진한 치즈 소스와 매콤한 체리페퍼를 듬뿍 올린 크링클 컷 프라이"));
                this.menuItems.add(new MenuItem("Fries", 4.9, "바삭하고 담백한 크링클 컷 프라이"));
                this.menuItems.add(new MenuItem("Cheese Fries", 6.0, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이"));
                break;
        }
    }
}
