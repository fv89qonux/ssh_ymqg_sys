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
				<legend>新增订单</legend>
			</fieldset>

			<form class="layui-form" action="${ctx}/myorder_exAdd.do" onsubmit="return checkForm()" enctype="multipart/form-data" onsubmit="return toVaild()">
				<input type="hidden" value="${userId}" name="user.id">
				<input type="hidden" value="2" name="state">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">选择场地</label>
						<div class="layui-input-block" style="width: 190px;">
							<select name="area.id" >
							<c:forEach items="${areas}" var="data" varStatus="l">
								<option value="${data.id}">场地${data.id}
									           		<c:if test="${data.type == 0}">
           		专业场
            	</c:if>
            	           		<c:if test="${data.type == 1}">
           		贵宾场
            	</c:if>
            	           		<c:if test="${data.type == 2}">
           		高级场
            	</c:if>
            	           		<c:if test="${data.type == 3}">
           		标准场
            	</c:if>
            	           		<c:if test="${data.type == 4}">
           		普通场
            	</c:if>
								</option>
							</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">选择日期</label>
						<div class="layui-input-block">
							<input type="text" name="time" id="LAY_demorange_s" placeholder="yyyy-mm-dd hh:mm:ss" autocomplete="off" class="layui-input">
						</div>
				</div>
				</div>
				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">预定费用</label>
						<div class="layui-input-block">
							<input type="text" name="price"autocomplete="off" class="layui-input" value="100" readonly="readonly">
						</div>
				</div>
				</div>
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
						<button class="layui-btn">预定</button>
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
				    ,istoday: true,
				    format: 'YYYY-MM-DD hh:mm:ss'
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
			var ye =  ${user.ye};
			
			function checkForm(){
				var name = ${user.userName};
				var passWord = ${user.passWord};
				var ye =  ${user.ye};
  				if(ye<100){
					alert("余额不足");
					return false;
				}else if($("#uName").val()!=name||$("#uPassWord").val()!=passWord){
					alert("用户名或密码错误");
					return false;
				}else{
					
				}
				$("#layui-form").submit();
			}
		</script>
	</body>

</html>