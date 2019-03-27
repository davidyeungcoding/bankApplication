package dto;

import java.sql.SQLException;
import java.util.Scanner;

import bank_application.frontend.*;
import dto.AccountWithdraw.*;

public class UserScreen {
	static Scanner scanner = new Scanner(System.in);
	
	public static void customerScreen() throws SQLException {
		System.out.println("What would you like to do?");
		System.out.println("1) Make a Withdraw");
		System.out.println("2) Make a Deposit");
		System.out.println("3) Make a Transfer");
		System.out.println("4) Create a Joint Accout");
		System.out.println("5) Check Your Balance");
		System.out.println("6) Logout");
		
		int inputCustomer;
		
		do {
			String input = scanner.nextLine();
			try {
				inputCustomer = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Plese enter a vaild numeric response: 1 / 2 / 3 / 4 / 5 / 6");
				customerScreen();
			}
		} while(true);
		
		switch(inputCustomer) {
		case 1:
			AccountWithdraw.withdraw();
			break;
		case 2:
			deposit();
			break;
		case 3:
			transfer();
			break;
		case 4:
			applyForJoint();
			break;
		case 5:
			checkBalance();
			break;
		case 6:
			ClientSide.logout();
			break;
		default:
			System.out.println("Plese enter a vaild numeric response: 1 / 2 / 3 / 4 / 5 / 6");
			customerScreen();
		}
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		
	}

	private static void transfer() {
		// TODO Auto-generated method stub
		
	}

	private static void applyForJoint() {
		// TODO Auto-generated method stub
		
	}

	private static void checkBalance() {
		// TODO Auto-generated method stub
		
	}
}
