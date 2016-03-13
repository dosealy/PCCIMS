package com.cardpay.pccims.dao.mapper;

import java.util.List;

public interface BaseMapper {

	/**
	 * 传入继承FormMap的子类对象，返回一个List<T>集合<br/>
	 * 调用findByPage接口，必须传入PageView对象！formMap.set("paging", pageView);<br/>
	 * 根据多字段分布查询<br/>
	 * 如果是多个id,用","组成字符串.<br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> findByPage(T formMap);
	
	/**
	 * 自定义where查询条件，传入FormMap的子类对象，返回一个List<T>集合<br/>
	 * 返回查询条件数据，如不传入，则返回所有数据。如果附加条件，如下<br/>
	 * formMap.pub("where", "id=XX and name XX order by XX ") <br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> findByWhere(T formMap);
	
	/**
	 * 更新数据<br/>
	 * 传入继承FormMap的子类对象<br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void editEntity(Object formMap) throws Exception;
	
	/**
	 * 根据多字段查询 <br/>
	 * 传入继承FormMap的子类对象<br/>
	 * 如果是多个id,用“，”组成字符串.<br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> findByNames(T formMap);
	
	/**
	 * 根据某个字段查询数据.
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <T> List<T> findByAttribute(String key, String value, Class<T> clazz);
	
	/**
	 * 根据某个字段删除数据
	 * @param key
	 * @param value
	 * @param clazz
	 * @throws Exception
	 */
	public void deleteByAttribute(String key, String value, Class clazz) throws Exception;
	
	/**
	 * 传入继承FormMap的子类对象<br/>
	 * 保存数据，保存数据后返回子类对象的所有数据包括id,主键统一返回为id <br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(Object formMap) throws Exception;
	
	
	/**
	 * 批量保存数据，如果是mysql,在驱动连接加上allowMultiQueries=true这个参数<br/>
	 * 传入继承FormMap的子类对象的一个list集合<br/>
	 * @param formMap
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void batchSave(List formMap) throws Exception;
	
	/**
	 * 根据多个字段删除，传入继承FormMap的子类对象<br/>
	 * 如果是多个id值，用","组成字符串。 <br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void deleteByNames(Object formMap) throws Exception;
	
	/**
	 * 根据某个字段查询数据，返回一个对象，如果返回多个值，则异常<br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <T> T findByFirst(String key, String value, Class<T> clazz);
	
	/**
	 * 获取表字段存在放缓存
	 * @param formMap
	 * @return
	 */
	public <T> List<T> initTableField(T formMap);
}
