<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>Table</title>
		<link rel="stylesheet" href="${ctx}/common/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${ctx}/common/css/global.css" media="all">
		<link rel="stylesheet" href="${ctx}/common/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${ctx}/common/css/table.css" />
		<script type="text/javascript" src="${ctx}/common/plugins/layui/layui.js"></script>
	</head>

	<body>
		<div class="admin-main">

			<blockquote class="layui-elem-quote">
			<form class="layui-form" method="post" action="${ctx}/tuser_user1.do" id="listform">
				<table>
					<tr>
						<td style="width:20%;">					
							<label class="layui-form-label">真实姓名:</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" name="realName" value="${Obj.realName}">
							</div>
						</td>
						<td style="width:20%;">					
							<label class="layui-form-label">手机号码:</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" name="phone" value="${Obj.phone}">
							</div>
						</td>
						<td style="width:20%;">
							<label class="layui-form-label">会员性别:</label>
							<div class="layui-input-block" style="width: 190px;">
								<select name="sex" lay-filter="zhungtai" id="zhuangtai">
									<option></option>
									<option value="0">男</option>
									<option value="1">女</option>
								</select>
							</div>
						</td>
						<td>
							<a href="javascript:;" class="layui-btn layui-btn-small" id="search" onclick="changesearch()">
							<i class="layui-icon">&#xe615;</i> 查找会员
							</a>
						</td>
					</tr>
				</table>
			</form>

			</blockquote>
			<fieldset class="layui-elem-field">
				<div class="layui-field-box">
					<table class="site-table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>真实姓名</th>
								<th>会员名</th>
								<th>密码</th>
								<th>电话号码</th>
								<th>余额</th>
								<th>生日</th>
								<th>会员等级</th>
								<th>性别</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
        <c:forEach items="${pagers.datas}" var="data" varStatus="l">
        <tr>
           <td>${data.id}</td>
           <td>${data.realName}</td>
           <td>${data.userName}</td>
           <td>${data.passWord}</td>
           <td>${data.phone}</td>
           <td>${data.ye}</td>
           <td>${data.brithday}</td>
           <td>
           		<c:if test="${data.level == 0}">
           		一级
            	</c:if>
            	           		<c:if test="${data.level == 1}">
           		二级
            	</c:if>
            	           		<c:if test="${data.level == 2}">
           		三级
            	</c:if>
           </td>
           <td>
               <c:if test="${data.sex == 0}">
           		男
            	</c:if>
            	               <c:if test="${data.sex == 1}">
           		女
            	</c:if>

           </td>
           <td>
              <div class="button-group"> <a class="layui-btn layui-btn-mini" href="${ctx}/tuser_update1.do?id=${data.id}">充值</a></div>
           </td>
        </tr>
       </c:forEach>
       <tr>
        <td colspan="10"><div class="pagelist">
        <!-- 分页开始 -->
			      <pg:pager  url="${ctx}/tuser_user1.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			        
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
      </tr>
		</tbody>
	</table>

	</div>
	</fieldset>
		</div>
		<script>
		layui.use(['form', 'layedit', 'laydate'], function() {

		});
		
		function changesearch(){	
			$("#listform").submit();
		}
		
		layui.config({
			base: 'common/plugins/layui/modules/'
		});

		layui.use(['icheck', 'laypage','layer'], function() {

			$('#search').on('click', function() {
				
			});


			$('.site-table tbody tr').on('click', function(event) {
				var $this = $(this);
				var $input = $this.children('td').eq(0).find('input');
				$input.on('ifChecked', function(e) {
					$this.css('background-color', '#EEEEEE');
				});
				$input.on('ifUnchecked', function(e) {
					$this.removeAttr('style');
				});
				$input.iCheck('toggle');
			}).find('input').each(function() {
				var $this = $(this);
				$this.on('ifChecked', function(e) {
					$this.parents('tr').css('background-color', '#EEEEEE');
				});
				$this.on('ifUnchecked', function(e) {
					$this.parents('tr').removeAttr('style');
				});
			});
			$('#selected-all').on('ifChanged', function(event) {
				var $input = $('.site-table tbody tr td').find('input');
				$input.iCheck(event.currentTarget.checked ? 'check' : 'uncheck');
			});
		})
		</script>
	</body>

</html>