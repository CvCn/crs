package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.RenttableMapper;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Renttable;
import com.bjsxt.service.RenttableService;

@Service
public class RenttableServiceImpl implements RenttableService
{

	@Resource
	private RenttableMapper renttableMapper;
	
	@Override
	public int addRenttable(Renttable r)
	{
		return renttableMapper.insRenttable(r);
	}

	@Override
	public List<Renttable> findRenttableBy(Renttable r, Pagination p)
	{
		return renttableMapper.selRenttable(r, p);
	}

	@Override
	public int renttableCount(Renttable r)
	{
		return renttableMapper.renttableCount(r);
	}

	@Override
	public int updateRenttable(Renttable r)
	{
		return renttableMapper.updateRenttable(r);
	}

	@Override
	public List<Long> allTableid()
	{
		return renttableMapper.selTableid();
	}

	@Override
	public List<Renttable> monthReturnCarNumber(Date d, Pagination p)
	{
		return renttableMapper.selRenttableBy(null, d, "month", p);
	}

	@Override
	public List<Renttable> dayReturnCarnumber(Date d, Pagination p)
	{
		return renttableMapper.selRenttableBy(null, d, "day", p);
	}
	

}
