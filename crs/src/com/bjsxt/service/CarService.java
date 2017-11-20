package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Pagination;

public interface CarService
{
	int addCar(Cars c);
	
	List<String> allCarNumber();
	
	List<Cars> findCar(Cars c, Pagination p);
	
	int carCount(Cars c);
	
	int updateCar(Cars c);
	
	int deleteCar(String carnumber);
}
