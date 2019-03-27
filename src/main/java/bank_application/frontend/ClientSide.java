package bank_application.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;
import dto.UserScreen;
import dto.EmployeeScreen;
import dto.EmployeeScreen.*;
import utility.DBUtility;
import dto.AddPerson;
import dto.LoginScreen;


public class ClientSide {
	
//	static Logger logger = Logger.getLogger(ClientSide.class);
	static Scanner scanner = new Scanner(System.in);
	static public String currentUser = "";
	static Connection connection;
	static Statement statement;
	
	public static void main(String[] args) throws SQLException {
		welcomeMessage();
//		EmployeeScreen.workerScreen();
//		UserScreen.customerScreen();
//		logger.info("Info log test.");
		
	}

	private static void welcomeMessage() throws SQLException {
		System.out.println("Thank you for choosing us for your banking needs. \nHow can we help?");
		mainMenu();
	}
	
	private static void mainMenu() throws SQLException {
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
			AddPerson.newPerson();
			break;
		case 2:
			LoginScreen.login();
			break;
		default:
			System.out.println("Please enter a valid response: 1 / 2");
			mainMenu();
		}
	}

//	private static void createNewAcc() throws SQLException {
//		AddPerson.newPerson();
//	}

//	private static String createPass() {
//		System.out.println("Please enter a password.");
//		String tempPass = scanner.nextLine();
//		System.out.println("Confirm your password.");
//		String newPass = scanner.nextLine();
//		if(tempPass != newPass) {
//			createPass();
//		}
//		return newPass;
//	}

	private static void login() {	
		System.out.println("Pleaes enter your username.");
		String username = scanner.nextLine();
		System.out.println("Please enter your password.");
		String password = scanner.nextLine();
		checkCredentials(username, password);
		// Send user to customer screen if approved else display message 
		// for pending approval

		currentUser = username;
		// Go to account screen.
	}

	private static void checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		
		
	}
	
	public static void logout() throws SQLException {
		currentUser = "";
		System.out.println();
		System.out.println("Thank you for your business!");
		System.out.println();
		welcomeMessage();
	}
}
