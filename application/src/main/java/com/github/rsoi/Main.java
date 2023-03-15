package com.github.rsoi;
import com.github.rsoi.repository.PhonesRepository;
import com.github.rsoi.service.*;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Main implements CommandLineRunner {

	private final PhoneService phoneService;
	private final PhonesRepository phonesRepository;
	@Autowired
	public Main(PhoneService phoneService, PhonesRepository phonesRepository) {
		this.phoneService = phoneService;
		this.phonesRepository= phonesRepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int number = 0;
		String s;
		PhoneComparator cl = new PhoneComparator(phonesRepository);


		while (number!=6)
		{
			System.out.println("Нажмите 1 для показа всех телефонов");
			System.out.println("Нажмите 2 для поиска телефона");
			System.out.println("Нажмите 3 для добавления телефона");
			System.out.println("Нажмите 4 для удаления телефона");
			System.out.println("Нажмите 5 для обновления телефона");
			System.out.println("Нажмите 6 для выхода");
			s = sc.next();
			try {
				number = Integer.parseInt(s);
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
			switch (number)
			{
				case 1:
					cl.printAll();
					break;
				case 2:
					cl.changeValues();
					cl.comparePhones();
					break;
				case 3:
					phoneService.addPhone();
					break;
				case 4:
					phoneService.deletePhone();
					break;
				case 5:
					phoneService.updatePhone();
					break;
				case 6:
					sc.close();
					break;
			}

		}
	}
}



/*List<Phone> phones = new ArrayList<>();
		phones.add(new Phone("Телефон 1", 8, 6.1, true,100, 180));
		phones.add(new Phone("Телефон 2", 16, 6.1, true,180, 250));
		phones.add(new Phone("Телефон 3", 8, 6.2, false,130, 150));
		phones.add(new Phone("Телефон 4", 4, 6.4, false,50, 150));
		phones.add(new Phone("Телефон 5", 4, 6.1, true,70, 130));*/
