package Runner;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import DAo.DAO;

public class CustomerRunner {
	public static void main(String[] args) {
		CustomerRunner.fourth();

	}

	static void fourth() {
		Scanner input = new Scanner(System.in);
		int ssn = 0;
		boolean validInput = false;

		do {

			System.out.println("Please Enter SSN: ");
			if (input.hasNextInt()) {
				ssn = input.nextInt();
				validInput = true;
			}

			else {
				System.out.println("Please Enter Integer");
				input.next();
				validInput = false;
			}

		} while (!validInput);

		DAO.selectByUsername4(ssn);

		System.out.println("Thank you !");
		System.out.println("---------------------------------------------");

	}

//----------------------------------------------------------------------------------------------------------------------------
	
	static void fifth() {
		Scanner input = new Scanner(System.in);
		int ssn = 0;
		String Firstname = null;
		String Middlename = null;
		String Lastname = null;
		String Aptno = null;
		boolean validInput = false;

		int number = 0;
		
		do {

			System.out.println("Please Enter SSN: ");
			if (input.hasNextInt()) {
				ssn = input.nextInt();
				validInput = true;
				break;
			}

			else {
				System.out.println("Please Enter Integer");
				input.next();
				validInput = false;
			}

		} while (!validInput);

		
		do {
			System.out.println("");
			System.out.println("-----------------------UPDATE--------------------");
			System.out.println("1: Do you want to update First Name? ");
			System.out.println("2. Do you want to update Middle Name? ");
			System.out.println("3. Do you want to update Last Name?");
			System.out.println("4: Do you want to update Apt No?");
			System.out.println("5: To save Updated Value");
			System.out.println("--------------------------------------------------");
			{
				System.out.println("Choose what you want to update?");
			}
			if (input.hasNextInt()) {
				number = input.nextInt();
				if (number == 1) {
					System.out.println("Please Enter First Name");
					Firstname = input.next();
					validInput = false;
					
				} else if (number == 2) {
					System.out.println("Please Enter Middle Name");
					Middlename = input.next();
					
				} else if (number == 3) {
					System.out.println("Please Enter Last Name");
					Lastname = input.next();
					
				} else if (number == 4) {
					System.out.println("Please Enter Apt No");
					Aptno = input.next();
					
				}else if (number == 5) {
						validInput = true;
					
				}else {
					validInput = true;
				}
				if (number > 5 || number < 1) {
					System.out.println("Please enter valid Number");
					validInput = false;
				}
			} else {
				System.out.println("Please Enter Integer Number");
				input.next();
				validInput = false;
			}
		
		} while (!validInput);

		DAO.selectByUsername5(ssn, Firstname, Middlename, Lastname, Aptno);

	}

//------------------------------------------------------------------------------------------------------------------------
	static void sixth() {
		Scanner input = new Scanner(System.in);
		String creditCardNumber= null;
		int month = 0;
		int year = 0;
		boolean validInput = false;

		do {

			System.out.println("Please Enter Credit Card Number : ");
			creditCardNumber = input.nextLine();
			
			for(int i = 0;i<creditCardNumber.length();i++){
				if(!((int)creditCardNumber.charAt(i)>47 && (int)creditCardNumber.charAt(i)<58)){
				System.out.println("Enter Integer");
	
				validInput = false;
				break;}
			
			else {
			validInput = true;
			break;
		}}	

			}while (!validInput);
			
	//-----------------------------------------------------------------------------------------------------------------//		
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
		
//----------------------------------------------------------------------------


		DAO.selectByUsername6(creditCardNumber, month , year);
	}
	

//------------------------------------------------------------------------------------------------------------------------------------
static void seven() {
			Scanner input = new Scanner(System.in);
			int ssn = 0;
			String from = null;
			String to = null;
			Date test = null;
			
			

			boolean validInput = false;
			
		do {
				System.out.println("Please Enter SSN: ");
				if (input.hasNextInt()) {
					ssn = input.nextInt();
					validInput = true;
				}
				else {
					System.out.println("Please Enter Integer");
					input.next();
					validInput = false;
				}

		} while (!validInput);	
			

			//=------------------------------------------------------------------
			System.out.println("Please Enter Date Range: ");
		validInput = false;
		do {

			System.out.println("Range From : ");
			System.out.println("Date should be (m-d-y, 02-02-2018) format  : ");
			if (input.hasNextLine()) {
				String inp = input.next();
				
				DateFormat df = new SimpleDateFormat("mm-dd-yyyy");
				try {
					test = df.parse(inp);
					from  = inp;
					validInput = true;
				} catch (ParseException e) {
					System.out.println("Please enter valid Date: ");
					
					//input.next();
					validInput = false;
				}
			} else {
				System.out.println("Please enter valid Date: ");
				input.next();
				validInput = false;
			}

		}while (!validInput);
		System.out.println(from);
		//-----------------------------------------------------------------
		validInput = false;
		do {

			System.out.println("Range to : ");
			System.out.println("Date should be (m-d-y, 02-02-2018) format  : ");
			if (input.hasNextLine()) {
				String inp = input.next();
				
				DateFormat df = new SimpleDateFormat("mm-dd-yyyy");
				try {
					test = df.parse(inp);
					to  = inp;
					validInput = true;
				} catch (ParseException e) {
					System.out.println("Please enter valid Date");
					//input.next();
					validInput = false;
				}
			} else {
				System.out.println("Please enter valid Date");
				input.next();
				validInput = false;
			}

		}while (!validInput);
		
	DAO.selectByUsername7( ssn, from, to );
	
}
}
	