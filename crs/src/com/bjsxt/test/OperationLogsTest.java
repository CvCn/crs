package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.OperationLogsMapper;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;

public class OperationLogsTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OperationLogsMapper b = ac.getBean("operationLogsMapper", OperationLogsMapper.class);
		OperationLogs o = new OperationLogs();
		List<OperationLogs> selOperationLogsBy = b.selOperationLogsBy(o, new Pagination("1", "1", b.operationLogsCount(o), 1));
		for (OperationLogs operationLogs : selOperationLogsBy)
		{
			System.out.println(operationLogs);
		}
		

	}
}
