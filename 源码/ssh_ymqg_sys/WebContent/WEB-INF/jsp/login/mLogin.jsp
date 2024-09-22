<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>管理员登录</title> 
<link href="${ctx}/common/css/login.css" type="text/css" rel="stylesheet">

<!-- 网页图标 -->
<link rel = " shortcut icon" href = "${ctx}/common/picture/icon.png">

</head> 
<body> 

<div class="login">
    <div class="message">
    	<select id="roleType" style=" height: 30px;border-color: #27A9E3;background-color: #27A9E3;font-size: 20px;color: white;">
    		<option value="1" style="font-size:20px;">用户登录</option>
    		<option value="2" style="font-size:20px;">收银员登录</option>
    		<option value="3" style="font-size:20px;">管理员登录</option>
    	</select>
    </div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="${ctx}/login_toLogin.do">
		<input name="role" value="1" type="hidden">
		<input name="userName" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="passWord" placeholder="密码" required="" type="password">
		<div id="my" style="display: none;">
			<hr class="hr15">
			<input name="key" placeholder="密钥" type="password">
		</div>
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
	</form>

	
</div>
<script type="text/javascript">
	$(function(){
		$("#roleType").change(function(){  
			$("input[name='role']").val($(this).val());
			if($(this).val()==3){
				$("#my").show();
			}else{
				$("#my").hide();
			}
		});
	});
</script>
</body>
</html>