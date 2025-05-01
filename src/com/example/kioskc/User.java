package com.example.kioskc;

public enum User {
    // User enum 상수(인스턴스)
    // discountNum에 따라 생성. 
    // User 클래스의 추상메서드 discount를 오버라이드하여 작성 -> 사용자 유형별로 할인률 적용을 구현
    NATIONALMERIT(1) {
        @Override
        public double discount(double totalPrice) {
            return totalPrice * 0.900;
        }
    },
    SOLDIER(2) {
        @Override
        public double discount(double totalPrice) {
            return totalPrice * 0.950;
        }
    },
    STUDENT(3) {
        @Override
        public double discount(double totalPrice) {
            return totalPrice * 0.970;
        }
    },
    GENERAL(4) {
        @Override
        public double discount(double totalPrice) {
            return totalPrice;
        }
    };

    // 속성
    private final int discountNum; // 번호에 따라 사용자 유형을 설정

    // 생성자
    // 매개변수에 따라 discountNum을 초기화
    User(int discountNum) {
        this.discountNum = discountNum;
    }

    // 기능
    // 매개변수로 받은 totalPrice를 할인률에 따라 계산하여 리턴해주는 메서드
    public abstract double discount(double totalPrice);
    
    // 매개변수로 받은 discountNum에 해당하는 User enum상수(인스턴스)를 리턴하는 메서드
    public static User getUserByDiscountNum(int discountNum) {
        for (User user : values()) { // User enum상수(인스턴스)를 배열로 받아
            if (user.discountNum == discountNum) { // 입력받은 discount와 각 user인스턴스의 discountNum과 비교하여 같은 discountNum이 있다면 
                return user; // 그 user인스턴스를 리턴
            }
        }
        return GENERAL; // 없다면 GENERAL user 인스턴스를 리턴
    }
}
