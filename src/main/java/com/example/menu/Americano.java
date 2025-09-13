package com.example.menu;

import com.example.enums.ShotType;
import com.example.enums.Syrup;
import com.example.enums.Temperature;

public class Americano extends Coffee {
    private ShotType shotType;

    public Americano(int price, Temperature temperature, Syrup syrup, boolean isDecaf, ShotType shotType) {
        super("아메리카노", price, temperature, syrup, isDecaf);
        this.shotType = shotType;
    }

    public static ShotType selectShotType(int shotChoice) {
        ShotType shot;
        switch (shotChoice) {
            case 1: { shot = ShotType.SHORT; break; }
            case 2: { shot = ShotType.NORMAL; break; }
            case 3: { shot = ShotType.LONG; break; }
            default:{ shot = ShotType.NORMAL; break; }
        }
        return shot;
    }

    // 메시지 출력
    @Override
    public String message() {
        String decafStr = isDecaf() ? "디카페인(+300원)" : "일반";
        String syrupStr = (getSyrup() != null) ? getSyrup().getLabel() : "시럽 없음";
        return String.format(
                "%s / %s / %s / 샷: %s / 가격: %d원",
                getName(),
                getTemperature(),
                decafStr + ", " + syrupStr,
                shotType != null ? shotType.getShot() : "기본",
                calcPrice()
        );
    }
}
