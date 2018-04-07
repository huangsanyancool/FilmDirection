package com.java1234.service;

import java.util.List;

import com.java1234.entity.Film;
import com.java1234.entity.Film;

/**
 * 电影service接口
 * @author Administrator
 *
 */
public interface FilmService {
	
	/**
	 * 新增和修改电影信息
	 * @param film
	 */
	public void save(Film film);


	/**
	 * 分页查询 电影信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Film> list(Film film, Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount(Film film); 
	
	/**
	 * 根据id查找实体
	 * @param id
	 */
	public Film findById(Integer id);
	
	/**
	 * 根据id删除 电影信息
	 * @param id
	 */
	public void delete(Integer id);
}
