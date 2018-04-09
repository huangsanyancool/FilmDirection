package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import com.java1234.entity.WebSiteInfo;
import com.java1234.repository.WebSiteInfoRepository;
import com.java1234.service.WebSiteInfoService;
import com.java1234.util.StringUtil;

/**
 * 网站service实现类
 * @author Administrator
 *
 */
@Service("webSiteInfoService")
public class WebSiteInfoServiceImpl implements WebSiteInfoService{
	@Resource
	private WebSiteInfoRepository webSiteInfoRepository;

	@Override
	public List<WebSiteInfo> list(WebSiteInfo webSiteInfo, Integer page, Integer pageSize) {
		Pageable pageable=new PageRequest(page, pageSize, Sort.Direction.DESC,"publishDate");
		Page<WebSiteInfo> pageWebSiteInfo = webSiteInfoRepository.findAll(new Specification<WebSiteInfo>() {
		
			@Override
			public Predicate toPredicate(Root<WebSiteInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(webSiteInfo!=null){
					if(StringUtil.isNotEmpty(webSiteInfo.getInfo())){
						predicate.getExpressions().add(cb.like(root.get("info"), "%"+webSiteInfo.getInfo().trim()+"%"));
					}
					
				}
				return predicate;
			}
		}, pageable);
		return pageWebSiteInfo.getContent();
	}

	@Override
	public Long getCount(WebSiteInfo webSiteInfo) {
		Long count=webSiteInfoRepository.count(new Specification<WebSiteInfo>() {

			@Override
			public Predicate toPredicate(Root<WebSiteInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(webSiteInfo!=null){
					if(StringUtil.isNotEmpty(webSiteInfo.getInfo())){
						predicate.getExpressions().add(cb.like(root.get("info"), "%"+webSiteInfo.getInfo().trim()+"%"));
					}
				}
				return predicate;
			}
		});
		return count;
	}

	
	@Override
	public List<WebSiteInfo> findByFilmId(Integer filmId) {
		return webSiteInfoRepository.findByFilmId(filmId);
	}

	@Override
	public List<WebSiteInfo> findByWebSiteId(Integer webSiteId) {
		return webSiteInfoRepository.findByWebSiteId(webSiteId);
	}

	@Override
	public void save(WebSiteInfo webSiteInfo) {
		webSiteInfoRepository.save(webSiteInfo);
		
	}

	@Override
	public void delete(Integer id) {
		webSiteInfoRepository.delete(id);
		
	}

	
	

}
