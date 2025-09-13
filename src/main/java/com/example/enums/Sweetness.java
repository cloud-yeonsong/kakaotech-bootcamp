package com.example.enums;

public enum Sweetness {
    SWEETNESS_30("당도 30"),
    SWEETNESS_50("당도 50"),
    SWEETNESS_70("당도 70"),
    SWEETNESS_100("당도 100");

    private final String sweet;

    Sweetness(String sweet) {
        this.sweet = sweet;
    }

    public String getSweet() {
        return sweet;
    }
}
