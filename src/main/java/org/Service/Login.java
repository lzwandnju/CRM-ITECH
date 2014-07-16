package org.Service;

import javax.annotation.Resource;

import org.DAO.GetDAO;
import org.POJO.UserAccounts;
import org.springframework.stereotype.Service;

@Service("login")
public class Login {
	
	@Resource(name="getDao")
	public GetDAO getDAO;
	
	public boolean validate(String username, String password){
		UserAccounts userAccounts = new UserAccounts();
		userAccounts.setPassword(password);
		userAccounts.setUsername(username);
		return getDAO.validateCheck(userAccounts);
		
	}

}
