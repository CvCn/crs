package com.bjsxt.pojo;

import java.util.List;

/**
 * 页数类
 * @param start 每次查询的起始位置
 * @param size 每页显示多少条数据
 * @param page 当前页
 * @param totalCount 总记录数
 * @param totalPage 总页数
 * @param hasPrev 是否有上一页
 * @param prevPage 上一页
 * @param hasNext 是否有下一页
 * @param nextPage 下一页
 * @param firstPage 首页
 * @param lastPage 尾页
 * @param navCount 导航页数量
 * @param navBegin 导航页开始位置
 * @param navEnd 导航页结束位置
 * @param list 每页的数据
 * @author xiaowei
 */
public class Pagination {

	// 每次查询的起始位置
	private int start;
	// 每页显示多少条数据
	private int size;
	// 当前页数
	private int page;
	// 总记录数
	private int totalCount;
	// 总页数
	private int totalPage;
	// 是否有上一页
	private boolean hasPrev;
	// 上一页
	private int prevPage;
	// 是否有下一页
	private boolean hasNext;
	// 下一页
	private int nextPage;
	// 首页
	private int firstPage;
	// 尾页
	private int lastPage;
	// 导航页数量
	private int navCount;
	// 导航页开始位置
	private int navBegin;
	// 导航页结束位置
	private int navEnd;
	//每页的数据
	private List<?> list;
	
	private int listSize;

	/**
	 * 
	 * @param page 当前页
	 * @param size 每页数据量
	 * @param totalCount 总记录数
	 * @param navCount 导航数量
	 * @author xiaowei
	 */
	public Pagination(String page, String size, int totalCount, int navCount) {
		// 当前页数
		this.page = null != page ? Integer.parseInt(page) : 1;
		// 每页显示多少条数据
		this.size = null != size ? Integer.parseInt(size) : 10;
		// 总记录数
		this.totalCount = totalCount;
		// 总页数
		this.totalPage = (int) Math.ceil(this.totalCount * 1.0 / this.size);
		// 每次查询的起始位置
		this.start = (this.page - 1) * this.size;
		if (this.page > 1) {
			// 是否有上一页
			this.hasPrev = true;
			// 上一页
			this.prevPage = this.page - 1;
		}else{
			// 是否有上一页
			this.hasPrev = false;
			// 上一页
			this.prevPage = 1;
		}
		if (this.page < this.totalPage) {
			// 是否有下一页
			this.hasNext = true;
			// 下一页
			this.nextPage = this.page + 1;
		}else{
			// 是否有下一页
			this.hasNext = false;
			// 下一页
			this.nextPage = this.totalPage;
		}
		// 首页
		this.firstPage = 1;
		// 尾页
		this.lastPage = this.totalPage;
		// 导航页数量
		this.navCount = navCount;
		// 导航页开始位置
		//if(this.page > this.totalPage - this.navCount){
		//	this.navBegin = this.totalPage - this.navCount + 1;
		//}else{
			this.navBegin = this.page - this.navCount / 2 < 1 ? 1 : this.page - this.navCount / 2;
		//}
		// 导航页结束位置
		this.navEnd = this.navBegin + this.navCount - 1 > this.totalPage ? this.totalPage : this.navBegin + this.navCount - 1;
		
	}

	

	/**
	 * @return the page
	 * @author xiaowei
	 */
	public int getPage()
	{
		return page;
	}



	/**
	 * @param page the page to set
	 * @author xiaowei
	 */
	public void setPage(int page)
	{
		this.page = page;
	}



	/**
	 * @return the size
	 * @author xiaowei
	 */
	public int getSize()
	{
		return size;
	}



	/**
	 * @param size the size to set
	 * @author xiaowei
	 */
	public void setSize(int size)
	{
		this.size = size;
	}



	/**
	 * @return the totalCount
	 * @author xiaowei
	 */
	public int getTotalCount()
	{
		return totalCount;
	}



	/**
	 * @param totalCount the totalCount to set
	 * @author xiaowei
	 */
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}



	/**
	 * @return the totalPage
	 * @author xiaowei
	 */
	public int getTotalPage()
	{
		return totalPage;
	}



	/**
	 * @param totalPage the totalPage to set
	 * @author xiaowei
	 */
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}



	/**
	 * @return the start
	 * @author xiaowei
	 */
	public int getStart()
	{
		return start;
	}



	/**
	 * @param start the start to set
	 * @author xiaowei
	 */
	public void setStart(int start)
	{
		this.start = start;
	}



	/**
	 * @return the hasPrev
	 * @author xiaowei
	 */
	public boolean isHasPrev()
	{
		return hasPrev;
	}



	/**
	 * @param hasPrev the hasPrev to set
	 * @author xiaowei
	 */
	public void setHasPrev(boolean hasPrev)
	{
		this.hasPrev = hasPrev;
	}



	/**
	 * @return the prevPage
	 * @author xiaowei
	 */
	public int getPrevPage()
	{
		return prevPage;
	}



	/**
	 * @param prevPage the prevPage to set
	 * @author xiaowei
	 */
	public void setPrevPage(int prevPage)
	{
		this.prevPage = prevPage;
	}



	/**
	 * @return the hasNext
	 * @author xiaowei
	 */
	public boolean isHasNext()
	{
		return hasNext;
	}



	/**
	 * @param hasNext the hasNext to set
	 * @author xiaowei
	 */
	public void setHasNext(boolean hasNext)
	{
		this.hasNext = hasNext;
	}



	/**
	 * @return the nextPage
	 * @author xiaowei
	 */
	public int getNextPage()
	{
		return nextPage;
	}



	/**
	 * @param nextPage the nextPage to set
	 * @author xiaowei
	 */
	public void setNextPage(int nextPage)
	{
		this.nextPage = nextPage;
	}



	/**
	 * @return the firstPage
	 * @author xiaowei
	 */
	public int getFirstPage()
	{
		return firstPage;
	}



	/**
	 * @param firstPage the firstPage to set
	 * @author xiaowei
	 */
	public void setFirstPage(int firstPage)
	{
		this.firstPage = firstPage;
	}



	/**
	 * @return the lastPage
	 * @author xiaowei
	 */
	public int getLastPage()
	{
		return lastPage;
	}



	/**
	 * @param lastPage the lastPage to set
	 * @author xiaowei
	 */
	public void setLastPage(int lastPage)
	{
		this.lastPage = lastPage;
	}



	/**
	 * @return the navCount
	 * @author xiaowei
	 */
	public int getNavCount()
	{
		return navCount;
	}



	/**
	 * @param navCount the navCount to set
	 * @author xiaowei
	 */
	public void setNavCount(int navCount)
	{
		this.navCount = navCount;
	}



	/**
	 * @return the navBegin
	 * @author xiaowei
	 */
	public int getNavBegin()
	{
		return navBegin;
	}



	/**
	 * @param navBegin the navBegin to set
	 * @author xiaowei
	 */
	public void setNavBegin(int navBegin)
	{
		this.navBegin = navBegin;
	}



	/**
	 * @return the navEnd
	 * @author xiaowei
	 */
	public int getNavEnd()
	{
		return navEnd;
	}



	/**
	 * @param navEnd the navEnd to set
	 * @author xiaowei
	 */
	public void setNavEnd(int navEnd)
	{
		this.navEnd = navEnd;
	}

	
	/**
	 * @return the list
	 * @author xiaowei
	 */
	public List<?> getList()
	{
		return list;
	}



	/**
	 * @param list the list to set
	 * @author xiaowei
	 */
	public void setList(List<?> list)
	{
		this.list = list;
		this.listSize = list.size();
	}



	/**
	 * @return the listSize
	 * @author xiaowei
	 */
	public int getListSize()
	{
		return listSize;
	}



	/**
	 * @param listSize the listSize to set
	 * @author xiaowei
	 */
	public void setListSize(int listSize)
	{
		this.listSize = listSize;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Pagination [start=" + start + ", size=" + size + ", page="
				+ page + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", hasPrev=" + hasPrev + ", prevPage=" + prevPage
				+ ", hasNext=" + hasNext + ", nextPage=" + nextPage
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage
				+ ", navCount=" + navCount + ", navBegin=" + navBegin
				+ ", navEnd=" + navEnd + ", list=" + list + ", listSize="
				+ listSize + "]";
	}

	
}
