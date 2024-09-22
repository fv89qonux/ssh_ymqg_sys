package com.my.dzzw.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时51分03秒
 */
import org.springframework.stereotype.Repository;
import com.my.dzzw.model.ZiLiao;
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
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时51分03秒
 */

@Repository
public class ZiLiaoDaoImpl extends BaseDaoImpl<ZiLiao> implements ZiLiaoDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<ZiLiao> findPager(ZiLiao ziLiao) {
		if(ziLiao.getId() !=0 && !"".equals(ziLiao.getId() )){
	    	   String hql = "from ZiLiao";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +ziLiao.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from ZiLiao where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
