package com.bjsxt.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Renttable;
import com.bjsxt.service.RenttableService;

@Controller
public class OperatorStatisticsController implements BaseController
{
	@Resource
	private RenttableService renttableServiceImpl;
	
	@RequestMapping("monthReturnCar")
	public String monthReturnCar(HttpServletRequest req, String page){
		Pagination p = new Pagination(page, 每页显示数量, renttableServiceImpl.renttableCount(null), 分页导航数量);
		List<Renttable> monthReturnCarNumber = renttableServiceImpl.monthReturnCarNumber(new Date(), p);
		if(monthReturnCarNumber.size()>0){
			p.setList(monthReturnCarNumber);
			req.setAttribute("p", p);
		}else{
			req.setAttribute("error", "没有查询到结果");
		}
		
		return "operatorStatistics/viewMonthReturnCarResult";
	}
	
	@RequestMapping("transTableid")
	public String transTableid(Long tableid, HttpServletRequest req){
		Renttable renttable = new Renttable();
		renttable.setTableid(tableid);
		List<Renttable> findRenttableBy = renttableServiceImpl.findRenttableBy(renttable, null);
		if(findRenttableBy.size()>0){
			req.setAttribute("rent", findRenttableBy.get(0));
		}
		return "operatorStatistics/findMonthReturnCarByInfo";
	}
	
	@RequestMapping("welcome")
	public String dayReturnCar(HttpServletRequest req){
		Pagination p = new Pagination("1", "10", 5, 5);
		List<Renttable> dayReturnCarnumber = renttableServiceImpl.dayReturnCarnumber(new Date(), p);
		if(dayReturnCarnumber.size()>0){
			p.setList(dayReturnCarnumber);
			req.setAttribute("p", p);
		}
		return "welcome";
	}
}
