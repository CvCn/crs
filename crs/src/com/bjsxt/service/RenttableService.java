package com.bjsxt.service;

import java.util.Date;
import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Renttable;

public interface RenttableService
{
	int addRenttable(Renttable r);
	
	List<Renttable> findRenttableBy(Renttable r, Pagination p);
	
	int renttableCount(Renttable r);
	
	int updateRenttable(Renttable r);
	
	List<Long> allTableid();
	
	List<Renttable> monthReturnCarNumber(Date d, Pagination p);
	
	List<Renttable> dayReturnCarnumber(Date d, Pagination p);
}
