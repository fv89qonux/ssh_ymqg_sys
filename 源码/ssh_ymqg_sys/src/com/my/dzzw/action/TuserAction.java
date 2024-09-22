package com.my.dzzw.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.UnsupportedEncodingException;
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

@Controller("tuserAction")
@Scope("prototype")
public class TuserAction extends BaseAction implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private User tuser;
		@Override
		public User getModel() {
			if(tuser==null) tuser = new User();
			return tuser;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private UserService tuserService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
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
	public String user(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from User where 1=1 ");
		if(tuser.getPhone() != null&&!"".equals(tuser.getPhone())){
			sb.append(" and phone = :phone");
			alias.put("phone", tuser.getPhone());
		}
		if(tuser.getSex() != null&&!"".equals(tuser.getSex())){
			sb.append(" and sex = :sex");
			alias.put("sex", tuser.getSex());
		}
		if(tuser!=null && tuser.getRealName() !=null && !"".equals(tuser.getRealName())){
			sb.append("  and realName like :getRealName ");
			alias.put("getRealName", "%" +tuser.getRealName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<User> pagers = tuserService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", tuser);
		return SUCCESS;
    }
	
	public String user1(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from User where 1=1 ");
		if(tuser.getPhone() != null&&!"".equals(tuser.getPhone())){
			sb.append(" and phone = :phone");
			alias.put("phone", tuser.getPhone());
		}
		if(tuser.getSex() != null&&!"".equals(tuser.getSex())){
			sb.append(" and sex = :sex");
			alias.put("sex", tuser.getSex());
		}
		if(tuser!=null && tuser.getRealName() !=null && !"".equals(tuser.getRealName())){
			sb.append("  and realName like :getRealName ");
			alias.put("getRealName", "%" +tuser.getRealName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<User> pagers = tuserService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", tuser);
		return SUCCESS;
    }
	
	public String user2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from User where 1=1 ");

			sb.append(" and id = :id");
			alias.put("id", tuser.getId());


		sb = sb.append(" order by id desc");
		Pager<User> pagers = tuserService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", tuser);
		return SUCCESS;
    }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exAdd() throws UnsupportedEncodingException{
		String newName = new String(tuser.getRealName().getBytes("ISO8859-1"),"utf-8");
		tuser.setRealName(newName);
		String newName2 = new String(tuser.getUserName().getBytes("ISO8859-1"),"utf-8");
		tuser.setUserName(newName2);
		tuserService.save(tuser);
		ActionContext.getContext().put("url", "/tuser_user.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		User n = tuserService.getById(tuser.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		User n = tuserService.getById(tuser.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	public String update1(){
		User n = tuserService.getById(tuser.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	public String update2(){
		User n = tuserService.getById(tuser.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exUpdate() throws UnsupportedEncodingException{
		User n = tuserService.getById(tuser.getId());
		String newName = new String(tuser.getRealName().getBytes("ISO8859-1"),"utf-8");
		n.setRealName(newName);
		String newName2 = new String(tuser.getUserName().getBytes("ISO8859-1"),"utf-8");
		n.setUserName(newName2);
		n.setPassWord(tuser.getPassWord());
		n.setPhone(tuser.getPhone());
		n.setBrithday(tuser.getBrithday());
		n.setLevel(tuser.getLevel());
		n.setSex(tuser.getSex());
		n.setYe(tuser.getYe());
		
		tuserService.update(n);
		ActionContext.getContext().put("url", "/tuser_user.do");
		return "redirect";
	}
	
	public String exUpdate1() {
		User n = tuserService.getById(tuser.getId());
		if(n.getYe()!=null){
			n.setYe(tuser.getYe()+n.getYe());
		}else{
			n.setYe(tuser.getYe());
		}
		
		tuserService.update(n);
		ActionContext.getContext().put("url", "/tuser_user1.do");
		return "redirect";
	}
	
	public String exUpdate2() throws UnsupportedEncodingException{
		User n = tuserService.getById(tuser.getId());
		String newName = new String(tuser.getRealName().getBytes("ISO8859-1"),"utf-8");
		n.setRealName(newName);
		String newName2 = new String(tuser.getUserName().getBytes("ISO8859-1"),"utf-8");
		n.setUserName(newName2);
		n.setPassWord(tuser.getPassWord());
		n.setPhone(tuser.getPhone());
		n.setBrithday(tuser.getBrithday());
		n.setSex(tuser.getSex());
		tuserService.update(n);
		ActionContext.getContext().put("url", "/tuser_user2.do?id="+tuser.getId());
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		tuserService.delete(tuser.getId());
		ActionContext.getContext().put("url", "/tuser_user.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
