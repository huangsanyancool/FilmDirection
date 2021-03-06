package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.java1234.entity.Link;
import com.java1234.repository.LinkRepository;
import com.java1234.service.LinkService;

/**
 * 友情链接service实现类
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{
	@Resource
	private LinkRepository linkRepository;
	@Override
	public List<Link> list(Integer page, Integer pageSize) {
		return linkRepository.findAll(new PageRequest(page, pageSize)).getContent();
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return linkRepository.count();
	}

	@Override
	public void save(Link link) {
		linkRepository.save(link);
		
	}

	@Override
	public void delete(Integer id) {
		linkRepository.delete(id);
		
	}

}
