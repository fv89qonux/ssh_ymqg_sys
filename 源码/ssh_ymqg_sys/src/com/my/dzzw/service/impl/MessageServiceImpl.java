/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年01月25日 22时47分56秒
 */
package com.my.dzzw.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.dzzw.model.Message;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.service.MessageService;
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

@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService{
	 
	@Autowired
	private MessageDao messageDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Message> findPager(Message message) {
		return messageDao.findPager(message);
	}
	

	

}
