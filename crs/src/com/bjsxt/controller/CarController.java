package com.bjsxt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.CarService;

@Controller
public class CarController implements BaseController
{

	@Resource
	private CarService carServiceImpl;
	
	@RequestMapping("addCar")
	public String addCar(Cars car, HttpServletRequest req, MultipartFile file) throws IOException{
		if(car.getCarnumber() == "" || car.getCartype() == "" || car.getColor() == "" ||
				car.getDeposit() < 0 || car.getDescription() == "" || car.getIsrenting() == "" ||
				car.getPrice() < 0 || car.getRentprice() < 0){
			req.setAttribute("error", 完整性提示);
			return "carManager/addCar";
		}
		
		
		if(!verCarnumber(car.getCarnumber())){
			req.setAttribute("error", "已存在");
			return "carManager/addCar";
		}
		String fileName = car.getCarnumber() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if (file.getOriginalFilename() != "")
		{
			File file2 = new File(req.getServletContext().getRealPath(
					"/WEB-INF/upload"), fileName);
			if (!file2.getParentFile().exists())
			{
				file2.getParentFile().mkdir();
			}
			file.transferTo(file2);
		}
		car.setImgpath(fileName);
		
		if(!verCarnumber(car.getCarnumber())){
			req.setAttribute("error", "已存在");
			return "carManager/addCar";
		}
		if(carServiceImpl.addCar(car) >0){
			req.setAttribute("error", "添加成功");
			return "ok";
		}
		req.setAttribute("error", "添加失败");
		return "carManager/addCar";
	}
	
	@RequestMapping("vercarnumber")
	@ResponseBody
	public boolean verCarnumber(String carnumber){
		List<String> allCarNumber = carServiceImpl.allCarNumber();
		for (String string : allCarNumber)
		{
			if(string.equals(carnumber)){
				return false;
			}
		}
		return true;
	}
	
	
	@RequestMapping("findCar")
	public String findCar(Cars car, HttpServletRequest req, String page){
		Pagination p = new Pagination(page, 每页显示数量, carServiceImpl.carCount(car), 分页导航数量);
		List<Cars> findCar = carServiceImpl.findCar(car, p);
		
		if(findCar.size()>0){
			p.setList(findCar);
			req.setAttribute("p", p);
			req.setAttribute("car", car);
		}else{
			req.setAttribute("error", 查询为空);
		}
		return "carManager/viewCars";
	}
	
	@RequestMapping("transCar")
	public String transCar(String carnumber, HttpServletRequest req){
		Cars car = new Cars();
		car.setCarnumber(carnumber);
		List<Cars> findCar = carServiceImpl.findCar(car, null);
		if(findCar.size()>0){
			Cars c = findCar.get(0);
			req.setAttribute("car", c);
		}
		return "carManager/updateCars";
	}
	
	@RequestMapping("updateCar")
	public String updateCar(Cars car, HttpServletRequest req, MultipartFile file) throws IOException{
		if(car.getCarnumber() == "" || car.getCartype() == "" || car.getColor() == "" ||
				car.getDeposit() < 0 || car.getDescription() == "" || car.getIsrenting() == "" ||
				car.getPrice() < 0 || car.getRentprice() < 0){
			req.setAttribute("error", 完整性提示);
			return "carManager/updateCar";
		}
		if (file.getOriginalFilename() != "")
		{
			String fileName = car.getCarnumber() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File file2 = new File(req.getServletContext().getRealPath(
					"/WEB-INF/upload"), fileName);
			if (!file2.getParentFile().exists())
			{
				file2.getParentFile().mkdir();
			}
			file.transferTo(file2);
			car.setImgpath(fileName);
		}
		
		if(carServiceImpl.updateCar(car)>0){
			req.setAttribute("error", "修改成功");
			return "ok";
		}else{
			req.setAttribute("error", "修改失败");
		}
		req.setAttribute("car", car);
		return "custManager/updateCustomers";
	}
	
	@RequestMapping("deleteCar")
	public String deleteCar(String carnumber, HttpServletRequest req){
		Cars c = new Cars();
		c.setCarnumber(carnumber);
		List<Cars> findCar = carServiceImpl.findCar(c, null);
		if(findCar.size()>0){
			String imgpath = findCar.get(0).getImgpath();
			File f = new File(req.getServletContext().getRealPath(
					"/WEB-INF/upload"), imgpath);
			if(f.exists()){
				f.delete();
			}
		}
		if(carServiceImpl.deleteCar(carnumber)>0){
			req.setAttribute("error", "删除成功");
			return "ok";
		}else{
			req.setAttribute("error", "删除失败");
		}
		return "custManager/findCustomers";
	}
	
	
	
	@RequestMapping("car/{page}/{name}")
	public String userManager(@PathVariable String page, @PathVariable String name){
		return page+ "/" +name;
	}
	@RequestMapping("upload/{imgpath}.{suff}")
	public void userManager(@PathVariable String imgpath, @PathVariable String suff, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		FileInputStream fis = null;
		try
		{
			File file = new File(req.getServletContext().getRealPath("WEB-INF/upload/"+imgpath+"."+suff));
			if (file.exists()){
				fis = new FileInputStream(file);
				IOUtils.copy(fis, resp.getOutputStream());
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} finally
		{
			if (fis != null)
				fis.close();
		}
	}
	
	
}
