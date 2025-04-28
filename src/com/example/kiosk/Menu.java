package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 속성
    private final String categoryName;
    private final List<MenuItem> menuItems = new ArrayList<>();

    // 생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        initMenuItems();
    }

    // getter
    public String getCategoryName() {
        return this.categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    // 기능
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
        }
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

    private void initMenuItems() {
        switch (this.categoryName) {
            case "Burgers":
                this.menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                this.menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                break;
            case "Drinks":
                this.menuItems.add(new MenuItem("Strawberry Peach Tea", 5.7, "레몬에이드에 아이스티와 딸기, 복숭아 맛을 더한 시즈널 레몬에이드"));
                this.menuItems.add(new MenuItem("Lemonade", 5.2, "매장에서 직접 만드는 상큼한 레몬에이드"));
                this.menuItems.add(new MenuItem("Fresh Brewed Iced Tea", 4.4, "직접 유기농 홍차를 우려낸 아이스 티"));
                this.menuItems.add(new MenuItem("Shack Latte", 4.5, "쉑 블렌드 원두로 내린 에스프레소에 부드러운 우유를 더한 라떼"));
                break;
            case "Desserts":
                this.menuItems.add(new MenuItem("Cherry Pepper Fries", 7.2, "고소하고 진한 치즈 소스와 매콤한 체리페퍼를 듬뿍 올린 크링클 컷 프라이"));
                this.menuItems.add(new MenuItem("Fries", 4.9, "바삭하고 담백한 크링클 컷 프라이"));
                this.menuItems.add(new MenuItem("Cheese Fries", 6.0, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이"));
                break;
        }
    }
}
