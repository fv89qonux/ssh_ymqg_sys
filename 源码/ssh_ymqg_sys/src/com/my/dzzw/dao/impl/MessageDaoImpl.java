package com.my.dzzw.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时47分56秒
 */
import org.springframework.stereotype.Repository;
import com.my.dzzw.model.Message;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.base.dao.impl.BaseDaoImpl;
import java.util.*;

import com.my.dzzw.model.*;
import com.my.dzzw.dao.*;
import com.my.dzzw.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时47分56秒
 */

@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Message> findPager(Message message) {
		if(message.getId() !=0 && !"".equals(message.getId() )){
	    	   String hql = "from Message";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +message.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Message where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
