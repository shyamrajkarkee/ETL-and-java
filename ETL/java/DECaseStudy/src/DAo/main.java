package DAo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		customers c = new customers();
		Scanner s = new Scanner(System.in);	
		boolean isValid = false;
		
		do {
		
		System.out.println("1: Transactions made by customers living in a given zipcode for a given month and year");
		System.out.println("2. Total number of transactions, sum of the transaction value, and transaction type");
		System.out.println("3. Total number of transactions, sum of the transaction value, and branch state");
		System.out.println("4: To check the existing account details of a customer");
		System.out.println("5: To modify the existing account details of a customer" );
		System.out.println("6: To generate  monthly  bill  for a credit  card number for a given month and year");
		System.out.println("7: To  display the transactions made by a customer between two dates. Order by year, month, and day in descending order.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Welcome Please enter Number you want?:");
		
		
		int num = s.nextInt();
		
		if (num > 7 ) {
			System.out.print("Please Enter a Correct Number");}
			else 
				continue;
			isValid = false;
		     }while(!isValid);
		
		}}