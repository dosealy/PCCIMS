package com.cardpay.pccims.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cardpay.pccims.dao.UserFormMap;
import com.cardpay.pccims.dao.mapper.ResourcesMapper;
import com.cardpay.pccims.model.ResFormMap;
import com.cardpay.pccims.util.Common;
import com.cardpay.pccims.util.FormMap;
import com.cardpay.pccims.util.PageView;
import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * 
 * @author licho
 * date 2015-03-11
 */
public class BaseController {
	
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	public PageView pageView = null;
	public PageView getPageView(String pageNow, String pageSize, String orderBy) {
		if(Common.isNullOrEmpty(pageNow)) {
			pageView = new PageView(1);
		}else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		
		if(Common.isNullOrEmpty(pageSize)) {
			pageSize = "10";
		}
		
		pageView.setPageSize(Integer.parseInt(pageSize));
		pageView.setOrderby(orderBy);
		return pageView;				
	}
	
	public <T> T toFormMap(T t, String pageNow, String pageSize, String orderBy) {		
		@SuppressWarnings("unchecked")
		FormMap<String, Object> formMap = (FormMap<String, Object>)t;
		formMap.put("paging", getPageView(pageNow, pageSize, orderBy));
		return t;
	}
	
	/**
	 * 获取返回某一页面的按键组
	 * @return
	 */
	public List<ResFormMap> findByRes() {
		//资源ID
		String id = getPara("id");
		
		//获取request
		HttpServletRequest request = getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		
		//user id
		int userId = userFormMap.getInt("id");
		ResFormMap resQueryForm = new ResFormMap();
		resQueryForm.put("parentId", id);
		resQueryForm.put("userId", userId);
		List<ResFormMap> rse = resourcesMapper.findRes(resQueryForm);
		for(ResFormMap resFormMap : rse) {
			Object o = resFormMap.get("description");
			if(o!=null && !Common.isNullOrEmpty(o.toString())) {
				resFormMap.put("description", Common.stringtohtml(o.toString()));
			}
		}
		return rse;
	}
	
	/**
	 * 获取页面传递的一个参数值
	 * @param key
	 * @return
	 */
	public String getPara(String key) {
		HttpServletRequest request = getRequest();
		return request.getParameter(key);
	}
	
	public String[] getParaValues(String key) {
		HttpServletRequest request = getRequest();
		return request.getParameterValues(key);
	}
	
	public HttpServletRequest getRequest() {
		//TODO:据说上传文件时，这里获取不到，以后更改为方法入参
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	}
	
	/**
	 * 获取传递所有参数，反射实例化对象，再设置属性值
	 * @param clazz
	 * @return
	 */
	public <T> T getFormMap(Class<T> clazz) {
		HttpServletRequest request = getRequest();
		Enumeration<String> en = request.getParameterNames();
		T t = null;
		try {
			t = clazz.newInstance();
			@SuppressWarnings("unchecked")
			FormMap<String, Object> map = (FormMap<String, Object>) t;
			String order = "", sort = "";
			while (en.hasMoreElements()) {
				String nms = en.nextElement().toString();
				if(nms.endsWith("[]")){
					String[] as = request.getParameterValues(nms);
					if(as!=null&&as.length!=0&&as.toString()!="[]"){
						String mname = t.getClass().getSimpleName().toUpperCase();
						if(nms.toUpperCase().startsWith(mname)){
							nms=nms.substring(nms.toUpperCase().indexOf(mname)+1);
							map.put(nms,as);
						}
					}
				}else{
					String as = request.getParameter(nms);
					if(!Common.isNullOrEmpty(as)){
						String mname = t.getClass().getSimpleName().toUpperCase();
						if(nms.toUpperCase().startsWith(mname)){
							nms=nms.substring(mname.length()+1);
							map.put(nms, as);
						}
						if(nms.toLowerCase().equals("column"))order = as;
						if(nms.toLowerCase().equals("sort"))sort = as;
					}
				}
			}
			if(!Common.isNullOrEmpty(order) && !Common.isNullOrEmpty(sort))
				map.put("orderby", " order by " + order + " " + sort);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return  t;
	}
}
