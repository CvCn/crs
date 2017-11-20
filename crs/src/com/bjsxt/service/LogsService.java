package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;

public interface LogsService
{
	List<OperationLogs> findOperationLogs(OperationLogs o, Pagination p);
	
	int OperationLogsCount(OperationLogs o);
	
	List<LoginLogs> findLoginLogs(LoginLogs login, Pagination p);
	
	int LoginLogsCount(LoginLogs login);
	
	int addOperationLogs(OperationLogs o);
	
	int addLoginLogs(LoginLogs login);
}
