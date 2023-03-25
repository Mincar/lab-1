package com.github.rsoi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}

}

/*
	private final PhoneService phoneService;

	private final PhoneComparator phoneComparator;
	@Autowired
	public Main(PhoneService phoneService,PhoneComparator phoneComparator) {
		this.phoneService = phoneService;
		this.phoneComparator = phoneComparator;
	}*/

/*List<Phone> phones = new ArrayList<>();
		phones.add(new Phone("Телефон 1", 8, 6.1, true,100, 180));
		phones.add(new Phone("Телефон 2", 16, 6.1, true,180, 250));
		phones.add(new Phone("Телефон 3", 8, 6.2, false,130, 150));
		phones.add(new Phone("Телефон 4", 4, 6.4, false,50, 150));
		phones.add(new Phone("Телефон 5", 4, 6.1, true,70, 130));*/


	/*@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int number = 0;
		String s;

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
					phoneComparator.printAll();
					break;
				case 2:
					phoneComparator.changeValues();
					phoneComparator.comparePhones();
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
	}*/
