package com.github.rsoi.service;

import com.github.rsoi.domain.Phone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.rsoi.repository.PhonesRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PhoneService {
    private final  PhonesRepository phonesRepository;

    @Transactional
    public Phone findById(long id)
        {
           return phonesRepository.findById(id).orElseThrow();
        }


    @Transactional
    public List<Phone> phoneList()
    {
        return phonesRepository.findAll();
    }
    @Transactional
    public void savePhone(Phone phone)
    {
        log.info("Saving new {}", phone);
        phonesRepository.save(phone);
    }
    @Transactional
    public void deletePhoneById(Long id)
    {
        phonesRepository.deleteById(id);
    }




}


/*

    private int ram = 0;
    private double size = 0;
    private boolean sd = false;
    private int minP = 0;
    private int maxP = 0;


@Transactional
    public void addPhone()
    {   Scanner scan = new Scanner(System.in);
        String name;
        String s;
        int number;
        double numberD;
        ram = -1;
        size = -1;
        sd = false;
        minP = -1;
        maxP = -1;
        System.out.println("Введите название телефона");
        name = scan.next();
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
        phonesRepository.save(new Phone(name, ram, size,sd,minP,maxP));
        System.out.println("Добавлено");
    }
    @Transactional
    public void deletePhone()
    {   Scanner scan = new Scanner(System.in);
        String s;
        long id=-1;
        do {
            System.out.println("Введите id");
            s = scan.next();
            try {
                id = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (id < 0);
        phonesRepository.deleteById(id);
        System.out.println("Удалено");
    }

    public void updatePhone()
    {
        Scanner scan = new Scanner(System.in);
        String s;
        long id=-1;
        do {
            System.out.println("Введите id");
            s = scan.next();
            try {
                id = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (id < 0);
        var update= phonesRepository.findById(id).orElseThrow();
        update.setName("новое название");
        phonesRepository.save(update);
        System.out.println("Обновлено");
    }



 */