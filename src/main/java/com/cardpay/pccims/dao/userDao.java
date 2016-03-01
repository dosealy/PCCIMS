package com.cardpay.pccims.dao;

import com.cardpay.pccims.model.User;

public interface userDao {
	public User selectUsersByName(String name);
	// public void deleteUserByName(String name);
}
