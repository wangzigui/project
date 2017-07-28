package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

import common.JDBCDateSource;
import dbutil.DButil;

@Repository
public class RoleDao {
	
	@Resource
	private JDBCDateSource jDBCDateSource;
	
	public Role queryRoleByName(String user)
	{
		Connection conn = null;
		PreparedStatement ps =null; 
		ResultSet rs = null;
		Role role = new Role();
		conn = jDBCDateSource.getConnection();
		System.out.println(conn);
		try {
			ps = (PreparedStatement) conn.prepareStatement("select * from role where user =?");
			ps.setString(1, user);
			rs = ps.executeQuery();
			while(rs.next())
			{
				role.setUser(user);
				role.setPassword(rs.getString("password"));
				role.setRole(rs.getInt("role"));
			}
			return role;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally
		{
			DButil.closeConnection(conn);
		}
		
	}
	
	public void init()
	{
		System.out.println("init.....");
	}
}
