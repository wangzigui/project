package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String USER;
	
	public static String PSW;
	
	public static String URL;
	
	public static String ADDRESS; 
	
	static
	{
		Properties prop =  new  Properties();    
		InputStream in = Object.class.getResourceAsStream("/sql.properties");

		try {
			prop.load(in);
			
			USER = prop.getProperty("user");
			
			PSW = prop.getProperty("password");
			
			URL = prop.getProperty("url");
			
			ADDRESS = prop.getProperty("address");
			System.out.println(USER);
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {

		System.out.println(PropertiesUtil.USER);
		System.out.println(PropertiesUtil.PSW);
		System.out.println(PropertiesUtil.URL);
		System.out.println(PropertiesUtil.ADDRESS);
	}

}
