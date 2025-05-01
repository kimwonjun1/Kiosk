package com.example.kioskc;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private final List<CartItem> cartItems = new ArrayList<>(); // 장바구니 리스트

    // 기능
    // getter
    public List<CartItem> getCartItem() {
        return this.cartItems;
    }

    // 장바구니에 선택한 메뉴를 추가하는 메서드
    public void addItem(MenuItem menuItem) {
//        for (CartItem item : cartItems) { // cartItems 리스트에 이미 있다면
//            if (item.getMenuItem().getName().equals(menuItem.getName())) {
//                item.increaseQuantity(); // 수량만 증가시키고 종료
//                return;
//            }
//        }
//        cartItems.add(new CartItem(menuItem)); // cartItems 리스트에 없다면 메뉴 아이템을 cartItems 리스트에 추가
        // 람다 & 스트림 활용
        cartItems.stream() // cartItems list를 스트림으로 변환하여 사용
                .filter(item -> item.getMenuItem().getName().equals(menuItem.getName())) // cartItems list의 아이템의 이름과 입력받은 menuItem의 이름이 같은지 확인하는 로직 필터
                .findFirst() // 조건에 맞는 첫번째 항목을 Optional로 반환
                .ifPresentOrElse( // if - else 문
                        CartItem::increaseQuantity, // cartItem이 있다면 수량만 증가시킴
                        () -> cartItems.add(new CartItem(menuItem)) // cartItems 리스트에 없다면 메뉴 아이템을 cartItems 리스트에 추가
                );
    }

    // 장바구니 메뉴들을 출력하는 메서드
    public void printOrderMenu(int OrdersNum, int CancelNum) {
        System.out.println("[ ORDER MENU ]");
        System.out.println(OrdersNum + ". Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println(CancelNum + ". Cancel       | 진행중인 주문을 취소합니다.");
    }

    // 장바구니에 추가된 메뉴들의 정보 & 총 주문 금액을 출력하는 메서드
    public void printOrders(int cartNum) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[Orders]");
        if (cartItems.isEmpty()) { // 장바구니가 비어있을때 처리
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
//        for (int i = 0; i < cartItems.size(); i++) { // cartItem(장바구니에 추가된 메뉴)의 이름, 가격, 설명을 출력
//            System.out.printf(" %-15s| w %.1f | %-100s\n" ,
//                    cartItems.get(i).getName(),
//                    cartItems.get(i).getPrice(),
//                    cartItems.get(i).getDescription());
//        }
        // 스트림 활용
        cartItems.stream() // cartItems list를 스트림으로 변환
                .forEach(item -> // 각 cartItem에 대해 forEach문 실행
                System.out.printf(" %-15s| w %.1f | %-100s\n",
                        item.getMenuItem().getName(),
                        item.getMenuItem().getPrice(),
                        item.getMenuItem().getDescription())
        );
        System.out.println("[Total]");
        System.out.printf("w %.1f\n", calcTotalPrice()); // calcTotalPrice 메서드를 통해 총 주문 금액을 계산하여 출력
    }

    // 총 주문 금액 계산 메서드
    public double calcTotalPrice() {
//        double sum = 0;
//        for (int i=0; i<cartItems.size(); i++) { // cartItems list 크기만큼 반복하며
//            sum += cartItems.get(i).getPrice(); // 각 cartItem의 가격을 getPrice로 가져와 sum에 합
//        }
//        return sum; // cartItem의 price를 모두 합한 값을 리턴
        // 스트림 활용
        return cartItems.stream() // cartItems list를 스트림으로 변환
                .mapToDouble(item -> item.getMenuItem().getPrice()) // 각 cartItem의 가격을 getPrice로 가져와 double로 매핑
                .sum(); // 합하여 리턴
    }

    // cart 초기화 메서드
    public void clearCart() {
        getCartItem().clear();
    }
}
