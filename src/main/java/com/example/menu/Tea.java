package com.example.menu;

import com.example.enums.Temperature;

public class Tea extends CafeMenu {
    private String type;
    private Temperature temperature;

    public Tea(String type, int price, Temperature temperature) {
        super(type, price);
        this.type = type;
        this.temperature = temperature;
    }

    public static Temperature selectTemperature(int tempChoice) {
        Temperature temperature = (tempChoice == 2) ? Temperature.HOT : Temperature.ICE;
        return temperature;
    }

    // 출력 메시지
    @Override
    public String message() {
        return String.format("%s / %s / 가격: %d원",
                type,
                temperature,
                calcPrice());
    }
}
