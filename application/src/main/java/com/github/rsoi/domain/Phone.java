package com.github.rsoi.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phonelist")
public class Phone {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id")
    Long id;
    @Column(name = "name")private String name;
    @Column(name = "ram") private int RAM;
    @Column(name = "size") private double size;
    @Column(name = "sdcard")private boolean SDCard;
    @Column(name = "min_price") private int minPrice;
    @Column(name = "max_price") private int maxPrice;

    private int counterForCompare=0;

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


}
