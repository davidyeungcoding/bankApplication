package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.DBUtility;

public class AddPerson {
	
	void addPerson() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		String firstName;
		String lastName;
		String phoneNo;
		String address;
		
		System.out.println("Please enter a unique username.");
		username = scanner.nextLine();
		System.out.println("Please enter a password.");
		password = scanner.nextLine();
		System.out.println("What is your first name?");
		firstName = scanner.nextLine();
		System.out.println("What is your last name?");
		lastName = scanner.nextLine();
		System.out.println("Please provide a phone number in the following format: ##########\n"
				+ "If you do not have one just hit 'enter' or 'return' to move forward.");
		phoneNo = scanner.nextLine();
		// Integer.parseInt(phoneNo)
		System.out.println("Please provide an address else hit 'enter' or 'return' to skip ahead.");
		address = scanner.nextLine();
		
		try {
			connection = DBUtility.getInstance();
			statement = connection.createStatement();
			String sql = "INSET INTO person VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, phoneNo);
			ps.setString(6, address);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Something went wrong, please try entering your information again.");
			connection.rollback();
			statement.close();
			connection.close();
		}
	}
}
