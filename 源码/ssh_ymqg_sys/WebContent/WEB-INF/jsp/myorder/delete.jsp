<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<title>表单</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="${ctx}/common/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${ctx}/common/plugins/font-awesome/css/font-awesome.min.css">
	</head>

	<body>
		<div style="margin: 15px;">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>删除订单</legend>
			</fieldset>

			<form class="layui-form" action="${ctx}/myorder_exDelete.do" onsubmit="return checkForm()" enctype="multipart/form-data" onsubmit="return toVaild()">
				<input type="hidden" value="${order.id}" name="id">
				<input type="hidden" value="${order.state}" name="state">

				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">用户名</label>
						<div class="layui-input-block">
							<input type="text" autocomplete="off" class="layui-input" value="" id="uName">
						</div>
				</div>
				</div>
				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-block">
							<input type="text" autocomplete="off" class="layui-input" value="" id="uPassWord">
						</div>
				</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn">取消预定</button>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="${ctx}/common/plugins/layui/layui.js"></script>
		<script language="JavaScript">
			layui.use(['form', 'layedit', 'laydate'], function() {
				  var laydate = layui.laydate;
				  
				  var start = {
				    min: laydate.now()
				    ,max: '2099-06-16 23:59:59'
				    ,istoday: true
				    ,choose: function(datas){

				    }
				  };
				 
				  document.getElementById('LAY_demorange_s').onclick = function(){
				    start.elem = this;
				    laydate(start);
				  }
			});
			
			var name = ${user.userName};
			var passWord = ${user.passWord};
			
			function checkForm(){
				var name = ${user.userName};
				var passWord = ${user.passWord};
				var ye =  ${user.ye};
				if($("#uName").val()!=name||$("#uPassWord").val()!=passWord){
					alert("用户名或密码错误");
					return false;
				}else{
					$("#layui-form").submit();
				}
			}
		</script>
	</body>

</html>