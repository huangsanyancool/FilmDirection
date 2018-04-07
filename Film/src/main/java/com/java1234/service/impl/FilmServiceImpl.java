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

import com.java1234.entity.Film;
import com.java1234.repository.FilmRepository;
import com.java1234.service.FilmService;
import com.java1234.util.StringUtil;
/**
 * 电影service接口实现类
 * @author Administrator
 *
 */

@Service("filmService")
public class FilmServiceImpl implements FilmService{
	@Resource
	private FilmRepository filmRepository;
	@Override
	public void save(Film film) {
		filmRepository.save(film);
		
	}
	@Override
	public List<Film> list(Film film, Integer page, Integer pageSize) {
		Pageable pageable=new PageRequest(page, pageSize, Sort.Direction.DESC,"publishDate");
		Page<Film> pageFilm = filmRepository.findAll(new Specification<Film>() {
		
			@Override
			public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(film!=null){
					if(StringUtil.isNotEmpty(film.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+film.getName().trim()+"%"));
					}
					
				}
				return predicate;
			}
		}, pageable);
		return pageFilm.getContent();
	}
	@Override
	public Long getCount(Film film) {
		Long count=filmRepository.count(new Specification<Film>() {

			@Override
			public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(film!=null){
					if(StringUtil.isNotEmpty(film.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+film.getName().trim()+"%"));
					}
					
				}
				return predicate;
			}
		});
		return count;
	}
	
	@Override
	public Film findById(Integer id) {
		// TODO Auto-generated method stub
		return filmRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		filmRepository.delete(id);
		
	}
}
