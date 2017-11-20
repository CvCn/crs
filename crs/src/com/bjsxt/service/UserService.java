package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;
import com.bjsxt.pojo.Users;

public interface UserService
{
	List<Users> login(String username, String userpwd);
	
	List<Roles> allRoles();
	
	int addUser(Users user);
	
	List<Users> findUsers(Users u, Pagination p);
	
	int userCount(Users u);
	
	int updateUser(Users u, String username);
	
	int deleteUser(String username);
	
	List<String> allUsername();
}
