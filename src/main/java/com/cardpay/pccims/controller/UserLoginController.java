package com.cardpay.pccims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cardpay.pccims.dao.UserLoginFormMap;
import com.cardpay.pccims.dao.mapper.UserLoginMapper;
import com.cardpay.pccims.util.Common;
import com.cardpay.pccims.util.PageView;


@Controller
@RequestMapping("/userlogin/")
public class UserLoginController extends BaseController{
	
	@Autowired
	private UserLoginMapper userLoginMapper;
	
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/userlogin/list";
	}
	
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		UserLoginFormMap userLoginFormMap = getFormMap(UserLoginFormMap.class);
		userLoginFormMap = toFormMap(userLoginFormMap, pageNow, pageSize, userLoginFormMap.getStr("orderby"));
		pageView.setRecords(userLoginMapper.findByPage(userLoginFormMap));
		return pageView;
	}
}