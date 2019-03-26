package dto;

import java.util.Scanner;

public class AccountWithdraw {
	static Scanner scanner = new Scanner(System.in);
	
	static void withdraw() {
		 System.out.println("How much would you like to take out?");
		 
		 int withdrawAmt;
		 
		 do {
			 String input = scanner.nextLine();
			 try {
				withdrawAmt = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a numeric value.");
				withdraw();
			}
		 } while(true);
		 
		 withdrawAcc();
		
	}

	private static void withdrawAcc() {
		// TODO Auto-generated method stub
		
	}
}
