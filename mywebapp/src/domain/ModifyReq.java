package domain;

public class ModifyReq {
	private String name;
	private String address;
	private String age;
	private String userId;
	
	public ModifyReq(){}
	
	public ModifyReq(String name,String address,String age,String userId)
	{
		this.name = name;
		this.address = address;
		this.age = age;
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ModifyReq [name=" + name + ", address=" + address + ", age=" + age + ", userId=" + userId + "]";
	}


	
	
}
