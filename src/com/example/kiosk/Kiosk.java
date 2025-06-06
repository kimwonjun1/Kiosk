package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // Menu를 List로 관리
    private List<Menu> menu;
    
    // 생성자
    // Kiosk 객체를 생성 시 Menu List에 Burgers, Drinks, Desserts Menu 객체를 생성하여 추가
    public Kiosk() {
        this.menu = new ArrayList<>();
        menu.add(new Menu("Burgers"));
        menu.add(new Menu("Drinks"));
        menu.add(new Menu("Desserts"));
    }

    // 기능
    // 메뉴를 출력하고 메뉴를 선택(번호 입력)하면 입력받은 번호에 따라 MenuSelection 메서드를 호출하는 메서드
    public void start() {
        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        // 반복문 시작
        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) { // Menu List의 크기만큼 반복하며 Menu 객체의 categoryName을 getter를 통해 가져와 출력
                System.out.printf("%2d. %-10s\n",
                        i + 1,
                        menu.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            System.out.println("메인 메뉴(번호)를 입력해주세요");

            try { // try-catch문을 통해 숫자 이외의 값에 대한 예외 처리
                int orderNum = sc.nextInt(); // 숫자 입력 받기

                if (orderNum == 0) { // 0을 입력받은 경우 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                } else if (orderNum >= 1 && orderNum <= menu.size()) { // 입력받은 번호가 1 ~ Menu List 크기 범위에 있다면
                    MenuSelection(orderNum - 1, sc); // MenuSelection 메서드 호출
                } else {
                    System.out.println("메뉴(번호)를 잘못 입력하였습니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) { // 숫자 이외의 값에 대한 예외처리
                System.out.println("번호만 입력해주세요.");
                sc.nextLine(); // 버퍼 지우기
            }
        }
    }

    // 입력받은 메뉴의 번호(menuIndex)에 따라 메뉴 아이템을 출력하는 메서드
    public void MenuSelection(int menuIndex, Scanner sc) {
        menu.get(menuIndex).viewMenuItem(); // Menu 객체의 viewMenuItem 메서드를 호출
        try { // try-catch문을 통해 숫자 이외의 값에 대한 예외 처리
            int orderNum = sc.nextInt(); // 메뉴 아이템에 대한 번호를 입력

            if (orderNum == 0) return; // 0인 경우 return값 없이 메서드 종료

            if (orderNum >= 1 && orderNum <= menu.get(menuIndex).getMenuItems().size()) { // 입력받은 메뉴의 번호에 맞는 메뉴 아이템이 있는 경우(MenuItems List 크기 내에 있는 menuIndex인 경우)
                menu.get(menuIndex).selectMenuItem(orderNum); // 입력 받은 번호에 따라 Menu List 의 Menu 객체에서 selectMenu 메서드를 호출
            } else { // 이외의 번호 입력에 대한 예외 처리
                System.out.println("메뉴(번호)를 잘못 입력하였습니다. 다시 입력해주세요.");
            }
        } catch (InputMismatchException e) { // 숫자 이외의 값에 대한 예외처리
            System.out.println("번호만 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 비우기
        }

    }
}
