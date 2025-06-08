package com.framework.rbac.good.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.good.model.Good;

public interface GoodDao {

	public List<Good> Query(Map<String,Object> map);
	
	public Integer queryCount(@Param("good")Good good);
	
	public Good QueryOne(@Param("id")Integer id);
	
	public void goodAdd(@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("goodIntroduce")String goodIntroduce);
	
	public void informationUpdate(@Param("id")Integer id,@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("goodIntroduce")String goodIntroduce);
	
	public void informationDelete(@Param("id")Integer id);
	
}
