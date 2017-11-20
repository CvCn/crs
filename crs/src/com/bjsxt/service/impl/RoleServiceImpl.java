package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.RolesMapper;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;
import com.bjsxt.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{
	@Resource
	private RolesMapper rolesMapper;

	@Override
	public List<Roles> findRoleBy(Roles r, Pagination p)
	{
		return rolesMapper.selRoleBy(r, p);
	}

	@Override
	public int roleCount(Roles r)
	{
		return rolesMapper.roleCount(r);
	}

	@Override
	public int addRole(Roles r)
	{
		return rolesMapper.insRole(r);
	}

	@Override
	public int updateRole(Roles r, Integer[] menuid)
	{
		rolesMapper.deleteRoleMenu(r.getRoleid());
		if (menuid.length > 0)
		{
			for (Integer id : menuid)
			{
				if (id != null)
				{
					rolesMapper.insRoleMenu(r.getRoleid(), id);
				}
			}
		}

		return rolesMapper.updateRole(r);
	}

	@Override
	public int deleteRole(Roles r)
	{
		rolesMapper.deleteRoleMenu(r.getRoleid());
		return rolesMapper.deleteRole(r);
	}

	@Override
	public List<String> allRolename()
	{
		return rolesMapper.selRolename();
	}
	
}
