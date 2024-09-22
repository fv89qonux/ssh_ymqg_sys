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
				<legend>新增会员</legend>
			</fieldset>

			<form class="layui-form" action="${ctx}/tuser_exUpdate.do" enctype="multipart/form-data" onsubmit="return toVaild()">
				<input type="hidden" name="id" value="${Obj.id}">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">真实姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="realName" autocomplete="off" class="layui-input" value="${Obj.realName}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">会员名</label>
						<div class="layui-input-inline">
							<input type="text" name="userName" autocomplete="off" class="layui-input" value="${Obj.userName}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-inline">
							<input type="text" name="passWord" autocomplete="off" class="layui-input" value="${Obj.passWord}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-inline">
							<input type="text" name="phone" autocomplete="off" class="layui-input" value="${Obj.phone}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">余额</label>
						<div class="layui-input-inline">
							<input type="text" name="ye" autocomplete="off" class="layui-input" value="${Obj.ye}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">生日</label>
						<div class="layui-input-block">
							<input type="text" name="brithday" id="date"  placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})" value="${Obj.brithday}">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
						<label class="layui-form-label">会员等级:</label>
						<div class="layui-input-block" style="width: 190px;">
							<select name="level" lay-filter="leixin" id="leixing">
								<option></option>
								<option value="0">一级</option>
								<option value="1">二级</option>
								<option value="2">三级</option>
							</select>
						</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">性别:</label>
					<div class="layui-input-block" style="width: 190px;">
						<select name="sex" lay-filter="zhungtai" id="zhuangtai">
							<option></option>
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" type="submit">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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