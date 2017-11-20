package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.ChecktableMapper;
import com.bjsxt.pojo.Checktable;
import com.bjsxt.pojo.Pagination;

public class CheckTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ChecktableMapper b = ac.getBean("checktableMapper", ChecktableMapper.class);
		Checktable checktable = new Checktable();
		List<Checktable> selChecktable = b.selChecktable(checktable, new Pagination("1", "10", 10, 6));
		for (Checktable checktable2 : selChecktable)
		{
			System.out.println(checktable2);
		}
	}
}
