package com.framework.rbac.collect.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.collect.dao.CollectDao;
import com.framework.rbac.collect.model.Collect;
import com.framework.rbac.collect.service.inte.CollcetService;
@Service
public class CollectServiceImpl implements CollcetService {

	@Autowired
	private CollectDao collectDao;
	@Override
	public Pager Query(Pager pager, Collect collect) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("collect", collect);
		List<Collect> list = this.collectDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有商品");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(collect));
		return pager;
	}

	@Override
	public Integer queryCount(Collect collect) {
		Integer count = this.collectDao.queryCount(collect);
		return count;
	}

	@Override
	public void collectAdd(String goodName, String goodType, String goodPrice, String customName,String customTel,String customAddress, Integer goodNumber,Integer goodId) {
		try{
			this.collectDao.collectAdd(goodName, goodType, goodPrice, customName,customTel,customAddress,goodNumber,goodId);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationUpdate(Integer id, String goodName, String goodType, String goodPrice, String customName,String customTel,String customAddress,
			Integer goodNumber,Integer goodId) {
		try{
			this.collectDao.informationUpdate(id, goodName, goodType, goodPrice, customName,customTel,customAddress,goodNumber,goodId);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.collectDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public Collect queryOne(Integer id) {
		Collect collect = this.collectDao.queryOne(id);
		return collect;
	}

}
