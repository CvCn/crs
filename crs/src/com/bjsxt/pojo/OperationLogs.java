package com.bjsxt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OperationLogs
{
	private int id;
	private String username;
	private String action;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date actiontime;
	public OperationLogs(int id, String username, String action, Date actiontime)
	{
		super();
		this.id = id;
		this.username = username;
		this.action = action;
		this.actiontime = actiontime;
	}
	public OperationLogs()
	{
		super();
	}
	/**
	 * @return the id
	 * @author xiaowei
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 * @author xiaowei
	 */
	public void setId(int id)
	{
		this.id = id;
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
	 * @return the action
	 * @author xiaowei
	 */
	public String getAction()
	{
		return action;
	}
	/**
	 * @param action the action to set
	 * @author xiaowei
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
	/**
	 * @return the actiontime
	 * @author xiaowei
	 */
	public Date getActiontime()
	{
		return actiontime;
	}
	/**
	 * @param actiontime the actiontime to set
	 * @author xiaowei
	 */
	public void setActiontime(Date actiontime)
	{
		this.actiontime = actiontime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "OperationLogs [id=" + id + ", username=" + username
				+ ", action=" + action + ", actiontime=" + actiontime + "]";
	}
	
	
	
}
