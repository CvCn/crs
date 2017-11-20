package com.bjsxt.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.mapper.FunsMapper;
import com.bjsxt.mapper.MenusMapper;
import com.bjsxt.pojo.Funs;
import com.bjsxt.pojo.Menus;
import com.bjsxt.pojo.Users;

public class OperationInterceptor implements HandlerInterceptor
{
	@Resource
	private MenusMapper menusMapper;
	
	@Resource
	private FunsMapper funsMapper;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		Users u = (Users) request.getSession().getAttribute("user");
		String requestURI = request.getRequestURI();
		if(u != null){
			List<Menus> selDiffMenu = menusMapper.selDiffMenu(0, u.getRoleid());
			for (Menus menus : selDiffMenu)
			{
				if((request.getContextPath() + "/" +menus.getUri()).equals(requestURI)){
					response.sendRedirect(request.getContextPath() + "/error");
					return false;
				}
			}
			List<Funs> selDiffFuns = funsMapper.selDiffFuns(0, u.getRoleid());
			for (Funs funs : selDiffFuns)
			{
				if((request.getContextPath() + "/" +funs.getUri()).equals(requestURI)){
					response.sendRedirect(request.getContextPath() + "/error");
					return false;
				}
			}
		}
//		if (u != null)
//		{
//
//			List<Menus> menus3 = u.getRoles().getMenus();
//			List<Menus> menus = new ArrayList<>();
//			for (Menus m2 : menus3)
//			{
//				List<Menus> childrenmenus = m2.getChildrenmenus();
//				for (Menus m3 : childrenmenus)
//				{
//					menus.add(m3);
//				}
//			}
//
//			List<Menus> menus2 = menusMapper.selMenusTwo();
//			for (int i = 0; i < menus.size(); i++)
//			{
//				if (menus2.get(i).getMenuid() == menus.get(i).getMenuid())
//				{
//					menus2.set(i, null);
//				}
//			}
//			for (Menus m : menus2)
//			{
//				if (m != null)
//				{
//					if ((request.getContextPath() + "/" +m.getUri()).equals(requestURI))
//					{
//						response.sendRedirect(request.getContextPath()
//								+ "/error");
//						return false;
//					}	
//				}
//			}
//		}
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
	}
}