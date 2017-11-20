package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.CustMapper;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Customers;
import com.bjsxt.pojo.Pagination;

public class CustTest
{

	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustMapper b = ac.getBean("custMapper", CustMapper.class);
//		System.out.println(b.addCust(new Customers("12313123131231", "123", "1", "1", "1", "1")));
//		List<String> selIdentity = b.selIdentity();
//		for (String string : selIdentity)
//		{
//			System.out.println(string);
//		}
//		Customers customers = new Customers();
//		List<Customers> selCust = b.selCustBy(customers, new Pagination("2", "10", b.custCount(customers), 5));
//		for (Customers customers2 : selCust)
//		{
//			System.out.println(customers2);
//		}
		
		int updateCust = b.updateCust(new Customers("130625139920243430", "123", "1", "123", "123", "123"), "130625139920243430");
		System.out.println(updateCust);
	}

}
