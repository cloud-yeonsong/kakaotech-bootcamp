package com.example.enums;

public enum ShotType {
    SHORT("숏(리스트레토), 15~20초"),
    NORMAL("일반, 20~30초 사이"),
    LONG("롱, 35~45초 이상");

    private final String shot;

    ShotType (String shot) {
        this.shot = shot;
    }

    public String getShot() {
        return shot;
    }
}
