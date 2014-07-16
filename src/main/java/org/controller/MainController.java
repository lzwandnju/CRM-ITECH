package org.controller;

import java.util.List;

import javax.annotation.Resource;

import org.POJO.UserAccounts;
import org.POJO.UserViewDetails;
import org.Service.GetService;
import org.Service.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class MainController {

	@Resource(name = "getService")
	private GetService getservice;

	@Resource(name = "loginservice")
	private Login login;

	@RequestMapping("/fields")
	public String getField(Model model) {
		model.addAttribute("fields", getservice.getFieldMt());
		return "getField";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model)
	{
		model.addAttribute("user", new UserAccounts());
		return "login";	}



	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "user") UserAccounts username,
			ModelMap map) {
		if (login.validate(username.getUsername(), username.getPassword()) == true)
			return "userview";
		else {
			map.addAttribute("errmessage", "Incorrect Username or Password");
			return "login";
		}

	}

	@RequestMapping("/userview")
	public String getUserView(List<UserViewDetails> userviewDetails) {

		return "userview";
	}
}
