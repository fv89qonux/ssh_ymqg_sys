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
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时47分57秒
 */

@Controller("newsAction")
@Scope("prototype")
public class NewsAction extends ActionSupport implements ModelDriven<News>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private News news;
		@Override
		public News getModel() {
			if(news==null) news = new News();
			return news;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private NewsService newsService;
	
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
	 */
	public String news(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from News where 1=1 and isDelete = 0 ");
		sb = sb.append("order by id desc");
		Pager<News> pagers = newsService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", news);
		return SUCCESS;
    }
	
	/**
	 * 列表分页查询
	 */
	public String news2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from News where 1=1 and isDelete = 0 ");
		if(news.getTitle() != null ){
			sb.append(" and title like :title");
		}
		if(news.getType() != null){
			sb.append(" and type = :type");
		}
		sb = sb.append(" order by id desc");
		if(news.getTitle() != null ){
			alias.put("title", "%" +news.getTitle()+ "%");
		}
		if(news.getType() != null){
			alias.put("type", news.getType());
		}
		Pager<News> pagers = newsService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", news);
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
		news.setIsDelete(0);
		news.setAddTime(new Date());
		newsService.save(news);
		ActionContext.getContext().put("url", "/news_news.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		News n = newsService.getById(news.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		News n = newsService.getById(news.getId());
		
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		News n = newsService.getById(news.getId());
		n.setContent(news.getContent());
		n.setTitle(news.getTitle());
		n.setType(news.getType());
		newsService.update(n);
		ActionContext.getContext().put("url", "/news_news.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		News n = newsService.getById(news.getId());
		n.setIsDelete(1);
		newsService.update(n);
		ActionContext.getContext().put("url", "/news_news.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
