package com.java1234.service;

import java.util.List;

import com.java1234.entity.WebSiteInfo;

/**
 * 电影网站动态信息service接口
 * @author Administrator
 *
 */
public interface WebSiteInfoService {

/**
 * 分页查询电影网站动态信息
 * @param page
 * @param pageSize
 * @return
 */
	public List<WebSiteInfo> list(WebSiteInfo webSiteInfo, Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount(WebSiteInfo webSiteInfo); 
	
	/**
	 * 根据电影Id查询电影网站动态信息
	 * @param filmId
	 * @return
	 */
	public List<WebSiteInfo>findByFilmId(Integer filmId);
	
	/**
	 * 根据电影网站Id查询电影网站动态信息
	 * @param filmId
	 * @return
	 */
	public List<WebSiteInfo>findByWebSiteId(Integer webSiteId);
	
	/**
	 * 添加或者修改电影网站动态信息
	 * @param link
	 */
	public void save(WebSiteInfo webSiteInfo); 
	
	/**
	 * 根据id删除电影网站动态信息
	 * @param id
	 */
	public void delete(Integer id);
}
