package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.LoginLogsMapper;
import com.bjsxt.mapper.OperationLogsMapper;
import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.LogsService;

@Service
public class LogsServiceImpl implements LogsService
{

	@Resource
	private OperationLogsMapper operationLogsMapper;
	
	@Resource
	private LoginLogsMapper loginLogsMapper;
	
	@Override
	public List<OperationLogs> findOperationLogs(OperationLogs o, Pagination p)
	{
		return operationLogsMapper.selOperationLogsBy(o, p);
	}

	@Override
	public List<LoginLogs> findLoginLogs(LoginLogs login, Pagination p)
	{
		return loginLogsMapper.selLoginLogsBy(login, p);
	}

	@Override
	public int OperationLogsCount(OperationLogs o)
	{
		return operationLogsMapper.operationLogsCount(o);
	}

	@Override
	public int LoginLogsCount(LoginLogs login)
	{
		return loginLogsMapper.loginLogsCount(login);
	}

	@Override
	public int addOperationLogs(OperationLogs o)
	{
		return operationLogsMapper.insOperationLogs(o);
	}

	@Override
	public int addLoginLogs(LoginLogs login)
	{
		return loginLogsMapper.insLoginLogs(login);
	}
	
}
