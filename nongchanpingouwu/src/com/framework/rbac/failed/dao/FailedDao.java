package com.framework.rbac.failed.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.failed.model.Failed;

public interface FailedDao {

	public List<Failed> Query(Map<String,Object> map);
	
	public Integer queryCount(@Param("failed")Failed failed);
	
	public void failedAdd(@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("customName")String customName,@Param("reason")String reason);
	
	public void informationUpdate(@Param("id")Integer id,@Param("goodName")String goodName,@Param("goodType")String goodType,@Param("goodPrice")String goodPrice,@Param("customName")String customName,@Param("reason")String reason);
	
	public void informationDelete(@Param("id")Integer id);
	
}
