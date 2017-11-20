package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;

public interface RolesMapper
{
	List<Roles> selRoleBy(@Param("r")Roles r, @Param("p") Pagination p);
	
	int roleCount(@Param("r")Roles r);
	
	@Insert("insert into roles values(default, #{rolename})")
	int insRole(Roles r);
	
	@Update("update roles set rolename=#{rolename} where roleid=#{roleid}")
	int updateRole(Roles r);
	
	@Delete("delete from roles_menus where roleid=#{0}")
	int deleteRoleMenu(int roleid);
	
	@Insert("insert into roles_menus values(default, #{0}, #{1})")
	int insRoleMenu(int roleid, int menuid);
	
	@Delete("delete from roles where roleid=#{roleid}")
	int deleteRole(Roles r);
	
	@Select("select rolename from roles")
	List<String> selRolename();
}
