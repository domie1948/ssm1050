package com.framework.rbac.failed.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.failed.model.Failed;
import com.framework.rbac.failed.service.impl.FailedServiceImpl;
import com.framework.rbac.failed.service.inte.FailedService;

@Controller
@RequestMapping("/sys/failed")
public class FailedController {

	@Autowired
	private FailedService fs = new FailedServiceImpl();
	@RequestMapping("/query")
	public String query(Pager pager,Failed failed,String search,Model model){
		try{
		model.addAttribute("pager", this.fs.Query(pager, failed));
		model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/foreground/failed";
	}
	
}
