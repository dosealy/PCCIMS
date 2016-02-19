package com.cardpay.pccims.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.cardpay.pccims.UserService;
import com.cardpay.pccims.domain.User;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")
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
	
	@RequestMapping("/{userId}")
	public ModelAndView showDetail(@PathVariable("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/showDetail");
		mav.addObject("user", userService.getUserById(userId));
		return mav;
	}
	
	public String handle41(@RequestBody String requestBody){
		System.out.println(requestBody);
		return "success";
	}
	
	public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException {
		System.out.println("load image of " + imageId);
		Resource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return fileData;
	}
	
	@RequestMapping(value="/handle81")
	public String handle81(@RequestParam("user") User user, ModelMap modelMap){
		modelMap.put("user", user);
		return "/user/showUser";
	}
	
	@RequestMapping(value="/handle91")	
	public String handle91(@Valid @ModelAttribute("user")User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user/register3";
		}else{
			return "/user/showUser";
		}
	}
	
	@ModelAttribute("user")
	public User getUser(){
		User user = new User();
		user.setUserId("1001");
		return user;
	}
	
}
