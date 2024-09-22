<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>


<script type="text/javascript" src="${ctx}/resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/MyCxcPlug.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resource/css2/style.css">
<link >
<link href="${ctx}/resource/css2/YJUI_Style.css" rel="stylesheet" type="text/css" />
<!--//theme-style-->

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
        
        <div class="search">
        	<input class="s_txt" type="text"/>
            <input class="s_sc" type="button" value=""/>
        </div>
	</div>   
</div>
<div style="clear: both"></div>
<!--工作动态列表部分-->
<div class="gzdt">
	<div class="gzdt_tit">
		<div class="dtnr_le">
			<p>您当前的位置：详情 </p>
		</div>
	</div>
	<div class="dt_cont">
		<div class="dt_tit">
			<p class="title_p">${Obj.title }</p>
		</div>
		<div class="dt_xx" >
            <div class="dt_time">
                <p class="time_p1">时间：${Obj.addTime }</p>
            </div>
            <div class="dt_time">
            </div>
        </div>
		<div class="line"></div>
			<div class="news_content">
                    <div>
                     ${Obj.content }
                    </div>

                </div>
	</div>
</div>
<div style="clear: both"></div>
<!--尾部-->
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