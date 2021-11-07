<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	<!-- fileinput -->
	<link href="css/fileinput.css" media="all"rel="stylesheet" type="text/css" />
	
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/fileinput.js"type="text/javascript"></script>
	<script src="js/locales/zh.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

	<style type="text/css">
		.news-foot {
			padding-top: 50px;
			padding-bottom: 50px;
		}
	</style>
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
					<li class="active">当前页面</li>
				</ol>
				
				<div class="col-xs-8 col-xs-offset-2">
					<legend>审核信息</legend>
					<div class="form-group">
						<label>主题:</label> <input type="text" class="form-control"
							name="tname" value="${topic.tname}" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>标题:</label> <input type="text" class="form-control"
							name="ntitle" value="${news.ntitle}" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>摘要:</label> <input type="text" class="form-control"
							name="nsummary" value="${news.nsummary}" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>内容:</label>
						<textarea rows="10" class="form-control" name="ncontent">${news.ncontent}</textarea>
					</div>
					<div class="form-group" id="pId">
						<label>图片:</label><br>
						<img
							src="${pageContext.servletContext.contextPath}${news.file}"
							alt="图片不存在" class="img-thumbnail" id="imgId" />
					</div>
					<div class="form-group">
						<div style="text-align:center; padding-top:20px;">
							<button type="button" class="btn btn-success" onclick="{javascrtpt:window.location.href =
								'${pageContext.servletContext.contextPath}/NewsServlet?method=changeCheckStatus&nid=${news.nid}&checkStatus=3'}">通过审核</button>
							<button type="button" class="btn btn-warning" onclick="{javascrtpt:window.location.href =
								'${pageContext.servletContext.contextPath}/NewsServlet?method=changeCheckStatus&nid=${news.nid}&checkStatus=1'}">不予通过</button>
							<button type="button" class="btn btn-default" onclick="{javascrtpt:window.location.href =
								'javascript:history.go(-1);'}">取消操作</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 页脚 -->	
			<div class="news-foot">
				<footer>
					<p class="pull-right">
						<a href="#top">回到顶部</a>
					</p>
					<p>&copy; 2020 南开通校园综合信息平台</p>
				</footer>
			</div>
		</div>
	</div>
</body>
		
</html>