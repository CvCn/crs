package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.FunsMapper;
import com.bjsxt.pojo.Funs;
import com.bjsxt.service.FunsService;

@Service
public class FunsServiceImpl implements FunsService
{

	@Resource
	private FunsMapper funsMapper;
	
	@Override
	public List<Funs> allFuns()
	{
		return funsMapper.selAllFuns();
	}

}
