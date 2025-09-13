package com.example.menu;

import com.example.enums.MilkType;
import com.example.enums.Syrup;
import com.example.enums.Temperature;

public class Latte extends Coffee {
   private MilkType milkType;

    public Latte(int price, Temperature temperature, Syrup syrup, boolean isDecaf,  MilkType milkType) {
        super("라떼", price, temperature, syrup, isDecaf);
        this.milkType = milkType;
    }

    public static MilkType selectMilkType (int milkChoice) {
        MilkType milk;
        switch (milkChoice) {
            case 1: { milk = MilkType.MILK; break; }
            case 2: { milk = MilkType.OAT; break; }
            case 3: { milk = MilkType.ALMOND; break; }
            case 4: { milk = MilkType.SOY; break; }
            default:{ milk = MilkType.MILK; break; }
        }
        return milk;
    }

    @Override
    public int calcPrice() {
        int base = super.calcPrice();
        if (milkType != null) {
            base += milkType.getExtraPrice();
        }
        return base;
    }

    // 메시지 출력
    @Override
    public String message() {
        String decafStr = isDecaf() ? "디카페인(+300원)" : "일반";
        String syrupStr = (getSyrup() != null) ? getSyrup().getLabel() : "시럽 없음";
        String milkStr = (milkType != null) ? milkType.getMilkType() + "(+" + milkType.getExtraPrice() + "원)" : "기본 우유";
        return String.format(
                "%s / %s / %s / %s / 우유: %s / 가격: %d원",
                getName(),
                getTemperature(),
                decafStr,
                syrupStr,
                milkStr,
                calcPrice()
        );
    }
}
