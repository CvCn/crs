package com.bjsxt.pojo;

import java.util.List;

public class Menus
{
	private int menuid;
	private String name;
	private String uri;
	private int fatherid;
	private List<Menus> childrenmenus;
	private String checked;
	public Menus(int menuid, String name, String uri, int fatherid,
			List<Menus> childrenmenus, String checked)
	{
		super();
		this.menuid = menuid;
		this.name = name;
		this.uri = uri;
		this.fatherid = fatherid;
		this.childrenmenus = childrenmenus;
		this.checked = checked;
	}
	public Menus()
	{
		super();
		this.checked = "";
	}
	/**
	 * @return the menuid
	 * @author xiaowei
	 */
	public int getMenuid()
	{
		return menuid;
	}
	/**
	 * @param menuid the menuid to set
	 * @author xiaowei
	 */
	public void setMenuid(int menuid)
	{
		this.menuid = menuid;
	}
	/**
	 * @return the name
	 * @author xiaowei
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 * @author xiaowei
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the uri
	 * @author xiaowei
	 */
	public String getUri()
	{
		return uri;
	}
	/**
	 * @param uri the uri to set
	 * @author xiaowei
	 */
	public void setUri(String uri)
	{
		this.uri = uri;
	}
	/**
	 * @return the fatherid
	 * @author xiaowei
	 */
	public int getFatherid()
	{
		return fatherid;
	}
	/**
	 * @param fatherid the fatherid to set
	 * @author xiaowei
	 */
	public void setFatherid(int fatherid)
	{
		this.fatherid = fatherid;
	}
	/**
	 * @return the childrenmenus
	 * @author xiaowei
	 */
	public List<Menus> getChildrenmenus()
	{
		return childrenmenus;
	}
	/**
	 * @param childrenmenus the childrenmenus to set
	 * @author xiaowei
	 */
	public void setChildrenmenus(List<Menus> childrenmenus)
	{
		this.childrenmenus = childrenmenus;
	}
	/**
	 * @return the checked
	 * @author xiaowei
	 */
	public String getChecked()
	{
		return checked;
	}
	/**
	 * @param checked the checked to set
	 * @author xiaowei
	 */
	public void setChecked(String checked)
	{
		this.checked = checked;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Menus [menuid=" + menuid + ", name=" + name + ", uri=" + uri
				+ ", fatherid=" + fatherid + ", childrenmenus=" + childrenmenus
				+ ", checked=" + checked + "]";
	}
	
	
}
