package com.my.dzzw.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.dzzw.model.Cashier;
import com.my.dzzw.model.Manage;
import com.my.dzzw.model.News;
import com.my.dzzw.model.User;
import com.my.dzzw.service.CashierService;
import com.my.dzzw.service.ManageService;
import com.my.dzzw.service.NewsService;
import com.my.dzzw.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

//============依赖注入start================
		@Autowired
		private ManageService manageService;//管理
		@Autowired
		private UserService userService;//用户
		@Autowired
		private CashierService cashierService;//用户
		@Autowired
		private NewsService newsService;
		
		
		//===========依赖注入end==================
		
		//-------------------------华丽分割线---------------------------------------------
		
		//============自定义参数start=============
		 private String userName;
		   private String passWord;
		   private String phone;//手机号
			private String realName;//真实名
			private String email;
			private String newName;
		   public String getNewName() {
				return newName;
			}
			public void setNewName(String newName) {
				this.newName = newName;
			}
		public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
		public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getRealName() {
				return realName;
			}
			public void setRealName(String realName) {
				this.realName = realName;
			}

		   private int role;
		   private String key;
		   
		   private Integer keyword1;
		   private Integer keyword2;
		   
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Integer getKeyword1() {
			return keyword1;
		}
		public void setKeyword1(Integer keyword1) {
			this.keyword1 = keyword1;
		}
		public Integer getKeyword2() {
			return keyword2;
		}
		public void setKeyword2(Integer keyword2) {
			this.keyword2 = keyword2;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		//============自定义参数end=============
		
		//-------------------------华丽分割线---------------------------------------------
		
		//============文件上传start=============
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
		//============文件上传end=============
		
       //登录
		public String toLogin(){		
			if(role==1){//用户
				String hql = "from User where userName = :userName and passWord = :passWord";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				  List<User> userList= userService.getByHQL(hql, alias);
				if(userList.size()>0){
					//将用户信息放入session
					HttpSession session = ServletActionContext.getRequest()
							.getSession();
					session.setAttribute("userId",userList.get(0).getId() );
					session.setAttribute("user", userList.get(0));
					session.setAttribute("roleId", role);
					ActionContext.getContext().put("userId", userList.get(0).getId());
					ActionContext.getContext().put("userName", userName);
					ActionContext.getContext().put("role", role);
					return "manageIndex";
				}else{
					return "manageLogin";
				}
			}else if(role==2){//收银员
				String hql = "from Cashier where name = :userName and passWord = :passWord";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				List<Cashier> cashierList=cashierService.getByHQL(hql, alias);
				if(cashierList.size()>0){
					//将用户信息放入session
					HttpSession session = ServletActionContext.getRequest()
							.getSession();
					session.setAttribute("userId2",cashierList.get(0).getId() );
					session.setAttribute("manage", cashierList.get(0));
					session.setAttribute("roleId", role);
					ActionContext.getContext().put("role", role);
					ActionContext.getContext().put("userName", userName);
					return "manageIndex";
				}else{
					return "manageLogin";
				}
			}else{
				String hql = "from Manage where name = :userName and passWord = :passWord and key = :key";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				  alias.put("key", key);
				List<Manage> manageList=manageService.getByHQL(hql, alias);
				if(manageList.size()>0){
					//将用户信息放入session
					HttpSession session = ServletActionContext.getRequest()
							.getSession();
					session.setAttribute("userId2",manageList.get(0).getId() );
					session.setAttribute("manage", manageList.get(0));
					session.setAttribute("roleId", role);
					ActionContext.getContext().put("role", role);
					ActionContext.getContext().put("userName", userName);
					return "manageIndex";
				}else{
					return "manageLogin";
				}	
			}
		}
		
		   //退出
			public String tuichu() {
				ActionContext ac = ActionContext.getContext();
				Map session = ac.getSession();
				session.remove("userName");
				session.remove("userId");
				session.remove("role");
				return "manageLogin";
			}
			
			public String welcome(){
				return SUCCESS;
			}
	
}
