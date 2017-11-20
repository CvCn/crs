package com.bjsxt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.Menus;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Roles;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.LogsService;
import com.bjsxt.service.RoleService;

@Controller
public class SystemController implements BaseController
{
	@Resource
	private RoleService roleServiceImpl;
	
	@Resource
	private LogsService logsServiceImpl;
	
	@RequestMapping("findRoleBy")
	public String findRoleBy(Roles r, String page, HttpServletRequest req){
		Pagination p = new Pagination(page, 每页显示数量, roleServiceImpl.roleCount(r), 分页导航数量);
		List<Roles> findRoleBy = roleServiceImpl.findRoleBy(r, p);
		if(findRoleBy.size()>0){
			p.setList(findRoleBy);
			req.setAttribute("p", p);
		}else{
			req.setAttribute("error", 查询为空);
		}
		req.setAttribute("role", r);
		return "systemManager/viewAllRole";
	}
	
	@RequestMapping("transRole")
	public String transRole(Integer roleid, HttpServletRequest req){
		Roles r = new Roles();
		r.setRoleid(roleid);
		List<Roles> findRoleBy = roleServiceImpl.findRoleBy(r, null);
		if(findRoleBy.size()>0){
			List<Menus> currMenu = findRoleBy.get(0).getMenus();
			req.setAttribute("role", findRoleBy.get(0));
			if(roleid == 0){
				req.setAttribute("disabled", "disabled");
			}
			Users user = (Users) req.getSession().getAttribute("user");
			List<Menus> allMenu = user.getRoles().getMenus();
			for (Menus m1 : allMenu)
			{
				for (Menus m2 : currMenu)
				{
					if(m1.getMenuid() == m2.getMenuid()){
						m1.setChecked("checked");
					}
					for (Menus Childrenmenu1 : m1.getChildrenmenus())
					{
						for (Menus Childrenmenu2 : m2.getChildrenmenus())
						{
							if(Childrenmenu1.getMenuid() == Childrenmenu2.getMenuid()){
								Childrenmenu1.setChecked("checked");
							}
						}
					}
				}
			}
		}else{
			return "error";
		}
		return "systemManager/updateRole";
	}
	
	@RequestMapping("updateRole")
	public String updateRole(Integer[] menuid, Roles r, HttpServletRequest req) throws IOException{
		if(r.getRoleid() != null && r.getRolename() != null){
			if(roleServiceImpl.updateRole(r, menuid)>0){
				req.setAttribute("error", "修改成功");
			}else{
				return "error";
			}
		}else{
			req.setAttribute("error", "请填写角色名");
		}
		return "ok";
	}
	
	@RequestMapping("deleteRole")
	public String deleteRole(Roles r, HttpServletRequest req){
		if(roleServiceImpl.deleteRole(r)>0){
			req.setAttribute("error", "删除成功");
			return "ok";
		}else{
			req.setAttribute("error", "删除失败");
		}
		return "ok";
	}
	
	@RequestMapping("addRole")
	public String addRole(Roles r, HttpServletRequest req){
		if(!verRolename(r.getRolename())){
			req.setAttribute("error", "已存在");
			return "systemManager/addRole";
		}
		if(roleServiceImpl.addRole(r)>0){
			req.setAttribute("error", "角色添加成功");
		}else{
			req.setAttribute("error", "角色添加失败");
		}
		
		return "ok";
	}
	
	@RequestMapping("verrolename")
	@ResponseBody
	public boolean verRolename(String rolename){
		List<String> allRolename = roleServiceImpl.allRolename();
		for (String string : allRolename)
		{
			if(string.equals(rolename)){
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping("findOperationLogs")
	public String findOperationLogs(OperationLogs o, String page, HttpServletRequest req){
		Pagination p = new Pagination(page, 每页显示数量, logsServiceImpl.OperationLogsCount(o), 分页导航数量);
		List<OperationLogs> findOperationLogs = logsServiceImpl.findOperationLogs(o, p);
		if(findOperationLogs.size()>0){
			p.setList(findOperationLogs);
			req.setAttribute("p", p);
		}else{
			req.setAttribute("error", 查询为空);
		}
		return "systemManager/viewLog";
	}
	@RequestMapping("findLoginLogs")
	public String findLoginLogs(LoginLogs login, String page, HttpServletRequest req){
		Pagination p = new Pagination(page, 每页显示数量, logsServiceImpl.LoginLogsCount(login), 分页导航数量);
		List<LoginLogs> findLoginLogs = logsServiceImpl.findLoginLogs(login, p);
		if(findLoginLogs.size()>0){
			p.setList(findLoginLogs);
			req.setAttribute("p", p);
		}else{
			req.setAttribute("error", 查询为空);
		}
		return "systemManager/showLoginLogInfo";
	}
	
	@RequestMapping("system/{page}/{name}")
	public String userManager(@PathVariable String page, @PathVariable String name){
		return page+ "/" +name;
	}
}
