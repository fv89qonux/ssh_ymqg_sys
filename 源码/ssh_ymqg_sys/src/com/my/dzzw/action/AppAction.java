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

@Controller("AppAction")
@Scope("prototype")
public class AppAction extends ActionSupport implements ModelDriven<App>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private App app;
		@Override
		public App getModel() {
			if(app==null) app = new App();
			return app;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private AppService appService;
	
	
	//============文件上传start=======================================================
    private File[] file; //上传的文件
    private String[] fileFileName; //文件名称
    private String[] fileContentType; //文件类型
    
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
	 //============文件上传end=========================================================
			
	 //-------------------------华丽分割线---------------------------------------------//

	//=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询
	 */
	public String app(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from App where 1=1 ");
		sb = sb.append("order by id desc");
		Pager<App> pagers = appService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", app);
		return SUCCESS;
    }
	
	/**
	 * 列表分页查询
	 */
	public String app2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from App where 1=1 ");
//		if(news.getTitle() != null ){
//			sb.append(" and title like :title");
//		}
		if(app.getType() != null){
			sb.append(" and type = :type");
		}
		sb = sb.append(" order by id desc");
//		if(news.getTitle() != null ){
//			alias.put("title", "%" +news.getTitle()+ "%");
//		}
		if(app.getType() != null){
			alias.put("type", app.getType());
		}
		Pager<App> pagers = appService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", app);
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
	 * @throws IOException 
	 */
	public String exAdd() throws IOException{
	    String root  = "D:/my/upload";
	    ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
        if (file != null) {
            File savedir=new File(root);
            if(!savedir.getParentFile().exists())
                savedir.getParentFile().mkdirs();
            for(int i=0;i<file.length;i++){
            	System.out.println(fileFileName[i]);
            	if(i==0){
            		app.setApp("\\upload\\"+fileFileName[0]);
            	}
            	if(i==1){
                    app.setPic1("\\upload\\"+fileFileName[1]);
            	}
            	if(i==2){
            		app.setPic2("\\upload\\"+fileFileName[2]);
            	}
            	if(i==3){
            		app.setPic3("\\upload\\"+fileFileName[3]);
            	}
            	if(i==4){
            		app.setPic4("\\upload\\"+fileFileName[4]);
            	}
            	if(i==5){
            		app.setPic5("\\upload\\"+fileFileName[5]);
            	}
                File savefile = new File(savedir, fileFileName[i]);
                FileUtils.copyFile(file[i], savefile);
            }
        }
		appService.save(app);
		ActionContext.getContext().put("url", "/App_app.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		App n = appService.getById(app.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		App n = appService.getById(app.getId());
		
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws IOException 
	 */
	
	private String ceshi[];
	

	public String[] getCeshi() {
		return ceshi;
	}

	public void setCeshi(String[] ceshi) {
		this.ceshi = ceshi;
	}

	public String exUpdate() throws IOException{
		App n = appService.getById(app.getId());
		String root  = "D:/my/upload";
	    ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
	    
	    if(file!=null){
            File savedir=new File(root);
            if(!savedir.getParentFile().exists())
            	savedir.getParentFile().mkdirs();
            
	    	for (int i = 0; i < file.length; i++) {
            	File savefile = new File(savedir, fileFileName[i]);
            	FileUtils.copyFile(file[i], savefile);	
			}
	    }
	    
	    n.setApp(null);
	    n.setPic1(null);
	    n.setPic2(null);
	    n.setPic3(null);
	    n.setPic4(null);
	    n.setPic5(null);
	    String[] aArray = new String[ceshi.length]; 
	    
		if(ceshi!=null){
            List<String> list = new ArrayList<String>();
			for (int j = 0; j < ceshi.length; j++) {
				if(!"".equals(ceshi[j])){
					list.add(ceshi[j]);
				}
			}
	
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i)!=null){            	
					String[] ss = list.get(i).split("\\\\");
	            	if(i==0&&list.get(i)!=null){
	            		n.setApp("\\upload\\"+ss[ss.length-1]);
	            	}
	            	if(i==1&&list.get(i)!=null){
	                    n.setPic1("\\upload\\"+ss[ss.length-1]);
	            	}
	            	if(i==2&&list.get(i)!=null){
	            		n.setPic2("\\upload\\"+ss[ss.length-1]);
	            	}
	            	if(i==3&&list.get(i)!=null){
	            		n.setPic3("\\upload\\"+ss[ss.length-1]);
	            	}
	            	if(i==4&&list.get(i)!=null){
	            		n.setPic4("\\upload\\"+ss[ss.length-1]);
	            	}
	            	if(i==5&&list.get(i)!=null){
	            		n.setPic5("\\upload\\"+ss[ss.length-1]);
	            	}
				}
			}
		}
		
		n.setType(app.getType());
		n.setName(app.getName());

		appService.update(n);
		ActionContext.getContext().put("url", "/App_app.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
//		App n = appService.getById(app.getId());
//		n.setIsDelete(1);
//		appService.update(n);
		appService.delete(app.getId());
		ActionContext.getContext().put("url", "/App_app.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
