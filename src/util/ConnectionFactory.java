package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/salao?useTimezone=true&serverTimezone=UTC";
			String user = "nome do banco";
			String pass = "*********";
			
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			return null;
		}		
	}	
	
}
