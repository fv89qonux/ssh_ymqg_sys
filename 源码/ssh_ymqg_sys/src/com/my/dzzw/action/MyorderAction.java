package com.my.dzzw.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.utils.UserUtils;
import com.opensymphony.xwork2.ModelDriven;

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

@Controller("myorderAction")
@Scope("prototype")
public class MyorderAction extends BaseAction implements ModelDriven<Myorder>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Myorder myorder;
		@Override
		public Myorder getModel() {
			if(myorder==null) myorder = new Myorder();
			return myorder;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private MyorderService myorderService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private UserService userService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	private int userId;
	private File file;
	private Integer stat;
	
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    
    private String fileContentType;
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
	public String jsonAction() {
		  // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询
	 */
	public String myorder(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Myorder where 1=1 and state = 1 ");
		if(myorder.getTime() != null&&!"".equals(myorder.getTime())){
			sb.append(" and time >= :time and time <= :time2");
			alias.put("time",myorder.getTime());
			
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(myorder.getTime());  
	        int hour = cal.get(Calendar.HOUR_OF_DAY);  
	        int minute = cal.get(Calendar.MINUTE);  
	        int second = cal.get(Calendar.SECOND);  
	        //时分秒（毫秒数）  
	        long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;  
	        //凌晨23:59:59 
	        cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
			
			alias.put("time2",cal.getTime());
			
		}
		sb = sb.append(" order by id desc");
		Pager<Myorder> pagers = myorderService.findByAlias(sb.toString(),alias);
		int tj = 0;
		for(Myorder ord:pagers.getDatas()){
			if(ord.getConsume()!=null){
				tj+=ord.getConsume();
			}
			
		}
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", myorder);
		ActionContext.getContext().put("tj", tj);
		return SUCCESS;
    }
	
	public String myorder1(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Myorder where 1=1 ");
		sb = sb.append("order by id desc");
		Pager<Myorder> pagers = myorderService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", myorder);
		return SUCCESS;
    }
	
	public String myorder2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Myorder where 1=1 ");

		sb.append("  and user.id = :id ");
		alias.put("id",UserUtils.getLoginId());

	
		sb = sb.append(" order by id desc");
		Pager<Myorder> pagers = myorderService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", myorder);
		return SUCCESS;
    }
	 
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		User user = userService.getById(UserUtils.getLoginId());
		List<Area> areas = areaService.listByAlias("from Area where state=0 and (useState=0 or useState is null) ", null);
		ActionContext.getContext().put("areas", areas);
		ActionContext.getContext().put("user", user);
		
		return SUCCESS;
	}
	
	public String add1(){
		List<Area> areas = areaService.listByAlias("from Area where state=0 and (useState=0 or useState is null) ", null);
		ActionContext.getContext().put("areas", areas);	
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		User user = userService.getById(UserUtils.getLoginId());
		user.setYe(user.getYe()-100);
		userService.save(user);
		myorder.setUser(user);
		myorderService.save(myorder);
		ActionContext.getContext().put("url", "/myorder_myorder2.do");
		return "redirect";
	}
	
	public String exAdd1(){
		myorderService.save(myorder);
		ActionContext.getContext().put("url", "/myorder_myorder1.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Myorder n = myorderService.getById(myorder.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Myorder n = myorderService.getById(myorder.getId());
		Area area = areaService.getById(n.getArea().getId());
		ActionContext.getContext().put("Obj", n);
		ActionContext.getContext().put("area", area);
		return SUCCESS;
	}
	
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		Myorder n = myorderService.getById(myorder.getId());
		if(n.getUser()!=null){
			User user = userService.getById(n.getUser().getId());
			if(user.getYe()+100-myorder.getConsume()<0){
				ActionContext.getContext().put("url", "/tuser_update1.do");
				return "redirect";	
			}
			user.setYe(user.getYe()+100-myorder.getConsume());
			userService.save(user);
		}

		n.setConsume(myorder.getConsume());

		n.setState(myorder.getState());
		myorderService.update(n);
		ActionContext.getContext().put("url", "/myorder_myorder1.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String exDelete(){
		myorderService.delete(myorder.getId());
		User user = userService.getById(UserUtils.getLoginId());
		if(myorder.getState()==2){
			user.setYe(user.getYe()+100);
		}
		userService.update(user);
		ActionContext.getContext().put("url", "/myorder_myorder2.do");
		return "redirect";
	}
	
	public String delete(){
		Myorder ord = myorderService.getById(myorder.getId());
		User user = userService.getById(UserUtils.getLoginId());
		ActionContext.getContext().put("order", ord);
		ActionContext.getContext().put("user", user);
		return SUCCESS;
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
