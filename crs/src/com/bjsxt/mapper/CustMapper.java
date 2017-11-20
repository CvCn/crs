package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Customers;
import com.bjsxt.pojo.Pagination;

public interface CustMapper
{
	@Insert("insert into customers values(#{identity}, #{custname}, #{sex}, #{address}, #{phone}, #{career})")
	int insCust(Customers c);
	
	@Select("select identity from Customers")
	List<String> selIdentity();
	
	List<Customers> selCustBy(@Param("c") Customers c, @Param("p") Pagination p);
	
	@Select("select * from customers where identity=#{0}")
	Customers selCustByIdentity(String identity);
	
	int custCount(@Param("c") Customers c);
	
	int updateCust(@Param("c") Customers c, @Param("identity") String identity);
	
	@Delete("delete from Customers where identity=#{0}")
	int deleteCust(String identity);
}
