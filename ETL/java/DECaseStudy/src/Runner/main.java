package Runner;

import java.util.Scanner;

public class main {

	main() {
		System.out.println("-----------------JDBC CASE STUDY------------------------------------------------");
		System.out.println("");
		System.out.println("1: Transactions made by customers: ");
		System.out.println("2. Total number of transactions, sum of the transaction value, and transaction type");
		System.out.println("3. Total number of transactions, sum of the transaction value, and branch state");
		System.out.println("4: To check the existing account details of a customer");
		System.out.println("5: To modify the existing account details of a customer");
		System.out.println("6: To generate  monthly  bill  for a credit  card number for a given month and year");
		System.out.println(
				"7: To  display the transactions made by a customer between two dates. Order by year, month, and day in descending order.");
		System.out.println("8: Quit");
		System.out.println("------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {
		CustomerRunner c = new CustomerRunner();
		new main();
		main.user();}
	
		
	public static void go () {
		boolean validInput = false;
		Scanner input = new Scanner(System.in);
		do {
		if (input.hasNextInt()) {
			int a = input.nextInt();
				if (a == 1 ) {new main();main.user();}
				else { System.out.print("Press 1");validInput = false;}}
		else {
			System.out.println("Press 1");
					input.next();
					validInput = false;}
		}while (!validInput);
		
		
	}
	public static void user() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int number = 0;
		
		{
			do {
				System.out.print("Please Enter a Number: ");

				if (input.hasNextInt()) {
					number = input.nextInt();

					{
						if (number > 8 || number < 1) {
							System.out.println("Invalid Number.");
							System.out.println("");
							System.out.println("Please Enter Listed Number Above: ");
							
						} else {
							validInput = true;
						}
					}
				} else {
					System.out.println("Please Enter Integer Number");
					input.next();
					validInput = false;

				}

			} while (!validInput);}
	
		switch (number) {
		case 1:
			
			TransactionRunner.zip();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
		case 2:	
			TransactionRunner.second();						
				System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
	
		case 3:
			
			TransactionRunner.third();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
		case 4:
			
			CustomerRunner.fourth();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
		case 5:
			
			CustomerRunner.fifth();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
		case 6:
			
			CustomerRunner.sixth();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
		case 7:
			
			CustomerRunner.seven();
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
			
		case 8:
			System.out.print("Good Bye");
			System.out.println("");
			System.out.println("To Return At Menu Press 1");
			main.go();
			
			
		default: 
			System.out.println("Please enter correct Transaction Number: ");
			new main();
			main.user();
			break;			
		}
}
}


	
	
