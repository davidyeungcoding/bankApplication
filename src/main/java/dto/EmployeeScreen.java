package dto;

import java.util.Scanner;
import bank_application.frontend.*;

public class EmployeeScreen {
	static Scanner scanner = new Scanner(System.in);
	
	public static void workerScreen() {
		System.out.println("Welcome Back!");
		System.out.println("1) Approve New Accounts");
		System.out.println("2) Approve Joint Accounts");
		System.out.println("3) Approve Transfers");
		System.out.println("4) Look Up User Infomation");
		System.out.println("5) Logout");
		
		int inputEmp;
		
		do {
			String input = scanner.nextLine();
			try {
				inputEmp = Integer.parseInt(input);
				break;
			} catch(NumberFormatException e) {
				System.out.println("Pleae enter a valid numeric respone: 1 / 2 / 3 / 4 / 5");
				workerScreen();
			}
		} while(true);
		
		switch(inputEmp) {
		case 1:
			pendingNewAcc();
			break;
		case 2:
			pendingJointAcc();
			break;
		case 3:
			pendingTransfer();
			break;
		case 4:
			lookUpUser();
			break;
		case 5:
			ClientSide.logout();
			break;
		default:
			System.out.println("Pleae enter a valid numeric respone: 1 / 2 / 3 / 4 / 5");
			workerScreen();
		}
	}

	private static void pendingNewAcc() {
		// TODO Auto-generated method stub
		
	}

	private static void pendingJointAcc() {
		// TODO Auto-generated method stub
		
	}

	private static void pendingTransfer() {
		// TODO Auto-generated method stub
		
	}

	private static void lookUpUser() {
		// TODO Auto-generated method stub
		
	}
	
	
}
