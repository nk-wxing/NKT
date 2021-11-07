<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>发布信息</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		function check(){
			var tname = document.getElementById("tname");
			if(tname.value == "") {
				alert("请输入主题名称！");
				tname.focus();
				return false;
			}
			//验证新旧主题名是否一致，若一致拦截
			var tname_old = document.getElementById("oldTname").value;
			if(tname.value == tname_old) {
				alert("修改后的主题名不能与原主题名相同！");
				tname.focus();
				return false;
			}
			return true;
		}

	</script>

</head>

<body>
	<!-- 顶部导航栏 -->
	<%@include file="top.jsp"%>

	<div class="container-fluid" style="margin-top: 50px;">
		<!-- 左侧导航栏 -->
		<%@include file="left_admin.jsp"%>
		
		<!-- 右侧列表 -->
		<div class="col-xs-10">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li><a herf="#">首页</a></li>
					<li class="active">管理员</li>
				</ol>
				<form class="col-xs-6 col-xs-offset-3" action="${pageContext.servletContext.contextPath}/TopicServlet" method="post">
					<input name="method" type="hidden" value="editTopic"/>
					<input name="tid" type="hidden" value="${topic.tid}"/>
					<input id="oldTname" type="hidden" value="${topic.tname}"/>
					<legend>修改主题</legend>				
					<div class="form-group">
						<label>主题名称:</label>
						<input type="text" class="form-control" id="tname" name="tname" value="${topic.tname }"/>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-success" onclick="return check()">提交</button>
					</div>
					
				</form>

				
			</div>			
		</div>				
	</div>
</div>


</body>
</html>