package com.github.rsoi.domain;

interface work {

    void print();

}

public class Phone implements work {
    private String name;
    private int RAM;
    private double size;
    private boolean SDCard;
    private int minPrice;
    private int maxPrice;

    private int counterForCompare;

    @Override
    public void print() {
        System.out.println("--------------------------------");
        System.out.println("Название телефона: " + name);
        System.out.println("Размер телефона: " + size);
        System.out.println("Количество RAM: " + RAM);
        if (SDCard) {
            System.out.println("Наличие SD-карты: Да");
        }
        if (!SDCard) {
            System.out.println("Наличие SD-карты: Нет");
        }
        System.out.println("Цена: " + minPrice + " - " + maxPrice + " рублей.");
        System.out.println("--------------------------------");
    }

    public Phone(String name, int RAM, double size, boolean SDCard, int minPrice, int maxPrice) {
        this.name = name;
        this.RAM = RAM;
        this.size = size;
        this.SDCard = SDCard;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isSDCard() {
        return SDCard;
    }

    public void setSDCard(boolean SDCard) {
        this.SDCard = SDCard;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getCounterForCompare() {
        return counterForCompare;
    }

    public void setCounterForCompare(int counerForCompare) {
        this.counterForCompare = counerForCompare;
    }
}
