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
		.sticky { 
			position: -webkit-sticky; 
			position: sticky; 
			top: 50px; 
		}
	</style>
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
					<li><a herf="${pageContext.servletContext.contextPath}/UserServlet?method=gotoMyCenter">首页</a></li>				
					<li><a herf="javascript:history.go(-1);">返回上一级</a></li>	
					<li class="active">当前页面</li>	
				</ol>
				<form class="col-xs-8 col-xs-offset-2" action="
				${pageContext.servletContext.contextPath}/NewsAddServlet" method="post" enctype="multipart/form-data">
					<legend>发布新信息</legend>
					<div class="form-group">
						<label>主题:</label>
						<select class="form-control" name="tid">
							<c:forEach items="${topics}" var="topic">
							<option value="${topic.tid}">${topic.tname}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label>标题:</label>
						<input type="text" class="form-control" name="ntitle" value=""/>
					</div>
					<div class="form-group">
						<label>摘要:</label>
						<input type="text" class="form-control" name="nsummary" value=""/>
					</div>					
					<div class="form-group">
						<label>内容:</label>
						<textarea rows="10" class="form-control" name="ncontent"></textarea>
					</div>
					<div class="form-group">
						<label class="control-label" for="uploadfile">图片:</label>
						<input type="file" id="uploadfile" name="file" multiple />
					</div>
					
					<div class="form-group" style="text-align:center; padding-top:20px;">
						<button type="submit" class="btn btn-success" onclick="">提交发布</button>
						<button type="button" class="btn btn-default" onclick="{javascrtpt:window.location.href =
									'javascript:history.go(-1);'}">取消发布</button>
					</div>
					
				</form>				
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
<script type="text/javascript">
	//初始化fileinput
	$('#uploadfile').fileinput({
	    language: 'zh',
	    showCaption: true,
	    showUpload: false,
	    showRemove: true,
	    showClose: false,
	    layoutTemplates:{
	        actionDelete: ''
	    },
	    browseClass: 'btn btn-primary'
	});
</script>			
</html>