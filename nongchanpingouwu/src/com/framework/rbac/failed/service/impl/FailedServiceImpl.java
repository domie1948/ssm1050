package com.framework.rbac.failed.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.failed.dao.FailedDao;
import com.framework.rbac.failed.model.Failed;
import com.framework.rbac.failed.service.inte.FailedService;
@Service
public class FailedServiceImpl implements FailedService {

	@Autowired
	private FailedDao failedDao;
	@Override
	public Pager Query(Pager pager, Failed failed) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("failed", failed);
		List<Failed> list = this.failedDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有商品");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(failed));
		return pager;
	}

	@Override
	public Integer queryCount(Failed failed) {
		Integer count = this.failedDao.queryCount(failed);
		return count;
	}

	@Override
	public void failedAdd(String goodName, String goodType, String goodPrice, String customName, String reason) {
		try{
			this.failedDao.failedAdd(goodName, goodType, goodPrice, customName,reason);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationUpdate(Integer id, String goodName, String goodType, String goodPrice, String customName,
			String reason) {
		try{
			this.failedDao.informationUpdate(id, goodName, goodType, goodPrice, customName,reason);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.failedDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

}
