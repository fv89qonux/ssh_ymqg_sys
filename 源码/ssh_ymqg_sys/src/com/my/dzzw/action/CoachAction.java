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

@Controller("coachAction")
@Scope("prototype")
public class CoachAction extends BaseAction implements ModelDriven<Coach>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Coach coach;
		@Override
		public Coach getModel() {
			if(coach==null) coach = new Coach();
			return coach;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private CoachService coachService;
	
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
	public String coach(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Coach where 1=1 ");
		if(coach.getLevel() != null&&!"".equals(coach.getLevel())){
			sb.append(" and level = :level");
			alias.put("level", coach.getLevel());
		}
		if(coach.getSex() != null&&!"".equals(coach.getSex())){
			sb.append(" and sex = :sex");
			alias.put("sex", coach.getSex());
		}
		if(coach!=null && coach.getName() !=null && !"".equals(coach.getName())){
			sb.append("  and name like :name ");
			alias.put("name", "%" +coach.getName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<Coach> pagers = coachService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", coach);
		return SUCCESS;
    }
	
	public String coach1(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Coach where 1=1 ");
		if(coach.getLevel() != null&&!"".equals(coach.getLevel())){
			sb.append(" and level = :level");
			alias.put("level", coach.getLevel());
		}
		if(coach.getSex() != null&&!"".equals(coach.getSex())){
			sb.append(" and sex = :sex");
			alias.put("sex", coach.getSex());
		}
		if(coach.getPrice() != null&&!"".equals(coach.getPrice())){
			sb.append(" and price = :price");
			alias.put("price", coach.getPrice());
		}
		if(coach.getAge() != null&&!"".equals(coach.getAge())){
			sb.append(" and age = :age");
			alias.put("age", coach.getAge());
		}
//		if(coach!=null && coach.getName() !=null && !"".equals(coach.getName())){
//			sb.append("  and name like :name ");
//			alias.put("name", "%" +coach.getName()+ "%" );
//		}
		sb = sb.append(" order by id desc");
		Pager<Coach> pagers = coachService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", coach);
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

		String newName = new String(coach.getName().getBytes("ISO8859-1"),"utf-8");
		coach.setName(newName);
		coach.setState(0);

		coachService.save(coach);
		ActionContext.getContext().put("url", "/coach_coach.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Coach n = coachService.getById(coach.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Coach n = coachService.getById(coach.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	public String update1(){
		Coach n = coachService.getById(coach.getId());
		if(n.getState()==null||n.getState()==1){
			n.setState(0);
		}else{
			n.setState(1);
		}
		
		coachService.update(n);
		ActionContext.getContext().put("url", "/coach_coach1.do");
		return "redirect";
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exUpdate() throws UnsupportedEncodingException{
		Coach n = coachService.getById(coach.getId());
		String newName = new String(coach.getName().getBytes("ISO8859-1"),"utf-8");
		n.setAge(coach.getAge());
		n.setName(newName);
		n.setLevel(coach.getLevel());
		n.setSex(coach.getSex());
		n.setPrice(coach.getPrice());
		coachService.update(n);
		ActionContext.getContext().put("url", "/coach_coach.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		coachService.delete(coach.getId());
		ActionContext.getContext().put("url", "/coach_coach.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
