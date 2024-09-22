/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时51分03秒
 */
package com.my.dzzw.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.dzzw.model.ZiLiao;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.service.ZiLiaoService;
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

@Service("ziLiaoServiceImpl")
public class ZiLiaoServiceImpl extends BaseServiceImpl<ZiLiao> implements ZiLiaoService{
	 
	@Autowired
	private ZiLiaoDao ziLiaoDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<ZiLiao> findPager(ZiLiao ziLiao) {
		return ziLiaoDao.findPager(ziLiao);
	}
	

	

}
