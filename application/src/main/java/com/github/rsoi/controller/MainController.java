package com.github.rsoi.controller;

import com.github.rsoi.domain.Phone;
import com.github.rsoi.service.PhoneComparator;
import com.github.rsoi.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PhoneComparator phoneComparator;
    private final PhoneService phoneService;

    @GetMapping("/")
    public String greeting() {
        return "main";
    }

    @GetMapping("/phones")
    public String phones(Model model, @RequestParam(name = "method", required = false) String method,
                         @RequestParam(name = "id", required = false) Long id) {

        if (method != null && id != null && method.equals("delete")) {
            phoneService.deletePhoneById(id);
        }
        model.addAttribute("phones", phoneService.phoneList());
        return "phones";
    }
    @PostMapping("/phones/addPhone")
    public String phoneAdd( @RequestParam("name") String name,
                                 @RequestParam("ram") int ram,
                                 @RequestParam("size") double size,
                                 @RequestParam("sdCard") String sdCard,
                                 @RequestParam("minPrice") int minPrice,
                                 @RequestParam("maxPrice") int maxPrice
                                 ) {
        boolean SDCard=false;
        if (maxPrice < minPrice) {
            int t;
            t = maxPrice;
            maxPrice = minPrice;
            minPrice = t;
        }
        if (sdCard.equals("да")) {
            SDCard = true;
        }


        phoneService.savePhone(new Phone(name,ram,size,SDCard,minPrice,maxPrice));
        return "redirect:/phones";
    }



    @GetMapping("/phones/{id}/edit")
    public String phoneEdit(Model model, @PathVariable(value = "id") long id) {
        if(!phoneService.existsById(id))
        {
            return "redirect:/phones";
        }
        Optional<Phone> phone= Optional.ofNullable(phoneService.findById(id));
        ArrayList<Phone> res=new ArrayList<>();
        phone.ifPresent(res::add);
        model.addAttribute("phone", res);

        return "phones-edit";
    }

    @PostMapping("/phones/{id}/edit")
    public String phoneUpdate( @PathVariable(value = "id") long id,
                               @RequestParam("name") String name,
                            @RequestParam("ram") int ram,
                            @RequestParam("size") double size,
                            @RequestParam("sdCard") String sdCard,
                            @RequestParam("minPrice") int minPrice,
                            @RequestParam("maxPrice") int maxPrice
    ) {
        boolean SDCard=false;
        if (maxPrice < minPrice) {
            int t;
            t = maxPrice;
            maxPrice = minPrice;
            minPrice = t;
        }
        if (sdCard.equals("да")) {
            SDCard = true;
        }

        Phone phone = phoneService.findById(id);
        phone.setName(name);
        phone.setRAM(ram);
        phone.setSize(size);
        phone.setSDCard(SDCard);
        phone.setMinPrice(minPrice);
        phone.setMaxPrice(maxPrice);

        phoneService.savePhone(phone);
        return "redirect:/phones";
    }

    @GetMapping("/request")
    public String request() {
        return "request";
    }

    @PostMapping("/request/searchPhone")
    public String phoneSearch(

            @RequestParam("ram") int ram,
            @RequestParam("size") double size,
            @RequestParam("sdCard") String sdCard,
            @RequestParam("minPrice") int minPrice,
            @RequestParam("maxPrice") int maxPrice, Model model
    ) { String result;
        List<Phone> phones = phoneComparator.comparePhones(ram, size, sdCard, minPrice, maxPrice);
        if(phones.isEmpty()){
            result="Ничего не найдено";
        }
        else {
            result="Найдено";
        }
        model.addAttribute("result",result);
        model.addAttribute("phones", phones);
        return "request";
    }

}
