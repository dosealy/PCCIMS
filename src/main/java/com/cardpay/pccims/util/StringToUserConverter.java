package com.cardpay.pccims.util;


import org.springframework.core.convert.converter.Converter;

import com.cardpay.pccims.model.User;

public class StringToUserConverter implements Converter<String,User>{

	public User convert(String source) {
		User user = new User();
		if(source != null){
			String[] items = source.split(":");
//			user.setUserName(items[0]);
//			user.setPassword(items[1]);
//			user.setRealName(items[2]);
		}
		return user;
	}
}
