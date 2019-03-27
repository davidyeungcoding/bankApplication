package dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.DBUtility;

public class LookUpUser {
	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.getInstance();
			statement = connection.createStatement();
			String sql = "SELECT * FROM customer";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString(1);
				int accNumber = rs.getInt(2);
				int approved = rs.getInt(3);
				int joint = rs.getInt(4);
				Object accType = rs.getObject(5);
				int balance = rs.getInt(6);
				
				System.out.println(username);
				System.out.println(accNumber);
				System.out.println(approved);
				System.out.println(joint);
				System.out.println(accType);
				System.out.println(balance);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
}
