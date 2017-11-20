package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Checktable;
import com.bjsxt.pojo.Pagination;

public interface ChecktableService
{
	int addCheckTable(Checktable check);
	
	List<Checktable> findChecktableBy(Checktable c, Pagination p);
	
	int checktableCount(Checktable c);
	
	int updateChecktable(Checktable c);
}
