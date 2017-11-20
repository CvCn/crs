package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Checktable;
import com.bjsxt.pojo.Pagination;

public interface ChecktableMapper
{
	@Insert("insert into checktable values(#{checkid}, #{checkdate}, #{field}, #{problem}, #{paying}, #{checkuser}, #{rentid})")
	int insChecktable(Checktable check);
	
	List<Checktable> selChecktable(@Param("c") Checktable c, @Param("p") Pagination p);
	
	int checktableCount(@Param("c") Checktable c);
	
	int updateChecktable(Checktable c);
}
