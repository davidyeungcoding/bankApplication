package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import bank_application.frontend.ClientSide;
import utility.DBUtility;

public class AddPerson {
	
	public static void newPerson() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		String firstName;
		String lastName;
		String phoneNo;
		String address;
		
		System.out.println("\nPlease enter a unique username.");
		username = scanner.nextLine();
		connection = DBUtility.getInstance();
		statement = connection.createStatement();
		try {
			String checkUserSQL = "SELECT username FROM person WHERE username = '" + username + "'";
			ResultSet rs = statement.executeQuery(checkUserSQL);
			while(rs.next()) {
				System.out.println("\n" + username + " is already in use. Please choose a different username.");
				newPerson();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please enter a password.");
		password = scanner.nextLine();
		System.out.println("What is your first name?");
		firstName = scanner.nextLine();
		System.out.println("What is your last name?");
		lastName = scanner.nextLine();
		System.out.println("Please provide a phone number in the following format: ##########\n"
				+ "If you do not have one just hit 'enter' or 'return' to move forward.");
		phoneNo = scanner.nextLine();
		// Convert to int || Integer.parseInt(phoneNo)
		System.out.println("Please provide an address else hit 'enter' or 'return' to skip ahead.");
		address = scanner.nextLine();
		
		try {
			String insertSQL = "INSERT INTO person VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(insertSQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, phoneNo);
			ps.setString(6, address);
			ps.executeUpdate();
			connection.commit();
			System.out.println("\nNew account created successfully.\n\nReturning to main menu.\n");
		} catch (SQLException e) {
			System.out.println("Something went wrong, please try entering your information again.");
			connection.rollback();
			newPerson();
		} finally {
			statement.close();
			connection.close();
			ClientSide.logout();
		}
	}
}
