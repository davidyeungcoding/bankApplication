package dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.DBUtility;
import dto.UserScreen;
import bank_application.frontend.ClientSide;

public class LoginScreen {
	
	public static void login() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String currentUser = null;
		String username = null;
		String password;
		Connection connection = null;
		Statement statement = null;
		
		System.out.println("\nPlease enter your username:");
		username = scanner.nextLine();
		connection = DBUtility.getInstance();
		statement = connection.createStatement();
		try {
			String checkUserSQL = "SELECT username FROM person WHERE username = '" + username + "'";
			ResultSet rs1 = statement.executeQuery(checkUserSQL);
			if(rs1.next()) {
				System.out.println("Please enter your password:");
				password = scanner.nextLine();
				try {
				
				String verifySQL = "SELECT pass, approved FROM customer WHERE username = '" + username + "'";
				ResultSet rs2 = statement.executeQuery(verifySQL);
				if(rs2.next()) {
					String dbPass = rs2.getString("pass");
					int dbApproved = rs2.getInt("approved");
					if(password.equals(dbPass) && dbApproved == 1) {
						currentUser = username;
						UserScreen.customerScreen();
					} else if (password.equals(dbPass) && dbApproved <= 0) {
						System.out.println("Your application has not been approved by an admin.\n"
								+ "Please check back later.");
						statement.close();
						connection.close();
						ClientSide.logout();
					} else {
						System.out.println("Incorrect username or password.\n");
						statement.close();
						connection.close();
						ClientSide.logout();
					}
				} else {
					System.out.println("Your application has not been approved by an admin.\n"
							+ "Please check back later.");
					statement.close();
					connection.close();
					ClientSide.logout();
				}
			}catch(SQLException e) {System.out.println(e);}} else {				
				System.out.println("Incorrect username or password.\n");
				statement.close();
				connection.close();
				ClientSide.logout();
			}
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println("Something went wrong, please confirm your login credentials and try again.\n");
		} finally {
			statement.close();
			connection.close();
			ClientSide.logout();
		}
	}
}
