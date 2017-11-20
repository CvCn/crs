package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.CarMapper;
import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.CarService;

@Service
public class CarServiceInpl implements CarService
{

	@Resource
	private CarMapper carMapper;
	
	@Override
	public int addCar(Cars c)
	{
		return carMapper.insCar(c);
	}

	@Override
	public List<String> allCarNumber()
	{
		return carMapper.selCarNumber();
	}

	@Override
	public List<Cars> findCar(Cars c, Pagination p)
	{
		return carMapper.selCarBy(c, p);
	}

	@Override
	public int carCount(Cars c)
	{
		return carMapper.carCount(c);
	}

	@Override
	public int updateCar(Cars c)
	{
		return carMapper.updateCar(c);
	}

	@Override
	public int deleteCar(String carnumber)
	{
		return carMapper.deleteCar(carnumber);
	}

}
