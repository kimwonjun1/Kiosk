package com.example.kioskc;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정 -> Kiosk 클래스에서 구현
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입 -> Menu 클래스에서 구현

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();
        // Kiosk 객체의 start 메서드 호출
        kiosk.start();
    }
}
