package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menu;
    // 생성자
    public Kiosk() {
        this.menu = new ArrayList<>();
        menu.add(new Menu("Burgers"));
        menu.add(new Menu("Drinks"));
        menu.add(new Menu("Desserts"));
    }
    // 기능
    public void start() {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        // 반복문 시작
        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            int menuSize = 0;
            while(menuSize != menu.size()) {
                System.out.printf("%2d. %-10s\n",
                        menuSize + 1,
                        menu.get(menuSize).getCategoryName());
                menuSize++;
            }
            System.out.println("0. 종료");
            System.out.println("메인 메뉴(번호)를 입력해주세요");
            // 숫자 입력 받기
            int orderNum = sc.nextInt();
            // 입력 받은 숫자가 올바르다면 인덱스를 활용하여 List에 접근하기
            switch (orderNum) {
                case 1:
                case 2:
                case 3:
                    MenuSelection(orderNum - 1, sc);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("메뉴(번호)를 잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    private void MenuSelection(int menuIndex, Scanner sc) {
        menu.get(menuIndex).viewMenuItem();
        int orderNum = sc.nextInt();

        if (orderNum == 0) return;

        if (orderNum >= 1 && orderNum <= 4) {
            menu.get(menuIndex).selectMenuItem(orderNum);
        } else {
            System.out.println("메뉴(번호)를 잘못 입력하였습니다. 다시 입력해주세요.");
        }
    }
}
