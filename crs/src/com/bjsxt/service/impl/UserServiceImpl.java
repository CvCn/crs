package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.RolesMapper;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Resource
	UsersMapper usersMapper;
	@Resource
	RolesMapper rolesMapper;

	@Override
	public List<Users> login(String username, String userpwd)
	{
		return usersMapper.selUser(username, userpwd);
	}

	@Override
	public List<Roles> allRoles()
	{
		return rolesMapper.selRoleBy(null, null);
	}

	@Override
	public int addUser(Users user)
	{
		return usersMapper.insUser(user);
	}

	@Override
	public List<Users> findUsers(Users u, Pagination p)
	{
		return usersMapper.selUserBy(u, p);
	}

	@Override
	public int userCount(Users u)
	{
		return usersMapper.userCount(u);
	}

	@Override
	public int updateUser(Users u, String username)
	{
		return usersMapper.updateUser(u, username);
	}

	@Override
	public int deleteUser(String username)
	{
		return usersMapper.deleteUser(username);
	}

	@Override
	public List<String> allUsername()
	{
		return usersMapper.selUsername();
	}

	
	

}
