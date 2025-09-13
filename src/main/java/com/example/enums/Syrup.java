package com.example.enums;

public enum Syrup {
    NONE("추가 안함", 0),
    VANILLA("바닐라 시럽 추가", 500),
    HAZELNUT("헤이즐넛 시럽 추가", 500),
    CARAMEL("카라멜 시럽 추가", 500);

    private final String label;
    private final int extraPrice;

    Syrup(String label, int extraPrice){
        this.label = label;
        this.extraPrice = extraPrice;
    }

    public String getLabel() {
        return label;
    }

    public int getExtraPrice() {
        return extraPrice;
    }
}
