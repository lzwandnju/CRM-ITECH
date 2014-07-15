package org.Service;

import java.util.List;

import javax.annotation.Resource;

import org.DAO.GetDAO;
import org.POJO.FieldMt;
import org.springframework.stereotype.Service;

@Service(value="getService")
public class GetService {
	
	@Resource(name="getDao")
	private GetDAO getdao;
	
	public List<FieldMt> getFieldMt(){
		return getdao.getFieldMt();
	}

}
