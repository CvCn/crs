package com.bjsxt.pojo;

//汽车信息表
public class Cars {
   
	private String carnumber;
	private String cartype; 
	private String color;  
	private Double price;   
	private Double rentprice; 
	private Double deposit;  
	private String isrenting;
	private String description;
	private String imgpath;
	public Cars(String carnumber, String cartype, String color, double price,
			double rentprice, Double deposit, String isrenting,
			String description, String imgpath)
	{
		super();
		this.carnumber = carnumber;
		this.cartype = cartype;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.isrenting = isrenting;
		this.description = description;
		this.imgpath = imgpath;
	}
	public Cars()
	{
		super();
		this.price = 0.0;
		this.rentprice = 0.0;
		this.deposit = 0.0;
	}
	/**
	 * @return the carnumber
	 * @author xiaowei
	 */
	public String getCarnumber()
	{
		return carnumber;
	}
	/**
	 * @param carnumber the carnumber to set
	 * @author xiaowei
	 */
	public void setCarnumber(String carnumber)
	{
		this.carnumber = carnumber;
	}
	/**
	 * @return the cartype
	 * @author xiaowei
	 */
	public String getCartype()
	{
		return cartype;
	}
	/**
	 * @param cartype the cartype to set
	 * @author xiaowei
	 */
	public void setCartype(String cartype)
	{
		this.cartype = cartype;
	}
	/**
	 * @return the color
	 * @author xiaowei
	 */
	public String getColor()
	{
		return color;
	}
	/**
	 * @param color the color to set
	 * @author xiaowei
	 */
	public void setColor(String color)
	{
		this.color = color;
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
	 * @return the rentprice
	 * @author xiaowei
	 */
	public Double getRentprice()
	{
		return rentprice;
	}
	/**
	 * @param rentprice the rentprice to set
	 * @author xiaowei
	 */
	public void setRentprice(Double rentprice)
	{
		this.rentprice = rentprice;
	}
	/**
	 * @return the deposit
	 * @author xiaowei
	 */
	public Double getDeposit()
	{
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 * @author xiaowei
	 */
	public void setDeposit(Double deposit)
	{
		this.deposit = deposit;
	}

	/**
	 * @param deposit the deposit to set
	 * @author xiaowei
	 */
	public void setDeposit(double deposit)
	{
		this.deposit = deposit;
	}
	/**
	 * @return the isrenting
	 * @author xiaowei
	 */
	public String getIsrenting()
	{
		return isrenting;
	}
	/**
	 * @param isrenting the isrenting to set
	 * @author xiaowei
	 */
	public void setIsrenting(String isrenting)
	{
		this.isrenting = isrenting;
	}
	/**
	 * @return the description
	 * @author xiaowei
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * @param description the description to set
	 * @author xiaowei
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * @return the imapath
	 * @author xiaowei
	 */
	public String getImgpath()
	{
		return imgpath;
	}
	/**
	 * @param imapath the imapath to set
	 * @author xiaowei
	 */
	public void setImgpath(String imgpath)
	{
		this.imgpath = imgpath;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Cars [carnumber=" + carnumber + ", cartype=" + cartype
				+ ", color=" + color + ", price=" + price + ", rentprice="
				+ rentprice + ", deposit=" + deposit + ", isrenting="
				+ isrenting + ", description=" + description + ", imapath="
				+ imgpath + "]";
	}
	
	
	
}
