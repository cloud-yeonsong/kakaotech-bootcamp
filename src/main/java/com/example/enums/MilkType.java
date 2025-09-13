package com.example.enums;

public enum MilkType {
    OAT("오트",700),
    ALMOND("아몬드", 700),
    SOY("두유", 700),
    MILK("기본 우유", 0);

    private final String milkType;
    private final int extraPrice;

    MilkType(String milkType, int extraPrice) {
        this.milkType = milkType;
        this.extraPrice = extraPrice;
    }

    public String getMilkType() {
        return milkType;
    }

    public int getExtraPrice() {
        return extraPrice;
    }
}
