package com.java1234.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java1234.entity.WebSite;
import com.java1234.entity.WebSiteInfo;
import com.java1234.service.WebSiteInfoService;
import com.java1234.service.WebSiteService;

/**
 * 收录电影网址Controller类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin/webSiteInfo")
public class WebSiteInfoAdminController {
	
	
	@Resource
	private WebSiteInfoService webSiteInfoService;
	
	
	/**
	 * 分页查询收录电影网址
	 * @param film
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(WebSiteInfo webSiteInfo,@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{  
		List<WebSiteInfo> webSiteInfoList=webSiteInfoService.list(webSiteInfo, page-1, rows);
		Long total=webSiteInfoService.getCount(webSiteInfo);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows", webSiteInfoList);
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
	public Map<String,Object> save(WebSiteInfo webSiteInfo)throws Exception{  
		webSiteInfo.setPublishDate(new Date());
		Map<String,Object> resultMap=new HashMap<String,Object>();
		webSiteInfoService.save(webSiteInfo);
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
			webSiteInfoService.delete(Integer.parseInt(idsStr[i]));
		}
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("success", true);
		return resultMap;
	}
	
	
}
