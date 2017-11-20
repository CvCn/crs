package com.bjsxt.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.RenttableMapper;
import com.bjsxt.pojo.Renttable;

public class RenTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		RenttableMapper b = ac.getBean("renttableMapper", RenttableMapper.class);
//		int insRenttable = b.insRenttable(new Renttable(123132L, 11.3, 32.4, 12.3, new Date(), new Date(), new Date(), "1", "11", "京BB0000", "dome01"));
//		System.out.println(insRenttable);
//		Renttable renttable = new Renttable();
//		renttable.setRentflag("0");
//		List<Renttable> selRenttable = b.selRenttable(renttable, new Pagination("1", "10", b.renttableCount(renttable), 10));
//		for (Renttable renttable2 : selRenttable)
//		{
//			System.out.println(renttable2);
//		}
//		Renttable renttable = new Renttable();
//		List<Renttable> selRenttable = b.selRenttable(renttable, new Pagination("1", "10", b.renttableCount(renttable), 10));
//		for (Renttable renttable2 : selRenttable)
//		{
//			System.out.println(renttable2);
//		}
//		Renttable r = new Renttable();
//		r.setReturndate(new Date());
//		r.setTableid(9141201711170911989L);
//		System.out.println(b.updateRenttable(r));
	}
}
