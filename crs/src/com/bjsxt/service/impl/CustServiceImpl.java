package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.CustMapper;
import com.bjsxt.pojo.Customers;
import com.bjsxt.pojo.Pagination;
import com.bjsxt.service.CustService;

@Service
public class CustServiceImpl implements CustService
{

	@Resource
	private CustMapper custMapper;
	
	@Override
	public int addCust(Customers c)
	{
		return custMapper.insCust(c);
	}

	@Override
	public List<String> allIdentity()
	{
		return custMapper.selIdentity();
	}

	@Override
	public List<Customers> findCust(Customers c, Pagination p)
	{
		return custMapper.selCustBy(c, p);
	}

	@Override
	public int custCount(Customers c)
	{
		return custMapper.custCount(c);
	}

	@Override
	public int updateCust(Customers c, String identity)
	{
		return custMapper.updateCust(c, identity);
	}

	@Override
	public int deleteCust(String identity)
	{
		return custMapper.deleteCust(identity);
	}

}
