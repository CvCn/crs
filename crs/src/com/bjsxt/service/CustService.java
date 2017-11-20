package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Customers;
import com.bjsxt.pojo.Pagination;

public interface CustService
{
	int addCust(Customers c);
	
	List<String> allIdentity();
	
	List<Customers> findCust(Customers c, Pagination p);
	
	int custCount(Customers c);
	
	int updateCust(Customers c, String identity);
	
	int deleteCust(String identity);
}
