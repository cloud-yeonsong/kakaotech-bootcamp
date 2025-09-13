package com.example.menu;

import com.example.enums.Syrup;
import com.example.enums.Temperature;

public class Coffee extends CafeMenu {
    private Temperature temperature;
    private Syrup syrup;
    private boolean isDecaf;

    public Coffee(String name, int price, Temperature temperature, Syrup syrup, boolean isDecaf) {
        super(name, price);
        this.temperature = temperature;
        this.syrup = syrup;
        this.isDecaf = isDecaf;
    }

    public Temperature getTemperature() { return temperature; }
    public Syrup getSyrup() { return syrup; }
    public boolean isDecaf() { return isDecaf; }

    public static Temperature selectTemperature(int tempChoice) {
        Temperature temperature = (tempChoice == 2) ? Temperature.HOT : Temperature.ICE;
        return temperature;
    }

    public static Syrup selectSyrup(int syrup_choice) {
        Syrup syrup;
        switch (syrup_choice) {
            case 2: { syrup = Syrup.VANILLA; break; }
            case 3: { syrup = Syrup.HAZELNUT; break; }
            case 4: { syrup = Syrup.CARAMEL; break; }
            default:{ syrup = Syrup.NONE; break; }
        }
        return syrup;
    }
    public static boolean selectDecaf(int decafChoice) {
        return (decafChoice == 1);
    }

    @Override
    public int calcPrice() {
        int add = 0;

        // 시럽 추가
        if (syrup != null ) {
            add += syrup.getExtraPrice();
        }

        // 디카페인
        if (isDecaf) {
            add += 300;
        }

        return getPrice() + add;
    }
}
