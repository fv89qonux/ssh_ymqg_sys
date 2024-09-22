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
        	<form action="${ctx }/ziLiao_ziLiao2.do">
           <input class="s_txt" type="text" name="title" value="${Obj.title }"/>
            <input class="s_sc" type="submit" />
        </form>
        </div>
	</div>   
</div>
<div style="clear: both"></div>
<!--工作动态列表部分-->
<div class="gzdt">
	<div class="gzdt_tit">
		<div class="gzdt_le">
			<p>当前位置：首页->资料下载</p>
		</div>
		<div class="gzdt_rig">
		<!-- private Integer type;//类型 1政务公开 2. 通知公告 3.人事信息 4.规划计划 5.新闻 -->
			<p>当前位置：首页->资料下载</p>
		</div>
	</div>
	
	<div class="gzdt_list">
	
	 <c:forEach items="${pagers.datas}" var="data" varStatus="l">
	 <div class="list_a">
			<div class="list_jt">
					<img src="images/list_a.gif" width="5" height="7" >
			</div>
			<div class="list_tit">
				<a target="_blank" class="list01" href="${ctx}/DownLoadServlet?curfile=${data.title}&path=${data.url2}"; title="">${data.title}
				</a>
			</div>
			<div class="list_time">
				${data.addTime}
			</div>
		
		</div>
       </c:forEach>
	
		
		
	</div>
	<div id="paging" style="width: 480px;">
					 <!-- 分页开始 -->
			      <pg:pager  url="${ctx}/ziLiao_ziLiao2.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			        
			        <pg:param name="title" value="${Obj.title}"/>
					<pg:last>  
						共${pagers.total}记录,共${pageNumber}页,  
					</pg:last>  
						当前第${curPage}页 
			        <pg:first>  
			    		<a href="${pageUrl}">首页</a>  
					</pg:first>  
					<pg:prev>  
			    		<a href="${pageUrl}">上一页</a>  
					</pg:prev>  
			       	<pg:pages>  
			        	<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">[${pageNumber }]</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">${pageNumber}</a>  
			            	</c:otherwise>  
			        	</c:choose>  
			    	</pg:pages>
			             
			        <pg:next>  
			    		<a href="${pageUrl}">下一页</a>  
					</pg:next>  
					<pg:last>  
						<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">尾页</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">尾页</a>  
			            	</c:otherwise>  
			        	</c:choose> 
			    		  
					</pg:last>
				</pg:pager>
				 </div></td>
                    <!-- 分页结束 -->
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