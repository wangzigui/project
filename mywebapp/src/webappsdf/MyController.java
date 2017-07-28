package webappsdf;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dao.Role;
import dao.RoleDao;
import dao.User;
import dao.UserDao;
import domain.ModifyReq;

@Controller
@RequestMapping("/day01")
public class MyController{

	@Resource
	private RoleDao roleDao;
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping("/login.do")
	public ModelAndView execute(String user ,String psw)
	{
		System.out.println(user+","+psw);
		if(StringUtils.isEmpty(psw)||StringUtils.isEmpty(user))
		{
			throw new NullPointerException("登陆参数不能为null");
		}
		
		Role role = roleDao.queryRoleByName(user);
		System.out.println(role);
		
		if(null == role || !psw.equals(role.getPassword()))
		{
			throw new NullPointerException("登陆名或者密码错误！");
		}
		System.out.println("jisdfsdf");
		RedirectView view = new RedirectView("list.do");
		return new ModelAndView(view);
	}
	
	@RequestMapping("/login.html")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/list.do")
	public String queryList(HttpServletRequest req)
	{
		List<User> users = userDao.queryUser();
		req.setAttribute("users", users);
		return "NewFile";
	}
	
	@RequestMapping("/change.do")
	public String change(HttpServletRequest req)
	{
		String userId = req.getParameter("userId");
		User user= userDao.queryById(userId);
		req.setAttribute("user", user);
		
		return "modify";
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView change(ModifyReq modifyReq,HttpServletRequest req)
	{
		System.out.println(modifyReq.toString());
		User u = new User();
		u.setUserId(modifyReq.getUserId());
		u.setName(modifyReq.getName());
		u.setAddress(modifyReq.getAddress());;
		u.setAge(Integer.parseInt(modifyReq.getAge()));
		userDao.modifyUser(u);
		
		RedirectView view = new RedirectView("list.do");
		return new ModelAndView(view);
		
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req)
	{
		String userId = req.getParameter("userId");
		userDao.deleteUser(userId);
		RedirectView view = new RedirectView("list.do");
		return new ModelAndView(view);
	}
	
	@RequestMapping("/create.do")
	public String create()
	{
		return "NewFile1";
	}
	
	@RequestMapping("/save.do")
	public ModelAndView save(User req)
	{
		System.out.println(req.toString());
		try {
			userDao.saveUser(req);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RedirectView view = new RedirectView("list.do");
		return new ModelAndView(view);
	}
	
}
