package bank_application.frontend;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class ClientSide {
	
//	static Logger logger = Logger.getLogger(ClientSide.class);
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		welcomeMessage();
//		logger.info("Info log test.");
		
	}

	private static void welcomeMessage() {
		System.out.println("Thank you for choosing us for your banking needs. \nHow can we help you?");
		mainMenu();
	}
	
	private static void mainMenu() {
		System.out.println("1. Create a New Account");
		System.out.println("2. Login");
		
		int inputMain = 0;
		
		do {
			String input = scanner.nextLine();
			try {
				inputMain = Integer.parseInt(input);
				break;
			} catch (NumberFormatException exc) {
				System.out.println("Please enter a vaild response, 1 or 2");
				mainMenu();
			}
		} while (true);
		
		switch(inputMain) {
		case 1: 
			createNewAcc();
			break;
		case 2:
			login();
			break;
		default:
			System.out.println("Please enter a valid response, 1 or 2.");
			mainMenu();
		}
	}

	private static void createNewAcc() {
		System.out.println("Exiting Program");
		System.exit(0);
		// TODO Auto-generated method stub
		
	}

	private static void login() {
		System.out.println("Pleaes enter your username.");
		String username = scanner.nextLine();
		System.out.println("Please enter your password.");
		String password = scanner.nextLine();
		checkCredentials(username, password);
	}

	private static void checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		
	}
}
