package com.github.rsoi;

import java.util.ArrayList;
import java.util.Scanner;

import com.github.rsoi.classes.phone;

public class Main {
	public static void main(String[] args) {
		int counter=0;
		ArrayList<phone> phoneArrayList= new ArrayList<>();
		phoneArrayList.add(new phone("Телефон 1", 8, 6.1, true,100, 180));
		phoneArrayList.add(new phone("Телефон 2", 16, 6.1, true,180, 250));
		phoneArrayList.add(new phone("Телефон 3", 8, 6.2, false,130, 150));
		phoneArrayList.add(new phone("Телефон 4", 4, 6.4, false,50, 150));
		phoneArrayList.add(new phone("Телефон 5", 4, 6.1, true,70, 130));

		Scanner sc = new Scanner(System.in);
		int number = 0;
		String s ="";

		while (number!=3)
		{   int ram=0;
			double size=0;
			boolean sd=false;
			int minP=0;
			int maxP=0;

			System.out.println("Нажмите 1 для показа всех телефонов");
			System.out.println("Нажмите 2 для поиска телефона");
			System.out.println("Нажмите 3 для выхода");
			//number = sc.nextInt();
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

					//comparePhone(ram, size, sd, minP, maxP);
					s ="";number = 0;
					double numberD=0.0;
					ram = -1;
					size=-1;
					sd=false;
					minP=-1;
					maxP=-1;
					Scanner scan = new Scanner(System.in);

					do {
						System.out.println("Введите количество памяти");
						s = scan.next();
						try {
							number = Integer.parseInt(s);
							ram =number;
						} catch (NumberFormatException e){
							System.out.println("Неверный ввод");
						}
					} while (ram <0);

					do {
						System.out.println("Введите размер");
						s = scan.next();
						try {
							numberD = Double.parseDouble(s);
							size=numberD;
						} catch (NumberFormatException e){
							System.out.println("Неверный ввод");
						}
					} while (size<0);



					do {
						System.out.println("Введите наличие SD-карты (да/нет)");
						s = scan.next();

					} while (!s.equals("да")&&!s.equals("нет"));
					if (s.equals("да")){sd=true;}
					if (s.equals("нет")){sd=false;}


					do {
						System.out.println("Введите минимальную цену");
						s = scan.next();
						try {
							number = Integer.parseInt(s);
							minP=number;
						} catch (NumberFormatException e){
							System.out.println("Неверный ввод");
						}
					} while (minP<0);


					do {
						System.out.println("Введите максимальную цену");
						s = scan.next();
						try {
							number = Integer.parseInt(s);
							maxP=number;
						} catch (NumberFormatException e){
							System.out.println("Неверный ввод");
						}
					} while (maxP<0);

					if (maxP<minP){
						int t; t = maxP; maxP=minP; minP=t;
					}

					System.out.println(ram+" "+ size+" "+sd+" "+ minP+" "+ maxP);


					for(phone phoneO: phoneArrayList)
					{
						phoneO.compare(ram, size, sd);
					}

					for(phone phoneO: phoneArrayList)
					{	int i=phoneO.getCounerForCompare();
						if(i>counter){
							counter=i;}
					}
					if(counter==0){System.out.println("По вашему запросу ничего не найдено"); break;}
					System.out.println(counter);
					int tel=0;
					for(phone phoneO: phoneArrayList)
					{ int i=phoneO.getCounerForCompare();
						int min=phoneO.getMinPrice();
						int max=phoneO.getMaxPrice();
						if(i==counter&&((min>minP&&min<maxP)||(max<maxP&&max>minP))){
							tel++;
						phoneO.print();}
					}
					if(tel==0){System.out.println("По вашему запросу ничего не найдено");}
					break;
				case 3:
					sc.close();
					break;
			}

		}


	}


	/*
	public static void comparePhone(int ram, double size, boolean sd, int minP, int maxP)
	{	String s ="";
		int number = 0;
		double numberD=0.0;
		 ram = -1;
		 size=-1;
		 sd=false;
		 minP=-1;
		 maxP=-1;
		Scanner scan = new Scanner(System.in);

		 do {
			System.out.println("Введите количество памяти");
			s = scan.next();
			try {
				number = Integer.parseInt(s);
				ram =number;
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
		} while (ram <0);

		do {
			System.out.println("Введите размер");
			s = scan.next();
			try {
				numberD = Double.parseDouble(s);
				size=numberD;
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
		} while (size<0);



		do {
			System.out.println("Введите наличие SD-карты (да/нет)");
			s = scan.next();

		} while (!s.equals("да")&&!s.equals("нет"));
		if (s.equals("да")){sd=true;}
		if (s.equals("нет")){sd=false;}


		do {
			System.out.println("Введите минимальную цену");
			s = scan.next();
			try {
				number = Integer.parseInt(s);
				minP=number;
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
		} while (minP<0);


		do {
			System.out.println("Введите максимальную цену");
			s = scan.next();
			try {
				number = Integer.parseInt(s);
				maxP=number;
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
		} while (maxP<0);

		if (maxP<minP){
			int t; t = maxP; maxP=minP; minP=t;
		}


	}*/


}
