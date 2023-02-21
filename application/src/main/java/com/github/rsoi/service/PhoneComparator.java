package com.github.rsoi.service;

import com.github.rsoi.domain.Phone;

import java.util.List;
import java.util.Scanner;

public class PhoneComparator {
    private int ram = 0;
    private double size = 0;
    private boolean sd = false;
    private int minP = 0;
    private int maxP = 0;


    public void compare(Phone phoneC, int RAMC, double sizeS, boolean SDCardC) {
        int counterForCompare = 0;
        phoneC.setCounterForCompare(counterForCompare);
        if (phoneC.getRAM() == RAMC) {
            counterForCompare++;
        }
        if (phoneC.getSize() == sizeS) {
            counterForCompare++;
        }
        if (phoneC.isSDCard() == SDCardC) {
            counterForCompare++;
        }
        phoneC.setCounterForCompare(counterForCompare);
    }

    public void comparePhones(List<Phone> phones) {
        int counter = 0;

        for (Phone phoneO : phones) {
            compare(phoneO, ram, size, sd);

        }

        for (Phone phoneO : phones) {
            int i = phoneO.getCounterForCompare();
            if (i > counter) {
                counter = i;
            }
        }
        if (counter == 0) {
            System.out.println("По вашему запросу ничего не найдено");
            return;
        }
        System.out.println(counter);
        int tel = 0;
        for (Phone phoneO : phones) {
            int i = phoneO.getCounterForCompare();
            int min = phoneO.getMinPrice();
            int max = phoneO.getMaxPrice();
            if (i == counter && ((min > minP && min < maxP) || (max < maxP && max > minP))) {
                tel++;
                phoneO.print();
            }
        }
        if (tel == 0) {
            System.out.println("По вашему запросу ничего не найдено");
        }


    }


    public void changeValues() {
        String s;
        int number;
        double numberD;
        ram = -1;
        size = -1;
        sd = false;
        minP = -1;
        maxP = -1;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Введите количество памяти");
            s = scan.next();
            try {
                number = Integer.parseInt(s);
                ram = number;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (ram < 0);

        do {
            System.out.println("Введите размер");
            s = scan.next();
            try {
                numberD = Double.parseDouble(s);
                size = numberD;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (size < 0);


        do {
            System.out.println("Введите наличие SD-карты (да/нет)");
            s = scan.next();

        } while (!s.equals("да") && !s.equals("нет"));
        if (s.equals("да")) {
            sd = true;
        }
        if (s.equals("нет")) {
            sd = false;
        }


        do {
            System.out.println("Введите минимальную цену");
            s = scan.next();
            try {
                number = Integer.parseInt(s);
                minP = number;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (minP < 0);


        do {
            System.out.println("Введите максимальную цену");
            s = scan.next();
            try {
                number = Integer.parseInt(s);
                maxP = number;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (maxP < 0);

        if (maxP < minP) {
            int t;
            t = maxP;
            maxP = minP;
            minP = t;
        }


    }
}
