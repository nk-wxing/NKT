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
	
	<script src="js/admin.js"></script>
    <script type=text/javascript src=js/addNews.js></script>
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
				<div class="col-xs-8 col-xs-offset-2">
				<!-- 主题列表 -->				
				<c:choose>
					<c:when test="${empty allTopics}">
						<h3>${msg}</h3>
					</c:when>
					<c:otherwise>
						<table class="table table-striped table-bordered" style="margin-top: 20px; text-align:center;">					
							<caption><h4>主题列表</h4></caption>
							<thead>
								<tr>
									<th style="text-align:center;">序号</th>
									<th style="text-align:center;">主题</th>
									<th style="text-align:center;">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items = "${allTopics}" var="topic" varStatus="status">							
								<tr>
									<td>${status.index+1}</td>
									<td>${topic.tname}</td>
									<td>
										<button class="btn btn-warning btn-xs" onclick="{javascrtpt:window.location.href =
											'${pageContext.servletContext.contextPath}/TopicServlet?method=preEditTopic&tid=${topic.tid}'}">修改</button>
										<button class="btn btn-danger btn-xs" 
										onclick="{if(confirm('确认删除?'))
										{javascrtpt:window.location.href = 
											'${pageContext.servletContext.contextPath}/TopicServlet?method=removeTopic&tid=${topic.tid}'}}">删除</button>
									</td>
								</tr>						
							</c:forEach>
							</tbody>
						</table>
						<!-- 设置分页 -->
						<nav class="text-center">
							<ul class="pagination">
								<li class="disabled"><a><span>&laquo;</span></a></li>
								<li class="active"><a>1</a></li>
								<li><a>2</a></li>
								<li><a>3</a></li>
								<li><a>4</a></li>
								<li><a>5</a></li>
								<li><a><span>&raquo;</span></a></li>
							</ul>
						</nav>
					</c:otherwise>
				</c:choose>	
				</div>
				
			</div>			
		</div>				
	</div>
	<%
	Object mess=session.getAttribute("message");
	if(!"".equals(mess)  && mess!=null){
	%>
	<script type="text/javascript">
		window.onload=function(){
			alert("<%=mess%>");
		};
	</script>
	<%  session.setAttribute("message", ""); %>	
 	<% 
	}
	%>
</body>
</html>