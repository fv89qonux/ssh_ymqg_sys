package com.my.dzzw.action;

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
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

import com.my.dzzw.model.*;
import com.my.dzzw.dao.*;
import com.my.dzzw.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2015年12月24日 下午1:46:33 - 2016年11月26日 21时06分03秒
 */

@Controller("manageAction")
@Scope("prototype")
public class ManageAction extends ActionSupport implements ModelDriven<Manage>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private Manage manage;
		@Override
		public Manage getModel() {
			if(manage==null) manage = new Manage();
			return manage;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private ManageService manageService;
	
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
			
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询
	 * 	private String name;
	private String passWord;
	private String realName;//真实名
	private int type;//管理员类型 1 是超级管理员 2 是普通管理员
	 */
	public String manage(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Manage where 1=1 and type = 2");
		
		if(manage!=null && manage.getName() !=null && !"".equals(manage.getName())){
			sb.append("  and name like :name");
			alias.put("name", "%" +manage.getName()+ "%");
		}
		sb = sb.append("  order by id desc");
		Pager<Manage> pagers = manageService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Manage", manage);
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
	 */
	public String exAdd(){
		manage.setType(2);
		manageService.save(manage);
		ActionContext.getContext().put("url", "/manage_manage.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Manage n = manageService.getById(manage.getId());
		ActionContext.getContext().put("Manage", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Manage n = manageService.getById(manage.getId());
		ActionContext.getContext().put("Manage", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		//Manage n = manageService.getById(manage.getId());
		manage.setType(2);
		manageService.update(manage);
		ActionContext.getContext().put("url", "/manage_manage.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		manageService.delete(manage.getId());
		ActionContext.getContext().put("url", "/manage_manage.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	public String welcome(){
		  return SUCCESS;
	  }
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
