package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.mapper.CarMapper;
import com.bjsxt.pojo.Cars;
import com.bjsxt.pojo.Pagination;

public class CarTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarMapper b = ac.getBean("carMapper", CarMapper.class);
		
//		int updateCar = b.updateCar(new Cars("京BF8888", "123", "123", 3.0, 3.0, 3.0, "1", "13", null));
//		System.out.println(updateCar);
		
		Cars selCarByNumber = b.selCarByNumber("京BA2222");
		System.out.println(selCarByNumber);
//		int addCar = b.addCar(new Cars("123", "123", "123", 12.9, 11.3, 33.1, "123", "123", "123"));
//		System.out.println(addCar);
//		List<String> selCarNumber = b.selCarNumber();
//		for (String string : selCarNumber)
//		{
//			System.out.println(string);
//		}
		
//		Cars car = new Cars();
//		System.out.println(b.carCount(car));
		
//		Cars car = new Cars();
//		car.setCarnumber("8888");
//		List<Cars> selCarBy = b.selCarBy(car, new Pagination("1", "10", b.carCount(car), 5));
//		for (Cars cars : selCarBy)
//		{
//			System.out.println(cars);
//		}

	}
}
