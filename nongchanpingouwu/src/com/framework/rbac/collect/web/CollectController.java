package com.framework.rbac.collect.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.bargain.service.impl.BargainServiceImpl;
import com.framework.rbac.bargain.service.inte.BargainService;
import com.framework.rbac.collect.model.Collect;
import com.framework.rbac.collect.service.impl.CollectServiceImpl;
import com.framework.rbac.collect.service.inte.CollcetService;
import com.framework.rbac.user.model.User;

@Controller
@RequestMapping("/sys/collect")
public class CollectController {

	@Autowired
	private CollcetService cs = new CollectServiceImpl();
	@Autowired
	private BargainService bs = new BargainServiceImpl();
	@RequestMapping("/query")
	public String query(Pager pager,Collect collect,String search,Model model,HttpSession session){
		try{
			if((User)session.getAttribute("User")!=null){
			User user = (User)session.getAttribute("User");
			collect.setCustomName(user.getAccount());
			}else{
				collect.setCustomName("no");
			}
			model.addAttribute("pager", this.cs.Query(pager, collect));
			model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/foreground/cart";
	}
	
	@RequestMapping("/add")
	public String add(Collect collect,Model model,HttpSession session){
			this.cs.collectAdd(collect.getGoodName(), collect.getGoodType(), collect.getGoodPrice(), collect.getCustomName(),collect.getCustomTel(),collect.getCustomAddress(), collect.getGoodNumber(),collect.getGoodId());
		return "redirect:../request/index";
	}
	@RequestMapping("/delete")
	public String delete(Integer id,Model model){
			Collect collect = this.cs.queryOne(id);
			this.bs.bargainAdd(collect.getGoodName(), collect.getGoodType(), collect.getGoodPrice(), collect.getCustomName(), collect.getCustomTel(), collect.getCustomAddress(), "1", collect.getGoodNumber(), collect.getGoodId());
			this.cs.informationDelete(id);
			
		return "redirect:query";
	}
	
}
