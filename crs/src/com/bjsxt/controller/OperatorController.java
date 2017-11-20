package com.bjsxt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Checktable;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Renttable;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.CarService;
import com.bjsxt.service.ChecktableService;
import com.bjsxt.service.RenttableService;

@Controller
public class OperatorController implements BaseController
{
	@Resource
	private CarService carServiceImpl;
	
	@Resource
	private RenttableService renttableServiceImpl;
	
	@Resource
	private ChecktableService checktableServiceImpl;
	
	@RequestMapping("showCar")
	public String showCar(String identity, HttpServletRequest req){
		Cars car = new Cars();
		car.setIsrenting("0");
		List<Cars> findCar = carServiceImpl.findCar(car, null);
		req.setAttribute("identity", identity);
		req.setAttribute("car", findCar);
		return "operatorManager/showCar";
	}
	
	@RequestMapping("preCreateRentCarTable")
	public String preCreateRentCarTable(String carnumber, String identity, HttpServletRequest req){
		Cars car = new Cars();
		car.setCarnumber(carnumber);
		List<Cars> findCar = carServiceImpl.findCar(car, null);
		if(findCar.size()>0){
			Cars c = findCar.get(0);
			req.setAttribute("car", c);
			req.setAttribute("identity", identity);
			
			String numStr = "" ;         
	        String trandStr = String.valueOf((Math.random() * 9 + 1) * 1000000);       
	        String dataStr = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());         
	        numStr = trandStr.toString().substring(0, 4);        
	        numStr = numStr + dataStr ;      
	        req.setAttribute("tableId", numStr);
		}else{
			req.setAttribute("error", "未找到相关车辆");
		}
		return "operatorManager/preCreateRenting";
	}
	
	@RequestMapping("createRentCarTable")
	public String createRentCarTable(Renttable r, HttpServletRequest req){
		if(renttableServiceImpl.addRenttable(r)>0){
			Cars c = new Cars();
			c.setIsrenting("1");
			c.setCarnumber(r.getCarid());
			if(carServiceImpl.updateCar(c)>0){
				req.setAttribute("error", "出租单生成成功");
				return "ok";
			}
		}
		req.setAttribute("error", "生成失败");
		return "operatorManager/preCreateRenting";
	}
	
	@RequestMapping("findRenttableBy")
	public String findRenttableBy(Renttable r, String page, HttpServletRequest req){
		Pagination p = new Pagination(page, 每页显示数量, renttableServiceImpl.renttableCount(r), 分页导航数量);
		List<Renttable> findRenttableBy = renttableServiceImpl.findRenttableBy(r, p);		
		if(findRenttableBy.size()>0){
			p.setList(findRenttableBy);
			req.setAttribute("p", p);
			req.setAttribute("renttable", r);
		}else{
			req.setAttribute("error", 查询为空);
		}
		req.setAttribute("rent", r);
		return "operatorManager/viewRenttables";
	}
	
	@RequestMapping("transRenttable")
	public String transRenttable(Long tableid, HttpServletRequest req){
		Renttable renttable = new Renttable();
		renttable.setTableid(tableid);
		List<Renttable> findRenttableBy = renttableServiceImpl.findRenttableBy(renttable, null);
		if(findRenttableBy.size()>0){
			req.setAttribute("rent", findRenttableBy.get(0));
		}
		return "operatorManager/updateRenttable";
	}
	
	@RequestMapping("updateRenttable")
	public String updateRenttable(Renttable renttable, HttpServletRequest req){
		if(renttable.getPrice() == null || renttable.getBegindate() == null || renttable.getShouldreturndate() == null || renttable.getRentflag() == ""){
			req.setAttribute("error", 完整性提示);
			return "ok";
		}
		if(renttableServiceImpl.updateRenttable(renttable)>0){
			req.setAttribute("error", "修改成功");
		}else{
			req.setAttribute("error", "修改失败");
		}
		return "ok";
	}
	
	
	@RequestMapping("vertableid")
	@ResponseBody
	public boolean verTableid(Long tableid){
		List<Long> allTableid = renttableServiceImpl.allTableid();
		for (Long id : allTableid)
		{
			if(id.equals(tableid)){
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping("findRenttable")
	public String findRenttable(Long tableid, HttpServletRequest req){
		Renttable r = new Renttable();
		r.setTableid(tableid);
		List<Renttable> findRenttableBy = renttableServiceImpl.findRenttableBy(r , null);
		if(findRenttableBy.size()>0){
			Checktable check = new Checktable();
			check.setRenttable(findRenttableBy.get(0));
			Users u = (Users) req.getSession().getAttribute("user");
			check.setCheckuser(u.getUsername());
			check.setCheckdate(new Date());
			
			
			String numStr = "" ;         
	        String trandStr = String.valueOf((Math.random() * 9 + 1) * 1000000);       
	        String dataStr = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());         
	        numStr = trandStr.toString().substring(0, 4);        
	        numStr = numStr + dataStr ; 
			
			check.setCheckid(Long.valueOf(numStr));
			
			req.setAttribute("check", check);
			return "operatorManager/createCheckTable";
		}
		req.setAttribute("error", "未搜索到结果");
		return "operatorManager/returnCar";
	}
	
	@RequestMapping("createCheckTable")
	public String createCheckTable(Checktable check, HttpServletRequest req){
		Renttable r = new Renttable();
		r.setRentflag("1");
		r.setReturndate(new Date());
		r.setTableid(check.getRentid());
		int updateRenttable = renttableServiceImpl.updateRenttable(r);
		if(updateRenttable>0){
			int creatCheckTable = checktableServiceImpl.addCheckTable(check);
			if(creatCheckTable>0){
				List<Renttable> findRenttableBy = renttableServiceImpl.findRenttableBy(r, null);
				if(findRenttableBy.size()>0){
					Renttable renttable = findRenttableBy.get(0);
					Cars c = new Cars();
					c.setCarnumber(renttable.getCarid());
					c.setIsrenting("0");
					if(carServiceImpl.updateCar(c)>0){
						req.setAttribute("error", "汽车入库成功");
					}
				}
			}else{
				req.setAttribute("error", "失败");
			}
		}else{
			req.setAttribute("error", "失败");
		}
		return "ok";
	}
	
	@RequestMapping("findChecktableBy")
	public String findChecktableBy(Checktable c, String page, HttpServletRequest req){
		Pagination p = new Pagination(page, "10", checktableServiceImpl.checktableCount(c), 分页导航数量);
		List<Checktable> findChecktableBy = checktableServiceImpl.findChecktableBy(c, p);
		if(findChecktableBy.size()>0){
			p.setList(findChecktableBy);
			req.setAttribute("p", p);
			req.setAttribute("renttable", c);
		}else{
			req.setAttribute("error", 查询为空);
		}
		req.setAttribute("checkTable", c);
		return "operatorManager/viewCheckTables";
	}
	
	@RequestMapping("transCheckid")
	public String transCheckid(Long checkid, HttpServletRequest req){
		Checktable checktable = new Checktable();
		checktable.setCheckid(checkid);
		List<Checktable> findChecktableBy = checktableServiceImpl.findChecktableBy(checktable, null);
		if(findChecktableBy.size()>0){
			req.setAttribute("check", findChecktableBy.get(0));
		}
		return "operatorManager/updateCheckTable";
	}
	
	@RequestMapping("updateChecktable")
	public String updateChecktable(Checktable check, HttpServletRequest req){
		if(check.getProblem() == "" && check.getField() == "" && check.getPaying() == null){
			req.setAttribute("error", "已将问题、属性、配费三项属性置为空");
		}else{
			if(checktableServiceImpl.updateChecktable(check)>0){
				req.setAttribute("error", "修改成功");
			}else{
				req.setAttribute("error", "修改失败");
			}
		}
		return "ok";
	}
	
	
	@RequestMapping("operator/{page}/{name}")
	public String userManager(@PathVariable String page, @PathVariable String name){
		return page+ "/" +name;
	}
}
