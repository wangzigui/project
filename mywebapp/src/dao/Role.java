package dao;


//@Entity
//@Table(name ="role")
public class Role {
	
//	@Id
//	@Column(name = "user")
	private String user;
	
//	@Column(name = "password")
	private String password;
	
//	@Column(name = "role")
	private Integer role;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "role [user=" + user + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
