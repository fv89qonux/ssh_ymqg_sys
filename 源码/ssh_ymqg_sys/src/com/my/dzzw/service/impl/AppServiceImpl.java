/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时47分57秒
 */
package com.my.dzzw.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.dzzw.model.News;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.service.NewsService;
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

@Service("appServiceImpl")
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService{
	 
	@Autowired
	private AppDao appDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<App> findPager(App app) {
		return appDao.findPager(app);
	}
//	@Override
//	public List<News> select5ByType(int i, String newName) {
//		// TODO Auto-generated method stub
//		return newsDao.select5ByType(i,newName);
//	}
	

	

}
