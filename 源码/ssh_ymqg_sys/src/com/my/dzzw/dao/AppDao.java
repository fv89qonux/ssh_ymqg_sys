package com.my.dzzw.dao;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时47分57秒
 */
import com.my.dzzw.utils.Pager;
import com.my.dzzw.base.dao.BaseDao;
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


public interface AppDao extends BaseDao<App>{
	
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	Pager<App> findPager(App app);

//	List<App> select5ByType(int i, String newName);
}
