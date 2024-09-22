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

			<form class="layui-form" action="${ctx}/myorder_exUpdate.do"enctype="multipart/form-data" onsubmit="return toVaild()">
				<input type="hidden" name="id" value="${Obj.id}">
				<input type="hidden" name="stat" value="${Obj.state}">
				<input type="hidden" name="price" value="${area.price}">
				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">选择日期</label>
						<div class="layui-input-block">
							<select name="state" lay-filter="leixin" id="leixing">
								<option value="1">完成订单</option>
								<option value="3">失效订单</option>
							</select>
						</div>
				</div>
				</div>
			
				<div class="layui-form-item">
				<div class="layui-inline">
						<label class="layui-form-label">消费金额</label>
						<div class="layui-input-block">
							<input type="text" id ="consume" name="consume" autocomplete="off" class="layui-input">
						</div>
				</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn">结算</button>
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
			
			var sj = "${Obj.time}";
			var jg = "${area.price}";
			var timestamp1 = Date.parse(new Date());
			var timestamp2 = Date.parse(new Date(sj));
			var min = (timestamp1-timestamp2)/1000/60;
			
			var zhengshu = parseInt(min/30);
			if(min%30>=15){
				zhengshu = zhengshu+1;
			}
			var price = zhengshu*jg;
			
			if(price<0){
				$("#consume").val(0);
			}else{
				$("#consume").val(price);
			}
			
			
		</script>
	</body>

</html>