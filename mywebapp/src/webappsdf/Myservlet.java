package webappsdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Role;
import dao.RoleDao;
import dao.User;
import dao.UserDao;

public class Myservlet extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse rsp) throws ServletException ,IOException
	{
		String uri = req.getRequestURI();
		rsp.setContentType("text/html;charset=UTF-8");
		UserDao dao = null;
		RoleDao roleDao = null;
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if("save".equals(action)){
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String age = req.getParameter("age");
			
			User u = new User();
			u.setName(name);
			u.setAddress(address);;
			u.setAge(Integer.parseInt(age));
			
			try {
				dao = new UserDao();
				dao.saveUser(u);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			rsp.sendRedirect("list.do");
		}
		else if("list".equals(action))
		{
			dao = new UserDao();
			List<User> users = dao.queryUser();
			req.setAttribute("users", users);
			req.getRequestDispatcher("NewFile.jsp").forward(req, rsp);
		}
		else if("delete".equals(action))
		{
			String userId = req.getParameter("userId");
			dao = new UserDao();
			dao.deleteUser(userId);
			rsp.sendRedirect("list.do");
		}
		else if("change".equals(action))
		{
			String userId = req.getParameter("userId");
			dao = new UserDao();
			User user= dao.queryById(userId);
			req.setAttribute("user", user);
			req.getRequestDispatcher("modify.jsp").forward(req, rsp);
		}
		else if("modify".equals(action))
		{
			String userId = req.getParameter("userId");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String age = req.getParameter("age");
			User u = new User();
			u.setUserId(userId);
			u.setName(name);
			u.setAddress(address);;
			u.setAge(Integer.parseInt(age));
			dao = new UserDao();
			dao.modifyUser(u);
			rsp.sendRedirect("list.do");
		}
		else if("login".equals(action))
		{
			roleDao = new RoleDao();
			String commint = req.getParameter("mima");
			String user = req.getParameter("user");
			String psw = req.getParameter("psw");
			Cookie[] cookies = req.getCookies();
			if(null != cookies){
				for(Cookie c :cookies){
					if("on".equals(commint))
					{
						if("user".equals(c.getName()))
						{
							c.setValue(user);
						}
						else{
							Cookie userCookie = new Cookie("user", user);
							rsp.addCookie(userCookie);
						}
						if("psw".equals(c.getName()))
						{
							c.setValue(psw);
						}
						else{
							Cookie pswCookie = new Cookie("psw", psw);
							rsp.addCookie(pswCookie);
						}
					}else{
						break;
					}
					
				} 
			}
			Role password = roleDao.queryRoleByName(user);
			HttpSession session = req.getSession();
	    	Integer count =(Integer) session.getAttribute("count");
	    	
	    	if(null == count)
	    	{
	    		count= 1;
	    	}
	    	else
	    	{
	    		count++;
	    	}
	    	session.setAttribute("count", count);
			if(psw.equals(password))
			{
				rsp.sendRedirect("list.do");
			}
			else
			{
				rsp.sendRedirect("login.jsp");
			}
			
		}
	}
	
	
}
