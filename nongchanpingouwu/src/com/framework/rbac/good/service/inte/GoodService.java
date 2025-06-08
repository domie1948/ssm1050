package com.framework.rbac.good.service.inte;



import com.framework.base.pager.Pager;
import com.framework.rbac.good.model.Good;

public interface GoodService {

	public Pager Query(Pager pager,Good good);
	
	public Integer queryCount(Good good);
	
	public Good queryOne(Integer id);
	
	public void goodAdd(String goodName,String goodType,String goodPrice,String goodIntroduce);
	
	public void informationUpdate(Integer id,String goodName,String goodType,String goodPrice,String goodIntroduce);
	
	public void informationDelete(Integer id);
	
}
