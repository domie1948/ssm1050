package com.framework.rbac.collect.service.inte;

import com.framework.base.pager.Pager;
import com.framework.rbac.collect.model.Collect;

public interface CollcetService {

	public Pager Query(Pager pager,Collect collect);
	
	public Integer queryCount(Collect collect);
	
	public Collect queryOne(Integer id);
	
	public void collectAdd(String goodName,String goodType,String goodPrice,String customName,String customTel,String customAddress,Integer goodNumber,Integer goodId);
	
	public void informationUpdate(Integer id,String goodName,String goodType,String goodPrice,String customName,String customTel,String customAddress,Integer goodNumber,Integer goodId);
	
	public void informationDelete(Integer id);
	
}
