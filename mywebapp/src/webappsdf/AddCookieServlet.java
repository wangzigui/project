package webappsdf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddCookieServlet extends HttpServlet{
	public void service(HttpServletRequest req , HttpServletResponse rsp) throws ServletException ,IOException
	{
		req.setCharacterEncoding("utf-8");
		rsp.setContentType("text/html;charset=UTF-8");
		
		Cookie cookie1 = new Cookie("user", "wangzigui");
		Cookie cookie2 = new Cookie("password", "123456");
		
		rsp.addCookie(cookie1);
		rsp.addCookie(cookie2);
		
	}
}
