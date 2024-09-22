package com.my.dzzw.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
 * @date 2015年12月24日 下午1:46:33 - 2017年01月25日 22时51分03秒
 */

@Controller("ziLiaoAction")
@Scope("prototype")
public class ZiLiaoAction extends ActionSupport implements ModelDriven<ZiLiao>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private ZiLiao ziLiao;
		@Override
		public ZiLiao getModel() {
			if(ziLiao==null) ziLiao = new ZiLiao();
			return ziLiao;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private ZiLiaoService ziLiaoService;
	
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
	public String ziLiao(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from ZiLiao where 1=1 ");
		sb = sb.append("order by id desc");
		Pager<ZiLiao> pagers = ziLiaoService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", ziLiao);
		return SUCCESS;
    }
	
	public String ziLiao2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from ZiLiao where 1=1 ");
		if(ziLiao.getTitle() != null ){
			sb.append(" and title like :title");
		}
		sb = sb.append(" order by id desc");
		if(ziLiao.getTitle() != null ){
			alias.put("title", "%" +ziLiao.getTitle()+ "%");
		}
		Pager<ZiLiao> pagers = ziLiaoService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", ziLiao);
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
        InputStream is = new FileInputStream(file);
        fileFileName = UUIDUtils.create()+fileFileName;
        OutputStream os = new FileOutputStream(new File(root, fileFileName));
        System.out.println("fileFileName: " + fileFileName);
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getPath());
        byte[] buffer = new byte[500];
        int length = 0;
        
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();
        ziLiao.setUrl2("\\upload\\"+fileFileName);
        ziLiao.setAddTime(new Date());
		ziLiaoService.save(ziLiao);
		ActionContext.getContext().put("url", "/ziLiao_ziLiao.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		ZiLiao n = ziLiaoService.getById(ziLiao.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		ZiLiao n = ziLiaoService.getById(ziLiao.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		ZiLiao n = ziLiaoService.getById(ziLiao.getId());
		ziLiaoService.update(n);
		ActionContext.getContext().put("url", "/ziLiao_ziLiao.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		ziLiaoService.delete(ziLiao.getId());
		ActionContext.getContext().put("url", "/ziLiao_ziLiao.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
