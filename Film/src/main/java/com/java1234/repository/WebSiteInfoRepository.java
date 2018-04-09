package com.java1234.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.java1234.entity.WebSiteInfo;
/**
 * 电影网站动态信息repository接口
 * @author Administrator
 *
 */

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo,Integer>,JpaSpecificationExecutor<WebSiteInfo>{
	/**
	 * 根据电影Id查询电影网站动态信息
	 * @param filmId
	 * @return
	 */
	@Query(value="select * from t_web_site_info where film_id=?1",nativeQuery=true)
	public List<WebSiteInfo>findByFilmId(Integer filmId);
	
	/**
	 * 根据电影网站Id查询电影网站动态信息
	 * @param filmId
	 * @return
	 */
	@Query(value="select * from t_web_site_info where web_site_id=?1",nativeQuery=true)
	public List<WebSiteInfo>findByWebSiteId(Integer webSiteId);
}
 