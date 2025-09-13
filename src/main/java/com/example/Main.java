package com.example;

import com.example.enums.*;
import com.example.menu.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 인사 / 아스키아트
        System.out.println("       {");
        System.out.println("    {   }");
        System.out.println("     }_{ __{");
        System.out.println("  .-{   }   }-.");
        System.out.println(" (   }     {   )");
        System.out.println("  |'-.._____..-'|   ))");
        System.out.println("  |             |  //");
        System.out.println("  |    파이니     | //");
        System.out.println("  |     카페     |//");
        System.out.println("  |             |");
        System.out.println("  |             |");
        System.out.println("  '-------------'");
        System.out.println();
        System.out.println("안녕하세요!! 파이니 카페 입니다...");
        System.out.println();

        boolean exit = false;

        while (!exit) {
            System.out.println("===== 메뉴를 선택하세요 =====");
            System.out.println("0. 종료   1. 커피   2. 티   3. 주스");

            // 메뉴 입력
            int menu = -1;
            while (menu < 0 || menu > 3) {
                if (!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    continue;
                }
                menu = sc.nextInt();
                if (menu < 0 || menu > 3) {
                    System.out.println("잘못된 입력입니다. 0~3 사이 숫자를 입력해주세요.");
                }
            }

            boolean ordered = false; // 주문 제대로 됐는지 확인하기

            switch (menu) {
                case 0: { // 종료
                    System.out.println("이용해주셔서 감사합니다. 다음에 또 만나요 !!");
                    exit = true;
                    break;
                }

                case 1: { // 커피
                    // 커피 종류
                    int choice = -1;
                    while (choice < 1 || choice > 2) {
                        System.out.println("1. 아메리카노(2000원)  2. 라떼(3000원)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        choice = sc.nextInt();
                        if (choice < 1 || choice > 2) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }

                    String coffee_type;
                    int price;
                    switch (choice) {
                        case 1: { coffee_type = "아메리카노"; price = 2000; break; }
                        case 2: { coffee_type = "라떼"; price = 3000; break; }
                        default:{ coffee_type = "아메리카노"; price = 2000; break; }
                    }

                    // 온도
                    int temp_choice = -1;
                    while (temp_choice < 1 || temp_choice > 2) {
                        System.out.println("1. 아이스(ICE)");
                        System.out.println("2. 핫(HOT)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        temp_choice = sc.nextInt();
                        if (temp_choice < 1 || temp_choice > 2) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }
                    Temperature temperature = Coffee.selectTemperature(temp_choice);

                    // 시럽
                    int syrup_choice = -1;
                    while (syrup_choice < 1 || syrup_choice > 4) {
                        System.out.println("시럽을 선택하세요.");
                        System.out.println("1. 없음  2. 바닐라(+500원)  3. 헤이즐넛(+500원)  4. 카라멜(+500원)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        syrup_choice = sc.nextInt();
                        if (syrup_choice < 1 || syrup_choice > 4) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }
                    Syrup syrup = Coffee.selectSyrup(syrup_choice);

                    // 디카페인
                    int decafChoice = -1;
                    while (decafChoice < 1 || decafChoice > 2) {
                        System.out.println("디카페인으로 변경하시겠습니까? (1. 예 / 2. 아니오)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        decafChoice = sc.nextInt();
                        if (decafChoice < 1 || decafChoice > 2) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }
                    boolean isDecaf = Coffee.selectDecaf(decafChoice);

                    if ("아메리카노".equals(coffee_type)) {
                        // 샷 타입
                        int shotChoice = -1;
                        while (shotChoice < 1 || shotChoice > 3) {
                            System.out.println("샷 추출 타입을 선택하세요.");
                            System.out.println("1. 숏(리스트레토)  2. 일반  3. 롱");
                            if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                            shotChoice = sc.nextInt();
                            if (shotChoice < 1 || shotChoice > 3) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                        }
                        ShotType shot = Americano.selectShotType(shotChoice);

                        Americano ame = new Americano(price, temperature, syrup, isDecaf, shot);
                        System.out.println("===== 주문 내역 =====");
                        System.out.println(ame.message());
                        ordered = true;

                    } else { // 라떼
                        int milkChoice = -1;
                        while (milkChoice < 1 || milkChoice > 4) {
                            System.out.println("우유 타입을 선택하세요.");
                            System.out.println("1. 기본 우유  2. 오트(+700원)  3. 아몬드(+700원)  4. 두유(+700원)");
                            if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                            milkChoice = sc.nextInt();
                            if (milkChoice < 1 || milkChoice > 4) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                        }
                        MilkType milk = Latte.selectMilkType(milkChoice);

                        Latte latte = new Latte(price, temperature, syrup, isDecaf, milk);
                        System.out.println("===== 주문 내역 =====");
                        System.out.println(latte.message());
                        ordered = true;
                    }

                    break;
                }

                case 2: { // 티
                    int choice = -1;
                    while (choice < 1 || choice > 4) {
                        System.out.println("어떤 티(Tea)를 원하세요?");
                        System.out.println("1. 녹차 (3000원)");
                        System.out.println("2. 페퍼민트 (3000원)");
                        System.out.println("3. 캐모마일 (3000원)");
                        System.out.println("4. 프리미엄 얼그레이 (4000원)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        choice = sc.nextInt();
                        if (choice < 1 || choice > 4) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }

                    String type;
                    int price;
                    switch (choice) {
                        case 1: { type = "녹차"; price = 3000; break; }
                        case 2: { type = "페퍼민트"; price = 3000; break; }
                        case 3: { type = "캐모마일"; price = 3000; break; }
                        case 4: { type = "프리미엄 얼그레이"; price = 4000; break; }
                        default:{ type = "녹차"; price = 3000; break; }
                    }

                    int tempChoice = -1;
                    while (tempChoice < 1 || tempChoice > 2) {
                        System.out.println("1. 아이스(ICE)  2. 핫(HOT)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        tempChoice = sc.nextInt();
                        if (tempChoice < 1 || tempChoice > 2) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }

                    Temperature temperature = Tea.selectTemperature(tempChoice);
                    Tea tea = new Tea(type, price, temperature);
                    System.out.println("===== 주문 내역 =====");
                    System.out.println(tea.message());
                    ordered = true;

                    break;
                }

                case 3: { // 주스
                    int choice = -1;
                    while (choice < 1 || choice > 4) {
                        System.out.println("어떤 주스를 원하세요?");
                        System.out.println("1. 딸기 (3500원)");
                        System.out.println("2. 딸기 바나나 (3800원)");
                        System.out.println("3. 오렌지 (3500원)");
                        System.out.println("4. 키위 (4000원)");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        choice = sc.nextInt();
                        if (choice < 1 || choice > 4) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }

                    String type;
                    int price;
                    switch (choice) {
                        case 1: { type = "딸기"; price = 3500; break; }
                        case 2: { type = "딸기 바나나"; price = 3800; break; }
                        case 3: { type = "오렌지"; price = 3500; break; }
                        case 4: { type = "키위"; price = 4000; break; }
                        default:{ type = "딸기"; price = 3500; break; }
                    }

                    int sweetChoice = -1;
                    while (sweetChoice < 1 || sweetChoice > 4) {
                        System.out.println("당도를 골라주세요.");
                        System.out.println("1. 30  2. 50  3. 70  4. 100");
                        if (!sc.hasNextInt()) { sc.next(); System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); continue; }
                        sweetChoice = sc.nextInt();
                        if (sweetChoice < 1 || sweetChoice > 4) System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    }

                    Juice juice = new Juice(type, price);
                    juice.selectSweetness(sweetChoice);
                    System.out.println("===== 주문 내역 =====");
                    System.out.println(juice.message());
                    ordered = true;

                    break;
                }

                default: {
                    System.out.println("잘못된 입력입니다. 0~3 사이 숫자를 입력해주세요.");
                    break;
                }
            }

            // 주문이 만들어졌을 때만 카운트다운
            if (ordered) {
                System.out.println("음료를 만들고 있어요...");
                Thread checkThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 1; i <= 3; i++) {
                                System.out.println(i + "...");
                                Thread.sleep(1000);
                            }
                            System.out.println("음료 준비 완료!");
                        } catch (InterruptedException e) {
                            System.out.println("음료 준비가 중단되었습니다.");
                            Thread.currentThread().interrupt();
                        }
                    }
                });
                checkThread.start();
                try { checkThread.join(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("맛있게 드세요!!!");
                System.out.println();

                exit = true;
            }
        }

        sc.close();
    }
}