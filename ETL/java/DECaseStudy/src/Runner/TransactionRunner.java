package Runner;

import java.util.Scanner;
import java.util.*;
import DAo.DAO;

import java.time.YearMonth;

public class TransactionRunner {


	public static void main(String[] args) {
	}

	static void zip() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String zip = null;
		int month = 0;
		int year = 0;

		do {

			System.out.println("Please Enter Zip Code: ");

			if (input.hasNextInt()) {
				zip = input.next();
				zip.length();

				if ((zip.length() < 5) || (zip.length() > 5)) {
					System.out.println("Invalid Zip Code format.");
					System.out.println("");
					System.out.println("Enter your 5 digit zip code: ");
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Please Enter Integer");
				input.next();
			}

		} while (!validInput);

		System.out.println("Thank you !");
		System.out.println("---------------------------------------------");
		// -------------------------------------------------------------------------------------------------------------//
		do {
			System.out.print("Please Enter a month in 2 Digit(Example Jan = 01 ): ");

			if (input.hasNextInt()) {
				month = input.nextInt();
				// if (Integer.toString(month).length() <= 2) {
				if (month <= 12 && month > 0) {
					validInput = true;
				} else {
					validInput = false;
					System.out.println("Invalid format.");
				}
			} else {
				System.out.println("Please Enter Integer");
				input.next();
				validInput = false;

			}

		} while (!validInput);

		System.out.println("Thank you !");
		System.out.println("--------------------------------------------------------");

		do {
			System.out.print("Please Enter a Year in 4 Digit: ");

			if (input.hasNextInt()) {
				year = input.nextInt();
				{
					if (year > 999 && year <= 9999) {
						validInput = true;
						

					} else {
						validInput = false;
						System.out.println("Invalid format.");
					}
				}
			} else {
				System.out.println("Please Enter Integer");
				input.next();
				validInput = false;

			}

		} while (!validInput);
		
		//("--------------------------------------------------------");
		DAO.selectByUsername (zip, month,  year);
	}

	static void second() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String transactionType = null;
		int totalTransaction = 0;
		double transactionValue = 0;
		

		System.out.println("1. Education : ");
		System.out.println("2. Entertainment : ");
		System.out.println("3. Grocery : ");
		System.out.println("4. Gas : ");
		System.out.println("5. Bills : ");
		System.out.println("6. Test : ");
		System.out.println("7. Healthcare : ");
		System.out.println("Please select Transaction Number: ");
		  if (input.hasNextInt()) {System.out.println("Thank You");
		  System.out.println("");}
		 	   
		 else { 
			 System.out.println("");
			 System.out.println("Please Enter Integer"); 
			 System.out.println("");
		 	input.next(); 
		 	TransactionRunner.second();
		 	}
		
		  
		int type = Integer.parseInt(input.next()); 
		String text = "";
		
		switch(type) {
			case 1: 
				text = "Education";
				break;
			case 2:
				text = "Entertainment";
				break;
			case 3:
				text = "Grocery";
				break;
			case 4:
				text = "Gas";
				break;
			case 5:
				text = "Bills";
				break;
			case 6:
				text = "Test";
				break;
			case 7:
				text = "Healthcare";
				break;
			default: 
				System.out.println("Please enter correct Transaction Number: ");
				second();
				break;
		}
		
		transactionType = text.toLowerCase();
		DAO.selectByUsername2(transactionType, totalTransaction, transactionValue);
		
		//"-------------------------------------------------------------------------------");
	}

	static void third() {	 
		 
		
		String[] states = new String[]{
				  "AK","AL","AR","AS","AZ","CA","CO","CT","DC","DE", "FL","GA","GU","HI",
		          "IA","ID","IL","IN","KS","KY","LA","MA","MD","ME","MI","MN","MO","MS","MT","NC",
		          "ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","PR","RI",
		          "SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
		Scanner input = new Scanner(System.in);	
		String state = null;
		int countTransaction = 0;
		double transactionValue = 0;
		System.out.println("Please Enter State with two letter Example(NY)  : ");
		state = input.next();
		state = state.toUpperCase();		
        // Convert String Array to List
        List<String> state_list = Arrays.asList(states);
        if (!state_list.contains(state)) {
            System.out.println("Please enter correct state code");
            third();
        } else {
    		DAO.selectByUsername3(state, countTransaction, transactionValue);
        }
	}
}
