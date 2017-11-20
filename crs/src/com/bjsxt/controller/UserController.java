package com.bjsxt.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.LoginLogs;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.LogsService;
import com.bjsxt.service.UserService;

@Controller
public class UserController implements BaseController
{
	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private LogsService logsServiceImpl;
	
	@RequestMapping("login")
	public String login(String username, String userpwd, String random,HttpServletRequest req,  HttpSession session){
		if(!session.getAttribute("RandStr").equals(random)){
			session.setAttribute("er", "验证码错误");
			session.setAttribute("un", username);
			return "redirect:login.jsp";
		}
		List<Users> login = userServiceImpl.login(username, userpwd);
		if(login.size()>0){
			session.setAttribute("user", login.get(0));
			session.setAttribute("roles", userServiceImpl.allRoles());
			logsServiceImpl.addLoginLogs(new LoginLogs(-1, username, getIp(req), new Date()));
			return "redirect:index";
		}
		session.setAttribute("un", username);
		session.setAttribute("er", "登陆名或者密码错误");
		return "redirect:login.jsp";
	}
	
	@RequestMapping("exit")
	public String exit(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:login.jsp";
	}
	
	@RequestMapping("addUser")
	public String addUserAction(Users user, HttpServletRequest req){
		System.out.println(user);
		if(user.getUsername() == "" || user.getIdentity() == "" || user.getAddress() == "" ||
				user.getPhone() == "" || user.getUserpwd() == "" || user.getPosition() == ""){
			req.setAttribute("error", 完整性提示);
			return "userManager/addUser";
		}
		if(!verUsername(user.getUsername())){
			req.setAttribute("error", "已存在");
			return "userManager/addUser";
		}
		if(userServiceImpl.addUser(user) >0){
			req.setAttribute("error", "添加成功");
			return "ok";
		}
		req.setAttribute("error", "添加失败");
		return "userManager/addUser";
	}
	
	@RequestMapping("findUser")
	public String findUser(Users user, HttpServletRequest req, String page){
		Pagination p = new Pagination(page, 每页显示数量, userServiceImpl.userCount(user), 分页导航数量);
		List<Users> findUsers = userServiceImpl.findUsers(user, p);
		
		if(findUsers.size()>0){
			p.setList(findUsers);
			req.setAttribute("p", p);
			req.setAttribute("user", user);
		}else{
			req.setAttribute("error", 查询为空);
		}
		return "userManager/viewUser";
	}
	
	@RequestMapping("transUser")
	public String transUser(String username, HttpServletRequest req){
		Users users = new Users();
		users.setUsername(username);
		List<Users> login = userServiceImpl.findUsers(users, null);
		if(login.size()>0){
			Users u = login.get(0);
			req.getSession().setAttribute("roles", userServiceImpl.allRoles());
			req.setAttribute("user", u);
		}
		return "userManager/updateUser";
	}
	
	@RequestMapping("updateUser")
	public String updateUser(Users user, String rawusername, HttpServletRequest req){
		if(user.getUsername() == "" || user.getIdentity() == "" || user.getAddress() == "" ||
				user.getPhone() == "" || user.getPosition() == ""){
			req.setAttribute("error", 完整性提示);
			return "userManager/updateUser";
		}
		Users u = (Users) req.getSession().getAttribute("user");
		if(u.getRoleid() != 0){
			return "error";
		}
		if(userServiceImpl.updateUser(user, rawusername)>0){
			req.setAttribute("error", "修改成功");
			return "ok";
		}else{
			req.setAttribute("error", "修改失败");
		}
		user.setUsername(rawusername);
		req.setAttribute("user", user);
		return "userManager/updateUser";
	}
	
	@RequestMapping("changePwd")
	public String changePwd(String rawusername, String oldpwd, String newuserpwd, String oknewpwd, HttpServletRequest req){
		Users users = new Users();
		users.setUsername(rawusername);
		List<Users> findUsers = userServiceImpl.findUsers(users, null);
		if(findUsers.size()>0){
			Users users2 = findUsers.get(0);
			if(!users2.getUserpwd().equals(oldpwd)){
				req.setAttribute("error", "旧密码有误请重新输入");
			}else{
				users.setUserpwd(newuserpwd);
				int updateUser = userServiceImpl.updateUser(users, users.getUsername());
				if(updateUser>0){
					req.setAttribute("error", "密码修改成功");
					return "ok";
				}else{
					req.setAttribute("error", "密码修改失败");
				}
			}
		}
		return "userManager/changeUserPwd";
	}
	
	@RequestMapping("deleteUser")
	public String deleteUser(String username, HttpServletRequest req){
		if(userServiceImpl.deleteUser(username)>0){
			req.setAttribute("error", "删除成功");
			return "ok";
		}else{
			req.setAttribute("error", "删除失败");
		}
		return "userManager/findUser";
	}
	
	@RequestMapping("verusername")
	@ResponseBody
	public boolean verUsername(String username){
		List<String> allUsername = userServiceImpl.allUsername();
		for (String string : allUsername)
		{
			if(string.equals(username)){
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping("{page}")
	public String page(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("user/{page}/{name}")
	public String userManager(@PathVariable String page, @PathVariable String name){
		return page+ "/" +name;
	}
	
	
	
	private String getIp(HttpServletRequest req){
		String ip = req.getHeader("x-forwarded-for"); 
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getHeader("X-Real-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = req.getRemoteAddr();  
        } 
        return ip;  
	}
	
}
