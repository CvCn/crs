package com.bjsxt.pojo;


public class Users
{
	private String username;
	private String identity;
	private String fullname;
	private String sex;
	private String address;
	private String phone;
	private Integer roleid;
	private String userpwd;
	private String position;
	private Roles roles;
	public Users(String username, String identity, String fullname, String sex,
			String address, String phone, Integer roleid, String userpwd,
			String position, Roles roles)
	{
		super();
		this.username = username;
		this.identity = identity;
		this.fullname = fullname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.roleid = roleid;
		this.userpwd = userpwd;
		this.position = position;
		this.roles = roles;
	}
	public Users()
	{
		super();
	}
	/**
	 * @return the username
	 * @author xiaowei
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 * @author xiaowei
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the identity
	 * @author xiaowei
	 */
	public String getIdentity()
	{
		return identity;
	}
	/**
	 * @param identity the identity to set
	 * @author xiaowei
	 */
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	/**
	 * @return the fullname
	 * @author xiaowei
	 */
	public String getFullname()
	{
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 * @author xiaowei
	 */
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	/**
	 * @return the sex
	 * @author xiaowei
	 */
	public String getSex()
	{
		return sex;
	}
	/**
	 * @param sex the sex to set
	 * @author xiaowei
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	/**
	 * @return the address
	 * @author xiaowei
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * @param address the address to set
	 * @author xiaowei
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/**
	 * @return the phone
	 * @author xiaowei
	 */
	public String getPhone()
	{
		return phone;
	}
	/**
	 * @param phone the phone to set
	 * @author xiaowei
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	/**
	 * @return the roleid
	 * @author xiaowei
	 */
	public Integer getRoleid()
	{
		return roleid;
	}
	/**
	 * @param roleid the roleid to set
	 * @author xiaowei
	 */
	public void setRoleid(Integer roleid)
	{
		this.roleid = roleid;
	}
	/**
	 * @return the userpwd
	 * @author xiaowei
	 */
	public String getUserpwd()
	{
		return userpwd;
	}
	/**
	 * @param userpwd the userpwd to set
	 * @author xiaowei
	 */
	public void setUserpwd(String userpwd)
	{
		this.userpwd = userpwd;
	}
	/**
	 * @return the position
	 * @author xiaowei
	 */
	public String getPosition()
	{
		return position;
	}
	/**
	 * @param position the position to set
	 * @author xiaowei
	 */
	public void setPosition(String position)
	{
		this.position = position;
	}
	/**
	 * @return the roles
	 * @author xiaowei
	 */
	public Roles getRoles()
	{
		return roles;
	}
	/**
	 * @param roles the roles to set
	 * @author xiaowei
	 */
	public void setRoles(Roles roles)
	{
		this.roles = roles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Users [username=" + username + ", identity=" + identity
				+ ", fullname=" + fullname + ", sex=" + sex + ", address="
				+ address + ", phone=" + phone + ", roleid=" + roleid
				+ ", userpwd=" + userpwd + ", position=" + position
				+ ", roles=" + roles + "]";
	}
	
}
