package com.my.dzzw.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.dzzw.utils.Pager;
import com.my.dzzw.utils.UUIDUtils;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

import com.my.dzzw.model.*;
import com.my.dzzw.dao.*;
import com.my.dzzw.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时47分57秒
 */

@Controller("areaAction")
@Scope("prototype")
public class AreaAction extends ActionSupport implements ModelDriven<Area>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private Area area;
		@Override
		public Area getModel() {
			if(area==null) area = new Area();
			return area;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private AreaService areaService;


	/**
	 * 列表分页查询
	 */
	public String area(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Area where 1=1 ");
		if(area.getPrice() != null){
			sb.append(" and price = :price");
			alias.put("price", area.getPrice());
		}
		if(area.getState() != null&&!"".equals(area.getState())){
			sb.append(" and state = :state");
			alias.put("state", area.getState());
		}
		if(area.getType() != null&&!"".equals(area.getType())){
			sb.append(" and type = :type");
			alias.put("type", area.getType());
		}
		sb = sb.append(" order by id desc");

		Pager<Area> pagers = areaService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", area);
		return SUCCESS;
    }
	
	public String area1(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Area where 1=1 and state =0 ");
		if(area.getPrice() != null){
			sb.append(" and price = :price");
			alias.put("price", area.getPrice());
		}
		if(area.getUseState() != null&&!"".equals(area.getUseState())){
			sb.append(" and useState = :useState");
			alias.put("useState", area.getUseState());
		}
		if(area.getType() != null&&!"".equals(area.getType())){
			sb.append(" and type = :type");
			alias.put("type", area.getType());
		}
		sb = sb.append(" order by id desc");

		Pager<Area> pagers = areaService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", area);
		return SUCCESS;
    }
	
	/**
	 * 列表分页查询
	 */
	public String area2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Area where 1=1 and state =0 ");
		if(area.getPrice() != null){
			sb.append(" and price = :price");
			alias.put("price", area.getPrice());
		}
		if(area.getUseState() != null&&!"".equals(area.getUseState())){
			sb.append(" and useState = :useState");
			alias.put("useState", area.getUseState());
		}
		if(area.getType() != null&&!"".equals(area.getType())){
			sb.append(" and type = :type");
			alias.put("type", area.getType());
		}
		sb = sb.append(" order by id desc");

		Pager<Area> pagers = areaService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", area);
		return SUCCESS;
    }
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		
		return SUCCESS;
	}
	
	public String exAdd(){
		areaService.save(area);
		ActionContext.getContext().put("url", "/area_area.do");
		return "redirect";
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Area n = areaService.getById(area.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	public String update1(){
		Area n = areaService.getById(area.getId());
		if(n.getUseState()==null||n.getUseState()==1||n.getUseState()==0){
			n.setUseState(2);
		}else{
			n.setUseState(0);	
		}
		areaService.save(n);
		ActionContext.getContext().put("url", "/area_area1.do");
		return "redirect";
	}

	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		areaService.delete(area.getId());
		ActionContext.getContext().put("url", "/area_area.do");
		return "redirect";
	}
	
	public String exUpdate() {
		Area n = areaService.getById(area.getId());
		n.setPrice(area.getPrice());
		n.setType(area.getType());
		n.setState(area.getState());
		areaService.update(n);
		ActionContext.getContext().put("url", "/area_area.do");
		return "redirect";
	}

	
	
}
