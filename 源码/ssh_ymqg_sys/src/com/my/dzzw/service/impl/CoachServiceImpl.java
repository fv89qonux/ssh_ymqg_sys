/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 package com.my.dzzw.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.dzzw.model.Coach;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.service.CoachService;
import java.util.*;

import com.my.dzzw.model.*;
import com.my.dzzw.dao.*;
import com.my.dzzw.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */

@Service("coachServiceImpl")
public class CoachServiceImpl extends BaseServiceImpl<Coach> implements CoachService{
	 
	@Autowired
	private CoachDao coachDao;

	

	

}
