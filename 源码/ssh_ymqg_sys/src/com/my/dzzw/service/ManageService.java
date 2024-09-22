package com.my.dzzw.service;

import com.my.dzzw.model.Manage;
import com.my.dzzw.utils.Pager;
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
public interface ManageService extends BaseService<Manage>{

	/**
	 * dao层分页查询
	 */
	Pager<Manage> findPager(Manage manage);
}
