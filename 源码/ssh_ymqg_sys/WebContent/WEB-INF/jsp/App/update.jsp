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
   	<title>易购后台管理中心</title>  
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
<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
<div class="panel admin-panel margin-top">
	<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改管理员</strong></div>
	<div class="body-content">
		<form method="post" class="form-x" action="${ctx}/App_exUpdate.do" enctype="multipart/form-data" onsubmit="return toVaild()"> 
			<input type="hidden" name="id" value="${Obj.id}">  
			<div class="form-group">
				<div class="label">
					<label>应用名称</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" name="name" value="${Obj.name}" data-validate="required:请输入名称" />         
					<div class="tips"></div>
				</div>
			</div> 
			<div class="form-group">
				<div class="label">
					<label>分类：</label>
				</div>
				<div class="field">
					<select name="type" class="input w50">
						<option value="">请选择分类</option>
						<option value="电脑应用" <c:if test="${Obj.type=='电脑应用'}">selected="selected"</c:if>>电脑应用</option>
						<option value="手机应用" <c:if test="${Obj.type=='手机应用'}">selected="selected"</c:if>>手机应用</option>
					</select>
					<div class="tips"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>应用：</label>
				</div>
				<div class="field">
					<input type="file" class="button bg-blue margin-left"  name="file" onclick="getVal('test')" id="yy">
					<c:if test="${Obj.app !=null}">
							<input id="test" class="inputColor" type="text" value="${Obj.app}" style="border:0px;background-color:#0ae;margin-left:-224px;width:200px;font-size:14px;color:white;"/>
					</c:if>
				</div>
			</div>
			
			<div id="contentPic">
				<div class="form-group appPic">
					<div class="label">
						<label>截图:</label>
					</div>
					<div class="field">
						<input type="file" class="button bg-blue margin-left " value="${Obj.pic1}" name="file" onclick="getVal('test1')"> <input type="button" onclick="appendFile()" value="增加">
						<c:if test="${Obj.pic1 !=null}">
							<input id="test1" class="inputColor" type="text" value="${Obj.pic1}" style="border:0px;background-color:#0ae;margin-left:-270px;width:200px;font-size:14px;color:white;"/>
						</c:if>  
					</div>
				</div>
				<c:if test="${Obj.pic2 !=null}">
					<div class="form-group appPic">
						<div class="label">
							<label>截图:</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left " value="${Obj.pic2}" name="file" onclick="getVal('test2')"> <input type="button" onclick="appendFile()" value="增加"><input type="button" onclick="deleteFile(2)" value="删除">
							<input id="test2" class="inputColor" type="text" value="${Obj.pic2}" style="border:0px;background-color:#0ae;margin-left:-312px;width:200px;font-size:14px;color:white;"/>
						</div>
					</div>
				</c:if>
				<c:if test="${Obj.pic3 !=null}">
					<div class="form-group appPic">
						<div class="label">
							<label>截图:</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left " value="${Obj.pic3}" name="file" onclick="getVal('test3')"> <input type="button" onclick="appendFile()" value="增加"><input type="button" onclick="deleteFile(3)" value="删除">
							<input id="test3" class="inputColor" type="text" value="${Obj.pic3}" style="border:0px;background-color:#0ae;margin-left:-312px;width:200px;font-size:14px;color:white;"/>
						</div>
					</div>
				</c:if>
				<c:if test="${Obj.pic4 !=null}">
					<div class="form-group appPic">
						<div class="label">
							<label>截图:</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left " value="${Obj.pic4}" name="file" onclick="getVal('test4')"> <input type="button" onclick="appendFile()" value="增加"><input type="button" onclick="deleteFile(4)" value="删除">
							<input id="test4" class="inputColor" type="text" value="${Obj.pic4}" style="border:0px;background-color:#0ae;margin-left:-312px;width:200px;font-size:14px;color:white;"/>
						</div>
					</div>
				</c:if>
				<c:if test="${Obj.pic5 !=null}">
					<div class="form-group appPic">
						<div class="label">
							<label>截图:</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left " value="${Obj.pic5}" name="file" onclick="getVal('test5')"> <input type="button" onclick="appendFile()" value="增加"><input type="button" onclick="deleteFile(5)" value="删除">
							<input id="test5" class="inputColor" type="text" value="${Obj.pic5}" style="border:0px;background-color:#0ae;margin-left:-312px;width:200px;font-size:14px;color:white;"/>
						</div>
					</div>
				</c:if>
			</div>
			<div class="form-group">
				<div class="label">
				<label></label>
        		</div>
        		<div class="field">
          			<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        		</div>
      		</div>
      		<input type="hidden" value="${Obj.app}" name="ceshi" class="test">
      		<input type="hidden" value="${Obj.pic1}" name="ceshi" class="test1">
      		<input type="hidden" value="${Obj.pic2}" name="ceshi" class="test2">
      		<input type="hidden" value="${Obj.pic3}" name="ceshi" class="test3">
      		<input type="hidden" value="${Obj.pic4}" name="ceshi" class="test4">
      		<input type="hidden" value="${Obj.pic5}" name="ceshi" class="test5">
    	</form>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("input[name='file']").mouseover(function(){
		$(".inputColor").css("background-color","#3bd");

	}).mouseleave(function(){
		$(".inputColor").css("background-color","#0ae");
	})
});

	function getVal(val){
		$("#"+val).remove();
		$("."+val).val("");
	}
	
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
		return;
	}
	
	function deleteFile(num){
		for (var int = num; int <5 ; int++) {
			$("input[name='ceshi']").eq(num).val($("input[name='ceshi']").eq(num+1).val());
		}
		var len = $("#contentPic").find(".appPic").length;
		$("input[name='ceshi']").eq(len).val("");
		
		$("#contentPic").find(".appPic").eq(num-1).remove();
		var inp = $("#contentPic").find(".appPic");
		for(var i=0;i<inp.length;i++){
			$(inp).eq(i).find("input").eq(0).attr("name","file");
			$(inp).eq(i).find("input").eq(2).attr("onclick","deleteFile("+(i+1)+")");

		}
	}
	
	function toVaild(){
		var infile = $("input[name='file']");
		for (var int = 0; int < infile.length; int++) {
			if(int==0&&infile[int].value!=""){
				$(".test").val(infile[int].value);
			}else{
				if(infile[int].value!=""){
					$(".test"+int).val(infile[int].value);
				}
			}
		}

        var yy=$("#yy").val();
        var cyy=$(".test").val();
        if(yy==""&&cyy==""){
            alert("请上传应用文件");
          return false;
        }
	}

</script>
</html>