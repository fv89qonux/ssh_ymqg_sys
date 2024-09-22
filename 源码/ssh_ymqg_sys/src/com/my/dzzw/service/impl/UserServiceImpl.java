/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2016年11月26日 20时34分33秒
 */
package com.my.dzzw.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.dzzw.model.User;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.service.UserService;
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

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	 
	@Autowired
	private UserDao userDao;

	

}
