package com.java1234.service;

import java.util.List;
import com.java1234.entity.WebSite;

/**
 * 收录电影网站service接口
 * @author Administrator
 *
 */
public interface WebSiteService {

/**
 * 分页查询收录电影网站
 * @param page
 * @param pageSize
 * @return
 */
	public List<WebSite> list(WebSite webSite, Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount(WebSite webSite); 
	
	/**
	 * 添加或者修改收录电影网站
	 * @param link
	 */
	public void save(WebSite webSite); 
	
	/**
	 * 根据id删除收录电影网站
	 * @param id
	 */
	public void delete(Integer id);
}
