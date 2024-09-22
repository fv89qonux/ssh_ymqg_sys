package com.my.dzzw.dao;

import com.my.dzzw.base.dao.BaseDao;
import com.my.dzzw.model.Manage;
import com.my.dzzw.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2015年12月24日 下午1:46:33 - 2016年11月26日 20时34分33秒
 */


public interface ManageDao extends BaseDao<Manage>{
	
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	Pager<Manage> findPager(Manage manage);
}
