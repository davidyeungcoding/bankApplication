package utility;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBUtility {
	
	public static String url, username, password;
	static BasicDataSource connectionPool = new BasicDataSource();

	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("C:\\Users\\David\\eclipse-workspace\\bank_application\\src\\main\\resources\\database.properties"));
//			connectionPool.setDriver(properties.getProperty("driver"));
			connectionPool.setUrl(properties.getProperty("url"));
			connectionPool.setUsername(properties.getProperty("username"));
			connectionPool.setPassword(properties.getProperty("password"));
			connectionPool.setMaxTotal(20);
			connectionPool.setDefaultAutoCommit(false);
		} /*catch (ClassNotFoundException e) {
			System.out.println("Cannot find driver class.");
		}*/ catch (IOException e) {
			System.out.println("Cannot find your property file.");
		}
	}
	
	public static Connection getInstance() throws SQLException {
		return connectionPool.getConnection();
	}
}
