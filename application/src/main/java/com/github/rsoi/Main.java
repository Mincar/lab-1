package com.github.rsoi;
import com.github.rsoi.service.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.github.rsoi.domain.phone;

public class Main {


	public static void main(String[] args) {

		ArrayList<phone> phoneArrayList= new ArrayList<>();
		phoneArrayList.add(new phone("Телефон 1", 8, 6.1, true,100, 180));
		phoneArrayList.add(new phone("Телефон 2", 16, 6.1, true,180, 250));
		phoneArrayList.add(new phone("Телефон 3", 8, 6.2, false,130, 150));
		phoneArrayList.add(new phone("Телефон 4", 4, 6.4, false,50, 150));
		phoneArrayList.add(new phone("Телефон 5", 4, 6.1, true,70, 130));
		Scanner sc = new Scanner(System.in);
		int number = 0;
		String s;
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
					for(phone phoneO: phoneArrayList)
					{
						phoneO.print();
					}
					break;
				case 2:
					CompareClass cl = new CompareClass();
					cl.changeValues();
					cl.comparePhones(phoneArrayList);
					break;
				case 3:
					sc.close();
					break;
			}

		}
	}

}
