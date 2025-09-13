package com.example.menu;

public class CafeMenu {
    private String name; // 메뉴 이름
    private int price; // 메뉴 가격

    public CafeMenu(int price) {
        this.price = price;
    }

    public CafeMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int calcPrice() {
        return price;
    }

    // 출력 메시지
    public String message() {
        return String.format("%s", name);
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}
