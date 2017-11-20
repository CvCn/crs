package com.bjsxt.interceptor;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.mapper.FunsMapper;
import com.bjsxt.mapper.OperationLogsMapper;
import com.bjsxt.pojo.Funs;
import com.bjsxt.pojo.OperationLogs;
import com.bjsxt.pojo.Users;

public class LogsInterceptor implements HandlerInterceptor
{

	@Resource
	private FunsMapper funsMapper;
	
	@Resource
	private OperationLogsMapper operationLogsMapper;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		if(handler instanceof HandlerMethod){
			HandlerMethod h = (HandlerMethod) handler;
			List<Funs> allFuns = funsMapper.selAllFuns();
			if (allFuns != null)
			{
				for (Funs funs : allFuns)
				{
					if(!funs.getName().equals("查询操作日志") && !funs.getName().equals("查询登陆日志")){
						if (funs.getUri().equals(h.getMethod().getName()))
						{
							Users u = (Users) request.getSession().getAttribute("user");
							if (u != null)
							{
								operationLogsMapper.insOperationLogs(new OperationLogs(-1,
										u.getUsername(), funs.getName(), new Date()));
							}
						}
					}
				}
			}
		}
	}
}