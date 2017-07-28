package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;


public class JDBCDateSource {
	private String user;
	private String pwd;
	private String url;
	private String driver;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		try {
			Class.forName(driver);
			this.driver = driver;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public Connection getConnection()
	{
		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(url, user, pwd);
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
