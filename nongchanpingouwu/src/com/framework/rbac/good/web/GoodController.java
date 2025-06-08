package com.framework.rbac.good.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.good.model.Good;
import com.framework.rbac.good.service.impl.GoodServiceImpl;
import com.framework.rbac.good.service.inte.GoodService;

@Controller
@RequestMapping("/sys/good")
public class GoodController {
	
	@Autowired
	GoodService gs = new GoodServiceImpl();
	
	@RequestMapping("/query")
	public String query(Pager pager,Good good,String search,String searchType,Model model){
		if(searchType!=null&&!search.isEmpty()){
			if(searchType.equals("商品名称")){
				good.setGoodName(search);
			}else if(searchType.equals("商品价格")){
				good.setGoodPrice(search);
			}else if(searchType.equals("商品类型")){
				good.setGoodType(search);
			}
		}
		try{
		model.addAttribute("pager", this.gs.Query(pager, good));
		model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/foreground/GoodTable";
	}
	@RequestMapping("/queryB")
	public String queryB(Pager pager,Good good,String search,String searchType,Model model){
		if(searchType!=null&&!search.isEmpty()){
			if(searchType.equals("商品名称")){
				good.setGoodName(search);
			}else if(searchType.equals("商品价格")){
				good.setGoodPrice(search);
			}else if(searchType.equals("商品类型")){
				good.setGoodType(search);
			}
		}
		try{
		model.addAttribute("pager", this.gs.Query(pager, good));
		model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/background/GoodTable";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
		model.addAttribute("good", this.gs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/foreground/Good";
	}
	
	@RequestMapping("/queryOneB")
	public String queryOneB(Integer id,Model model){
		try{
		model.addAttribute("good", this.gs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/background/Good";
	}
	
	@RequestMapping("/goodAdd")
	public String goodAdd(Good good,Model model){
		try{
			this.gs.goodAdd(good.getGoodName(), good.getGoodType(), good.getGoodPrice(), good.getGoodIntroduce());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/background/Good";
	}
	
	@RequestMapping("/goodUpdate")
	public String goodUpdate(Good good,Model model){
		try{
			this.gs.informationUpdate(good.getId(), good.getGoodName(), good.getGoodType(), good.getGoodPrice(), good.getGoodIntroduce());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:queryB";
	}
	
	@RequestMapping("/goodDelete")
	public String goodDelete(Integer id,Model model){
		try{
			this.gs.informationDelete(id);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:queryB";
	}

}
