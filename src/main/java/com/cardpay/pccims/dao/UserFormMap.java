package com.cardpay.pccims.dao;


import com.cardpay.pccims.annotation.TableSeg;
import com.cardpay.pccims.util.FormMap;

/**
 * user实现类
 * @author licho
 *
 */
@TableSeg(tableName="cp_user", id="id")
public class UserFormMap extends FormMap<String, Object>{
	/**
	 * @author licho
	 */
	private static final long serialVersionUID = 1L;
}
