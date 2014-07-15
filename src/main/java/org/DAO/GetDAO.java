package org.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.POJO.FieldMt;
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
		return query.list();
	}
	public static void main(String args[]){
		
		for(FieldMt f: new GetDAO().getFieldMt()){
			System.out.println(f.getFieldname());
		}
	}
}
