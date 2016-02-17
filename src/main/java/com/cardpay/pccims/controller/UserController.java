package com.cardpay.pccims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cardpay.pccims.UserService;
import com.cardpay.pccims.dao.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/register")
	public String register(){
		return "user/register";
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createUser(User user){
		userService.createUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/createSuccess");
		return mav;
	}
}
