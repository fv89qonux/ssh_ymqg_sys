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

@Controller("equipAction")
@Scope("prototype")
public class EquipAction extends BaseAction implements ModelDriven<Equip>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Equip equip;
		@Override
		public Equip getModel() {
			if(equip==null) equip = new Equip();
			return equip;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private EquipService equipService;
	
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
	public String equip(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Equip where 1=1 ");
		if(equip.getType() != null&&!"".equals(equip.getType())){
			sb.append(" and type = :type");
			alias.put("type",equip.getType());
		}
		if(equip.getPrice() != null&&!"".equals(equip.getPrice())){
			sb.append(" and price = :price");
			alias.put("price",equip.getPrice());
		}
		if(equip!=null && equip.getName() !=null && !"".equals(equip.getName())){
			sb.append("  and name like :name ");
			alias.put("name", "%" +equip.getName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<Equip> pagers = equipService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", equip);
		return SUCCESS;
    }
	
	public String equip1(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Equip where 1=1 ");
		if(equip.getType() != null&&!"".equals(equip.getType())){
			sb.append(" and type = :type");
			alias.put("type",equip.getType());
		}
		if(equip.getPrice() != null&&!"".equals(equip.getPrice())){
			sb.append(" and price = :price");
			alias.put("price",equip.getPrice());
		}
		sb = sb.append(" order by id desc");
		Pager<Equip> pagers = equipService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", equip);
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

		String newName = new String(equip.getName().getBytes("ISO8859-1"),"utf-8");
		equip.setName(newName);
		equip.setState(0);
		equipService.save(equip);
		ActionContext.getContext().put("url", "/equip_equip.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Equip n = equipService.getById(equip.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Equip n = equipService.getById(equip.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	public String update1(){
		Equip n = equipService.getById(equip.getId());
		if(n.getState()==null||n.getState()==1){
			n.setState(0);
		}else{
			n.setState(1);
		}
		equipService.update(n);
		ActionContext.getContext().put("url", "/equip_equip1.do");
		return "redirect";
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exUpdate() throws UnsupportedEncodingException{
		Equip n = equipService.getById(equip.getId());
		String newName = new String(equip.getName().getBytes("ISO8859-1"),"utf-8");

		n.setName(newName);
		n.setPrice(equip.getPrice());
		n.setType(equip.getType());
		equipService.update(n);
		ActionContext.getContext().put("url", "/equip_equip.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		equipService.delete(equip.getId());
		ActionContext.getContext().put("url", "/equip_equip.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
