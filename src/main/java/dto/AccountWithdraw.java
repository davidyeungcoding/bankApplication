package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import bank_application.frontend.*;
import utility.DBUtility;
import dto.UserScreen;

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
		System.out.println("1) Checkings");
		System.out.println("2) Savings");
		// Need to come back here and update to have choice based on the number
		// of accounts the user has.

		do {
			input = scanner.nextLine();
			try {
				checkAccType = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid numeric response: 1 / 2");
				withdraw();
			}
			break;
		} while (true);

		switch (checkAccType) {
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
		} while(true);

		withdrawAcc();

	}

	private static void withdrawAcc() {
		// TODO Auto-generated method stub
		String accReqSQL;
		String updateAccSQL;
//		int accTotal;
		
		try {
			connection = DriverManager.getConnection(DBUtility.url, DBUtility.username, DBUtility.password);
			statement = connection.createStatement();
			accReqSQL = "SELECT accNumber FROM customer WEHERE username = '" + ClientSide.currentUser
					+ "' AND accType = '" + accType + "'";
			ResultSet rs = statement.executeQuery(accReqSQL);
			getBalance(rs);

			updateAccSQL = "UPDATE customer SET " + ClientSide.currentUser + ".balance - " + withdrawAmt
					+ " WHERE accNumber = (SELECT accNumber FROM customer WHERE username = '" + ClientSide.currentUser
					+ "' AND accType = '" + accType + "')";
			statement.executeUpdate(updateAccSQL);
			getBalance(rs);
			rs.close();
			System.out.println("Returning to Customer Menu.\n");
			UserScreen.customerScreen();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getBalance(ResultSet rs) throws SQLException {
		int accTotal;
		while (rs.next()) {
			accTotal = rs.getInt("balance");
			System.out.println("Your current balance is: $" + accTotal);
		}
	}
}
