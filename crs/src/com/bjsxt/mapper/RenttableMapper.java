package com.bjsxt.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Renttable;

public interface RenttableMapper
{
	
	@Insert("insert into renttable values(#{tableid}, #{imprest}, #{shouldpayprice}, #{price}, #{begindate}"
			+ ", #{shouldreturndate}, #{returndate}, #{rentflag}, #{custid}, #{carid}, #{username})")
	int insRenttable(Renttable r);
	
	List<Renttable> selRenttable(@Param("r") Renttable r, @Param("p") Pagination p);
	
	List<Renttable> selRenttableBy(@Param("tableid") Long tableid, @Param("date") Date date, @Param("findbydate") String findbydate, @Param("p") Pagination p);
	
	@Results({
		@Result(id=true, property="tableid", column="tableid"),
		@Result(property="custid", column="custid"),
		@Result(property="carid", column="carid"),
		@Result(property="cust", one=@One(select="com.bjsxt.mapper.CustMapper.selCustByIdentity"), column="custid"),
		@Result(property="car", one=@One(select="com.bjsxt.mapper.CarMapper.selCarByNumber"), column="carid")
	})
	@Select("select * from renttable where tableid=#{0}")
	Renttable selRenttableByTableid(Long tableid);
//	@Results({
//		@Result(id=true, property="tableid", column="tableid"),
//		@Result(property="custid", column="custid"),
//		@Result(property="carid", column="carid"),
//		@Result(property="cust", one=@One(select="com.bjsxt.mapper.CustMapper.selCustByIdentity"), column="custid"),
//		@Result(property="car", one=@One(select="com.bjsxt.mapper.CarMapper.selCarByNumber"), column="carid")
//	})
//	@Select("select * from renttable where DATE_FORMAT(shouldreturndate,'%Y-%m') = DATE_FORMAT(#{0},'%Y-%m')")
//	List<Renttable> seltableidByMouth(Date d);
//	
//	@Results({
//		@Result(id=true, property="tableid", column="tableid"),
//		@Result(property="custid", column="custid"),
//		@Result(property="carid", column="carid"),
//		@Result(property="cust", one=@One(select="com.bjsxt.mapper.CustMapper.selCustByIdentity"), column="custid"),
//		@Result(property="car", one=@One(select="com.bjsxt.mapper.CarMapper.selCarByNumber"), column="carid")
//	})
//	@Select("select * from renttable where DATE_FORMAT(shouldreturndate,'%Y-%m-%d') = DATE_FORMAT(#{0},'%Y-%m-%d')")
//	List<Renttable> seltableidByDay(Date d);
	
	int renttableCount(@Param("r") Renttable r);
	
	
	int updateRenttable(Renttable r);
	
	@Select("select tableid from renttable")
	List<Long> selTableid();
}
