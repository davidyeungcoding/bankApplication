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


public class ClientSide {
	
//	static Logger logger = Logger.getLogger(ClientSide.class);
	static Scanner scanner = new Scanner(System.in);
	static public String currentUser = "";
	static Connection connection;
	static Statement statement;
	
	public static void main(String[] args) {
		welcomeMessage();
//		EmployeeScreen.workerScreen();
//		UserScreen.customerScreen();
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
		String userCheckSQL;
		String testSQL;
		
		System.out.println("Please enter a unique username:");
		username = scanner.nextLine();
		try {
			connection = DBUtility.getInstance();
			statement = connection.createStatement();
			userCheckSQL = "SELECT username FROM customer WHERE username = '" + username + "'";
			ResultSet rs = statement.executeQuery(userCheckSQL);
			boolean unique = rs.next();
			
			testSQL = "select username from customer";
			String rsUsername = rs.getString("username");
			System.out.println(rsUsername);
//			if(unique = false) {
//				password = createPass();
//				System.out.println(username);
//				System.out.println(password);
//			} else {
//				createNewAcc();
//			}
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println("Username already in use, please use a different one.");
			createNewAcc();
		}
		
		currentUser = username;
		// Go to account screen.
	}

	private static String createPass() {
		System.out.println("Please enter a password.");
		String tempPass = scanner.nextLine();
		System.out.println("Confirm your password.");
		String newPass = scanner.nextLine();
		if(tempPass != newPass) {
			createPass();
		}
		return newPass;
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
