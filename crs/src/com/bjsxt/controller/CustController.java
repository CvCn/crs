package com.bjsxt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Customers;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.CustService;

@Controller
public class CustController implements BaseController
{
	@Resource
	private CustService custServiceImpl;
	
	@RequestMapping("addCust")
	public String addCust(Customers cust, HttpServletRequest req){
		if(cust.getAddress() == "" || cust.getCareer() == "" || cust.getCustname() == "" ||
				cust.getIdentity() == "" || cust.getIdentity() == "" || cust.getPhone() == "" || cust.getSex() == ""){
			req.setAttribute("error", 完整性提示);
			return "custManager/addCustomers";
		}
		if(!verIdentity(cust.getIdentity())){
			req.setAttribute("error", "已存在");
			return "custManager/addCustomers";
		}
		if(custServiceImpl.addCust(cust) >0){
			req.setAttribute("error", "添加成功");
			return "ok";
		}
		req.setAttribute("error", "添加失败");
		return "custManager/addCustomers";
	}
	
	@RequestMapping("veridentity")
	@ResponseBody
	public boolean verIdentity(String identity){
		List<String> allIdentity = custServiceImpl.allIdentity();
		for (String string : allIdentity)
		{
			if(string.equals(identity)){
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping("findCust")
	public String findCust(Customers cust, HttpServletRequest req, String page){
		Pagination p = new Pagination(page, 每页显示数量, custServiceImpl.custCount(cust), 分页导航数量);
		List<Customers> findCust = custServiceImpl.findCust(cust, p);
		
		if(findCust.size()>0){
			p.setList(findCust);
			req.setAttribute("p", p);
			req.setAttribute("cust", cust);
		}else{
			req.setAttribute("error", 查询为空);
		}
		return "custManager/viewCustomers";
	}
	
	@RequestMapping("transCust")
	public String transCust(String identity, HttpServletRequest req){
		Customers cust = new Customers();
		cust.setIdentity(identity);
		List<Customers> findCust = custServiceImpl.findCust(cust, null);
		if(findCust.size()>0){
			Customers c = findCust.get(0);
			req.setAttribute("cust", c);
		}
		return "custManager/updateCustomers";
	}
	
	@RequestMapping("updateCust")
	public String updateCust(Customers cust, String rawIdentity, HttpServletRequest req){
		if(cust.getAddress() == "" || cust.getCareer() == "" || cust.getCustname() == "" ||
				cust.getIdentity() == "" || cust.getIdentity() == "" || cust.getPhone() == "" || cust.getSex() == ""){
			req.setAttribute("error", 完整性提示);
			return "custManager/updateCustomers";
		}
		if(custServiceImpl.updateCust(cust, rawIdentity)>0){
			req.setAttribute("error", "修改成功");
			return "ok";
		}
		req.setAttribute("error", "修改失败");
		cust.setIdentity(rawIdentity);
		req.setAttribute("cust", cust);
		return "custManager/updateCustomers";
	}
	
	@RequestMapping("deleteCust")
	public String deleteCust(String identity, HttpServletRequest req){
		if(custServiceImpl.deleteCust(identity)>0){
			req.setAttribute("error", "删除成功");
			return "ok";
		}else{
			req.setAttribute("error", "删除失败");
		}
		return "custManager/findCustomers";
	}
	
	@RequestMapping("cust/{page}/{name}")
	public String userManager(@PathVariable String page, @PathVariable String name){
		return page+ "/" +name;
	}
}
