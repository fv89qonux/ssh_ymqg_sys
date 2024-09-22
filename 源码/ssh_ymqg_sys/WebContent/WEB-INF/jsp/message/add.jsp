<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>


<script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/MyCxcPlug.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resource/css2/style.css">
<link >
<link href="${ctx}/resource/css2/YJUI_Style.css" rel="stylesheet" type="text/css" />
<!--//theme-style-->
<script type="text/javascript">
	$(function(){
		var maxCount = 500;  // 最高字数，这个值可以自己配置
		$("#txtContent").on('keyup', function() {
			var len = getStrLength(this.value);
			$(".count").html(len);
			if(len>500){
				$(".beyond").html(len-maxCount);
			}
			else{
				$(".count").html(len);
			}
		})
	})
	 
	// 中文字符判断
	function getStrLength(str) { 
		var len = str.length; 
		var reLen = 0; 
		for (var i = 0; i < len; i++) {        
			if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) { 
				// 全角    
				reLen += 2; 
			} else { 
				reLen++; 
			} 
		} 
		return reLen;    
	}


	/* $(function(){
		$("#btnsub").click(function(){
			if($("#txtContent").val()==''){
				 alert ("请填写举报申诉事件，我们将为您真诚服务！");
			}else {
				alert ("您的举报申诉事件已提交，我们将尽快处理！");
				//$("#form1").submit();
			}
		
		  });
		  
		  
	}); */
</script>
</head>
<body>
<div class="indexCont">
	<div class="headerCont">
	<c:if test="${userId == null }">
	<span class="header"><em class="m20">您好，欢迎来到衡阳电子政务网！您还未登陆，请<b><a href="${ctx}/login_ulogin.do" >【登录】</a></b></em></span>
	</c:if>
	<c:if test="${userId != null }">
	欢迎您：${user.realName}
	</c:if>
	<span class="fl"><img src="${ctx}/resource/images/logo2.png" width="1000" height="180"/></span>
	<div class="menu_nav clearfix">
        <ul class="nav_content">
            <li style="margin-left: -20px;"><a href="${ctx}/login_uIndex.do">网站首页</a></li>
            <li><a href="${ctx}/ziLiao_ziLiao2.do">资料下载</a></li>
            <li><a href="${ctx}/message_add.do?type=4">建言献策</a></li>
            <li><a href="${ctx}/message_add.do?type=3">举报投诉</a></li>
            <li><a href="${ctx}/message_add.do?type=2">公众来电</a></li>
            <li><a href="${ctx}/message_add.do?type=1">领导信箱</a></li>
        </ul>
	    <div class="menu_nav_right"></div>
	</div>   
</div>
<div style="clear: both"></div>
<!--意见反馈部分-->
<div id="about" style="min-height:400px;">
	<div id="yjfk">
		<form  class="sub_yj" id=form1 action="${ctx}/message_exAdd.do?type=${Obj.type}" method="post" target=_blank>
		
			<p>请输入内容！</p>
		
			<div class="textarea">
				<textarea name="content" id="txtContent" placeholder="您的联系方式（手机、邮箱、QQ等）对我们非常重要！"></textarea>
			</div>
			<div class="txt_tz">
			最多可以输入500个字符，已输入
			<span class="count">0</span>
			个字符，超过
			<span class="beyond">0</span>
			个字符
			</div>
			<input type="submit" name="submit" id="btnsub" value="提交">
		</form>
		
	</div>
</div>
<div class="indexCont">
     <div class="footer">
        <div class="f_line_top"></div>
        <span class="f_txt">
        	<p>版权所有 衡阳电子在政务网站Copyright© 2017 All Rights Reserved </p>
        	<p>地址:衡阳市XXXXXXXXXXXXXXXXXXX　　电话:XXXX-XXXXXXXXX</p>
        </span>
    </div>
</div>
</div>
</body>
</html>