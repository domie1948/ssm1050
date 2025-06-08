package com.framework.rbac.collect.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.collect.model.Collect;

public interface CollectDao {

	public List<Collect> Query(Map<String,Object> map);
	
	public Integer queryCount(@Param("collect")Collect collect);
	
	public Collect queryOne(@Param("id")Integer id);
	
	public void collectAdd(@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("customName")String customName,@Param("customTel")String customTel,@Param("customAddress")String customAddress,@Param("goodNumber")Integer goodNumber,@Param("goodId")Integer goodId);
	
	public void informationUpdate(@Param("id")Integer id,@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("customName")String customName,@Param("customTel")String customTel,@Param("customAddress")String customAddress,@Param("goodNumber")Integer goodNumber,@Param("goodId")Integer goodId);
	
	public void informationDelete(@Param("id")Integer id);
	
}
