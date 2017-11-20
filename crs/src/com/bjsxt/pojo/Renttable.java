package com.bjsxt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//出租汽车表
public class Renttable {
   
	private Long tableid;
	private Double imprest;
	private Double shouldpayprice;
	private Double price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date begindate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date shouldreturndate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date returndate;
	private String  rentflag;
	private String  custid;
	private Customers cust;
	private String  carid;
	private Cars car;
	private String  username;
	public Renttable(Long tableid, Double imprest, Double shouldpayprice,
			Double price, Date begindate, Date shouldreturndate,
			Date returndate, String rentflag, String custid, Customers cust,
			String carid, Cars car, String username)
	{
		super();
		this.tableid = tableid;
		this.imprest = imprest;
		this.shouldpayprice = shouldpayprice;
		this.price = price;
		this.begindate = begindate;
		this.shouldreturndate = shouldreturndate;
		this.returndate = returndate;
		this.rentflag = rentflag;
		this.custid = custid;
		this.cust = cust;
		this.carid = carid;
		this.car = car;
		this.username = username;
	}
	public Renttable()
	{
		super();
	}
	/**
	 * @return the tableid
	 * @author xiaowei
	 */
	public Long getTableid()
	{
		return tableid;
	}
	/**
	 * @param tableid the tableid to set
	 * @author xiaowei
	 */
	public void setTableid(Long tableid)
	{
		this.tableid = tableid;
	}
	/**
	 * @return the imprest
	 * @author xiaowei
	 */
	public Double getImprest()
	{
		return imprest;
	}
	/**
	 * @param imprest the imprest to set
	 * @author xiaowei
	 */
	public void setImprest(Double imprest)
	{
		this.imprest = imprest;
	}
	/**
	 * @return the shouldpayprice
	 * @author xiaowei
	 */
	public Double getShouldpayprice()
	{
		return shouldpayprice;
	}
	/**
	 * @param shouldpayprice the shouldpayprice to set
	 * @author xiaowei
	 */
	public void setShouldpayprice(Double shouldpayprice)
	{
		this.shouldpayprice = shouldpayprice;
	}
	/**
	 * @return the price
	 * @author xiaowei
	 */
	public Double getPrice()
	{
		return price;
	}
	/**
	 * @param price the price to set
	 * @author xiaowei
	 */
	public void setPrice(Double price)
	{
		this.price = price;
	}
	/**
	 * @return the begindate
	 * @author xiaowei
	 */
	public Date getBegindate()
	{
		return begindate;
	}
	/**
	 * @param begindate the begindate to set
	 * @author xiaowei
	 */
	public void setBegindate(Date begindate)
	{
		this.begindate = begindate;
	}
	/**
	 * @return the shouldreturndate
	 * @author xiaowei
	 */
	public Date getShouldreturndate()
	{
		return shouldreturndate;
	}
	/**
	 * @param shouldreturndate the shouldreturndate to set
	 * @author xiaowei
	 */
	public void setShouldreturndate(Date shouldreturndate)
	{
		this.shouldreturndate = shouldreturndate;
	}
	/**
	 * @return the returndate
	 * @author xiaowei
	 */
	public Date getReturndate()
	{
		return returndate;
	}
	/**
	 * @param returndate the returndate to set
	 * @author xiaowei
	 */
	public void setReturndate(Date returndate)
	{
		this.returndate = returndate;
	}
	/**
	 * @return the rentflag
	 * @author xiaowei
	 */
	public String getRentflag()
	{
		return rentflag;
	}
	/**
	 * @param rentflag the rentflag to set
	 * @author xiaowei
	 */
	public void setRentflag(String rentflag)
	{
		this.rentflag = rentflag;
	}
	/**
	 * @return the custid
	 * @author xiaowei
	 */
	public String getCustid()
	{
		return custid;
	}
	/**
	 * @param custid the custid to set
	 * @author xiaowei
	 */
	public void setCustid(String custid)
	{
		this.custid = custid;
	}
	/**
	 * @return the cust
	 * @author xiaowei
	 */
	public Customers getCust()
	{
		return cust;
	}
	/**
	 * @param cust the cust to set
	 * @author xiaowei
	 */
	public void setCust(Customers cust)
	{
		this.cust = cust;
	}
	/**
	 * @return the carid
	 * @author xiaowei
	 */
	public String getCarid()
	{
		return carid;
	}
	/**
	 * @param carid the carid to set
	 * @author xiaowei
	 */
	public void setCarid(String carid)
	{
		this.carid = carid;
	}
	/**
	 * @return the car
	 * @author xiaowei
	 */
	public Cars getCar()
	{
		return car;
	}
	/**
	 * @param car the car to set
	 * @author xiaowei
	 */
	public void setCar(Cars car)
	{
		this.car = car;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Renttable [tableid=" + tableid + ", imprest=" + imprest
				+ ", shouldpayprice=" + shouldpayprice + ", price=" + price
				+ ", begindate=" + begindate + ", shouldreturndate="
				+ shouldreturndate + ", returndate=" + returndate
				+ ", rentflag=" + rentflag + ", custid=" + custid + ", cust="
				+ cust + ", carid=" + carid + ", car=" + car + ", username="
				+ username + "]";
	}

}
