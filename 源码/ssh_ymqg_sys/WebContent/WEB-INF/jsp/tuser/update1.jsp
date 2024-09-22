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
				<legend>充值</legend>
			</fieldset>

			<form class="layui-form" action="${ctx}/tuser_exUpdate1.do" enctype="multipart/form-data" onsubmit="return toVaild()">
				<input type="hidden" name="id" value="${Obj.id}">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">充值金额</label>
						<div class="layui-input-inline">
							<input type="text" name="ye" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">真实姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="realName" autocomplete="off" class="layui-input" value="${Obj.realName}" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">会员名</label>
						<div class="layui-input-inline">
							<input readonly="readonly" type="text" name="userName" autocomplete="off" class="layui-input" value="${Obj.userName}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-inline">
							<input readonly="readonly" type="text" name="passWord" autocomplete="off" class="layui-input" value="${Obj.passWord}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-inline">
							<input readonly="readonly" type="text" name="phone" autocomplete="off" class="layui-input" value="${Obj.phone}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" type="submit">充值</button>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="${ctx}/common/plugins/layui/layui.js"></script>
		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {

			});
 			var leixing = ${Obj.level};
			var zhuangtai = ${Obj.sex};

 			$(function(){
				 $("#leixing").find("option[value="+leixing+"]").attr("selected",true);
				 $("#zhuangtai").find("option[value="+zhuangtai+"]").attr("selected",true);
			}) 
		</script>
	</body>

</html>