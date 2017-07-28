package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import common.PropertiesUtil;

public class DButil {
	public static Connection getConnection()
	{
		java.sql.Connection con;
		String user = "root";
		String password = "123456";
		String url = "jdbc:mysql://localhost:3306/user";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static void closeConnection(Connection con)
	{
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
