package com.github.rsoi.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phonelist")
public class Phone {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")private String name;
    @Column(name = "ram") private int RAM;
    @Column(name = "size") private double size;
    @Column(name = "sdcard")private boolean SDCard;
    @Column(name = "min_price") private int minPrice;
    @Column(name = "max_price") private int maxPrice;

    private double counterForCompare=0;

    @Column(name = "picurl") private String picURL;


    public Phone(String name, int RAM, double size, boolean SDCard, int minPrice, int maxPrice) {
        this.name = name;
        this.RAM = RAM;
        this.size = size;
        this.SDCard = SDCard;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Phone(String name, int RAM, double size, boolean SDCard, int minPrice, int maxPrice, String picURL) {
        this.name = name;
        this.RAM = RAM;
        this.size = size;
        this.SDCard = SDCard;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.picURL = picURL;
    }



}
