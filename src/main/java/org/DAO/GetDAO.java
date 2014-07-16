package org.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.POJO.FieldMt;
import org.POJO.UserAccounts;
import org.POJO.UserViewDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value="getDao")
public class GetDAO {
	
	//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Resource(name="sessionfactory")
	private SessionFactory sessionfactory;//=(SessionFactory) ac.getBean("sessionfactory");

	@SuppressWarnings("unchecked")
	public List<FieldMt> getFieldMt(){
		Session session=sessionfactory.openSession();
		Query query = session.createQuery("from FieldMt");
		session.close();
		return query.list();
	}
	
	public boolean validateCheck(UserAccounts accounts){
		Session session=sessionfactory.openSession();
		Query query = session.createQuery("from UserAccounts where username:=username");
		query.setParameter("username", accounts.getUsername());
		UserAccounts userAccounts = (UserAccounts) query.uniqueResult();
		session.close();
		if(userAccounts != null)
		{
			if(userAccounts.getPassword().equals(accounts.getPassword()))
				return true;
			else
				return false;
		}
		else	
			return false;
	}
	
	public static void main(String args[]){
		UserAccounts userAccounts = new UserAccounts();
		userAccounts.setUsername("ankit");
		userAccounts.setPassword("1234");
		System.out.println(new GetDAO().validateCheck(userAccounts));
		
	}
}
