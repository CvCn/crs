package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;

public interface OperationLogsMapper
{
	List<OperationLogs> selOperationLogsBy(@Param("o") OperationLogs o, @Param("p") Pagination p);
	
	int operationLogsCount(@Param("o") OperationLogs o);
	
	@Insert("insert into  operation_logs values(default, #{username}, #{action}, #{actiontime})")
	int insOperationLogs(OperationLogs o);
}
