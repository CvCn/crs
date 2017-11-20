package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;

public interface RoleService
{
	List<Roles> findRoleBy(Roles r, Pagination p);
	
	int roleCount(Roles r);
	
	int addRole(Roles r);
	
	int updateRole(Roles r, Integer[] menuid);
	
	int deleteRole(Roles r);
	
	List<String> allRolename();

}
