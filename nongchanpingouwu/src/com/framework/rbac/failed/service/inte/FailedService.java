package com.framework.rbac.failed.service.inte;

import com.framework.base.pager.Pager;
import com.framework.rbac.failed.model.Failed;

public interface FailedService {

	public Pager Query(Pager pager,Failed failed);
	
	public Integer queryCount(Failed failed);
	
	public void failedAdd(String goodName,String goodType,String goodPrice,String customName,String reason);
	
	public void informationUpdate(Integer id,String goodName,String goodType,String goodPrice,String customName,String reason);
	
	public void informationDelete(Integer id);
	
}
