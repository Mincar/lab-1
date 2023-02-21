package com.github.rsoi;
import com.github.rsoi.service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.github.rsoi.domain.Phone;

public class Main {


	public static void main(String[] args) {

		List<Phone> phones = new ArrayList<>();
		phones.add(new Phone("Телефон 1", 8, 6.1, true,100, 180));
		phones.add(new Phone("Телефон 2", 16, 6.1, true,180, 250));
		phones.add(new Phone("Телефон 3", 8, 6.2, false,130, 150));
		phones.add(new Phone("Телефон 4", 4, 6.4, false,50, 150));
		phones.add(new Phone("Телефон 5", 4, 6.1, true,70, 130));
		Scanner sc = new Scanner(System.in);
		int number = 0;
		String s;
		PhoneComparator cl = new PhoneComparator();
		while (number!=3)
		{
			System.out.println("Нажмите 1 для показа всех телефонов");
			System.out.println("Нажмите 2 для поиска телефона");
			System.out.println("Нажмите 3 для выхода");
			s = sc.next();
			try {
				number = Integer.parseInt(s);
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
			switch (number)
			{
				case 1:
					for(Phone phoneO: phones)
					{
						phoneO.print();
					}
					break;
				case 2:
					cl.changeValues();
					cl.comparePhones(phones);
					break;
				case 3:
					sc.close();
					break;
			}

		}
	}
}
