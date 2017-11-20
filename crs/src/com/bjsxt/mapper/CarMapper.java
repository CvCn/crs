package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Pagination;

public interface CarMapper
{
	@Insert("insert into cars values(#{carnumber}, #{cartype}, #{color}, #{price}, #{rentprice}, #{deposit},"
			+ "#{isrenting}, #{description}, #{imgpath} )")
	int insCar(Cars c);
	
	@Select("select carnumber from cars")
	List<String> selCarNumber();
	
	List<Cars> selCarBy(@Param("c") Cars c, @Param("p") Pagination p);
	
	@Select("Select * from cars where carnumber=#{0}")
	Cars selCarByNumber(String carnumber);
	
	int carCount(@Param("c") Cars c);
	
	int updateCar(@Param("c") Cars c);
	
	@Delete("delete from cars where carnumber=#{0}")
	int deleteCar(String carnumber);
}
