package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.DBUtility;

public class AddPerson {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.getInstance();
			statement = connection.createStatement();
			String sql = "insert into test values (?, ?)";
			PreparedStatement pt = connection.prepareStatement(sql);
			pt.setInt(1, 4);
			pt.setString(2, "testing");
			pt.executeUpdate();			
			try {connection.commit();} catch(Exception e) {}
			
			
//			String sql = "UPDATE person " +
//					"Set pass = 'qwerty' WHERE username = 'demo'";
//			statement.executeUpdate(sql);
//			sql = "SELECT * FROM person WHERE username = 'demo'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String username = rs.getString(1);
//				String pass = rs.getString(2);
//				String first = rs.getString(3);
//				String last = rs.getString(4);
//				String phoneNo = rs.getString(5);
//				String address = rs.getString(6);
//				
//				System.out.println(username);
//				System.out.println(pass);
//				System.out.println(first);
//				System.out.println(last);
//				System.out.println(phoneNo);
//				System.out.println(address);
//				
//			}
		} catch (SQLException e) {
			System.out.println(e);
			statement.close();
			connection.close();
		}
	}
}
