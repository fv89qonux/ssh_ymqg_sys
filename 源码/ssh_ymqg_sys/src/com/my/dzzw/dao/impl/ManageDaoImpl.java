package com.my.dzzw.dao.impl;


import org.springframework.stereotype.Repository;
import com.my.dzzw.model.Manage;
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
 * @date 2015年12月24日 下午1:46:33 - 2016年11月26日 20时34分33秒
 */

@Repository
public class ManageDaoImpl extends BaseDaoImpl<Manage> implements ManageDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Manage> findPager(Manage manage) {
		/*if(user.getRealName() !=null && !"".equals(user.getRealName() )){
	    	   String hql = "from Manage";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +manage.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Manage where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }*/
		return null;
	}
	
}
