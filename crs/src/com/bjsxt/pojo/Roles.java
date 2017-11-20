package com.bjsxt.pojo;

import java.util.List;

public class Roles
{
	private Integer roleid;
	private String rolename;
	private List<Menus> menus;
	private List<Funs> funs;
	public Roles(Integer roleid, String rolename, List<Menus> menus,
			List<Funs> funs)
	{
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.menus = menus;
		this.funs = funs;
	}
	public Roles()
	{
		super();
		this.roleid = -1;
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
	 * @return the rolename
	 * @author xiaowei
	 */
	public String getRolename()
	{
		return rolename;
	}
	/**
	 * @param rolename the rolename to set
	 * @author xiaowei
	 */
	public void setRolename(String rolename)
	{
		this.rolename = rolename;
	}
	/**
	 * @return the menus
	 * @author xiaowei
	 */
	public List<Menus> getMenus()
	{
		return menus;
	}
	/**
	 * @param menus the menus to set
	 * @author xiaowei
	 */
	public void setMenus(List<Menus> menus)
	{
		this.menus = menus;
	}
	/**
	 * @return the funs
	 * @author xiaowei
	 */
	public List<Funs> getFuns()
	{
		return funs;
	}
	/**
	 * @param funs the funs to set
	 * @author xiaowei
	 */
	public void setFuns(List<Funs> funs)
	{
		this.funs = funs;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Roles [roleid=" + roleid + ", rolename=" + rolename
				+ ", menus=" + menus + ", funs=" + funs + "]";
	}
	
	
	
}
