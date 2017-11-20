package com.bjsxt.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Users;

public class Test
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersMapper b = ac.getBean("usersMapper", UsersMapper.class);
//		List<Users> selUser = b.selUser("dome01", "123123");
//		for (Users users : selUser)
//		{
//			System.out.println(users);
//		}
		Users users2 = new Users();
		users2.setUsername("dome06");
		List<Users> selUserBy = b.selUserBy(users2, null);
		for (Users users : selUserBy)
		{
			System.out.println(users);
		}
		
//		int addUser = b.addUser(new Users("123", "123", "123", "na", "123", "123", 0, "123", "123", null));
//		System.out.println(addUser);
//		Users u2 = new Users();
//		u2.setPosition("业务");
//		List<Users> selUserBy = b.selUserBy(u2, new Pagination("1", String.valueOf(b.userCount(u2)), b.userCount(u2), 0));
//		for (Users users : selUserBy)
//		{
//			System.out.println(users);
//		}
		
//		System.out.println(b.selUsername());
		
//		int updateUser = b.updateUser(new Users("dome02", "157876452736485", "dome02", "女", "北京市海淀区", "17878655643", 2, "", "总监", null)
//							, "dome02");
//		System.out.println(updateUser);
//		List<Users> u = b.selUser("dome01", "123123");
//		for (Users users : u)
//		{
//			System.out.println(users);
//		}
//		FunsMapper b = ac.getBean("funsMapper", FunsMapper.class);
//		List<Funs> selFuns = b.selFuns(0);
//		for (Funs funs : selFuns)
//		{
//			System.out.println(funs);
//		}
//		MenusMapper b = ac.getBean("menusMapper", MenusMapper.class);
//		Map<String, Integer> map = new HashMap<>();
//		map.put("roleid", 0);
//		map.put("fatherid", 0);
//		List<Menus> selMenus = b.selMenus(map);
//		for (Menus menus : selMenus)
//		{
//			System.out.println(menus);
//		}
		
//		RolesMapper b = ac.getBean("rolesMapper", RolesMapper.class);
//		List<Roles> selRoles = b.selRoles(0);
//		for (Roles roles : selRoles)
//		{
//			System.out.println(roles);
//		}
//		RolesMapper b = ac.getBean("rolesMapper", RolesMapper.class);
//		List<Roles> selAllRoles = b.selAllRoles();
//		for (Roles roles : selAllRoles)
//		{
//			System.out.println(roles);
//		}
		
//		String numStr = "" ;         
//        String trandStr = String.valueOf((Math.random() * 9 + 1) * 1000000);       
//        String dataStr = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());         
//        numStr = trandStr.toString().substring(0, 4);        
//        numStr = numStr + dataStr ;      
//        System.out.println(numStr);
		
	}
}
