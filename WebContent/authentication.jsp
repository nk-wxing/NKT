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
</head>

<body>
	<!-- 顶部导航栏 -->
	<%@include file="top.jsp"%>

	<div class="container-fluid" style="margin-top: 50px;">
		<!-- 左侧导航栏 -->
		<c:choose>
			<c:when test="${user.isAdmin == 1}">
				<%@include file="left_admin.jsp"%>
			</c:when>
			<c:otherwise>
				<%@include file="left_user.jsp"%>
			</c:otherwise>
		</c:choose>
		
		<!-- 右侧列表 -->
		<div class="col-xs-10">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li><a herf="#">首页</a></li>
					<li class="active">管理员</li>
				</ol>
				<form class="col-xs-6 col-xs-offset-3" action="${pageContext.servletContext.contextPath}/NewsAddServlet" method="post">
					<input name="method" type="hidden" value="preAddNews"/>
					<legend>校园认证</legend>
					<div class="form-group">
						<label>姓名:</label>
						<input type="text" class="form-control" name="trueName" value=""/>
					</div>
					<div class="form-group">
						<label>学号:</label>
						<input type="text" class="form-control" name="sno" value=""/>
					</div>
					<div class="form-group">
						<label>身份证号:</label>
						<input type="text" class="form-control" name="idNumber" value=""/>
					</div>					
					<div class="form-group">
						<button type="submit" class="btn btn-success" onclick="">提交认证</button>
					</div>
					
				</form>				
			</div>			
		</div>
	</div>
</body>		
</html>