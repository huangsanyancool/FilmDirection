package com.java1234.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java1234.entity.WebSite;

import com.java1234.service.WebSiteService;

/**
 * 收录电影网址Controller类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin/webSite")
public class WebSiteAdminController {
	
	
	@Resource
	private WebSiteService webSiteService;
	
	
	/**
	 * 分页查询收录电影网址
	 * @param film
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(WebSite webSite,@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{  
		List<WebSite> webSiteList=webSiteService.list(webSite, page-1, rows);
		Long total=webSiteService.getCount(webSite);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows", webSiteList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	/**
	 * 添加或者修改收录电影网址
	 * @param link
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String,Object> save(WebSite webSite)throws Exception{  
		Map<String,Object> resultMap=new HashMap<String,Object>();
		webSiteService.save(webSite);
		resultMap.put("success", true);
		return resultMap;
	}
	/**
	 * 删除收录电影网址
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestParam(value="ids")String ids)throws Exception{  
		String idsStr[]=ids.split(",");
		for(int i=0;i<idsStr.length;i++ ){
			webSiteService.delete(Integer.parseInt(idsStr[i]));
		}
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("success", true);
		return resultMap;
	}
	
	
}
