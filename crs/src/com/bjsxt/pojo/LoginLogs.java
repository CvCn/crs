package com.bjsxt.pojo;

import java.util.Date;

public class LoginLogs
{
	private int loginlogid;
	private String loginname;
	private String loginip;
	private Date logintime;
	public LoginLogs(int loginlogid, String loginname, String loginip,
			Date logintime)
	{
		super();
		this.loginlogid = loginlogid;
		this.loginname = loginname;
		this.loginip = loginip;
		this.logintime = logintime;
	}
	/**
	 * @return the loginlogid
	 * @author xiaowei
	 */
	public int getLoginlogid()
	{
		return loginlogid;
	}
	/**
	 * @param loginlogid the loginlogid to set
	 * @author xiaowei
	 */
	public void setLoginlogid(int loginlogid)
	{
		this.loginlogid = loginlogid;
	}
	/**
	 * @return the loginname
	 * @author xiaowei
	 */
	public String getLoginname()
	{
		return loginname;
	}
	/**
	 * @param loginname the loginname to set
	 * @author xiaowei
	 */
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	/**
	 * @return the loginip
	 * @author xiaowei
	 */
	public String getLoginip()
	{
		return loginip;
	}
	/**
	 * @param loginip the loginip to set
	 * @author xiaowei
	 */
	public void setLoginip(String loginip)
	{
		this.loginip = loginip;
	}
	/**
	 * @return the logintime
	 * @author xiaowei
	 */
	public Date getLogintime()
	{
		return logintime;
	}
	/**
	 * @param logintime the logintime to set
	 * @author xiaowei
	 */
	public void setLogintime(Date logintime)
	{
		this.logintime = logintime;
	}
	public LoginLogs()
	{
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "LoginLogs [loginlogid=" + loginlogid + ", loginname="
				+ loginname + ", loginip=" + loginip + ", logintime="
				+ logintime + "]";
	}
	
	
	
}
