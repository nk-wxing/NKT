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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/news.css" />
	
	<style type="text/css">
		.sticky { 
			position: -webkit-sticky; 
			position: sticky; 
			top: 70px; 
		}
	</style>
</head>
<body>
	<!-- 顶部导航栏 -->
	<%@include file="top_news.jsp"%>
	<!-- 内容 -->
	<div class="container" style="margin-top: 70px;">
		<div class="row">
			<!-- 左侧导航栏 -->
			<div class="sticky">
			<div class="col-sm-2 ">
				<div class="list-group side-bar">
					<a href="${pageContext.servletContext.contextPath}/NewsServlet?method=gotoFirstPage"
							class="list-group-item active"> 全部主题 </a>
					<c:forEach items="${allTopics}" var="topic">
						<a href="${pageContext.servletContext.contextPath}/NewsServlet?method=gotoFirstPage&tid=${topic.tid}"
							class="list-group-item"> ${topic.tname} </a>
					</c:forEach>
				</div>
			</div>
			</div>
			<!-- 中间 -->
			<div class="col-sm-7">
				<div class="news-list">
					<c:forEach items="${pageBean.beanList}" var="news">
						<div class="news-list-item clearfix">
							<div class="col-xs-5">
								<a href="${pageContext.servletContext.contextPath}/NewsServlet?method=findNewsByNid&nid=${news.nid}">
									<img src="${pageContext.servletContext.contextPath}${news.file}" alt="新闻图片不存在"></a>
							</div>
							<div class="col-xs-7">
								<a href="${pageContext.servletContext.contextPath}/NewsServlet?method=findNewsByNid&nid=${news.nid}" class="title">${news.ntitle}</a>
								<div class="info">
									<span><i class="glyphicon glyphicon-user"></i> ${news.uname} </span> | <span>
										<fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd HH:mm"/></span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				
			</div>
			<!-- 侧栏卡片 -->
			<div class="col-sm-3">
				<div class="search-bar">
					<form action="${pageContext.servletContext.contextPath}/NewsServlet" method="get">
						<input name="method" type="hidden" value="gotoFirstPage"/>
						<input name="keywords" type="search" class="form-control" placeholder="请输入关键词"/>
					</form>
				</div>
				<div class="side-bar-card clearfix">
					<div class="card-title">最新发布</div>
					<div class="card-body">
						<div class="list">
							<c:forEach items="${newses}" var="news" varStatus="status">
								<c:if test="${status.index+1 <= 10}">
								<div class="item">
									<div class="title">${news.ntitle}</div>
									<div class="desc"><span> ${news.uname} </span> | <span>
										<fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd"/></span></div>
								</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 设置分页 -->
		<nav aria-label="...">
		  	<ul class="pager">
		  		<c:if test="${pageBean.totalPages>1}">
		    		<li class="previous"><a href="${pageBean.url }">
		    		<span aria-hidden="true">&larr;</span> 首页</a></li>
					<li class="next"><a href="${pageBean.url }&currentPage=${pageBean.totalPages }">
		    		尾页 <span aria-hidden="true">&rarr;</span></a></li>
		  		</c:if>
		    	<!-- 当当前页>1，才有上一页 -->
		    	<c:if test="${pageBean.currentPage > 1}">
		    		<li><a href="${pageBean.url }&currentPage=${pageBean.currentPage-1 }">上一页</a></li>
		    	</c:if>
		    	<!-- 当当前页<总页数，才有下一页 -->
				<c:if test="${pageBean.currentPage < pageBean.totalPages}">
					<li><a
						href="${pageBean.url }&currentPage=${pageBean.currentPage+1 }">下一页</a></li>
				</c:if>
		  	</ul>
		</nav>
		<div class="news-foot">
			<footer>
				<p class="pull-right">
					<a href="#top">回到顶部</a>
				</p>
				<p>&copy; 2020 南开通校园综合信息平台</p>
			</footer>
		</div>
	</div>

	<!-- 引用js文件，写在底部目的是提高网页响应速度 -->
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>