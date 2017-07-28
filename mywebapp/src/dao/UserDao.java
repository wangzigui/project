package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import common.JDBCDateSource;
import dbutil.DButil;

@Repository
public class UserDao {

	@Resource
	private JDBCDateSource jDBCDateSource;
	
	public void saveUser(User u) throws ClassNotFoundException {
		// ����Connection����
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		try {
			con = jDBCDateSource.getConnection();
			ps = (PreparedStatement) con.prepareStatement("INSERT INTO user(userId,name,address,age) VALUES(?,?,?,?);");
			String userid = UUID.randomUUID().toString();
			ps.setString(1, userid);
			ps.setString(2, u.getName());
			ps.setString(3, u.getAddress());
			ps.setInt(4, u.getAge());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(con);
		}

	}

	public List<User> queryUser() {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		User user = null;
		try {
			con = DButil.getConnection();
			ps = (PreparedStatement) con.prepareStatement("select * from user");
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				users.add(user);

			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			DButil.closeConnection(con);
		}
		
	}
	
	public static void main(String[] args) {
		UserDao u = new UserDao();
		u.deleteUser("123456");
		
		
	}

	public void deleteUser(String userId) {
		java.sql.Connection con;
		PreparedStatement ps = null;
		
		con = DButil.getConnection();
		try {
			ps = (PreparedStatement) con.prepareStatement("delete from user where userId = ?");
			ps.setString(1, userId);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();


		} finally {
			DButil.closeConnection(con);
		}
		
	}

	public User queryById(String userId) {
		java.sql.Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user=null;
		con = DButil.getConnection();
		try {
			ps = (PreparedStatement) con.prepareStatement("select * from user where userId = ?");
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
			}
			return user;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			DButil.closeConnection(con);
		}
		
		
	}

	public void modifyUser(User u) {
		java.sql.Connection con;
		PreparedStatement ps = null;
		
		con = DButil.getConnection();
		try {
			ps = (PreparedStatement) con.prepareStatement("update user set name = ?, address=?, age = ? where userId = ?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getAddress());
			ps.setInt(3, u.getAge());
			ps.setString(4, u.getUserId());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();


		} finally {
			DButil.closeConnection(con);
		}
	}

}
