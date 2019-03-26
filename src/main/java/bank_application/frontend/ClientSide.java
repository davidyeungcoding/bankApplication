package bank_application.frontend;

import java.util.Scanner;

import org.apache.log4j.Logger;
import dto.UserScreen;
import dto.EmployeeScreen;
import dto.EmployeeScreen.*;


public class ClientSide {
	
//	static Logger logger = Logger.getLogger(ClientSide.class);
	static Scanner scanner = new Scanner(System.in);
	static public String currentUser = "";
	
	public static void main(String[] args) {
//		welcomeMessage();
//		EmployeeScreen.workerScreen();
		UserScreen.customerScreen();
//		logger.info("Info log test.");
		
	}

	private static void welcomeMessage() {
		System.out.println("Thank you for choosing us for your banking needs. \nHow can we help?");
		mainMenu();
	}
	
	private static void mainMenu() {
		System.out.println("1) Create a New Account");
		System.out.println("2) Login");
		
		int inputMain;
		
		do {
			String input = scanner.nextLine();
			try {
				inputMain = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a vaild numeric response: 1 / 2");
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
			System.out.println("Please enter a valid response: 1 / 2");
			mainMenu();
		}
	}

	private static void createNewAcc() {
		String username;
		String password;
		
		do {
			System.out.println("Please enter a unique username:");
			username = scanner.nextLine();
		} while(checkUniqueUser() == false);
		
		System.out.println("Please enter a password:");
		password = scanner.nextLine();
		// Add additional check to confirm password
		currentUser = username;
		// Go to account screen.
		System.out.println("User created username: " + username);
		System.out.println("User created password: " + password);
		System.out.println("Exiting Program");
		System.exit(0);
		// TODO Auto-generated method stub
		
	}

	private static boolean checkUniqueUser() {
		return false;
		// TODO Auto-generated method stub
		
	}

	private static void login() {	
		System.out.println("Pleaes enter your username.");
		String username = scanner.nextLine();
		System.out.println("Please enter your password.");
		String password = scanner.nextLine();
		checkCredentials(username, password);
		// Send user to customer screen if approved else display message 
		// for pending approval
	}

	private static void checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	public static void logout() {
		currentUser = "";
		System.out.println();
		System.out.println("Thank you for your business!");
		System.out.println();
		welcomeMessage();
	}
}
