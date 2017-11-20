package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.ChecktableMapper;
import com.bjsxt.pojo.Checktable;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.ChecktableService;

@Service
public class ChecktableServiceImpl implements ChecktableService
{

	@Resource
	private ChecktableMapper checktableMapper;
	
	@Override
	public int addCheckTable(Checktable check)
	{
		return checktableMapper.insChecktable(check);
	}

	@Override
	public List<Checktable> findChecktableBy(Checktable c, Pagination p)
	{
		return checktableMapper.selChecktable(c, p);
	}

	@Override
	public int checktableCount(Checktable c)
	{
		return checktableMapper.checktableCount(c);
	}

	@Override
	public int updateChecktable(Checktable c)
	{
		return checktableMapper.updateChecktable(c);
	}

}
