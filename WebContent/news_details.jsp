<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>校园那些事</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/news.css"/>
</head>
<body>
	<!-- 顶部导航栏 -->
	<%@include file="top_news.jsp"%>
	<!-- 新闻详情 -->
	<div class="container" style="margin-top: 70px;">
		<div class="row">
			<!-- 左侧 -->
			<div class="col-md-8">
				<h1 class="news-title">${news.ntitle}</h1>
				<div class="news-status"><span><i class="glyphicon glyphicon-user"></i> ${news.uname} </span> | <span>
										<fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd HH:mm"/></span> 
					<div class="label label-default">${topic.tname }</div>
				</div>
				<div class="news-content">
					<img src="${pageContext.servletContext.contextPath}${news.file}" >
					<blockquote>
						<p>${news.nsummary }</p>
					</blockquote>
					
					<div>${news.ncontent }</div>
				</div>
				<div style="text-align:center; padding-top:20px;">
					<button type="button" class="btn btn-success btn-lg active" onclick="{javascrtpt:window.location.href =
										'javascript:history.go(-1);'}">返回</button>
				</div>
			</div>
			<!-- 右侧 -->
			<div class="col-md-4">
				
			</div>
		</div>
		<!-- 页脚 -->
		<div style="padding-top: 50px; padding-bottom: 50px;">
			<footer>
				<p class="pull-right"><a href="#top">回到顶部</a></p>
				<p>&copy; 2020 南开通校园综合信息平台 </p>
			</footer>
		</div>
	</div>
	
	<!-- 引用js文件，写在底部目的是提高网页响应速度 -->
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>