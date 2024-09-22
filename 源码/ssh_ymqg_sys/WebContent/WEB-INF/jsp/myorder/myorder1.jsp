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
				<legend>订单列表</legend>
				<a href="${ctx}/myorder_add1.do" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 新增订单
				</a>
				<div class="layui-field-box">
					<table class="site-table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>场地</th>
								<th>日期</th>
								<th>状态</th>
								<th>消费金额</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
        <c:forEach items="${pagers.datas}" var="data" varStatus="l">
        <tr>
           <td>${data.id}</td>
           <td>场地${data.area.id}
                      		<c:if test="${data.area.type == 0}">
           		专业场
            	</c:if>
            	           		<c:if test="${data.area.type == 1}">
           		贵宾场
            	</c:if>
            	           		<c:if test="${data.area.type == 2}">
           		高级场
            	</c:if>
            	           		<c:if test="${data.area.type == 3}">
           		标准场
            	</c:if>
            	           		<c:if test="${data.area.type == 4}">
           		普通场
            	</c:if>
           </td>
           <td>${data.time}</td>
           <td>
                                 		<c:if test="${data.state == 0}">
           		正常订单
            	</c:if>
            	           		<c:if test="${data.state == 1}">
           		完成订单
            	</c:if>
            	           		<c:if test="${data.state == 2}">
           		预定订单
            	</c:if>
            	           		<c:if test="${data.state == 3}">
           		失效订单
            	</c:if>

           </td>
           <td>${data.consume}</td>
           <td>
              <div class="button-group">
             	           		<c:if test="${data.state == 0}">
           		<a class="layui-btn layui-btn-danger layui-btn-mini" href="${ctx}/myorder_update.do?id=${data.id}">结算</a>
            	</c:if>
            	             	           		<c:if test="${data.state == 2}">
           		<a class="layui-btn layui-btn-danger layui-btn-mini" href="${ctx}/myorder_update.do?id=${data.id}">结算</a>
            	</c:if>
              

              </div>
           </td>
        </tr>
       </c:forEach>
       <tr>
        <td colspan="8"><div class="pagelist">
        <!-- 分页开始 -->
			      <pg:pager  url="${ctx}/myorder_myorder1.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			        
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