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

@Controller("cashierAction")
@Scope("prototype")
public class CashierAction extends BaseAction implements ModelDriven<Cashier>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Cashier cashier;
		@Override
		public Cashier getModel() {
			if(cashier==null) cashier = new Cashier();
			return cashier;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private CashierService cashierService;
	
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
	public String cashier(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Cashier where 1=1 ");
		if(cashier!=null && cashier.getName() !=null && !"".equals(cashier.getName())){
			sb.append("  and name like :name ");
			alias.put("name", "%" +cashier.getName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<Cashier> pagers = cashierService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", cashier);
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
		String newName = new String(cashier.getName().getBytes("ISO8859-1"),"utf-8");
		cashier.setName(newName);
		cashierService.save(cashier);
		ActionContext.getContext().put("url", "/cashier_cashier.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Cashier n = cashierService.getById(cashier.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Cashier n = cashierService.getById(cashier.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exUpdate() throws UnsupportedEncodingException{
		Cashier n = cashierService.getById(cashier.getId());
		String newName = new String(cashier.getName().getBytes("ISO8859-1"),"utf-8");
		n.setName(newName);
		n.setPassWord(cashier.getPassWord());
		cashierService.update(n);
		ActionContext.getContext().put("url", "/cashier_cashier.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		cashierService.delete(cashier.getId());
		ActionContext.getContext().put("url", "/cashier_cashier.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
