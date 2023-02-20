package com.github.rsoi.service;
import  com.github.rsoi.domain.phone;

public class CompareClass {

    public void compare(phone phoneC ,int RAMC, double sizeS, boolean SDCardC) {
       int counerForCompare=0;
        if (phoneC.getRAM()==RAMC)
        {counerForCompare++;}
        if (phoneC.getSize()==sizeS)
        {counerForCompare++;}
        if (phoneC.isSDCard()==SDCardC)
        {counerForCompare++;}
        phoneC.setCounerForCompare(counerForCompare);
    }
}
