package com.my.dzzw.dao.impl;
import org.hibernate.Query;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时47分57秒
 */
import org.springframework.stereotype.Repository;
import com.my.dzzw.model.News;
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
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时47分57秒
 */

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<News> findPager(News news) {
		if(news.getId() !=0 && !"".equals(news.getId() )){
	    	   String hql = "from News";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +news.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from News where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}

@Override
public List<News> select5ByType(int i, String newName) {
	// TODO Auto-generated method stub
	String hql = "from News where isDelete = 0 and type = "+i;
	if(!isEmpty(newName)){
		hql+=" and title like :title";
	}
	hql+="  order by id desc";
	Query query = this.getSession().createQuery(hql);
	if(!isEmpty(newName)){
		query.setParameter("title", "%" +newName+ "%");
	}
	query.setFirstResult(0);
	query.setMaxResults(10);
	return query.list();
}
	
}
