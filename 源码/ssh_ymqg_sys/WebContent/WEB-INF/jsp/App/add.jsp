<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
   	<title>后台管理中心</title>  
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>  
    <script type="text/javascript" src="${ctx}/resource/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/ueditor/ueditor.all.min.js"></script>
</head>
<style>
    .file1 {
        position: relative;
        display: inline-block;
        background: #D0EEFF;
        border: 1px solid #99D3F5;
        border-radius: 4px;
        padding: 4px 12px;
        overflow: hidden;
        color: #1E88C7;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
    }
    .file1 input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }
    .file1:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }
</style>
<body>
<div class="panel admin-panel margin-top">
	<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加</strong></div>
	<div class="body-content">
		<form method="post" class="form-x" action="${ctx}/App_exAdd.do" enctype="multipart/form-data" onsubmit="return toVaild()">   
			<div class="form-group">
				<div class="label">
					<label>应用名称:</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" name="name" value="" data-validate="required:请输入名称" />         
					<div class="tips"></div>
				</div>
			</div>
      
			<div class="form-group">
				<div class="label">
					<label>分类:</label>
				</div>
				<div class="field">
					<select name="type" class="input w50">
			            <option value="">请选择分类</option>
			            <option value="电脑应用">电脑应用</option>
			            <option value="手机应用" >手机应用</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="label">
					<label>应用:</label>
				</div>
				<div class="field">
					<input type="file" class="button bg-blue margin-left" value="+ 浏览上传" name="file" id="yy" >
				</div>
			</div>
			
			<div id="contentPic">
				<div class="form-group appPic">
					<div class="label">
						<label>截图:</label>
					</div>
					<div class="field">
						<input type="file" class="button bg-blue margin-left " value="+ 浏览上传" name="file" > <input type="button" onclick="appendFile()" value="增加">
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="label">
					<label></label>
				</div>
				<div class="field">
					<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
<script type="text/javascript">

	function appendFile(){
		var len = $(".appPic").length;
		if(len==5){
			alert("最多能支持5张图片");
			return;
		}
		var text = "<div class='form-group appPic'>";
			text = text+"<div class='label'>";
			text = text+"<label>截图:</label>";
			text = text+"</div><div class='field'>";
			text = text+"<input type='file' class='button bg-blue margin-left' value='+ 浏览上传' name='file' > <input type='button' onclick='appendFile()' value='增加'><input type='button' onclick='deleteFile("+(len+1)+")' value='删除'>";
			text = text+"</div></div>";
		$("#contentPic").append(text);
	}
	
	function deleteFile(num){
		 $("#contentPic").find(".appPic").eq(num-1).remove();
		 var inp = $("#contentPic").find(".appPic");
		 for(var i=0;i<inp.length;i++){
			 $(inp).eq(i).find("input").eq(0).attr("name","file");
			 $(inp).eq(i).find("input").eq(2).attr("onclick","deleteFile("+(i+1)+")");

		 }
	}
	
	function toVaild(){
        var s=$("#yy").val();
        if(s==""){
            alert("请上传应用文件");
            return false;
        }
	}

</script>
</html>