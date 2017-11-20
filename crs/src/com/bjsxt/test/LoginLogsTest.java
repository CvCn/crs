package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.LoginLogsMapper;
import com.bjsxt.mapper.OperationLogsMapper;
import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;

public class LoginLogsTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginLogsMapper b = ac.getBean("loginLogsMapper", LoginLogsMapper.class);
		LoginLogs login = new LoginLogs();
		login.setLoginname("dome01");
		List<LoginLogs> selLoginLogsBy = b.selLoginLogsBy(login, new Pagination("1", "1", b.loginLogsCount(login), 1));
		for (LoginLogs loginLogs : selLoginLogsBy)
		{
			System.out.println(loginLogs);
		}
		
		

	}
}
