package com.bjsxt.pojo;

public class Funs
{
	private int funid;
	private String name;
	private String uri;
	private int menuid ;
	public Funs(int funid, String name, String uri, int menuid)
	{
		super();
		this.funid = funid;
		this.name = name;
		this.uri = uri;
		this.menuid = menuid;
	}
	public Funs()
	{
		super();
	}
	/**
	 * @return the funid
	 * @author xiaowei
	 */
	public int getFunid()
	{
		return funid;
	}
	/**
	 * @param funid the funid to set
	 * @author xiaowei
	 */
	public void setFunid(int funid)
	{
		this.funid = funid;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Funs [funid=" + funid + ", name=" + name + ", uri=" + uri
				+ ", menuid=" + menuid + "]";
	}
	
}
