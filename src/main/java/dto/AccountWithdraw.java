package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import bank_application.frontend.*;
import utility.DBUtility;

public class AccountWithdraw {
	static Scanner scanner = new Scanner(System.in);
	static Connection connection;
	static Statement statement;
	static int withdrawAmt;
	static int checkAccType;
	static char accType;
	static String input;

	static void withdraw() {
		System.out.println("Which account would you like to withdraw from?");
		System.out.println("1) Checking");
		System.out.println("2) Savings");
		
		do {
			input = scanner.nextLine();
			try {
				checkAccType = Integer.parseInt(input);
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid numeric response: 1 / 2");
				withdraw();
			}
			break;
		} while(true);
		
		switch(checkAccType) {
		case 1:
			accType = 'c';
			break;
		case 2:
			accType = 's';
			break;
		default:
			System.out.println("Please enter a valid numeric response: 1 / 2");
			withdraw();
		}
		
		System.out.println("How much would you like to take out?");

		do {
			input = scanner.nextLine();
			try {
				withdrawAmt = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a numeric value.");
				withdraw();
			}
		} while (true);

		withdrawAcc();

	}

	private static void withdrawAcc() {
		// TODO Auto-generated method stub
		try {
			connection = DriverManager.getConnection(DBUtility.url, DBUtility.username, DBUtility.password);
			statement = connection.createStatement();
			String sql = "UPDATE customer SET " + ClientSide.currentUser + ".ballance - " + withdrawAmt
					+ " WHERE accNumber = (SELECT accNumber FROM customer WHERE username = '" + ClientSide.currentUser
					+ "' AND accType = '" + accType + "');";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
