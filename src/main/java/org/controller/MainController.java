package org.controller;

import javax.annotation.Resource;

import org.Service.GetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public class MainController {
	
	@Resource(name="getService")
	private GetService getservice;
	
	@RequestMapping("/fields")
	public String getField(Model model ){
		model.addAttribute("fields", getservice.getFieldMt());
		return "getField";
	}

}
