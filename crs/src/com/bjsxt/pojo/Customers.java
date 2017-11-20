package com.bjsxt.pojo;

//用户表
public class Customers {
  
	private String identity;
	private String custname;
	private String sex;
	private String address;
	private String phone;
	private String career;
	
	public Customers()
	{
		super();
	}
	public Customers(String identity, String custname, String sex,
			String address, String phone, String career)
	{
		super();
		this.identity = identity;
		this.custname = custname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.career = career;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "Customers [identity=" + identity + ", custname=" + custname + ", sex=" + sex + ", address=" + address
				+ ", phone=" + phone + ", career=" + career + "]";
	}
	
	
	
}
