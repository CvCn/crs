package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.Pagination;

public interface LoginLogsMapper
{
	List<LoginLogs> selLoginLogsBy(@Param("login") LoginLogs login, @Param("p") Pagination p);
	
	int loginLogsCount(@Param("login") LoginLogs login);
	
	@Insert("insert into loginlogs values(default, #{loginname}, #{loginip}, #{logintime})")
	int insLoginLogs(LoginLogs login);
}
