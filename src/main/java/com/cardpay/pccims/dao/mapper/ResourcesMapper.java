package com.cardpay.pccims.dao.mapper;

import java.util.List;

import com.cardpay.pccims.model.ResFormMap;

public interface ResourcesMapper extends BaseMapper {

	public List<ResFormMap> findChildLists(ResFormMap map);
	public List<ResFormMap> findRes(ResFormMap map);
	public void updateSortOrder(List<ResFormMap> map);
	public List<ResFormMap> findUserResources(String userId);
}
