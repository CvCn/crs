package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.RolesMapper;
import com.bjsxt.pojo.Roles;

public class RoleTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		RolesMapper b = ac.getBean("rolesMapper", RolesMapper.class);
		
//		int insRoleMenu = b.insRoleMenu(5, 11);
//		System.out.println(insRoleMenu);
		
//		System.out.println(b.deleteRoleMenu(5));
		System.out.println(b.insRole(new Roles(1, "123", null, null)));
		
//		Roles r = new Roles();
//		r.setRoleid(0);
//		List<Roles> selRoles = b.selRoleBy(r, null);
//		for (Roles roles : selRoles)
//		{
//			System.out.println(roles);
//		}
	}
}
