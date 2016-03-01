package com.cardpay.pccims.model;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat;

import com.cardpay.pccims.model.share.Entity;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("message")
public class User implements Entity<User> {
	
	
	public User() {
		//for hibernate
	}
	
//	@XStreamAlias("id")
//	@XStreamAsAttribute
	private String userId;
	
//	@XStreamAsAttribute
	@Pattern(regexp="w{4,30}")
	private String userName;
	
//	@XStreamAsAttribute
	@Pattern(regexp="S{6,30}")
	private String password;
	
//	@XStreamAsAttribute
	@Length(min=2, max=100)
	private String realName;
	
//	@XStreamAsAttribute
	@Past
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date birthday;
	
//	@XStreamAsAttribute
	@DecimalMin(value="1000.00")
	@DecimalMax(value="100000.00")
	@NumberFormat(pattern="#,###.##")
	private long salary;
	
//	@XStreamOmitField
	private Dept dept;
	
	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}

	public String getRealName() {
		return realName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public long getSalary() {
		return salary;
	}

	public Dept getDept() {
		return dept;
	}

	@Override	
	public boolean sameIdentityAs(User other) {
		return true;
	}
	
	@Override
	public boolean equals(final Object object) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
