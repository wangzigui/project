package dbutil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Role;
import dao.RoleDao;
import dao.UserDao;

public class SpringTest {
	public static void main(String[] args) {
		String conf = "config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		RoleDao roleDao =(RoleDao) ac.getBean("roleDao");
		Role str = roleDao.queryRoleByName("wangzigui");
		UserDao userDao =(UserDao) ac.getBean("userDao");
		
		System.out.println(userDao.queryById("wangzigui"));
		System.out.println(str);
	}
}

