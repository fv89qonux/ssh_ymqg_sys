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

			<fieldset class="layui-elem-field">
				<legend>个人信息</legend>
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
              <div class="button-group"> <a class="layui-btn layui-btn-mini" href="${ctx}/tuser_update2.do?id=${data.id}">修改</a></div>
           </td>
        </tr>
       </c:forEach>
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