package com.example.menu;

import com.example.enums.Sweetness;

public class Juice extends CafeMenu {
    private String type; // 주스 타입
    private Sweetness sweetness; // 당도

    public Juice (String type, int price, Sweetness sweetness) {
        super(type + " 주스", price);
        this.type = type;
        this.sweetness = sweetness;
    }

    public Juice(String type, int price) {
        super(price);
        this.type = type;
    }

    public void selectSweetness(int sweetChoice) {
        switch (sweetChoice) {
            case 1: { sweetness = Sweetness.SWEETNESS_30; break; }
            case 2: { sweetness = Sweetness.SWEETNESS_50; break; }
            case 3: { sweetness = Sweetness.SWEETNESS_70; break; }
            case 4: { sweetness = Sweetness.SWEETNESS_100; break; }
            default:{ sweetness = Sweetness.SWEETNESS_100; break; }
        }
    }

    // 출력 메시지
    @Override
    public String message() {
        return String.format("%s / %s / 가격: %d원",
                type + " 주스",
                sweetness.getSweet(),
                calcPrice());
    }
}
