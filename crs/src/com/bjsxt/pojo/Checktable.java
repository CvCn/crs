package com.bjsxt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Checktable
{
	private Long checkid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkdate;
	private String field;
	private String problem;
	private Double paying;
	private String checkuser;
	private long rentid;
	private Renttable renttable;
	
	public Checktable(Long checkid, Date checkdate, String field,
			String problem, Double paying, String checkuser, long rentid,
			Renttable renttable)
	{
		super();
		this.checkid = checkid;
		this.checkdate = checkdate;
		this.field = field;
		this.problem = problem;
		this.paying = paying;
		this.checkuser = checkuser;
		this.rentid = rentid;
		this.renttable = renttable;
	}
	public Checktable()
	{
		super();
	}
	/**
	 * @return the checkid
	 * @author xiaowei
	 */
	public Long getCheckid()
	{
		return checkid;
	}
	/**
	 * @param checkid the checkid to set
	 * @author xiaowei
	 */
	public void setCheckid(Long checkid)
	{
		this.checkid = checkid;
	}
	
	/**
	 * @return the checkdate
	 * @author xiaowei
	 */
	public Date getCheckdate()
	{
		return checkdate;
	}
	/**
	 * @param checkdate the checkdate to set
	 * @author xiaowei
	 */
	public void setCheckdate(Date checkdate)
	{
		this.checkdate = checkdate;
	}
	/**
	 * @return the field
	 * @author xiaowei
	 */
	public String getField()
	{
		return field;
	}
	/**
	 * @param field the field to set
	 * @author xiaowei
	 */
	public void setField(String field)
	{
		this.field = field;
	}
	/**
	 * @return the problem
	 * @author xiaowei
	 */
	public String getProblem()
	{
		return problem;
	}
	/**
	 * @param problem the problem to set
	 * @author xiaowei
	 */
	public void setProblem(String problem)
	{
		this.problem = problem;
	}
	/**
	 * @return the paying
	 * @author xiaowei
	 */
	public Double getPaying()
	{
		return paying;
	}
	/**
	 * @param paying the paying to set
	 * @author xiaowei
	 */
	public void setPaying(Double paying)
	{
		this.paying = paying;
	}
	/**
	 * @return the checkuser
	 * @author xiaowei
	 */
	public String getCheckuser()
	{
		return checkuser;
	}
	/**
	 * @param checkuser the checkuser to set
	 * @author xiaowei
	 */
	public void setCheckuser(String checkuser)
	{
		this.checkuser = checkuser;
	}
	/**
	 * @return the rentid
	 * @author xiaowei
	 */
	public long getRentid()
	{
		return rentid;
	}
	/**
	 * @param rentid the rentid to set
	 * @author xiaowei
	 */
	public void setRentid(long rentid)
	{
		this.rentid = rentid;
	}
	/**
	 * @return the renttable
	 * @author xiaowei
	 */
	public Renttable getRenttable()
	{
		return renttable;
	}
	/**
	 * @param renttable the renttable to set
	 * @author xiaowei
	 */
	public void setRenttable(Renttable renttable)
	{
		this.renttable = renttable;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Checktable [checkid=" + checkid + ", chedkdate=" + checkdate
				+ ", field=" + field + ", problem=" + problem + ", paying="
				+ paying + ", checkuser=" + checkuser + ", rentid=" + rentid
				+ ", renttable=" + renttable + "]";
	}
	
	
}
